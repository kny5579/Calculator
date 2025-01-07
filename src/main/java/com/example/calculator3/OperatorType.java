package com.example.calculator3;

import java.util.function.BiFunction;

public enum OperatorType {
    PLUS('+', (a, b) -> (double) a + b),
    MINUS('-', (a, b) -> (double) a - b),
    MULTIPLY('x', (a, b) -> (double) a * b),
    DIVIDE('%', (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다");
        }
        return (double) (a / b);
    });

    //PLUS 안의 +가 char operator라는 것을 지정
    private final char operator;
    //2개의 인자를 받고 1개의 객체를 리턴하는 함수형 인터페이스. Long 두개를 받아서 Double로 반환
    private final BiFunction<Long, Long, Double> expression;

    //생성자
    OperatorType(char operator, BiFunction<Long, Long, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    //BiFunction 연산 결과 반환
    public double calculate(long a, long b) {
        return expression.apply(a, b);
    }

    //enum의 연산자(PLUS->+, MINUS->-) 꺼내기
    public char getOperator() {
        return operator;
    }

}
