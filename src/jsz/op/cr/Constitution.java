package jsz.op.cr;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.min;

/*
    This class represents constitution in state
    after parsing the text with TextParser class

    Class is responsible for objectifying text file after it is parsed.
 */
public class Constitution {

    private List<Chapter> chapterList = new ArrayList<>();
    private List<Article> articleList = new ArrayList<>();
    private long chapterCounter;
    private long articleCounter;

    private void countObjects(List<String> constitution){
        chapterCounter = constitution.stream().filter(line -> line.contains("Rozdział")).count();
        articleCounter = constitution.stream().filter(line -> line.contains("Art.")).count();
    }

    public void objectifyConstitution(List<String> constitution) {

        Integer size = constitution.size();
        Integer i = 0;
        Integer iarticle = 0;
        Integer ichapter = 0;
        String schapter = null;
        String sarticle = null;
        countObjects(constitution);
        //System.out.println("Debug0 : i=" + i +" ichap=" + ichapter +" iart="+iarticle + " size=" + size);

        while (i < size) {

            i = findChapter(i, constitution);
            iarticle = findArticle(i, constitution);
            schapter = joinStrings(i,iarticle-1,constitution);
            Chapter chapter = new Chapter(schapter);
            chapterCounter -= 1;
            ichapter = findChapter(i+1,constitution);

            while (i < ichapter){

                i = findArticle(i, constitution);
                iarticle = findArticle(i+1,constitution);
                sarticle = joinStrings(i,min(iarticle-1,ichapter-1),constitution);

                Article article = new Article(sarticle);
                articleCounter -= 1;
                i = iarticle;
                chapter.addArticle(article);
                articleList.add(article);
            }
            chapterList.add(chapter);
            i = ichapter;
        }

    }

    private Integer findArticle(Integer i, List<String> constitution){
        Integer article = i;
        while (articleCounter > 0 && article < constitution.size() && !constitution.get(article).contains("Art. "))
            article += 1;
        return article;
    }

    private Integer findChapter(Integer i, List<String> constitution){
        Integer chapter = i;
            while (chapterCounter>0 && chapter < constitution.size() && !constitution.get(chapter).contains("Rozdział"))
                chapter += 1;
        return chapter;
    }

    private String joinStrings(Integer s, Integer e, List<String> constitution) {
        String result = constitution.get(s);
        s += 1;
        while (s <= e) {
            result = String.join("\n", result, constitution.get(s));
            s += 1;
        }
        return result;
    }

    public void printChapters(){
        for (Chapter c : chapterList){
            System.out.println(c.toString());
        }
    }
    public void printArticles(){
        for (Article c : articleList){
            System.out.println(c.toString());
        }
    }


}
