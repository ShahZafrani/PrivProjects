package com.munist;

import java.io.Console;
import java.util.Scanner;
import static java.lang.System.*;

//change function names to start lowerCased

public class Main {

    public static void main(String[] args) {
        BehaviorTree bt = new BehaviorTree(null);
        //fr.TestFileReadLocation();
        FileReader.OpenFile();
        FileReader.PrintFile();
        //FileReader.ParseFile(bt);
    }
}
