package Stack;

import java.util.Stack;

class PushAtBottom {
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Recursive call to reach the bottom
        pushAtBottom(stack, data);

        // Push back the removed element
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
       

        System.out.println("Stack before: " + stack);
        pushAtBottom(stack, 4);
        System.out.println("Stack after pushing 0 at bottom: " + stack);
    }
}

