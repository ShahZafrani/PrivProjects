package com.munist;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by ShahZafrani on 3/5/2015.
 */
public class FileReader {
    static Scanner scanner;
    private FileReader () {}

    public static String TakeInput() //Read in the user's input to identify which file they would like to open
    {
        System.out.println("Enter the name of the file you would like to open. (with file extension)");
        Scanner s = new Scanner(System.in);
        String input = s.next();
        System.out.println("Input Recorded:" + "'" + input + "'");
        return input;
    }
    public static void TestFileReadLocation() //So I can find where to put the file I want to read
    {
        Formatter x;
        try {
            x = new Formatter("test.txt");
        }
        catch (Exception e) {
            System.out.println("no");
        }

    }
    public static void OpenFile() { //Reads the file specified by the TakeInput method
        try{
            scanner = new Scanner(new File(TakeInput()));
        }
        catch (Exception e) {
            System.out.println("404 File not Found. Check to see if it is in the right directory, and that you spelled the filename properly");
        }
    }
    public static void PrintFile(){
        while (scanner.hasNext()) {
            String a = scanner.next();
            System.out.println(a);
        }
    }
    public static void ParseFile()
    {
        // put all of your parsing logic here
    }

}
