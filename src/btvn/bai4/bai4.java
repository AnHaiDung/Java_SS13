package btvn.bai4;

import java.util.LinkedList;
import java.util.Scanner;

public class bai4 {
    private LinkedList<String> queue = new LinkedList<>();

    public void patientCheckIn(String name) {
        queue.addLast(name);
        System.out.println("Bệnh nhân " + name + " đã vào hàng chờ");
    }

    public void emergencyCheckIn(String name) {
        queue.addFirst(name);
        System.out.println("Ca cấp cứu  " + name + " được đưa lên đầu hàng");
    }

    public void treatPatient() {
        if(queue.isEmpty()) {
            System.out.println("Hiện không có bệnh nhân trong hàng đợi");
            return;
        }

        String patient = queue.removeFirst();

        if (patient.equals("C")) {
            System.out.println("Đang cấp cứu: " + patient);
        } else {
            System.out.println("Đang khám: " + patient);
        }
    }

    public static void main(String[] args) {
        bai4 er = new bai4();

        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");

        System.out.println("Bác sĩ bắt đầu làm việc");
        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}
