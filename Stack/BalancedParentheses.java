package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {
    public boolean balancedParentheses(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch); // Push opening brackets
            } else {
                if (stack.isEmpty()) {
                    return false; // If closing bracket appears first, it's unbalanced
                }
                char top = stack.pop();
                if ((top == '(' && ch != ')') ||
                    (top == '[' && ch != ']') ||
                    (top == '{' && ch != '}')) {
                    return false; // Mismatch in brackets
                }
            }
        }
        return stack.isEmpty(); // If stack is empty, it's balanced
    }

    public static void main(String[] args) {
        BalancedParentheses obj = new BalancedParentheses();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string of parentheses: ");
        String str = sc.nextLine();
        
        boolean isValid = obj.balancedParentheses(str);
        System.out.println("Is balanced? " + isValid);
        
        sc.close(); // Close scanner to avoid memory leaks
    }
}
