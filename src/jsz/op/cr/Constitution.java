package jsz.op.cr;

import java.util.ArrayList;
import java.util.List;

/*
    This class represents constitution in state
    after parsing the text with TextParser class

    Class is responsible for objectifying text file after it is parsed.
 */
public class Constitution {

    private List<Chapter> chapterList = new ArrayList<>();
    private List<Article> articleList = new ArrayList<>();

    public void objectifyConstitution(List<String> constitution){
        Integer i = 0;
        Integer iNextChapter = 0;
        Integer iNextArticle = 0;
        String line = null;
        String lineTmp = null;
        while (i < constitution.size()){
            i = indexOfChapter(i,constitution);
            line = joinStrings(i,i+1,constitution);
            Chapter chapter = new Chapter(line);
            chapterList.add(chapter);
            iNextChapter = indexOfChapter(i,constitution);
            i = indexOfArticle(i,constitution); // czy moge wywalic za while
            while (i < iNextChapter){
                iNextArticle = indexOfArticle(i+1,constitution);
                line = joinStrings(i,iNextArticle-1,constitution);
                Article article = new Article(line);

                articleList.add(article);
                // update listy artykolow rozdzialu
                Chapter chapterTmp = chapterList.get(chapterList.size()-1); // ostatni element
                chapterTmp.addArticle(article);
                chapterList.set(chapterList.size()-1,chapterTmp);

                i = iNextArticle;
            }
        }
    }

    // Finds index of the next chapter in the array
    private Integer indexOfChapter(Integer start , List<String> constitution){
        String line = constitution.get(start);
        while (!line.contains("Rozdział")) {
            start += 1;
            line = constitution.get(start);
        }
        return start;
    }
    // Finds index of the next article in the array
    private Integer indexOfArticle(Integer start , List<String> constitution){
        String line = constitution.get(start);
        while (!line.contains("Art.")) {
            start += 1;
            line = constitution.get(start);
        }
        return start;
    }
    // przedział [start,end]
    private String joinStrings (Integer start, Integer end, List<String> constitution){
        String result = constitution.get(start);
        while (start < end){
            start++;
            String tmp = constitution.get(start);
            result = String.join("\n",result,tmp);
        }
        return result;
    }

}
