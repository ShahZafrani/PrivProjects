/**
 * Created by Shah Zafrani on 3/9/2015.
 */

import java.util.*;
/**
 * Created by ShahZafrani on 3/5/2015.
 */
public class BehaviorTree {
    Node root;
    Scanner userInput = new Scanner(System.in);
    int counter;

    public BehaviorTree(Node rt) {
        root = rt;
    }

    public void printTree() { // does a bit of formatting, then calls printChildren on the root of the tree
        System.out.println();
        System.out.println();
        System.out.println("Printing Behavior Tree Structure...");
        printChildren(root);
    }

    public void printChildren(Node n) // prints children of this node and recurses through their children
    {
        System.out.println("Children of: " + n.identifier);
        for (Node c : n.children) {
            if (c.children.isEmpty()) {
                System.out.println(c.identifier);
            } else {
                System.out.println(c.identifier + " is a child of: " + n.identifier);
                printChildren(c);
            }
        }
    }

    public String printPrompt() {
        System.out.println("enter the behavior you would like me to respond to:");
        return userInput.nextLine();
    }

    public void printInstructions() {
        System.out.println("Would you like to search using Breadth-first, or Depth-first?");
        System.out.println("enter \"b\" for BREADTH-first, or \"d\" for DEPTH-first");
        System.out.println("enter \"x\" to EXIT");
    }

    public String chooseRandomResponse(Node n) {
        Random rand = new Random();
        ArrayList<String> possibilities = new ArrayList<String>();
        for (Node c : n.children) {
            if (c.isResponse == true) {
                possibilities.add(c.identifier);
            } else if (c.isResponse == false) {
                for (Node g : c.children) {
                    possibilities.add(g.identifier);
                }
            }
        }
        int r = rand.nextInt(possibilities.size());
        return possibilities.get(r);
    }

    public void respondUserInput() {
        printInstructions();
        boolean timeToQuit = false;
        while (!timeToQuit) {
            String input = userInput.nextLine();
            if (input.contains("b")) {
                System.out.println("Response: " + breadthFirst());
                printInstructions();
            } else if (input.contains("d")) {
                System.out.println("Response: " + depthFirst());
                printInstructions();
            } else if (input.contains("x")) {
                timeToQuit = true;
            } else {
                respondUserInput();
                timeToQuit = true;
            }
        }
    }

    public String breadthFirst() {
        System.out.println("You have chosen Breadth-First");
        String s = printPrompt();
        String result = recurseBreadthFirst(s, root) + " Steps: " + counter;
        counter = 0;
        return result;
        //return findBreadthFirst(s);
    }

    /*public String findBreadthFirst(String request) /*this is where I hit crunch time. I will have filled in this psuedo code with working methods,
    and will update this to use recursion as I am basically doing the same thing over and over again.*//*
    {
        for (Node n : root.children){
            if (n.identifier.equalsIgnoreCase(request)) {
                return chooseRandomResponse(n);
            }
        }
        for (Node n : root.children)
        {
            for (Node c : n.children)
            {
                if (c.identifier.equalsIgnoreCase(request))
                {
                    return chooseRandomResponse(n);
                }
            }
        }
        return "unable to process \"" + request + "\"";
}*/
    public String recurseBreadthFirst(String request, Node current) {
        counter++;
        System.out.println(current.identifier);
        for (Node n : current.children) {
            if (n.identifier.equalsIgnoreCase(request)) {
                return chooseRandomResponse(n);
            }
        }
        for (Node n : current.children) {
            if (recurseBreadthFirst(request, n) != "null") {
                return recurseBreadthFirst(request, n);
            }
        }
        return "null";
    }

    public String depthFirst() {
        System.out.println("You have chosen Depth-First");
        String s = printPrompt();
        String result = recurseDepthFirst(s, root) + " Steps: " + counter;
        counter = 0;
        return result;
        //return findDepthFirst(s);
    }

    public String recurseDepthFirst(String request, Node current) {
        counter++;
        System.out.println(current.identifier);
        if (current.identifier.equalsIgnoreCase(request)) {
            return chooseRandomResponse(current);
        } else {
            for (Node n : current.children) {
                if (recurseDepthFirst(request, n) != "null") {
                    return recurseDepthFirst(request, n);
                }
            }
        }
        return "null";
    }
    /*public String findDepthFirst(String request) /*this is where I hit crunch time. I will have filled in this psuedo code with working methods,
    and will update this to use recursion as I am basically doing the same thing over and over again.*//*
    {
        for (Node n : root.children) {
            if (n.identifier.equalsIgnoreCase(request)){
                return chooseRandomResponse(n);
            }
            else {
                for (Node c : n.children)
                {
                    if (c.identifier.equalsIgnoreCase(request))
                    {
                        //return random int based response from a node in n.children that has isResponse labeled as true;
                        return chooseRandomResponse(n);
                    }
                    else if (!c.children.isEmpty()){
                        for (Node g : c.children){
                            if (g.identifier.equalsIgnoreCase(request))
                            {
                                //return random int based response from a node in n.children that has isResponse labeled as true;
                                return chooseRandomResponse(n);
                            }
                        }
                    }
                }
            }
        }
        return "unable to process \"" + request + "\"";
    }*/
}