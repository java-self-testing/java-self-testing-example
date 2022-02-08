package cn.printf.concurrence;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeakExample {
    public static Map<Person, Integer> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            MemoryLeakExample.online(new MemoryLeakExample.Person("jon"));
        }

        Thread.sleep(1000000);
    }

    public static void online(Person person) {
        if (map.get(person) != null) {
            map.put(person, map.get(person) + 1);
        }
    }

    public static class Person {
        public String name;

        public Person(String name) {
            this.name = name;
        }
    }
}
