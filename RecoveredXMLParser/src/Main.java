
import java.awt.*;
import java.io.Console;
import java.io.File;
import java.util.Scanner;
import static java.lang.System.*;

/* *******************************
As of 11:05PM 3/16/15 (45 minutes before this assignment is due)
I have a working parser, and functional tree structuring.
Normally I would have done an assignment like this in C#, but
I wanted to challenge myself and learn the nuances of Java,
as this assignment presented itself as a good opportunity to
learn the main differences between the two.

That being said, I have tried my best to use best coding
practices, such as loose coupling, encapsulation, code
commenting, and proper naming conventions. If you take the time
to read through all of this, please let me know the areas in
which I could improve my coding etiquette.

 ********************************/

public class Main {
    public static void main(String[] args) {
        BehaviorTree bt;
        //fr.TestFileReadLocation();
        FileReader.openFile();
        FileReader.printFile();
        bt = FileReader.buildTree();
        bt.printTree();
        bt.respondUserInput();
    }
}
