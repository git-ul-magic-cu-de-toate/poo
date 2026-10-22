


import java.util.*;
import java.io.*;

class UnexpectedInputException extends Throwable {
    private String errorMessage;
    public UnexpectedInputException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String toString() {
        return this.errorMessage;
    }
}

class TreeNode<T> {
    T key;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T key) {
        this.key = key;
    }
}

class BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    PreorderIterator getPreorderIterator() {
        return new PreorderIterator();
    }

    class PreorderIterator implements Iterator {
        private Stack<TreeNode<T>> stack;

        public PreorderIterator() {
            stack = new Stack<>();
            if (root != null)
                stack.push(root);
        }

        public boolean hasNext() {
            return !stack.empty();
        }

        public TreeNode<T> next() {
            if (!hasNext()) throw new NoSuchElementException("no more nodes");
            // pop the current node
            TreeNode<T> node = stack.pop();
            // push its children on the stack if any
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            return node;
        }
    }

    public void insert(T key) {
        root = insertKey(root, key);
    }

    private TreeNode<T> insertKey(TreeNode<T> root, T key) {
        if (root == null) {
            root = new TreeNode<>(key);
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = insertKey(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertKey(root.right, key);
        }

        return root;
    }

    @Deprecated // only for building the reference in/out (?)
    void traverse(TreeNode<T> t) {
        if (t != null) {
            System.out.println(t.key);
            traverse(t.left);
            traverse(t.right);
        }
    }
}

class BinarySearchTreeFactory {

    public static BinarySearchTree readTree(Scanner input) throws UnexpectedInputException {
        String line = input.nextLine();
        switch (line) {
            case "Integer":
                return readIntegerTree(input);
            case "String":
                return readStringTree(input);
            case "Double":
                return readDoubleTree(input);
            default:
                throw new UnexpectedInputException("unexpected base type, expected Integer or String or Double, got "+ line);
        }
    }

    private static BinarySearchTree<Integer> readIntegerTree(Scanner input) throws UnexpectedInputException {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            try {
                Integer val = Integer.parseInt(line);
                t.insert(val);
            } catch(NumberFormatException e) {
                throw new UnexpectedInputException(line + " is not an Integer");
            }
        }
        return t;
    }

    private static BinarySearchTree<Double> readDoubleTree(Scanner input) throws UnexpectedInputException {
        BinarySearchTree<Double> t = new BinarySearchTree<>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            try {
                Double val = Double.parseDouble(line);
                t.insert(val);
            } catch(NumberFormatException e) {
                throw new UnexpectedInputException(line + " is not a Double");
            }
        }
        return t;
    }

    private static BinarySearchTree<String> readStringTree(Scanner input) {
        BinarySearchTree<String> t = new BinarySearchTree<>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            t.insert(line);
        }
        return t;
    }

}

public class TestBST {

    public static void main(String[] args) {
        try {
            Scanner inpFile = new Scanner(new File("in3.txt"));
            BinarySearchTree t = BinarySearchTreeFactory.readTree(inpFile);
            BinarySearchTree.PreorderIterator it = t.getPreorderIterator();
            while (it.hasNext()) {
                TreeNode node = it.next();
                System.out.println(node.key);
            }
            it.next(); // one more next(), to trigger that exception
        } catch (FileNotFoundException e) {
            System.out.println("eroare citire fisier"); // this will never happen on LambdaChecker
        } catch (UnexpectedInputException e) {
            System.out.println("Unexpected input: "+e);
        } catch (NoSuchElementException e) {
            System.out.println("Iterator exception: "+e.getMessage());
        }
    }
}
