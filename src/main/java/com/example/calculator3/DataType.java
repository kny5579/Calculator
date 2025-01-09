package com.example.calculator3;

public class DataType {
    //double, long 구분 메소드
    public static Number parseNumber(String input) {
        try {
            if (input.contains(".")) {
                return Double.parseDouble(input); // 소수점이 있는 경우 Double로 변환
            } else {
                return Long.parseLong(input); // 정수인 경우 Long으로 변환
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }
}
