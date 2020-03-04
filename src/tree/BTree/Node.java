package tree.BTree;

public class Node {

    private String tab;
    private int level;
    private String classes;
    private String content;
    private Node[] children;

    public Node(String tab, String content) {
        this.tab = tab;
        this.level = 0;
        this.content = content;
        this.children = new Node[0];

    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void addNode(Node node) {
        Node[] newTempChildren = new Node[this.children.length + 1];
        for (int i = 0; i < this.children.length; i++) {
            newTempChildren[i] = this.children[i];
        }
        node.setLevel(this.level + 1);
        newTempChildren[this.children.length] = node;
        System.out.println("Before add");
        printChildren();
        this.children = newTempChildren;
        System.out.println("After add");
        printChildren();
    }

    public String toString() {
        return "Node[" + this.tab + "] with [" + this.children.length + "] children";
    }

    private boolean deleteNode(Node node) {
        for (int i = 0; i < this.children.length; i++) {
            if (this.children[i] == node) {
                deleteNodeAtIndex(i);
                System.out.println("Success: Detected and delete " + this.toString());
                return true;
            }
        }
        System.out.println("Failed: Cannot find " + this.toString());
        return false;
    }

    private void deleteNodeAtIndex(int k) {
        Node[] newTempChildren = new Node[this.children.length - 1];
        for (int i = 0; i < this.children.length; i++) {
            if (i < k) {
                newTempChildren[i] = this.children[i];
            } else if (i == k) {
                continue;
            } else {
                newTempChildren[i] = this.children[i + 1];
            }
        }
        this.children = newTempChildren;
    }

    public String leftTab() {
        return "<" + this.tab + ">";
    }

    public String rightTab() {
        return "</" + this.tab + ">";
    }

    private void printChildren() {
        if (this.children.length < 1) {
            System.out.println("No children");
        } else {
            for (Node n : this.children) {
                System.out.print(n.toString() + " ");
            }
        }
        System.out.print(".");
        System.out.println();
    }

    public Node[] getChildren() {
        return this.children;
    }

    public String getTab() {
        return this.tab;
    }

    public String getContent() {
        if (this.content==""){
            return "No content";
        }
        return this.content;
    }

    public String getClasses() {
        return this.classes;
    }

}
