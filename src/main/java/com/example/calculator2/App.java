package com.example.calculator2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        //양의 정수 입력받기
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("첫 번째 숫자를 입력하세요: ");
            long first;
            try {
                first = sc.nextLong();
            } catch (Exception e) { //예외: 잘못된 입력인 경우
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                sc.nextLine();
                continue;
            }
            System.out.print("두 번째 숫자를 입력하세요: ");
            long second;
            try {
                second = sc.nextLong();
            } catch (Exception e) { //예외: 잘못된 입력인 경우
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                sc.nextLine();
                continue;
            }

            //사칙 연산 기호 입력받기
            double result = 0;
            System.out.print("사칙연산 기호를 입력하세요(ex:+,-,x,%): ");
            char operator = sc.next().charAt(0);

            //결과 값 출력하기
            System.out.println("결과: " + calculator.calculate(first, second, operator));

            //반복 종료 묻기
            System.out.print("계산을 종료하려면 'exit'을 입력하세요. 계속하려면 아무 키나 입력하세요: ");
            String exitInput = sc.next();
            if (exitInput.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

        }

    }
}
