package com.example.study.dto.calculator;

public class CalResult {
   private int add;
   private int minus;
   private int multiply;
   private double division;

   public CalResult(int add, int minus, int multiply, double division) {
      this.add = add;
      this.minus = minus;
      this.multiply = multiply;
      this.division = division;
   }

   public int getAdd() {
      return add;
   }

   public int getMinus() {
      return minus;
   }

   public int getMultiply() {
      return multiply;
   }

   public double getDivision() {
      return division;
   }
}
