package com.eomcs.oop.ex05.c.acompB;

public class Car {

  public String model;
  public String maker;
  public int capacity;

  public boolean fixed;
  public boolean water;


  public Car() {}

  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  public Car(String model, String maker, int capacity, boolean fixed, boolean water) {
    this(model, maker, capacity);
    this.fixed = fixed;
    this.water = water;
  }

  public void run() {
    System.out.println("달린다!");
  }
}


