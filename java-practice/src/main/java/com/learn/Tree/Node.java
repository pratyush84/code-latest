package com.learn.Tree;

public class Node {
    int key;
    String name;
    Node leftChild;
    Node rightChild;

    Node(int key, String name){
        this.name = name;
        this.key = key;
    }

    public String toString(){
        return name + " has a key " + key;
    }
}

