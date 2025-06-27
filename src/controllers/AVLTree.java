package controllers;

import models.Node;

public class AVLTree {
    private Node root;

    public AVLTree(){
        this.root = null;
    }

    public void insert(int value){
        root =  insertRec(root, value);
    }

    private Node insertRec(Node node, int value){
        if(node == null){
            Node newNode = new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado -> " + value + " con balance " + getBalance(newNode));
            return newNode;
        }

        if(value <= node.getValue()){
            Node newNode = insertRec(node.getLeft(), value);
            node.setLeft(newNode);
        } else if (value > node.getValue()){
            Node newNode = insertRec(node.getRight(), value);
            node.setRight(newNode);
        } else {
            return node;
        }

        System.out.println("Nodo actual -> " + node.getValue());
        int altura = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        node.setHeight(altura);
        System.out.println("   Altura -> " + node.getHeight());

        int balance = getBalance(node);
        System.out.println("   Balance -> " + balance);

        // Caso Izquierda Izquierda
        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("Cambio");
            return rightRotation(node);
        }

        // Caso Derecha Derecha
        if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("Cambio");
            return leftRotation(node);
        }

        // Caso Izquierda Derecha
        if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("Cambio");
            node.setLeft(leftRotation(node.getLeft()));
            System.out.println("Rotacion Simple Derecha");
            return rightRotation(node);
        }

        // Caso Derecha Izquierda
        if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("Cambio");
            node.setRight(rightRotation(node.getRight()));
            System.out.println("Rotacion Simple Izquierda");
            return leftRotation(node);
        }

        return node;
    }

    private int height(Node node){
        if (node == null)
            return 0;
        return node.getHeight();
    }

    private int getBalance(Node node){
        if (node == null)
            return 0;
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        return leftHeight - rightHeight;
    }

    private Node leftRotation(Node x){
        Node y = x.getRight();
        Node temp = y.getLeft();

        System.out.println("Rotacion IZQ en nodo: " + x.getValue()
                + ", con balance = " + getBalance(x));

        y.setLeft(x);
        x.setRight(temp);

        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        System.out.println("Nueva raiz despues de la rotación " + y.getValue());

        return y;
    }

    private Node rightRotation(Node y){
        Node x = y.getLeft();
        Node temp = x.getRight();

        System.out.println("Rotacion DER en nodo: " + y.getValue()
                + ", con balance = " + getBalance(y));

        x.setRight(y);
        y.setLeft(temp);

        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        System.out.println("Nueva raiz despues de la rotación " + x.getValue());

        return x;
    }
}
