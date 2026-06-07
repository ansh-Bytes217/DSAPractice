import java.util.Scanner;

class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }
}

public class AVLTreeUserInput {

    private Node root;

    private int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insertRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = insertRecursive(node.right, key);
        } else {
            System.out.println("Duplicate key " + key + " ignored (not allowed in AVL).");
            return node; 
        }

        node.height = 1 + max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Case 1: Left-Left (LL)
        if (balance > 1 && key < node.left.key) {
            System.out.println("Imbalance detected. Performing Right Rotation on node " + node.key);
            return rightRotate(node);
        }

        // Case 2: Right-Right (RR)
        if (balance < -1 && key > node.right.key) {
            System.out.println("Imbalance detected. Performing Left Rotation on node " + node.key);
            return leftRotate(node);
        }

        // Case 3: Left-Right (LR)
        if (balance > 1 && key > node.left.key) {
            System.out.println("Imbalance detected. Performing Left-Right Rotation on node " + node.key);
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Case 4: Right-Left (RL)
        if (balance < -1 && key < node.right.key) {
            System.out.println("Imbalance detected. Performing Right-Left Rotation on node " + node.key);
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Displays the tree hierarchy clearly to easily confirm balancing
    public void printTree() {
        printTreeRecursive(root, "", true);
    }

    private void printTreeRecursive(Node currNode, String indent, boolean last) {
        if (currNode != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R---- ");
                indent += "   ";
            } else {
                System.out.print("L---- ");
                indent += "|  ";
            }
            System.out.println(currNode.key + " (h:" + currNode.height + ")");
            printTreeRecursive(currNode.left, indent, false);
            printTreeRecursive(currNode.right, indent, true);
        }
    }

    public static void main(String[] args) {
        AVLTreeUserInput tree = new AVLTreeUserInput();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== AVL Tree Interactive Console ===");
        System.out.println("Enter integers one by one to insert. (Type any letter or 'q' to stop):");

        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            System.out.println("\nInserting: " + value);
            tree.insert(value);
            
            System.out.println("Current Tree Structure:");
            tree.printTree();
            System.out.println("--------------------------------------");
            System.out.print("Enter next integer: ");
        }

        System.out.println("\n=== Final Balanced AVL Tree ===");
        tree.printTree();
        
        scanner.close();
    }
}
