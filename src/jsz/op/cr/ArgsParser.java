package jsz.op.cr;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArgsParser {

    private static String[] opcje;

    private static void readCmd(){
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        String s = sc.next();
        opcje = s.split(" ");
    }
// ERROR -> 13 rozdziałów 243 artykuly
    public void argsParse(Constitution constitution){
        readCmd();
        if (opcje[0].equals("Rozdział"))
            constitution.printChapters(Integer.valueOf(opcje[1]));
        if (opcje[0].equals("Wstęp"))
            constitution.printIntro();
        if (opcje[0].equals("Artykuł"))
            constitution.printArticles(Integer.valueOf(opcje[1]),Integer.valueOf(opcje[1]));
        if (opcje[0].equals("Artykuły"))
            constitution.printArticles(Integer.valueOf(opcje[1]),Integer.valueOf(opcje[2]));

    }
}
