package exam.nowcoder;
import java.util.Stack;

public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int node = stack1.pop();
                stack2.add(node);
            }
        }

        return stack2.pop();
    }
}
