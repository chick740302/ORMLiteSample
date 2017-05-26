package com.sammy.sample.ormlitesample.db.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.sammy.sample.ormlitesample.db.DatabaseHelper;
import com.sammy.sample.ormlitesample.db.models.Article;
import com.sammy.sample.ormlitesample.db.models.User;

import java.sql.SQLException;
import java.util.List;

public class ArticleDao {
    private Dao<Article, Integer> articleDaoOpe;
    private DatabaseHelper helper;

    @SuppressWarnings("unchecked")
    public ArticleDao(Context context) {
        try {
            helper = DatabaseHelper.getHelper(context);
            articleDaoOpe = helper.getDao(Article.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Article article) {
        try {
            articleDaoOpe.create(article);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public Article getArticleWithUser(int id) {
        Article article = null;
        try {
            article = articleDaoOpe.queryForId(id);
            helper.getDao(User.class).refresh(article.getUser());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    public Article get(int id) {
        Article article = null;
        try {
            article = articleDaoOpe.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    public List<Article> listByUserId(int userId) {
        try {
            return articleDaoOpe.queryBuilder().where().eq("UserId", userId).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}