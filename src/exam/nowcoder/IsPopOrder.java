package exam.nowcoder;

import java.util.Stack;

public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null ||
                pushA.length == 0 || popA.length == 0 ||
                pushA.length != popA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (j < popA.length && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }

        return stack.empty();
    }
}
