package com.sammy.sample.ormlitesample.db.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "User")
public class User {
    @DatabaseField(generatedId = true, columnName = "Id")
    private int id;

    @DatabaseField(columnName = "Name")
    private String name;

    @DatabaseField(columnName = "Description")
    private String desc;
    public User() {

    }
    public User(String name, String desc) {
        this.setName(name);
        this.setDesc(desc);
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}