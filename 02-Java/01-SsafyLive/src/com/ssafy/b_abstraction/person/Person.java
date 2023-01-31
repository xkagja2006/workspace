// @@DELETE_FILE:
package com.ssafy.b_abstraction.person;

public class Person {
    String name;
    int age;
    boolean isHungry;

    Person() {
        this("익명");
    }

    Person(String name) {
        this(name, 0, true);
    }

    Person(String name, int age) {
        this(name, age, true);
    }

    Person(String name, int age, boolean isHungry) {
        this.name = name;
        this.age = age;
        this.isHungry = isHungry;
    }

    void eat() {
        System.out.println("냠냠");
        isHungry = false;
    }

    void work() {
        System.out.printf("%n");
        System.out.println("열심히");
        isHungry = true;
    }

    void printInfo() {
        System.out.printf("name: %s, age: %d, isHungry: %b%n", name, age, isHungry);
    }

    void walk() {
        walk(100, "cm");
    }

    void walk(int distance) {
        walk(distance, "cm");
    }

    void walk(int distance, String unit) {
        switch (unit) {
        case "cm":
            break;
        case "inch":
            distance *= 2.54;
            break;
        default:
            System.out.println("unknown");
            distance = 0;
        }
        System.out.println(distance + "cm 이동");
    }

}
