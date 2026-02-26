package btvn.bai6;

import java.util.Scanner;

public class Medicine {
    private String drugId;
    private String drugName;
    private double unitPrice;
    private int quantity;

    public Medicine(String drugId, String drugName, double unitPrice, int quantity) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return unitPrice * quantity;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-25s %12.0f %10d %15.0f",
                drugId, drugName, unitPrice, quantity, getTotalPrice());
    }
}
