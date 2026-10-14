package com.byreytiz.game.gui.famshop;

public class FamShopModel {

    int id, cost;
    String name, name2, img;

    public FamShopModel(int id, String name, String img, int cost) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.cost = cost;
    }

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}