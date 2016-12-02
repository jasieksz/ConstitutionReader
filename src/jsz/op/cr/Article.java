package jsz.op.cr;

import java.util.ArrayList;
import java.util.List;

/*
    Represents single article in the constitution
    Stores all the points from this article
*/
public class Article {

    private final String article;
    @Override
    public String toString() {
        return article;
    }

    public String getArticle() {
        return article;
    }



    public Article(String article) {
        this.article = article;
    }


}
