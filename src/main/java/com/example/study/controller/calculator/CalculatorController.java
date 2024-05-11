package com.example.study.controller.calculator;

import com.example.study.dto.calculator.CalResult;
import com.example.study.dto.calculator.Calculate;
import com.example.study.dto.calculator.CalculatorAddRequest;
import com.example.study.dto.calculator.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
   @GetMapping("/add")
   public int addTwoNumber(CalculatorAddRequest request){
      return request.getNumber1()+request.getNumber2();
   }
   @PostMapping("/multiply")
   public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request){
      return request.getNumber1()*request.getNumber2();
   }
   @GetMapping("calc")
   public CalResult calculate(Calculate request){
      int add = request.getNumber1()+ request.getNumber2();
      int minus = request.getNumber1()- request.getNumber2();
      int multiply = request.getNumber1()* request.getNumber2();
      double division = (double) request.getNumber1() / request.getNumber2();
      return new CalResult(add, minus, multiply, division);
   }

}
