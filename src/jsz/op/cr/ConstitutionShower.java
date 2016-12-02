package jsz.op.cr;

import java.io.IOException;
import java.util.List;

/*
    This class is responsible for showing selected chapters
     or articles from already parsed constitution text file
 */
public class ConstitutionShower {

    private TextParser parser = new TextParser();
    public Constitution constitution = new Constitution();

    protected void readConstitution(String args[]){
        try {
            parser.readConstitutuion("C:\\Users\\JASIEK\\Google Drive\\AGH\\Semestr III\\Programowanie Obiektowe\\ConstitutionReader\\konstytucja.txt");
            constitution.objectifyConstitution(parser.getConstitutionArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

