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
    private ArgsParser inputParser = new ArgsParser();
    private final String path = "C:\\Users\\JASIEK\\Google Drive\\AGH\\Semestr III\\Programowanie Obiektowe\\ConstitutionReader\\konstytucja.txt";

    public void readConstitution(){
        try {
            parser.parseConstitution(path);
            constitution.objectifyConstitution(parser.getConstitutionArray());
            inputParser.argsParse(constitution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

