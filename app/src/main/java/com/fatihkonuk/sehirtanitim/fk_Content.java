package com.fatihkonuk.sehirtanitim;

public class fk_Content {
    public int id;
    public String name;
    public String details;
    public int img;
    public int parentId;

    public fk_Content(int id, String name, String details, int img, int parentId) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.img = img;
        this.parentId = parentId;
    }
}
