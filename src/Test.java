import ds.Stack;

public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        int[] arr = {1, 2, 3, 4, 5};
        for (int item : arr) stack.push(item);
        System.out.println(stack.peek());
        while (!stack.isEmpty()) System.out.println(stack.pop());
    }
}
