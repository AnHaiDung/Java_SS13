package business;

import model.Category;
import myInterface.IManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryManager implements IManager<Category> {
    List<Category> categories = new ArrayList<>();
    @Override
    public void add(Category item) {
        categories.add(item);
        System.out.println("Thêm mới danh mục thành công .");
    }

    @Override
    public void update(Category item) {
        boolean flag = false;
        for (int i = 0 ; i < categories.size() ; i++){
            if (categories.get(i).getId() == item.getId()){
                categories.set(i,item);
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("Cập nhật danh mục thành công .");
        } else {
            System.out.println("Không tìm thấy id danh mục cần cập nhật .");
        }
    }

    @Override
    public void delete(int id) {
        boolean flag = false;
        for (int i = 0 ; i < categories.size() ; i++){
            if (categories.get(i).getId() == id){
                categories.remove(i);
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("Xóa danh mục thành công .");
        } else {
            System.out.println("Không tìm thấy id danh mục cần xóa .");
        }
    }

    @Override
    public void displayALL() {
        for (int i = 0 ; i < categories.size() ; i++){
            categories.get(i).displayData();
            System.out.println("");
        }
    }
}
