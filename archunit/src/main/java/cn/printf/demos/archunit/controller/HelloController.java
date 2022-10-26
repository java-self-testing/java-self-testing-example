package cn.printf.demos.archunit.controller;

import cn.printf.demos.archunit.dao.HelloDao;

public class HelloController {
    public void something() {
        HelloDao helloDao = new HelloDao();
        helloDao.other();
    }
}
