package com.example.ahsanulhoque.finoffer.domain;


public class ProductType {

    private String id;
    private boolean isClothing;
    private boolean isElectronics;
    private boolean isFood;

    public ProductType() {
    }

    public ProductType(String id, boolean isClothing, boolean isElectronics, boolean isFood) {
        this.id = id;
        this.isClothing = isClothing;
        this.isElectronics = isElectronics;
        this.isFood = isFood;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isClothing() {
        return isClothing;
    }

    public void setClothing(boolean clothing) {
        isClothing = clothing;
    }

    public boolean isElectronics() {
        return isElectronics;
    }

    public void setElectronics(boolean electronics) {
        isElectronics = electronics;
    }

    public boolean isFood() {
        return isFood;
    }

    public void setFood(boolean food) {
        isFood = food;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", isClothing=" + isClothing +
                ", isElectronics=" + isElectronics +
                ", isFood=" + isFood +
                '}';
    }

}
