public class Stack {
    static final int MAX = 3;
    int top = -1;
    Integer items[] = new Integer[MAX];

    boolean isEmpty(){
        return top < 0;
    }

    void push(int x){
        if((top+1) >= MAX){
            System.out.println("Stack Overflow");
            return;
        }

        top++;
        items[top] = x;
        System.out.println("Pushed:"+x);
    }

    int pop(){
        if(isEmpty()) {
            System.out.println("Stack Underflow");
            return 0;
        }

        int x = items[top];
        top--;
        System.out.println("Popped:"+x);
        return x;
    }

    public static void main(String[] args) {
        Stack test = new Stack();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);

        System.out.println("Print:"+test.pop());
        System.out.println("Print:"+test.pop());
        System.out.println("Print:"+test.pop());
        System.out.println("Print:"+test.pop());
    }
}
