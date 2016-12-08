package jsz.op.cr;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by JASIEK on 2016-12-08.
 */
public class ConstitutionShowerTest {

    @Test(expected = IllegalArgumentException.class)
    public void printChapterTest1() throws Exception {
        new Constitution().printChapters(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void printChapterTest2() throws Exception {
        new Constitution().printChapters(14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void printArticlesTest() throws Exception {
        new Constitution().printArticles(-1,4);
    }

    @Test
    public void chapterPrintTest(){
        Assert.assertEquals("ROZDZIAL II", new Chapter("ROZDZIAL II").toString());
    }

}