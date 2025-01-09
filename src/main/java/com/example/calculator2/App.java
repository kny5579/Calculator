package com.example.calculator2;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        //양의 정수 입력받기
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("첫 번째 숫자(양의 정수)를 입력하세요: ");
            long first;
            try {
                first = sc.nextLong();
                if (first < 0) {
                    System.out.println("양의 정수를 입력하셔야 합니다.");
                    sc.nextLine();
                    continue;
                }
            } catch (Exception e) { //예외: 잘못된 입력인 경우
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                sc.nextLine();
                continue;
            }
            System.out.print("두 번째 숫자(양의 정수)를 입력하세요: ");
            long second;
            try {
                second = sc.nextLong();
                if (second < 0) {
                    System.out.println("양의 정수를 입력하셔야 합니다.");
                    sc.nextLine();
                    continue;
                }
            } catch (Exception e) { //예외: 잘못된 입력인 경우
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                sc.nextLine();
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
                continue; // 잘못된 입력이 있으면 다시 입력받기
            }

            //컬렉션 가져오기(getter 활용)
            System.out.println("저장된 데이터: " + calculator.getResultList());

            if(Options.selectOptions(calculator, sc)) break;

        }

    }
}
