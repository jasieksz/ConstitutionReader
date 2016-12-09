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
   // private String path = "C:\\Users\\JASIEK\\Google Drive\\AGH\\Semestr III\\Programowanie Obiektowe\\ConstitutionReader\\konstytucja.txt";

    public void readConstitution(String path){
        try {
            //opcje = inputParser.readCmd();
            parser.parseConstitution(path); // parsuje niepotrzebne znaki i "-"
            constitution.objectifyConstitution(ConstitutionParser.getConstitutionArray()); // tworzy rozdziały i artykuły
            inputParser.argsParse(constitution, inputParser.readCmd()); // wczytywanie arguemtnow z cmd i obsluga wypisywania
        } catch (IOException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }
    }
}

