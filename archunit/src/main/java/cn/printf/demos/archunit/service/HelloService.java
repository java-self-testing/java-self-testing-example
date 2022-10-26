package cn.printf.demos.archunit.service;

import cn.printf.demos.archunit.controller.HelloController;

public class HelloService {
    HelloController helloController = new HelloController();

    public void hello() {
        helloController.something();
    }
}
