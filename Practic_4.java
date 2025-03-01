public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        int[][] array = {
                {3, 7, 1, 9, 44}};
        String[] resultString = new String[5]; //длина не меньше длины самого длинного вложеного массива

        for (int[] j : array) {
            for (int i : j) {
                tree.add(i);
            }
            resultString = tree.output().split(" ");
            for (int i = 0; i < j.length; i++) {
                j[i] = Integer.parseInt(resultString[i]);
            }
        }

        for (int[] j : array) {
            System.out.print("| ");
            for (int i : j) {
                System.out.print(i + " | ");
            }
        }

        tree.output();
    }
}
class Tree {
    private static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    private Node root;

    public void add(int data) {
        root = recAdd(root, data);
    }

    private Node recAdd(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        if (data < current.data) {
            current.left = recAdd(current.left, data);
        }
        else if (data > current.data) {
            current.right = recAdd(current.right, data);
        }
        else {
            return current;
        }
        return current;
    }

    String result = null;
    public String output() {
        result = output(root, result);
        return result;
    }
    private String output(Node node, String result) {
        if (node != null) {
            output(node.left, result);
            result += (node.data + " ");
            output(node.right, result);

        }
        return result;
    }
}