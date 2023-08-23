package org.kainos.ea.cli;

public class Product implements Comparable<Product> {
    private int ProductID;
    private String Name;

    public Product(int productID, String name, String description, double price) {
        ProductID = productID;
        Name = name;
        Description = description;
        Price = price;
    }

    private String Description;

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    private double Price;

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }

    @Override
    public String toString(){
        return "Product name " + this.getName() + ", product price " + this.getPrice();
    }
}
