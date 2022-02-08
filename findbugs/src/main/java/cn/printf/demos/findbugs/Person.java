package cn.printf.demos.findbugs;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String name() {
        return name();
    }
}
