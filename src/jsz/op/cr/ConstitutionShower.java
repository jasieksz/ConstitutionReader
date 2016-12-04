package jsz.op.cr;

import java.io.IOException;

/*
    This class is responsible for showing selected chapters
     or articles from already parsed constitution text file
 */
public class ConstitutionShower {

    private ConstitutionParser parser = new ConstitutionParser();
    private final String path = "C:\\Users\\JASIEK\\Google Drive\\AGH\\Semestr III\\Programowanie Obiektowe\\ConstitutionReader\\konstytucja.txt";

    public void readConstitution(String args[]){
        try {
            parser.parseConstitution(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

