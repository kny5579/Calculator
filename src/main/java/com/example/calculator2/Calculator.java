package com.example.calculator2;

import java.util.ArrayList;

//lv 2
public class Calculator {

    //연산 결과 저장하는 컬렉션 타입 필드 선언 및 생성
    ArrayList<Double> resultList = new ArrayList<>();

    //사칙연산 및 결과 값 반환하는 메소드
    public double calculate(long first, long second, char operator) {
        double result = 0;

        switch (operator) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case 'x':
                result = first * second;
                break;
            case '%':
                result = first / (double) second;
                break;
        }

        //결과 값 출력하기
        System.out.println("결과: " + result);

        //결과 값 저장하기
        resultList.add(result);

        //결과 값 반환하기
        return result;
    }
}
