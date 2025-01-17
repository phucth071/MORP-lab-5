package vn.hcmute.lab5.models;

import java.io.Serializable;

public class Fruit implements Serializable {
    private String name;
    private String desc;
    private int image;

    public Fruit() {
    }

    public Fruit(String name, String desc, int image) {
        this.name = name;
        this.desc = desc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
