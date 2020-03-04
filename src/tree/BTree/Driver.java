package tree.BTree;

public class Driver {

    public static void main(String[] args) {
        Node root = new Node("body","");
        Node div1 = new Node("div1","div1");
        Node div2 = new Node("div2","div2");
        Node div3 = new Node("div3","div3");
        Node div4 = new Node("div4","div4");

        //*            root
        //              /\
        //          div1 div2
        //           /\
        //       div3 div4

        root.addNode(div1);
        root.addNode(div2);
        div1.addNode(div3);
        div1.addNode(div4);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        Tree tree = new Tree(root);
        tree.printPostorder(root);
    }
}
