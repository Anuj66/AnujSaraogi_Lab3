import java.util.Scanner;
import java.util.Stack;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string : ");
        String query = sc.nextLine();

        // Checking String Validity
        for(int i=0;i<query.length();i++) {
            char ch = query.charAt(i);
            if(!(ch=='(' || ch==')' || ch=='{' || ch=='}' || ch=='[' || ch==']')) {
                System.out.println("Input String is invalid!");
                return;
            }
        }

        if (areBracketsBalanced(query)) System.out.println("The entered String has Balanced Brackets");
        else System.out.println("The entered Strings do not contain Balanced Brackets");
    }

    // function to check if brackets are balanced
    static boolean areBracketsBalanced(String expr) {
        Stack<Character> stack
                = new Stack<Character>();

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }
}
