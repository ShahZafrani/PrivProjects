package com.munist;

import java.io.Console;
import java.util.Scanner;
import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        BehaviorTree bt = new BehaviorTree();
        //fr.TestFileReadLocation();
        FileReader.OpenFile();
        FileReader.PrintFile();
        //FileReader.ParseFile(bt);
    }
}
