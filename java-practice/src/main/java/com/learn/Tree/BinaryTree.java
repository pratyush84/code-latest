package com.learn.Tree;

public class BinaryTree {
    Node root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(50,"Boss");
        tree.add(25,"VP");
        tree.add(15,"Office Manager");
        tree.add(30,"Secretary");
        tree.add(75,"Sales Manager");
        tree.add(85,"Salesman 1");

//        tree.postOrderTraversal(tree.root);
        System.out.println(tree.findNode(85));
    }
    public Node findNode(int key){
        Node focusNode =root;
        while(focusNode.key != key){
            if(key < focusNode.key){
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null){
                return null;
            }


        }
        return focusNode;
    }
    public void add(int key, String name){
        Node newNode = new Node(key,name);
        if(root == null){
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;

            while(true){
                parent = focusNode;
                if(key < focusNode.key){
                    focusNode = focusNode.leftChild;
                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                } else{
                    focusNode =  focusNode.rightChild;
                    if(focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraversal(Node focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTraversal(focusNode.leftChild);

            preOrderTraversal(focusNode.rightChild);
        }
    }

    public void postOrderTraversal(Node focusNode){
        if(focusNode != null){

            postOrderTraversal(focusNode.leftChild);

            postOrderTraversal(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }
}
