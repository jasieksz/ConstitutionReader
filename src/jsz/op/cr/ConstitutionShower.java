package jsz.op.cr;

import java.io.IOException;
import java.util.ArrayList;

/*
    This class is responsible for showing selected chapters
     or articles from already parsed constitution text file
 */
public class ConstitutionShower {

    private ConstitutionParser parser = new ConstitutionParser();
    private Constitution constitution = new Constitution();
    private final String path = "C:\\Users\\JASIEK\\Google Drive\\AGH\\Semestr III\\Programowanie Obiektowe\\ConstitutionReader\\konstytucja.txt";

    public void readConstitution(String args[]){
        try {
            parser.parseConstitution(path);
            //parser.printConstitution();
            constitution.objectifyConstitution(parser.getConstitutionArray());
            constitution.printChapters();
            constitution.printArticles();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

