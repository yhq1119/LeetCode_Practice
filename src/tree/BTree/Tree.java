package tree.BTree;

public class Tree {

    Node root;
    String document;

    public Tree(Node node) {
        this.root = node;
        this.document = new StringBuilder().toString();
    }

    void printPostorder(Node node) {


        if (node == null) {
            return;
        }
        System.out.println(indent(node.getLevel()) + node.leftTab() + "\n"
                + indent(node.getLevel()) + node.getContent());

        // first recur on left subtree
        for (Node n : node.getChildren()) {
            printPostorder(n);
        }


        // then recur on right subtree
//        printPostorder(node.right);

        // now deal with the node
//        System.out.println(node.getTab() + " at level[" + node.getLevel() + "]");
        System.out.println(indent(node.getLevel()) + node.rightTab());
    }

    private String indent(int times) {
        String start = "";
        String indent = "    ";
        for (int i = 0; i < times; i++) {
            start += indent;
        }
        return start;
    }

//    boolean hasClear(Node node) {
//        return this.temp < node.getChildren().length;
//    }
}
