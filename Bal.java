import java.util.*;

class Bal {

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a == '(' || a == '{' || a == '[') {
                stack.push(a);
            } 
            else if (a == ')' || a == '}' || a == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((a == ')' && top != '(') || (a == '}' && top != '{') || (a == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean result = isBalanced(s);
        if (result) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
        sc.close();
    }
}
