package btvn.bai6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrescriptionManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Medicine> cart = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU KÊ ĐƠN =====");
            System.out.println("1. Thêm thuốc");
            System.out.println("2. Điều chỉnh số lượng");
            System.out.println("3. Xóa thuốc");
            System.out.println("4. In hóa đơn");
            System.out.println("5. Tìm thuốc giá rẻ (<50.000)");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Nhập mã thuốc: ");
                    String id = sc.nextLine();

                    boolean found = false;

                    for (Medicine m : cart) {
                        if (m.getDrugId().equals(id)) {
                            System.out.print("Nhập số lượng thêm: ");
                            int addQty = sc.nextInt();
                            m.setQuantity(m.getQuantity() + addQty);
                            found = true;
                            System.out.println("Đã cộng dồn số lượng.");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.print("Nhập tên thuốc: ");
                        String name = sc.nextLine();
                        System.out.print("Nhập giá: ");
                        double price = sc.nextDouble();
                        System.out.print("Nhập số lượng: ");
                        int qty = sc.nextInt();

                        cart.add(new Medicine(id, name, price, qty));
                        System.out.println("Đã thêm thuốc mới.");
                    }
                    break;

                case 2:
                    System.out.print("Nhập mã thuốc cần chỉnh: ");
                    String editId = sc.nextLine();

                    for (int i = 0; i < cart.size(); i++) {
                        if (cart.get(i).getDrugId().equals(editId)) {
                            System.out.print("Nhập số lượng mới: ");
                            int newQty = sc.nextInt();

                            if (newQty == 0) {
                                cart.remove(i);
                                System.out.println("Đã xóa thuốc vì số lượng = 0");
                            } else {
                                cart.get(i).setQuantity(newQty);
                                System.out.println("Đã cập nhật số lượng.");
                            }
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã thuốc cần xóa: ");
                    String deleteId = sc.nextLine();

                    for (int i = 0; i < cart.size(); i++) {
                        if (cart.get(i).getDrugId().equals(deleteId)) {
                            cart.remove(i);
                            System.out.println("Đã xóa thuốc.");
                            break;
                        }
                    }
                    break;

                case 4:
                    double total = 0;
                    System.out.println("\n===== HÓA ĐƠN =====");
                    System.out.printf("%-10s %-20s %-10s %-10s %-15s\n",
                            "Mã", "Tên", "Giá", "SL", "Thành tiền");

                    for (Medicine m : cart) {
                        System.out.printf("%-10s %-20s %-10.0f %-10d %-15.0f\n",
                                m.getDrugId(),
                                m.getDrugName(),
                                m.getUnitPrice(),
                                m.getQuantity(),
                                m.getTotalPrice());

                        total += m.getTotalPrice();
                    }

                    System.out.println("TỔNG TIỀN: " + total + " VNĐ");

                    cart.clear(); // xóa giỏ sau khi in
                    System.out.println("Đã làm trống đơn thuốc.");
                    break;

                case 5:
                    System.out.println("Thuốc dưới 50.000 VNĐ:");
                    for (Medicine m : cart) {
                        if (m.getUnitPrice() < 50000) {
                            System.out.println(m.getDrugName() + " - " + m.getUnitPrice());
                        }
                    }
                    break;

                case 6:
                    System.out.println("Kết thúc chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
