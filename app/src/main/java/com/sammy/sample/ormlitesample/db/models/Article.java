package com.sammy.sample.ormlitesample.db.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Article")
public class Article
{
    @DatabaseField(generatedId = true, columnName = "Id")
    private int id;
    @DatabaseField(columnName = "Title")
    private String title;
    @DatabaseField(canBeNull = true, foreign = true, columnName = "UserId")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", user=" + user + "]";
    }
}

