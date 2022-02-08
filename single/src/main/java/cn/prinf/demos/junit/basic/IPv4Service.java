package cn.prinf.demos.junit.basic;

import sun.net.util.IPAddressUtil;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class IPv4Service implements IpService {

    private final AtomicBitSet bits = new AtomicBitSet(4294967295L);

    public void add(String ipString) {
        long ipValue = parseIPToLong(ipString);
        bits.add(ipValue);
    }

    @Override
    public boolean isInList(String ip) {
        long ipValue = parseIPToLong(ip);
        return bits.contain(ipValue);
    }

    private long parseIPToLong(String ipString) {
        byte[] bytes = IPAddressUtil.textToNumericFormatV4(ipString);
        int ipInt = 0;
        for (byte b : bytes) {
            ipInt = ipInt << 8 | (b & 0xFF);
        }
        // convert to unsigned int and store as long
        return Integer.toUnsignedLong(ipInt);
    }

    /**
     * this is my implementation
     */
    static public class SimpleBitMap {
        private volatile byte[] bits;

        public SimpleBitMap(long size) {
            int byteCount = getByteLocation(size) + 1;
            bits = new byte[byteCount];
        }

        public void add(long num) {
            // TODO scale the array if need
            int byteLocation = getByteLocation(num);
            int indexInByte = getIndexInByte(num);

            synchronized (this) {
                bits[byteLocation] |= 1 << indexInByte;
            }
        }

        public boolean contain(long num) {
            int byteLocation = getByteLocation(num);
            int indexInByte = getIndexInByte(num);
            return (bits[byteLocation] & (1 << indexInByte)) != 0;
        }

        private int getIndexInByte(long num) {
            return (int) (num & 0x07);
        }

        private int getByteLocation(long num) {
            return (int) (num >> 3);
        }
    }

    /**
     * this is a better solution which grabbing from internet
     */
    static public class AtomicBitSet {
        private final AtomicIntegerArray array;

        public AtomicBitSet(long length) {
            long intLength = (length + 31) / 32;
            array = new AtomicIntegerArray((int) intLength);
        }

        public void add(long n) {
            int bit = 1 << n;
            int idx = (int) (n >>> 5);
            while (true) {
                int num = array.get(idx);
                int num2 = num | bit;
                if (num == num2 || array.compareAndSet(idx, num, num2))
                    return;
            }
        }

        public boolean contain(long n) {
            int bit = 1 << n;
            int idx = (int) (n >>> 5);
            int num = array.get(idx);
            return (num & bit) != 0;
        }
    }
}
