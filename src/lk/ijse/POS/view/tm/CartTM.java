package lk.ijse.POS.view.tm;

import javafx.scene.control.Button;

public class CartTM {
    private String code;
    private String description;
    private double unitprice;
    private int qty;
    private double total;
    private Button deleteButton;

    public CartTM() {
    }

    public CartTM(String code, String description, double unitprice, int qty, double total, Button deleteButton) {
        this.setCode(code);
        this.setDescription(description);
        this.setUnitprice(unitprice);
        this.setQty(qty);
        this.setTotal(total);
        this.setDeleteButton(deleteButton);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    @Override
    public String toString() {
        return "CartTM{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", unitprice=" + unitprice +
                ", qty=" + qty +
                ", total=" + total +
                ", deleteButton=" + deleteButton +
                '}';
    }
}



