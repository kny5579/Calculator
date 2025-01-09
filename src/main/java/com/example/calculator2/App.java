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

            //데이터 삭제
            System.out.print("가장 먼저 저장된 데이터를 삭제하려면 y를 입력하세요. 계속하려면 아무 키나 입력하세요: ");
            String removeInput = sc.next();
            if (removeInput.equals("y")) {
                calculator.removeResult();
                System.out.println("변경된 데이터 목록: " + calculator.getResultList());
            }

            //컬렉션 초기화(setter 활용)
            System.out.print("리스트를 초기화하려면 y를 입력하세요. 계속하려면 아무 키나 입력하세요: ");
            String resetInput = sc.next();
            if (resetInput.equals("y")) {
                ArrayList<Double> list = new ArrayList<>();
                calculator.setResultList(list);
                System.out.println("변경된 데이터 목록: " + calculator.getResultList());
            }

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
