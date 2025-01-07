package com.example.calculator3;

import java.util.ArrayList;

//lv 2
public class ArithmeticCalculator {

    //연산 결과 저장하는 컬렉션 타입 필드 선언 및 생성
    private ArrayList<Double> resultList = new ArrayList<>();

    //getter
    public ArrayList<Double> getResultList() {
        return resultList;
    }
    //setter
    public void setResultList(ArrayList<Double> resultList) {
        this.resultList = resultList;
    }

    //사칙연산 및 결과 값 반환하는 메소드
    public double calculate(long first, long second, char operator) {
        double result = 0;
        //enum클래스의 operator와 입력한 operator 일치하는 거 찾기
        for(OperatorType type : OperatorType.values()){ //OperatorType.values()={PLUS,MINUS,MULTIPLY,DIVIDE}
            if(type.getOperator()==operator){
                result = type.calculate(first, second);
                resultList.add(result);
                return result;
            }
        }
        //enum의 operator와 일치하는 기호가 없을 때
        throw new IllegalArgumentException("유효하지 않은 연산 기호입니다.");
    }

    public void removeResult() {
        resultList.remove(0);
    }
}
