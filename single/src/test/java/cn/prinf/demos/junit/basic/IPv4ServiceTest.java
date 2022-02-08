package cn.prinf.demos.junit.basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class IPv4ServiceTest {

    @Test
    public void should_check_ip_in_mask() {
        IPv4Service ipFilter = new IPv4Service();

        ipFilter.add("255.255.255.255");
        ipFilter.add("192.168.1.1");
        ipFilter.add("0.0.0.0");

        assertTrue(ipFilter.isInList("255.255.255.255"));
        assertTrue(ipFilter.isInList("192.168.1.1"));
        assertTrue(ipFilter.isInList("0.0.0.0"));

        assertFalse(ipFilter.isInList("192.168.1.0"));
    }
}
