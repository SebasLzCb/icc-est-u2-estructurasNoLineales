import controllers.BinaryTree;

public class App {
    public static void main(String[] args) {
        BinaryTree ab = new BinaryTree();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);


        System.out.println("Nombre: Sebastian Loza");
        System.out.println("Peso del arbol = " + ab.getWeight());
        System.out.println("Altura es = "     + ab.getHeight());
        System.out.println();

        System.out.print("Arbol InOrder: ");
        ab.printInOrder();        

        System.out.print("Arbol InOrder con alturas: ");
        ab.printInOrderWithHeight();

        System.out.print("Arbol InOrder con factor de equilibrio: ");
        ab.printInOrderWithBalanceFactor();

        System.out.println();
        System.out.println("Arbol esta equilibrado = " + ab.isBalanced());
        System.out.println("Existe el nodo 15= "       + ab.findeValue(15));

        System.out.println("Agregamos valor = 15");
        ab.insert(15);

        System.out.println("Arbol esta equilibrado = " + ab.isBalanced());

        System.out.print("\nArbol InOrder con factor de equilibrio: ");
        ab.printInOrderWithBalanceFactor();

        ab.printInOrderWithBalanceFactor();
        ab.printUnbalancedNodes();
    }
}
