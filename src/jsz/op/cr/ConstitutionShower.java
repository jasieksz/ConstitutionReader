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

    public void readConstitution(String[] args){
        try {
            //opcje = inputParser.readCmd();
            parser.parseConstitution(args[0]); // parsuje niepotrzebne znaki i "-"
            constitution.objectifyConstitution(ConstitutionParser.getConstitutionArray()); // tworzy rozdziały i artykuły
            inputParser.argsParse(constitution, args); //obsluga wypisywania - TODO "change class/method name"
        } catch (IOException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }
    }
}

