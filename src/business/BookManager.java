package business;

import model.Book;
import myInterface.IManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager implements IManager<Book> {
    List<Book> books = new ArrayList<>();
    @Override
    public void add(Book item) {
        books.add(item);
        System.out.println("Thêm mới sách thành công .");
    }

    @Override
    public void update(Book item) {
        boolean flag = false;
        for (int i = 0 ; i < books.size() ; i++){
            if (books.get(i).getId() == item.getId()){
                books.set(i,item);
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("Cập nhật sách thành công .");
        } else {
            System.out.println("Không tìm thấy id sách cần cập nhật .");
        }
    }



    @Override
    public void delete(int id) {
        boolean flag = false;
        for (int i = 0 ; i < books.size() ; i++){
            if (books.get(i).getId() == id){
                books.remove(i);
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("Xóa sách thành công .");
        } else {
            System.out.println("Không tìm thấy id sách cần xóa .");
        }
    }

    @Override
    public void displayAll() {
        for (int i = 0 ; i < books.size() ; i++){
            books.get(i).displayData();
            System.out.println("");
        }
    }

}
