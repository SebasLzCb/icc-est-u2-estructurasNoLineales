package controllers;
import models.Node;

public class BinaryTree {

    private Node root;
    private int peso;

    public BinaryTree() {
        this.root = null;
        this.peso = 0;
    }

    public void insert(int value) {
        root = insertRec(root, value);
        this.peso = getWeightRec(root);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }
        if (value < padre.getValue()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public int getWeight() {
        return peso;
    }

    private int getWeightRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1
             + getWeightRec(node.getLeft())
             + getWeightRec(node.getRight());
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + ", ");
            preOrderRec(node.getLeft());
            preOrderRec(node.getRight());
        }
    }

    public void printInOrder() {
        printInOrderRec(root);
        System.out.println();
    }

    private void printInOrderRec(Node node) {
    if (node != null) {
        printInOrderRec(node.getLeft());
        System.out.print(node.getValue() + ", ");
        printInOrderRec(node.getRight());
        }
    }

    public void printInOrderWithHeight() {
        printInOrderWithHeightRec(root);
        System.out.println();
    }

    private void printInOrderWithHeightRec(Node node) {
        if (node != null) {
            printInOrderWithHeightRec(node.getLeft());
            int height = getHeightRec(node);
            System.out.print(node.getValue() + "(h = " + height + "), ");
            printInOrderWithHeightRec(node.getRight());
        }
    }

    private void printInOrderWithBalanceFactorRec(Node node) {
        if (node != null) {
            printInOrderWithBalanceFactorRec(node.getLeft());
            int balanceFactor = getBalanceFactor(node);
            System.out.print(node.getValue() + "(bf = " + balanceFactor + "), ");
            printInOrderWithBalanceFactorRec(node.getRight());
        }
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return leftHeight - rightHeight;
    }

    public void printInOrderWithBalanceFactor() {
        printInOrderWithBalanceFactorRec(root);
        System.out.println();
    }

    public boolean findeValue(int value) {
        return findeValue(root, value);
    }

    private boolean findeValue(Node node, int value) {


        if (node == null) {
            return false;
        }
        if (node.getValue() == value) {
            return true;
        }
        return findeValue(node.getLeft(), value) || findeValue(node.getRight(), value);
    }

    public int getHeight() {
        return getHeightRec(root);
    }
    public int getHeightRec(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalancedRec(node.getLeft()) && isBalancedRec(node.getRight());
    }

    public void printUnbalancedNodes() {
    System.out.print("Nodos desequilibrados: ");
    printUnbalancedRec(root);
    System.out.println();
}

private void printUnbalancedRec(Node node) {
    if (node == null) return;
    printUnbalancedRec(node.getLeft());
    int bf = getBalanceFactor(node);
    if (Math.abs(bf) > 1) {
        System.out.print(node.getValue() + "(fE=" + bf + ") ");
    }
    printUnbalancedRec(node.getRight());
}
}