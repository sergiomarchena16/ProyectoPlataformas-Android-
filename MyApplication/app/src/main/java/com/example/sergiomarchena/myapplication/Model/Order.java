package com.example.sergiomarchena.myapplication.Model;

/**
 * Created by SergioMarchena on 5/31/18.
 */

public class Order {

    private String ProdutcId, ProductName, Quantity, Price, Discount;

    public Order(){

    }

    public Order(String produtcId, String productName, String quantity, String price, String discount) {
        ProdutcId = produtcId;
        ProductName = productName;
        Quantity = quantity;
        Price = price;
        Discount = discount;
    }

    public String getProdutcId() {
        return ProdutcId;
    }

    public void setProdutcId(String produtcId) {
        ProdutcId = produtcId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}
