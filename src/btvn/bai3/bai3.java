package btvn.bai3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bai3 {
    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB) {
        List<T> commonList = new ArrayList<>();

        for (T patient : listA) {
            if (listB.contains(patient)) {
                if(!commonList.contains(patient)) {
                    commonList.add(patient);
                }
            }
        }
        return commonList;
    }

    public static void main(String[] args) {
        List<Integer> khoaNoiInt = List.of(101, 102, 105);
        List<Integer> khoaNgoaiInt = List.of(102, 105, 108);

        List<Integer> resultInt = findCommonPatients(khoaNoiInt, khoaNgoaiInt);
        System.out.println("Test Case 1 Output: " + resultInt);

        List<String> khoaNoiStr = List.of("DN01", "DN02", "DN03");
        List<String> khoaNgoaiStr = List.of("DN02", "DN04");

        List<String> resultStr = findCommonPatients(khoaNoiStr, khoaNgoaiStr);
        System.out.println("Test Case 2 Output: " + resultStr);
    }
}
