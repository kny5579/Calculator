package com.example.calculator3;

import java.util.function.BiFunction;

public enum OperatorType {
    PLUS('+', (a, b) -> a.doubleValue() + b.doubleValue()),
    MINUS('-', (a, b) -> a.doubleValue() - b.doubleValue()),
    MULTIPLY('x', (a, b) -> a.doubleValue() * b.doubleValue()),
    DIVIDE('%', (a, b) -> {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다");
        }
        return (double) (a.doubleValue() / b.doubleValue());
    });

    //PLUS 안의 +가 char operator라는 것을 지정
    private final char operator;
    //2개의 인자를 받고 1개의 객체를 리턴하는 함수형 인터페이스. 제네릭 사용을 위해 Number로 입력값 변경
    private final BiFunction<Number, Number, Double> expression;

    //생성자
    OperatorType(char operator, BiFunction<Number, Number, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    //BiFunction 연산 결과 반환
    public double calculate(Number a, Number b) {
        return expression.apply(a, b);
    }

    //enum의 연산자(PLUS->+, MINUS->-) 꺼내기
    public char getOperator() {
        return operator;
    }

}
