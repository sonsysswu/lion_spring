package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse { //에러가 한 개만 발생했을 땐 ㄱㅊ은데 두 개 이상 떴을 땐 모두 출력하기 위해 ErrorResponse 사용
   private int errorCode;
   private List<String> errorMessages;
}
