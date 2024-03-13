public class Heap{
    public class Node {
        public Integer prio;
        public Node left, right;
        public int subTree;
    
        public Node(Integer value) {
            this.prio = value;
            this.left = this.right = null;
        }
    
        public void print() {
            if(left != null)
                left.print();
            System.out.println("prio: " + prio);
            if(right != null)
                right.print();
        }

        public Integer dequeue(){
        if(root == null)
            return null;
        int ret = root.prio;

        root = root.remove();
        return ret;
    }

    private Node remove(){
        subTree--;
        if(right == null)
            return left;
        if(left == null)
            return right;
        if (left.prio < right.prio){
            prio = left.prio;
            left = left.remove();
        }
        else {
            prio = right.prio;
            right = right.remove();
        }
        return this;
    }
    }

    Node root;

    public Heap() {
        root = null;
    }

//adds a new node (leaf) to the
//tree that maps the key to the value. If the key is already present we
//update the value of the node. Note that the tree should still be sorted.

    public void add(Integer pr){
        if(root == null){
            root = new Node (pr);
            root.subTree++;
            return;
        }

        Node currentNode = root;

        while (true){
        currentNode.subTree++;
        if(pr < currentNode.prio){
            int tmp = currentNode.prio;
            currentNode.prio = pr;
            pr=tmp;
        }
        if(currentNode.left == null){
            currentNode.left = new Node(pr);
            return;
        }
        if(currentNode.right == null){
            currentNode.right = new Node(pr);
            return;
        }
        if((currentNode.right.subTree < currentNode.left.subTree)){
            currentNode = currentNode.right;
            continue;
        } 
        else{
            currentNode = currentNode.left;
            continue;
        }
        }
    }

    public int push(Integer incr){
        root.prio = root.prio + incr;
        Node currentNode = this.root;
        int depth = 0;
        
        while (true){

        if(currentNode.left != null && currentNode.right != null){

        if(currentNode.prio <= currentNode.right.prio && currentNode.prio <= currentNode.left.prio){
            break;
        }
        if(currentNode.left.prio < currentNode.right.prio){   
            int temp = currentNode.prio;
            currentNode.prio = currentNode.left.prio;
            currentNode.left.prio = temp;

            currentNode = currentNode.left;
            depth++;
            continue;
        }
        else{
            int temp = currentNode.prio;
            currentNode.prio = currentNode.right.prio;
            currentNode.right.prio = temp;

            currentNode = currentNode.right;
            depth++;
            continue;
        }
        }

        if(currentNode.left != null){
        if(currentNode.prio < currentNode.left.prio){
            int temp = currentNode.prio;
            currentNode.prio = currentNode.left.prio;
            currentNode.left.prio = temp;

            currentNode = currentNode.left;
            depth++;
            continue;
        }
        }

        if(currentNode.right != null){
        if(currentNode.prio < currentNode.right.prio){
            int temp = currentNode.prio;
            currentNode.prio = currentNode.right.prio;
            currentNode.right.prio = temp;

            currentNode = currentNode.right;
            depth++;
            continue;
        }
        }
        break;
        }
        return depth;
    }
}
