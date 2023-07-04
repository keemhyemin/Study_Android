package com.example.lastcloneappproject.order;

public class OrderDTO {

    private int imgfav, imgdot;
    private String shop, address, distance;

    public OrderDTO(int imgfav, int imgdot, String shop, String address, String distance) {
        this.imgfav = imgfav;
        this.imgdot = imgdot;
        this.shop = shop;
        this.address = address;
        this.distance = distance;
    }

    public int getImgfav() {
        return imgfav;
    }

    public void setImgfav(int imgfav) {
        this.imgfav = imgfav;
    }

    public int getImgdot() {
        return imgdot;
    }

    public void setImgdot(int imgdot) {
        this.imgdot = imgdot;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
