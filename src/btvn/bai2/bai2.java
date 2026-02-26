package btvn.bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        List<String> inputThuoc = new ArrayList<>();
        inputThuoc.add("Paracetamol");
        inputThuoc.add("Ibuprofen");
        inputThuoc.add("Panadol");
        inputThuoc.add("Paracetamol");
        inputThuoc.add("Aspirin");
        inputThuoc.add("Ibuprofen");

        System.out.println("Input: " + inputThuoc);

        List<String> uniqueThuoc = new ArrayList<>();
        for (String thuoc : inputThuoc) {
            if (!uniqueThuoc.contains(thuoc)) {
                uniqueThuoc.add(thuoc);
            }
        }

        Collections.sort(uniqueThuoc);

        System.out.println("Output: " + uniqueThuoc);
    }
}
