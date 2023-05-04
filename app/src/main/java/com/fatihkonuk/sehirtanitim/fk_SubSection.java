package com.fatihkonuk.sehirtanitim;

public class fk_SubSection {
    public int id;
    public String name;
    public int parentId;

    public fk_SubSection(int id, String name, int parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}
