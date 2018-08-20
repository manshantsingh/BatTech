package com.example.brand_000.battech;

/**
 * Created by Tejrai on 2017-04-07.
 */

public class File {
    private int id;
    private String description;
    private byte[] image;

    public File(int id, String description, byte[] image) {
        this.id = id;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
