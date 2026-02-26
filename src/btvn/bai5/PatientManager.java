package btvn.bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientManager {
    private static List<Patient> patients = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("2. Cập nhật chẩn đoán");
            System.out.println("3. Xuất viện (xóa bệnh nhân)");
            System.out.println("4. Sắp xếp danh sách");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng (1-5): ");

            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    updateDiagnosis();
                    break;
                case 3:
                    dischargePatient();
                    break;
                case 4:
                    sortPatients();
                    break;
                case 5:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Không thuộc menu");
            }
        } while (choice != 5);
    }

    private static void addPatient() {
        System.out.print("Nhập ID : ");
        String id = sc.nextLine().trim();

        if (findPatientById(id) != null) {
            System.out.println("ID đã tồn tại.");
            return;
        }

        System.out.print("Nhập họ tên: ");
        String name = sc.nextLine().trim();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = sc.nextLine().trim();

        patients.add(new Patient(id, name, age, diagnosis));
        System.out.println("Đã tiếp nhận bệnh nhân thành công");
    }

    private static void updateDiagnosis() {
        System.out.print("Nhập ID bệnh nhân cần cập nhật: ");
        String id = sc.nextLine().trim();

        Patient patient = findPatientById(id);
        if (patient == null) {
            System.out.println("Không tìm thấy bệnh nhân");
            return;
        }

        System.out.println("Thông tin hiện tại: " + patient);
        System.out.print("Nhập chẩn đoán mới: ");
        String newDiagnosis = sc.nextLine().trim();

        patient.setDiagnosis(newDiagnosis);
        System.out.println("Đã cập nhật chẩn đoán");
    }

    private static void dischargePatient() {
        System.out.print("Nhập ID bệnh nhân xuất viện: ");
        String id = sc.nextLine().trim();

        Patient patient = findPatientById(id);
        if (patient == null) {
            System.out.println("Không tìm thấy bệnh nhân");
            return;
        }

        patients.remove(patient);
        System.out.println("Đã xuất viện bệnh nhân " + patient.getFullName());
    }

    private static void sortPatients() {
        if (patients.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }

        patients.sort((p1, p2) -> {
            if (p2.getAge() != p1.getAge()) {
                return Integer.compare(p2.getAge(), p1.getAge());
            }
            return p1.getFullName().compareTo(p2.getFullName());
        });

        System.out.println("Danh sách bệnh nhân sau khi sắp xếp:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println(patients.get(i));
        }
    }

    private static Patient findPatientById(String id) {
        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}
