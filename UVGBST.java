public class UVGBST<E extends Comparable<E>> {

    public class Node<E extends Comparable<E>>{
        public E value;
        public Node leftChild = null;
        // Cambie a usar <E> para evitar usar cating.
        public Node rightChild = null;
        public Node parent = null;
        public Node(E cValue){
            this.value = cValue;
        }

        public Node(E cValue, Node<E> parent){
            this.value = cValue;
            this.parent = parent;
        }

        public String toString(){
            return value.toString();
        }

        public Node<E> addNode(E newVal) {
            int compCase = newVal.compareTo(value);
            if (compCase < 0) {
                if (leftChild == null) {
                    leftChild = new Node(newVal, this);
                    return leftChild;
                } else {
                    return leftChild.addNode(newVal);
                }
            }
            if (compCase == 0) {
                // Update the value
                value = newVal;
                return this;
            }
            if (rightChild == null) {
                rightChild = new Node(newVal, this);
                return rightChild;
            }
            return rightChild.addNode(newVal);
        }

        public int nodeHeight(){
            int currHeight = -1;
            if (this.leftChild != null){
                currHeight = this.leftChild.nodeHeight();
            }
            if (this.rightChild != null){
                int rightHeight = this.leftChild.nodeHeight();
                if (rightHeight > currHeight){
                    currHeight = rightHeight;
                }
            }
            return currHeight + 1;
        }

        public int nodeDepth(){
            if (this.parent == null){
                return 0;
            }
            return 1 + this.parent.nodeDepth();
        }

        public Node<E> getNode(E key){
            if (this.value.compareTo(key)==0){
                return this;
            }
            // busque a la izquierda o a la derecha
            // como se que lado buscar
            return null;
        }

        public void traverseInOrder(){
            if (this.leftChild !=null){
                this.leftChild.traverseInOrder();
            }
            System.out.println("--" + this.toString() + "--");
            if (this.rightChild!=null){
                this.rightChild.traverseInOrder();
            }
        }
    }

    private Node<E> root;

    public Node<E> getRoot(){
        return root;
    }

    public UVGBST(){
        this.root = null;
    }

    public E add(E newVal){
        if (root == null){
            root = new Node<E>(newVal);
            return root.value;
        }
        return (E) root.addNode(newVal).value;
    }

    public int height(){
        if (this.root  == null){
            return -1;
        }
        return this.root.nodeHeight();
    }

    public E get(E key){

        return null;
    }

    public String toString() {
        if (this.root != null) {
            return vPrintSubTree(this.root, 1);
        }
        return "X";
    }

    public String vPrintSubTree(Node<E> x, int depth){
        String txt = "";
        txt = " ".repeat(depth);
        txt += "->" + x.value.toString() + "\n";
        if (x.leftChild!=null){
            txt = vPrintSubTree(x.leftChild, depth + 1) + "\n" + txt;
        }
        if (x.rightChild!=null){
            txt = txt + "\n" + vPrintSubTree(x.rightChild, depth + 1);
        }
        return txt;
    }



}
