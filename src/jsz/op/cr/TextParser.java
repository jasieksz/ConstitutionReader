package jsz.op.cr;

import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/*
    This class is responisble for reading the text file
    and correcting it : remove unnecessary elements and fix end line splits
*/
public class TextParser {

    private final static Charset ENCODING = StandardCharsets.UTF_8;
    private List<String> constitutionArray = new ArrayList<>();

    public List<String> getConstitutionArray() {
        return constitutionArray;
    }

    public void readConstitutuion(String FileName) throws IOException {
        Path path = Paths.get(FileName);
        try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
            String line = null;
            String lineTmp = null;
            Integer i = 0;
            while ((line = reader.readLine()) != null){
                if (line.equals("©Kancelaria Sejmu") || line.matches("....-..-..") || line.length() < 2)
                    System.out.print("");
                else{
                    if (line.endsWith("-")){ // NIE DZIALA jeżeli 2 linie podrzą mają "-"
                        lineTmp = reader.readLine(); //nie trzeba sprawdzac czy ostatnio bo konczy sie na -
                        line = line.substring(0,line.length()-1);
                        if (!lineTmp.contains(" ")){
                            line = line.concat(lineTmp);
                            constitutionArray.add(i,line);
                            i += 1;
                        }
                        else if (lineTmp.length() > lineTmp.indexOf(" ") && !lineTmp.contains("-")){
                            line = line.concat(lineTmp.substring(0,lineTmp.indexOf(" ")));
                            lineTmp = lineTmp.substring(lineTmp.indexOf(" ")+1,lineTmp.length());
                            constitutionArray.add(i,line);
                            constitutionArray.add(i+1,lineTmp);
                            i += 2;
                        }
                        else if (lineTmp.length() > lineTmp.indexOf(" ") && lineTmp.contains("-")){
                            line = line.concat(lineTmp.substring(0,lineTmp.indexOf(" ")));
                            lineTmp = lineTmp.substring(lineTmp.indexOf(" ")+1,lineTmp.length());
                            constitutionArray.add(i,line);
                            line = lineTmp;
                            lineTmp = reader.readLine();
                            line = line.concat(lineTmp.substring(0,lineTmp.indexOf(" ")));
                            lineTmp = lineTmp.substring(lineTmp.indexOf(" ")+1,lineTmp.length());
                            constitutionArray.add(i+1,lineTmp);
                            i += 3;

                        }
                    }
                    else {
                        constitutionArray.add(i,line);
                        i += 1;
                    }

                }

            }
        }
    }

    public void printConstitution (){
        for (String line : constitutionArray) {
            System.out.println(line);
        }
    }

}
