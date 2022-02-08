package cn.prinf.demos.junit.basic;

public interface IpService {
    /**
     * 判断指定的ipv4地址是否在当前名单中
     *
     * @param ip 指定的ip地址值(v4)
     * @return true: 在名单中， false: 不在名单中
     */
    boolean isInList(String ip);
}
