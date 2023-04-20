package com.hspedu.reflection;

public class Car {
    public String brand = "BMW";
    public int price = 50000;
    public String color = "white";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
