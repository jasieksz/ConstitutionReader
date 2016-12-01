package jsz.op.cr;

import java.io.IOException;

/*
    This class is responsible for showing selected chapters
     or articles from already parsed constitution text file
 */
public class ConstitutionShower {

    public TextParser parser = new TextParser();

    protected void readConstitution(String args[]){
        try {
            parser.readConstitutuion("C:\\Users\\JASIEK\\Google Drive\\AGH\\Semestr III\\Programowanie Obiektowe\\ConstitutionReader\\konstytucja.txt");
            parser.printConstitution();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

