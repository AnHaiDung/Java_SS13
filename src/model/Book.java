package model;

import java.util.Scanner;

public class Book {
    private int id;
    private String title;
    private String author;
    private int categoryId;

    public Book(int id, String title, String author, int categoryId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.categoryId = categoryId;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void displayData(){
        System.out.printf("| ID : %d | Title : %s | Author : %s | CategoryId : %d |", this.id , this.title , this.author , this.categoryId);
    }
}
