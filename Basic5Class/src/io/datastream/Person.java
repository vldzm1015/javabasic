package io.datastream;


import java.io.Serializable;

public class Person implements Serializable {
    String name;
    int age;
    double height;
    char bloodType;

    public Person(){}

    public Person(String name, int age, double height, char bloodType) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.bloodType = bloodType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public char getBloodType() {
        return bloodType;
    }

    public void setBloodType(char bloodType) {
        this.bloodType = bloodType;
    }
}