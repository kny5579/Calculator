package com.example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //연산 결과 저장하는 컬렉션 타입 필드 선언 및 생성
    private final List<Double> resultList = new ArrayList<>();

    //getter
    public List<Double> getResultList() {
        return resultList;
    }

    //setter
    public void addResult(double result) {
        resultList.add(result);
    }

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
                if (second == 0) { //예외: 나눗셈 연산에서 분모가 0인 경우
                    throw new ArithmeticException("분모(두번째 정수)에 0이 입력된 경우 나눗셈 연산이 불가합니다.");
                }
                result = first / (double) second;
                break;
            default: //예외: 기호가 일치하지 않는 경우
                throw new IllegalArgumentException("유효하지 않은 연산 기호입니다.");
        }

        //결과 값 저장하기
        addResult(result);

        //결과 값 반환하기
        return result;
    }

    public void removeResult() {
        resultList.remove(0);
    }
}
