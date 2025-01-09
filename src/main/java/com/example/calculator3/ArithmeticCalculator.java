package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//lv 3
//제네릭을 사용해서 long뿐만 아니라 다른 데이터타입의 값을 받을 수 있도록 수정
//Integer, Long, Double 같은 숫자 타입의 상위 클래스 Number를 상속
public class ArithmeticCalculator<T extends Number> { // enum을 활용한 사칙연산 수행 클래스

    //연산 결과 저장하는 컬렉션 타입 필드 선언 및 생성
    private List<Double> resultList = new ArrayList<>();

    //getter
    public List<Double> getResultList() {
        return resultList;
    }

    //setter
    public void setResultList(List<Double> resultList) {
        this.resultList = resultList;
    }

    //사칙연산 및 결과 값 반환하는 메소드
    public double calculate(T first, T second, char operator) {
        double result = 0;
        //enum클래스의 operator와 입력한 operator 일치하는 거 찾기
        for (OperatorType type : OperatorType.values()) { //OperatorType.values()={PLUS,MINUS,MULTIPLY,DIVIDE}
            if (type.getOperator() == operator) {
                result = type.calculate(first.doubleValue(), second.doubleValue());
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

    public List<Double> moreThanInput(Double input) {
        return getResultList().stream().filter(num -> num > input).collect(Collectors.toList());
    }

    public List<Double> updateDoubleList(double sortingNum) {
        return getResultList().stream().map(num -> num == sortingNum ? num * 2 : num).collect(Collectors.toList());
    }
}
