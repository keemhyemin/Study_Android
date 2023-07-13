package com.example.lastcloneappproject.giftshop;

public class DrinkDTO {
    private int imgRes;
    private String drinkName;

    public DrinkDTO(int imgRes, String drinkName) {
        this.imgRes = imgRes;
        this.drinkName = drinkName;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }
}
