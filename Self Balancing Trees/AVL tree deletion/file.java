import java.util.Scanner;

class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }
}

public class AVLTreeDeletion {

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

    // Find the node with the minimum value (Inorder Successor helper)
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Public Insertion Interface
    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key) {
            node.left = insertRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = insertRecursive(node.right, key);
        } else {
            return node; 
        }

        node.height = 1 + max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) return rightRotate(node);
        if (balance < -1 && key > node.right.key) return leftRotate(node);
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Public Deletion Interface
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node root, int key) {
        // Step 1: Standard BST Deletion
        if (root == null) {
            System.out.println("Key " + key + " not found in the tree.");
            return root;
        }

        if (key < root.key) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRecursive(root.right, key);
        } else {
            // Found the node to delete!
            
            // Case 1 or 2: Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;

                if (temp == null) { // No child case
                    temp = root;
                    root = null;
                } else { // One child case
                    root = temp; // Copy the contents of the non-empty child
                }
            } else {
                // Case 3: Node with two children
                // Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteRecursive(root.right, temp.key);
            }
        }

        // If the tree had only one node, return
        if (root == null) return root;

        // Step 2: Update current node's height
        root.height = max(height(root.left), height(root.right)) + 1;

        // Step 3: Check for imbalance using Balance Factor
        int balance = getBalance(root);

        // Case 1: Left-Left (LL)
        if (balance > 1 && getBalance(root.left) >= 0) {
            System.out.println("Rebalancing: Right Rotation on " + root.key);
            return rightRotate(root);
        }

        // Case 2: Left-Right (LR)
        if (balance > 1 && getBalance(root.left) < 0) {
            System.out.println("Rebalancing: Left-Right Rotation on " + root.key);
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Case 3: Right-Right (RR)
        if (balance < -1 && getBalance(root.right) <= 0) {
            System.out.println("Rebalancing: Left Rotation on " + root.key);
            return leftRotate(root);
        }

        // Case 4: Right-Left (RL)
        if (balance < -1 && getBalance(root.right) > 0) {
            System.out.println("Rebalancing: Right-Left Rotation on " + root.key);
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

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
        AVLTreeDeletion tree = new AVLTreeDeletion();
        Scanner scanner = new Scanner(System.in);

        // Pre-populating elements for demonstration
        int[] initialElements = {9, 5, 10, 0, 6, 11, -1, 1, 2};
        for (int x : initialElements) {
            tree.insert(x);
        }

        System.out.println("Initial balanced AVL tree built with keys: [9, 5, 10, 0, 6, 11, -1, 1, 2]");
        tree.printTree();

        while (true) {
            System.out.print("\nEnter key to delete (or type '999' to exit): ");
            if (!scanner.hasNextInt()) break;
            
            int target = scanner.nextInt();
            if (target == 999) break;

            System.out.println("\n--- Deleting " + target + " ---");
            tree.delete(target);
            
            System.out.println("Resulting tree layout:");
            tree.printTree();
        }
        scanner.close();
    }
}
