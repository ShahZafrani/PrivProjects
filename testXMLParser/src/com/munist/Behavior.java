package com.munist;

import java.util.*;

/**
 * Created by ShahZafrani on 3/5/2015.
 */
public class Behavior {
    String name;
    List<Behavior> children;
    List<Response> responses;
    public Behavior (String n)
    {
        name = n;
    }
}
