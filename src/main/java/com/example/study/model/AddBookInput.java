package com.example.study.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddBookInput { //데이터를 입력받기 위한 클래스

   @NotBlank
   @Size(min=2, max = 20, message = "책 제목은 최소 2글자, 최대 20자로 작성해주세요.")
   private String bookName;

   @Range(min=100,max=100000, message="책 가격은 최소 100원, 최대 100,000원으로 기입해주세요.")
   private long bookPrice;

   //@Size는 문자열 길이 범위, @Range는 숫자 길이 범위
   //message는 오류 발생 시 message 값 출력. 근데 쓴다고 바로 보이는게 아님.exception 패키지의 GlobalExceptionHandler 작성.
}
