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
    private List<String> introConst = new ArrayList<>();

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

        ichapter = findChapter(0,constitution);
        for (Integer j=0;j<ichapter;j++){
            introConst.add(constitution.get(j));
        }

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

                //if (constitution.get(i).contains("Art. 243"))
                    //System.out.println("Debug1 : i="+i+ "ich="+ichapter+" iart="+iarticle);

                if (i < ichapter)
                    sarticle = joinStrings(i,min(iarticle-1,ichapter-1),constitution);
                else
                    sarticle = joinStrings(i,min(size-1,iarticle-1),constitution);
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
            if (chapterCounter == 0)
                return constitution.size();
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

    public void printChapters(Integer a) throws IllegalArgumentException {
        if (a < 1 || a > 13)
            throw new IllegalArgumentException("Nie ma takiego rozdziału");
        System.out.println(chapterList.get(a-1).toString());
        chapterList.get(a-1).printArticles();
    }
    public void printArticles(Integer a, Integer b) throws IllegalArgumentException{
        if (a < 1 || b > 243)
            throw new IllegalArgumentException("Nie ma takiego artykułu");
        if (b < a)
            throw new IllegalArgumentException("Zły zakres artykułów");
        while (a <= b){
            System.out.println(articleList.get(a-1).toString());
            a +=1;
        }
    }
    public void printIntro(){
        for (String line : introConst)
            System.out.println(line);
    }


}
