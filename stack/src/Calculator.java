public class Calculator {
    Item[] expr;
    int ip;
    Stack stack;
    
    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new Stack(expr.length);
        for(int i=0; i<expr.length; i++){
            if(!(expr[i].value()==Integer.MAX_VALUE)){
                this.stack.push(expr[i].value());
            }
        }
    }    

    public int run() {
        while ( ip < expr.length ) {
        step();
        }
        return stack.pop();
        }
    
    public void step() {
        Item nxt = expr[ip++];
        switch(nxt.type()) {
            case ADD : {
            int y = stack.pop();
            int x = stack.pop();
            stack.push(x + y);
            break;
            }
            case SUB : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
                }
            case MUL : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
                break;
                }
            case DIV : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                break;
                }
            case VALUE : {
                break;
            }
            
        }
    }
}

