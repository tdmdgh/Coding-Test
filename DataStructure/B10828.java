package DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class B10828 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            String command = scanner.next();
            if (command.equals("push")) {
                int num = scanner.nextInt();
                stack.push(num);
                continue;
            }
            if (command.equals("pop")) {
                if (stack.size() == 0)
                    sb.append(-1).append('\n');
                else
                    sb.append(stack.pop()).append('\n');
                continue;

            }
            if (command.equals("top")) {
                if (stack.size() == 0)
                    sb.append(-1).append('\n');
                else
                    sb.append(stack.peek()).append('\n');
                continue;

            }
            if (command.equals("size")) {
                sb.append(stack.size()).append('\n');
                continue;

            }
            if (command.equals("empty")) {
                if (stack.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }
}
