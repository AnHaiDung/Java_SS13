import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CategoryManager categoryManager = new CategoryManager();
        BookManager bookManager = new BookManager();
        int choice = 0;
        do {
            System.out.println("""
                    =========================== MENU ===========================
                    1. Quản lí danh mục.
                    2. Quản lí sách.
                    3. Thoát.
                    """);
            System.out.print("Nhập lựa chọn : ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    int choose = 0;
                    do {
                        System.out.println("""
                                 ============== MENU QUẢN LÍ DANH MỤC ==============
                                 1. Thêm danh mục.
                                 2. Xóa danh mục.
                                 3. Cập nhật danh mục.
                                 4. Hiển thị danh sách danh mục.
                                 5. Thoát.
                                """);
                        System.out.print("Nhập lựa chọn : ");
                        choose = Integer.parseInt(sc.nextLine());
                        switch (choose){
                            case 1:
                                Category newCategory = new Category();
                                System.out.print("Nhập id cho danh mục : ");
                                newCategory.setId(Integer.parseInt(sc.nextLine()));
                                System.out.print("Nhập tên danh mục : ");
                                newCategory.setName(sc.nextLine());
                                System.out.print("Nhập mô tả : ");
                                newCategory.setDescription(sc.nextLine());
                                categoryManager.add(newCategory);
                                break;
                            case 2:
                                System.out.print("Nhập id danh mục muốn xóa : ");
                                int idDelete = Integer.parseInt(sc.nextLine());
                                categoryManager.delete(idDelete);
                                break;
                            case 3:
                                Category newCategoryUpdate = new Category();
                                System.out.print("Nhập id danh mục cần update : ");
                                newCategoryUpdate.setId(Integer.parseInt(sc.nextLine()));
                                System.out.print("Nhập tên danh mục mới : ");
                                newCategoryUpdate.setName(sc.nextLine());
                                System.out.print("Nhập mô tả mới : ");
                                newCategoryUpdate.setDescription(sc.nextLine());
                                categoryManager.update(newCategoryUpdate);
                                break;
                            case 4:
                                categoryManager.displayALL();
                                break;
                            case 5:
                                System.out.println("Thoát Menu Danh Mục !.");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ !.");
                        }
                    } while (choose != 5);
                    break;
                case 2:
                    int input = 0;
                    do {
                        System.out.println("""
                                 ============== MENU QUẢN LÍ SÁCH ==============
                                 1. Thêm sách.
                                 2. Xóa sách.
                                 3. Cập nhật sách.
                                 4. Hiển thị danh sách sách.
                                 5. Thoát.
                                """);
                        System.out.print("Nhập lựa chọn : ");
                        input = Integer.parseInt(sc.nextLine());
                        switch (input){
                            case 1:
                                Book newBook = new Book();
                                System.out.print("Nhập id cho sách : ");
                                newBook.setId(Integer.parseInt(sc.nextLine()));
                                System.out.print("Nhập tác giả sách : ");
                                newBook.setAuthor(sc.nextLine());
                                System.out.print("Nhập tên sách : ");
                                newBook.setTitle(sc.nextLine());
                                System.out.print("Nhập id danh mục của sách : ");
                                newBook.setCategoryId(Integer.parseInt(sc.nextLine()));
                                bookManager.add(newBook);
                                break;
                            case 2:
                                System.out.print("Nhập id sách muốn xóa : ");
                                int idDelete = Integer.parseInt(sc.nextLine());
                                bookManager.delete(idDelete);
                                break;
                            case 3:
                                Book newBookUpdate = new Book();
                                System.out.print("Nhập id sách cần update : ");
                                newBookUpdate.setId(Integer.parseInt(sc.nextLine()));
                                System.out.print("Nhập tác giả sách mới : ");
                                newBookUpdate.setAuthor(sc.nextLine());
                                System.out.print("Nhập tên sách mới : ");
                                newBookUpdate.setTitle(sc.nextLine());
                                System.out.print("Nhập id danh mục của sách mới : ");
                                newBookUpdate.setCategoryId(Integer.parseInt(sc.nextLine()));
                                bookManager.update(newBookUpdate);
                                break;
                            case 4:
                                bookManager.displayALL();
                                break;
                            case 5:
                                System.out.println("Thoát Menu Danh Mục !.");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ !.");
                        }
                    } while (input != 5);
                    break;
                case 3:
                    System.out.println("Chương trình kết thúc !");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ !");
            }
        } while (choice != 3);
    }
}