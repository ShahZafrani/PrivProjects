package com.munist;

/**
 * Created by ShahZafrani on 3/7/2015.
 */
public class Node {
    List<Node> children;
    String behavior, response;

    public Node(String bh, String rs)
    {
        behavior = bh;
        response = rs;
    }
}
