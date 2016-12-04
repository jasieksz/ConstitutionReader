package jsz.op.cr;

/*
    Represents single chapter in the constitution
    Stores all the articles from this chapter
*/

import java.util.ArrayList;
import java.util.List;

public class Chapter {

    public final String chapterName;
    private List<Article> articleList = new ArrayList<>();

    public Chapter (String chapterName) {
        this.chapterName = chapterName;
    }

    public void addArticle(Article article){
        articleList.add(article);
    }

    @Override
    public String toString() {
        return chapterName;
    }

    public void printArticles (){
        for (Article article : articleList) {
            System.out.println(article.toString());
        }
    }
}
