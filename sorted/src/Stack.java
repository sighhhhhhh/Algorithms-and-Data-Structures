public class Stack{
    private int StackArray [];
    private int IndexPointer;
    private int Size;

/*static stack
    public Stack (int givensize){
        Size = givensize;
        StackArray = new int [givensize];
        IndexPointer = -1;
    }

    public int pop(){
        if (IndexPointer == -1){
            System.out.println("stack is empty");
        }
        int x = StackArray[IndexPointer];
        IndexPointer--;
        return x;
    }

    public void push(int num){
        if (IndexPointer == Size-1){
            System.out.println("stack is full");
        }
        else{
            IndexPointer++;
            StackArray[IndexPointer] = num;
        }
    }
*/
//dynamic stack
    public Stack (){
        Size = 8;
        StackArray = new int [8];
        IndexPointer = -1;
    }

    public int pop(){
        if (IndexPointer == -1){
            System.out.println("stack is empty");
        }
        if (IndexPointer == Size-9){
            Size = Size - 8;
            int x[] = new int [Size];
            for(int i=0; i<Size-8; i++){
                x[i] = StackArray[i];
            }
            StackArray= x;
        }
        int x = StackArray[IndexPointer];
        IndexPointer--;
        return x;
    }

    public void push(int num){
        if (IndexPointer == Size-1){
            Size = Size + 8;
            int x[] = new int [Size];
            for(int i=0; i<Size-8; i++){
                x[i] = StackArray[i];
            }
            StackArray= x;
        }

        IndexPointer++;
        StackArray[IndexPointer] = num;
    }

}
