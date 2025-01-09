package com.example.calculator3;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("첫 번째 숫자를 입력하세요: ");
            Number first;
            try {
                first = DataType.parseNumber(sc.next());
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
                continue;
            }
            System.out.print("두 번째 숫자를 입력하세요: ");
            Number second;
            try {
                second = DataType.parseNumber(sc.next());
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
                continue;
            }

            //사칙 연산 기호 입력받기
            System.out.print("사칙연산 기호를 입력하세요(ex:+,-,x,%): ");
            try {
                char operator = sc.next().charAt(0);
                double result = calculator.calculate(first, second, operator);
                System.out.println("결과: " + result);
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
                continue;
            }

            //컬렉션 가져오기(getter 활용)
            System.out.println("저장된 데이터: " + calculator.getResultList());

            //메인코드가 너무 길어져서 클래스로 작성
            if (Options.selectOptions(calculator, sc)) break;
        }

    }

}
