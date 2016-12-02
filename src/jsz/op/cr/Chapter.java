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
}
