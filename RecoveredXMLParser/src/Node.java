/**
 * Created by ShahZafrani on 3/7/2015.
 */
import java.util.*;
public class Node {
    ArrayList<Node> children;
    String identifier;
    boolean isResponse;

    /*public Node(String id, boolean isResp)
    {
        identifier = id;
        isResponse = isResp;
    }*/
    public Node()
    {
        identifier = "";
        isResponse = false;
        children = new ArrayList<Node>();
    }
    public void addChild(Node n)
    {
        children.add(n);
    }
}

