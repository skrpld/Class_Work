public class Main {
    public static void main(String[] args) {
        private static class Node {
            int data;
            Node left;
            Node right;
            Node(int data) {
                this.data = data;
            }
        }
        public static class Tree {
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
        }

        Tree.add(1);
    }
}