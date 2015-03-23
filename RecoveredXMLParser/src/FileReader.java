import java.io.File;
//import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by ShahZafrani on 3/5/2015.
 */
public class FileReader {
    static Scanner scanner;

    private FileReader() {
    }

    public static String takeInput() //Read in the user's input to identify which file they would like to open
    {
        System.out.println("Enter the name of the file you would like to open. (with file extension)");
        Scanner s = new Scanner(System.in);
        String input = s.next();
        System.out.println("Input Recorded:" + "'" + input + "'");
        return input;
    }

    /*public static void TestFileReadLocation() //So I can find where to put the file I want to read
    {
        Formatter x;
        try {
            x = new Formatter("test.txt");
        } catch (Exception e) {
            System.out.println("no");
        }

    }*/

    public static void openFile() { //Reads the file specified by the TakeInput method
        try {
            scanner = new Scanner(new File("Sample.xml"));//takeInput()));
        } catch (Exception e) {
            System.out.println("404 File not Found. Check to see if it is in the right directory, and that you spelled the filename properly");
        }
    }

    public static void printFile() {
        System.out.println("This is the file you selected");
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            System.out.println(a);
            //System.out.println(parseString(a));
        }
        scanner.close();
        System.out.println("Verify that this is the correct file by typing the name again.");
        openFile();
    }
public static BehaviorTree buildTree() {
    BehaviorTree sprout;
    Node root = new Node();
    root.identifier = "root";
    root.isResponse = false;
    sprout = new BehaviorTree(root);
    boolean rooted = false;
    if (scanner.nextLine().contains("<root>"))
    {
        rooted = true;
    }
    if (rooted) {
        while (scanner.hasNext()) {
            String next = scanner.nextLine().trim();
            if (next.equalsIgnoreCase("</root>")) {
                break;
            }
            else {
                if (!next.equalsIgnoreCase("</node>")) {
                    sprout.root.addChild(addNode(next));
                }
                else {
                    Node temp = new Node();
                    //sprout.root.addChild(temp);
                    sprout.root.children.add(temp);
                }
            }
        }
    }
    scanner.close();
    return sprout;
}

    public static Node addNode(String s)
    {
        Node temp = new Node();
        if (s.contains("/>"))
        {
            temp.isResponse = true;
            temp.identifier = parseString(s);
            //System.out.println(temp.identifier);
            return temp;
        }
        else
        {
            temp = new Node();
            temp.identifier = parseString(s);
            //System.out.println(temp.identifier);
            String next = scanner.nextLine().trim();
            while(!next.contains("</node>")){
                //temp.addChild(addNode(next));
                temp.children.add(addNode(next));
                next = scanner.nextLine().trim();
            }
            return temp;
        }
    }

    public static String parseString(String current){ // recurse through and return a nested structure of behaviors and responses
        String s;
        if (current.contains("behavior=\"\""))
        {
            s = current.substring(28,current.length()-3);
            //System.out.println(s);
            return s;
        }
        else if ((current.contains("response=\"\"")))// || ((!current.contains("response")) && (current.contains("behavior"))))
        {
            s = current.substring(16, current.length()-14);
            //System.out.println(s);
            return s;
        }
        else return current.substring(16, current.length()-2);
    }
}
