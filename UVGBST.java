public class UVGBST<E extends Comparable<E>> {

    public class Node<E extends Comparable<E>>{
        public E value;
        public E translatedValue; // New attribute for translated value
        public Node leftChild = null;
        public Node rightChild = null;
        public Node parent = null;
        
        public Node(E cValue, E cTranslatedValue) { // Constructor with two attributes
            this.value = cValue;
            this.translatedValue = cTranslatedValue;
        }

        public Node(E cValue, E cTranslatedValue, Node<E> parent) { // Constructor with two attributes and parent node
            this.value = cValue;
            this.translatedValue = cTranslatedValue;
            this.parent = parent;
        }

        public String toString() {
            return value.toString();
        }

        public Node<E> addNode(E newVal, E newTranslatedVal) {
            int compCase = newVal.compareTo(value);
            if (compCase < 0) {
                if (leftChild == null) {
                    leftChild = new Node(newVal, newTranslatedVal, this);
                    return leftChild;
                } else {
                    return leftChild.addNode(newVal, newTranslatedVal);
                }
            }
            if (compCase == 0) {
                // Update the value
                value = newVal;
                translatedValue = newTranslatedVal; // Update the translated value
                return this;
            }
            if (rightChild == null) {
                rightChild = new Node(newVal, newTranslatedVal, this);
                return rightChild;
            }
            return rightChild.addNode(newVal, newTranslatedVal);
        }

        public int nodeHeight() {
            int currHeight = -1;
            if (this.leftChild != null) {
                currHeight = this.leftChild.nodeHeight();
            }
            if (this.rightChild != null) {
                int rightHeight = this.leftChild.nodeHeight();
                if (rightHeight > currHeight) {
                    currHeight = rightHeight;
                }
            }
            return currHeight + 1;
        }

        public int nodeDepth() {
            if (this.parent == null) {
                return 0;
            }
            return 1 + this.parent.nodeDepth();
        }

        public Node<E> getNode(E key) {
            if (this.value.compareTo(key) == 0) {
                return this;
            } else if (this.value.compareTo(key) > 0 && this.leftChild != null) {
                return this.leftChild.getNode(key);
            } else if (this.value.compareTo(key) < 0 && this.rightChild != null) {
                return this.rightChild.getNode(key);
            } else {
                return null; // Key not found
            }
        }

        public void traverseInOrder() {
            if (this.leftChild != null) {
                this.leftChild.traverseInOrder();
            }
            System.out.println("--" + this.toString() + "--");
            if (this.rightChild != null) {
                this.rightChild.traverseInOrder();
            }
        }
    }

    private Node<E> root;

    public Node<E> getRoot() {
        return root;
    }

    public UVGBST() {
        this.root = null;
    }

    public E add(E newVal, E newTranslatedVal) {
        if (root == null) {
            root = new Node<E>(newVal, newTranslatedVal);
            return root.value;
        }
        return root.addNode(newVal, newTranslatedVal).value;
    }

    public int height() {
        if (this.root == null) {
            return -1;
        }
        return this.root.nodeHeight();
    }

    public Association<String, String> get(E key) {
        Node<E> node = this.root.getNode(key);
        if (node != null) {
            return new Association<>(node.value.toString(), node.translatedValue.toString());
        } else {
            return null; // Key not found
        }
    }

    public String toString() {
        if (this.root != null) {
            return vPrintSubTree(this.root, 1);
        }
        return "X";
    }

    public String vPrintSubTree(Node<E> x, int depth) {
        String txt = "";
        txt = " ".repeat(depth);
        txt += "->" + x.value.toString() + "\n";
        if (x.leftChild != null) {
            txt = vPrintSubTree(x.leftChild, depth + 1) + "\n" + txt;
        }
        if (x.rightChild != null) {
            txt = txt + "\n" + vPrintSubTree(x.rightChild, depth + 1);
        }
        return txt;
    }
}
