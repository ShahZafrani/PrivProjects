package com.munist;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by ShahZafrani on 3/5/2015.
 */
public class FileReader {
    static Scanner scanner;

    private FileReader() {
    }

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
        } catch (Exception e) {
            System.out.println("no");
        }

    }

    public static void OpenFile() { //Reads the file specified by the TakeInput method
        try {
            scanner = new Scanner(new File("Sample.xml"));//TakeInput()));
        } catch (Exception e) {
            System.out.println("404 File not Found. Check to see if it is in the right directory, and that you spelled the filename properly");
        }
    }

    public static void PrintFile() {
        System.out.println("This is the file you selected");
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            System.out.println(a);
        }
    }

    public static void ParseFile(BehaviorTree tree) { // I might make this into a public static Behavior tree later on
        System.out.println("File parsing has commenced");
        boolean rooted = false;
        while (scanner.hasNext() == true) {
            Behavior temp;
            Response rtemp;
            if (!rooted){ //Checks to see if the root node has been placed yet or not. A later implementation of this might include: if(tree.root != null)
                if (scanner.nextLine().contains("<root>"))
                {
                    tree.root = new Behavior("root");
                    rooted = true; //root has been placed, no need to run these 3 lines again
                }
            }
            String next = scanner.nextLine(); // this lets me check the string without accidentally advancing
            if (next.contains("behavior=\"\"")) // checks to see the unique aspect that would identify a response on a line, versus a behavior
            {
                // parse down to just response name
                //add response
            }
            else if(next.contains("response=\"\""))
            {
                temp = ParseString(next);
                tree.root.children.add(temp); // its gonna get recursive up in this mug
            }
        }
        scanner.close();
    }
    public static Behavior ParseString(String current){ // recurse through and return a nested structure of behaviors and responses
        Behavior btemp = new Behavior("n");
        if((current.contains("<node"))&&(current.contains("\">")))
        {
            //btemp = ...
            //add behavior
            //return ParseString(scanner.nextLine());
        }
        //else if (current.contains(""))
        return btemp;
    }
}
