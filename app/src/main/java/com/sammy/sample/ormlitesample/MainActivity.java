package com.sammy.sample.ormlitesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sammy.sample.ormlitesample.db.DatabaseHelper;
import com.sammy.sample.ormlitesample.db.dao.ArticleDao;
import com.sammy.sample.ormlitesample.db.dao.UserDao;
import com.sammy.sample.ormlitesample.db.models.Article;
import com.sammy.sample.ormlitesample.db.models.User;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //http://blog.csdn.net/lmj623565791/article/details/39122981

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //testAddArticle();
        List<User> users = new UserDao(this).getAllUser();
        Log.d(TAG, users.size() + "");
    }

    private void addArticle(User user) {
        new UserDao(this).add(user);
        //Article article = new Article();
        //article.setTitle("ORMLite");
        //article.setUser(u);
        //new ArticleDao(this).add(article);
    }

    public void testGetArticleById() {
        Article article = new ArticleDao(this).get(1);
        Log.e(TAG, article.getUser() + " , " + article.getTitle());
    }

    public void testGetArticleWithUser() {
        Article article = new ArticleDao(this).getArticleWithUser(1);
        Log.e(TAG, article.getUser() + " , " + article.getTitle());
    }

    public void testListArticlesByUserId() {
        List<Article> articles = new ArticleDao(this).listByUserId(1);
        Log.e(TAG, articles.toString());
    }
}
