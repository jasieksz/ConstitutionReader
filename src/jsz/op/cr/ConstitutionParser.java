package jsz.op.cr;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ConstitutionParser {

    private final static Charset ENCODING = StandardCharsets.UTF_8;
    public static List<String> constitutionArray = new ArrayList<>();

    public List<String> getConstitutionArray() {
        return constitutionArray;
    }


    public void parseConstitution (String fileName) throws IOException{
        try (Stream<String> lines = Files.lines(Paths.get(fileName),ENCODING)){
           constitutionArray = lines
                   .filter(line -> !line.matches("....-..-.."))
                   .filter(line -> !line.equals("©Kancelaria Sejmu"))
                   .filter(line -> line.length() > 1)
                   .collect(Collectors.toCollection(ArrayList::new));
           parseSplitLines();
        }
    }

    public static void parseSplitLines(){
        Integer i=0;
        Integer size = constitutionArray.size();
        String line1 = null;
        String line2 = null;
        while (i < size){
            if (constitutionArray.get(i).endsWith("-")){
                line1 = constitutionArray.get(i);
                line2 = constitutionArray.get(i+1);
                line1 = line1.substring(0,line1.length()-1);

                if (line2.contains(" ")){
                    line1 = line1.concat(line2.substring(0,line2.indexOf(" ")));
                    line2 = line2.substring(line2.indexOf(" ")+1,line2.length());
                    constitutionArray.set(i,line1);
                    constitutionArray.set(i+1,line2);
                    i+=1;
                }
                else if(!line2.contains(" ")){
                    line1 = line1.concat(line2);
                    constitutionArray.set(i,line1);
                    constitutionArray.remove(i+1);
                    size-=1;
                    i+=1;
                }
            }
            else
                i+=1;
        }
    }

    public void printConstitution(){
        for(String line : constitutionArray)
            System.out.println(line);
    }
}

