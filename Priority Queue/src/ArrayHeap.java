public class ArrayHeap{
    public class Node {
        public Integer prio;
        public int left, right;
        public int subTree;
    
        public Node(Integer value, Integer index) {
            this.prio = value;
            this.left = index*2 + 1;
            this.right = index*2 + 2;
        }
    }

    int rootIndex = 0;
    Node array[];

    public ArrayHeap(){
        rootIndex = 0;
        array = new Node[100000];
    }

    public void bubble(int newValue){
                
        int newIndex = 0;
        int temp;

        while(array[newIndex] != null){
            newIndex++;
        }

        array[newIndex] = new Node(newValue, newIndex);

        int parentNodeIndex;

        while(true){
        if(newIndex == 0){
            return;}

        if(newIndex%2 == 0)
            parentNodeIndex = (newIndex-2)/2;
        else
            parentNodeIndex = (newIndex-1)/2;

        if(array[newIndex].prio < array[parentNodeIndex].prio){
            temp = array[newIndex].prio;
            array[newIndex].prio = array[parentNodeIndex].prio;
            array[parentNodeIndex].prio = temp;
            newIndex = parentNodeIndex;
            continue;
        }
        break;
        }
    }

    public int sink(){
        int temp;
        int swapIndex = 0;
        int lastIndex = 0; 
        while(array[lastIndex + 1] != null){
            lastIndex++;
        }
        temp = array[rootIndex].prio;
        array[rootIndex].prio = array[lastIndex].prio;
        array[lastIndex].prio = temp;

        int ret = array[lastIndex].prio;
        array[lastIndex] = null;

        while(true){
        if(array[array[swapIndex].left] != null && array[array[swapIndex].right] != null){
        if(array[array[swapIndex].left].prio < array[array[swapIndex].right].prio){
            temp = array[swapIndex].prio;
            array[swapIndex].prio = array[array[swapIndex].left].prio;
            array[array[swapIndex].left].prio = temp;
    
            swapIndex = array[swapIndex].left;
            continue;
        }

        if(array[array[swapIndex].right].prio < array[array[swapIndex].left].prio){
            temp = array[swapIndex].prio;
            array[swapIndex].prio = array[array[swapIndex].right].prio;
            array[array[swapIndex].right].prio = temp;
    
            swapIndex = array[swapIndex].right;
            continue;
        }
        }

        if(array[array[swapIndex].left] != null && array[swapIndex].prio < array[array[swapIndex].left].prio){
            temp = array[swapIndex].prio;
            array[swapIndex].prio = array[array[swapIndex].left].prio;
            array[array[swapIndex].left].prio = temp;
    
            swapIndex = array[swapIndex].left;
            continue;
        }

        if(array[array[swapIndex].right] != null && array[swapIndex].prio < array[array[swapIndex].right].prio){
            temp = array[swapIndex].prio;
            array[swapIndex].prio = array[array[swapIndex].left].prio;
            array[array[swapIndex].left].prio = temp;
    
            swapIndex = array[swapIndex].right;
            continue;
        }
        break;
        }

        return ret;
    }

    public void print(){
        for(int i = 0; array[i] != null; i++){
            System.out.println("prio: " + array[i].prio);
        }
    }
}
