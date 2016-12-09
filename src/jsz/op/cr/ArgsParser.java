package jsz.op.cr;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArgsParser {

    /*
    // wczytyanie argumentow z cmd, i wpisanie ich do tablicy
    public String[] readCmd(){
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        String s = sc.next();
        String[] opcje = s.split(" ");
        return opcje;
    }*/
// obsługa opcji
    public void argsParse(Constitution constitution, String[] opcje) throws IllegalArgumentException{
        if (opcje[1].equals("Rozdział"))
            constitution.printChapters(Integer.valueOf(opcje[2]));
        else if (opcje[1].equals("Wstęp"))
            constitution.printIntro();
        else if (opcje[1].equals("Artykuł"))
            constitution.printArticles(Integer.valueOf(opcje[2]),Integer.valueOf(opcje[2]));
        else if (opcje[1].equals("Artykuły"))
            constitution.printArticles(Integer.valueOf(opcje[2]),Integer.valueOf(opcje[3]));
        else
            throw new IllegalArgumentException("Nie ma takiego polecenia : " + opcje[1]);

    }
}
