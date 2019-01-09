package test;

import test.ProductEntity;

import java.util.Set;

public class User {

    int id;
    String name;
    Set<ProductEntity> products;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<ProductEntity> getProducts() {
        return products;
    }
    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }
}
