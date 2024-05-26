package com.example.study.exception;

import com.example.study.model.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class}) //예외 처리 시 return 값 반환.
   public ResponseEntity<?> validationExceptionHandler(BindingResult bindingResult){
//      String message = bindingResult.getFieldError().getDefaultMessage(); 이렇게 작성하면 에러 한 개만 처리할 수 있음
      List<String> errorMessages = bindingResult.getFieldErrors()
              .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
              .collect(Collectors.toList());
      return ResponseEntity.badRequest().body(new ErrorResponse(400,errorMessages));
   }
}
