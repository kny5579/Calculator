package com.example.calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        //lv 1
        //양의 정수 입력받기(음수인 경우 예외처리)
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("첫 번째 숫자를 입력하세요: ");
            long first = sc.nextLong();
            System.out.print("두 번째 숫자를 입력하세요: ");
            long second = sc.nextLong();

            //사칙 연산 기호 입력받기
            boolean check = false;
            double result = 0;
            while (!check) {
                System.out.print("사칙연산 기호를 입력하세요(ex:+,-,x,%): ");
                result = 0;

                char operator = sc.next().charAt(0);
                switch (operator) {
                    case '+':
                        result = first + second;
                        check = true;
                        break;
                    case '-':
                        result = first - second;
                        check = true;
                        break;
                    case 'x':
                        result = first * second;
                        check = true;
                        break;
                    case '%':
                        result = first / (double) second;
                        check = true;
                        if (second == 0) { //예외: 나눗셈 연산에서 분모가 0인 경우
                            System.out.println("분모(두번째 정수)에 0이 입력된 경우 나눗셈 연산이 불가합니다. 다른 기호를 입력해주세요");
                            check = false;
                        }
                        break;
                    default: //예외: 기호가 일치하지 않는 경우
                        System.out.println("예시와 일치하는 기호를 입력해주세요");
                }
            }
            System.out.println("결과: " + result);

            System.out.print("계산을 종료하려면 'exit'을 입력하세요. 계속하려면 아무 키나 입력하세요: ");
            String exitInput = sc.next();
            if (exitInput.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

        }

    }
}
