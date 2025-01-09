package com.example.calculator3;

import java.util.ArrayList;
import java.util.Scanner;

class Options {
    public static boolean selectOptions(ArithmeticCalculator<?> calculator, Scanner sc) {
        System.out.println("옵션을 선택하세요. 연산을 계속하려면 옵션 외 다른 키를 입력하세요");
        System.out.println("1: 가장 먼저 저장된 데이터 삭제");
        System.out.println("2: 리스트 초기화");
        System.out.println("3: 특정 값보다 큰 데이터 목록 보기");
        System.out.println("4: 데이터 목록의 특정 값 두 배로 키우기");
        System.out.println("exit: 프로그램 종료");

        System.out.print("입력: ");
        String input = sc.next();

        switch (input) {
            case "1": //데이터 삭제
                if (!calculator.getResultList().isEmpty()) {
                    calculator.removeResult();
                    System.out.println("가장 먼저 저장된 데이터를 삭제했습니다.");
                } else {
                    System.out.println("저장된 데이터가 없습니다.");
                }
                System.out.println("현재 데이터 목록: " + calculator.getResultList());
                break;

            case "2": //컬렉션 초기화(setter 활용)
                calculator.setResultList(new ArrayList<>());
                System.out.println("리스트를 초기화했습니다.");
                System.out.println("현재 데이터 목록: " + calculator.getResultList());
                break;

            case "3": //입력받은 값보다 큰 결과값 출력(3-3)
                System.out.print("특정 값을 입력하세요: ");
                double num;
                try {
                    num = sc.nextDouble();
                } catch (Exception e) {
                    System.out.println("유효하지 않은 값입니다.");
                    sc.nextLine();
                    break;
                }
                System.out.println("결과 목록에서 " + num + "보다 큰 값: " +
                        calculator.moreThanInput(num));
                break;

            case "4": //데이터 목록의 특정 값 두 배로 키우기
                System.out.print("특정 값을 입력하세요: ");
                double sortingNum;
                try {
                    sortingNum = sc.nextDouble();
                } catch (Exception e) {
                    System.out.println("유효하지 않은 값입니다.");
                    sc.nextLine();
                    break;
                }
                System.out.println("현재 데이터 목록: " + calculator.updateDoubleList(sortingNum));

            case "exit": //반복 종료 묻기
                System.out.println("프로그램을 종료합니다.");
                return true;

            default: //연산 반복
                System.out.println("연산을 시작합니다");
        }

        return false;
    }
}
