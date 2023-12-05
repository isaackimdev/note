package languages.java.examples;

import java.util.Stack;

/**
 * StackExample
 */
public class StackExample {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(7);
        stack.push(85);
        stack.pop();
        stack.push(2);
        stack.push(1);
        stack.pop();
        while (!stack.isEmpty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
    }
}