package btvn.bai1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        List<Double> temperatures = new ArrayList<>();
        temperatures.add(36.5);
        temperatures.add(40.2);
        temperatures.add(37.0);
        temperatures.add(12.5);
        temperatures.add(39.8);
        temperatures.add(99.9);
        temperatures.add(36.8);

        System.out.println("Danh sách ban đầu: " + temperatures);

        Iterator<Double> iterator = temperatures.iterator();
        while (iterator.hasNext()) {
            double temp = iterator.next();

            if(temp < 34.0 || temp > 42.0) {
                iterator.remove();
            }
        }

        System.out.println("Danh sách sau khi lọc: " + temperatures);

        double sum = 0;
        for(double temp : temperatures) {
            sum += temp;
        }

        double average = sum / temperatures.size();

        System.out.printf("Nhiệt độ trung bình: %.2f", average);
    }
}
