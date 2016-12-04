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

        while (chapterCounter > 0 && i < size) {

            i = findChapter(i, constitution);
            iarticle = findArticle(i, constitution);
            schapter = joinStrings(i,iarticle-1,constitution);
            Chapter chapter = new Chapter(schapter);
            chapterCounter -= 1;
            ichapter = findChapter(i+1,constitution);

            while (i < ichapter){

                i = findArticle(i, constitution);
                iarticle = findArticle(i+1,constitution);
                if (i < ichapter)
                    sarticle = joinStrings(i,min(iarticle-1,ichapter-1),constitution);
                else
                    sarticle = joinStrings(i,size-1,constitution);
                //System.out.println("Debug : i=" + i +" iart="+iarticle +" ichap=" + ichapter  + " size=" + size);
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

    public void printChapters(Integer a){
        System.out.println(chapterList.get(a-1).toString());
        chapterList.get(a-1).printArticles();
    }
    public void printArticles(Integer a, Integer b){
        while (a <= b){
            System.out.println(articleList.get(a-1).toString());
            a +=1;
        }
    }


}
