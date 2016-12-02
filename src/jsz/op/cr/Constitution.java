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
        String line = null;


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

}
