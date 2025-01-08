package com.example.calculator;

import java.util.Scanner;

//lv 1->예외처리 수정 필요
public class Calculator {

    public static void main(String[] args) {

        //양의 정수 입력받기
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("첫 번째 숫자(양의 정수)를 입력하세요: ");
            long first;
            try {
                first = sc.nextLong();
                if (first < 0) {
                    System.out.println("양의 정수를 입력하셔야 합니다.");
                    break;
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
                    break;
                }
            } catch (Exception e) { //예외: 잘못된 입력인 경우
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                sc.nextLine();
                continue;
            }

            //사칙 연산 기호 입력받기
            double result = 0;
            System.out.print("사칙연산 기호를 입력하세요(ex:+,-,x,%): ");

            char operator = sc.next().charAt(0);
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
                        System.out.println("분모(두번째 정수)에 0이 입력된 경우 나눗셈 연산이 불가합니다. 다시 입력해주세요.");
                        continue;
                    }
                    result = first / (double) second;
                    break;
                default: //예외: 기호가 일치하지 않는 경우
                    System.out.println("유효하지 않은 연산 기호입니다. 다시 입력해주세요.");
                    continue;
            }

            //결과 값 출력하기
            System.out.println("결과: " + result);

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
