package com.example.calculator2;

import java.util.ArrayList;

//lv 2
public class Calculator {

    public ArrayList<Double> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<Double> resultList) {
        this.resultList = resultList;
    }

    //연산 결과 저장하는 컬렉션 타입 필드 선언 및 생성
    private ArrayList<Double> resultList = new ArrayList<>();

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
            default: //예외: 기호가 일치하지 않는 경우
                throw new IllegalArgumentException("유효하지 않은 연산 기호입니다.");
        }

        //결과 값 저장하기
        resultList.add(result);

        //결과 값 반환하기
        return result;
    }
}
