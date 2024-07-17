import java.util.*;
class postFix {
    static int evaluatePostfix(String str) {
        Stack<Integer> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if(Character.isDigit(ch)){
                stack.push(Character.getNumericValue(ch));
            }
            else{
                switch (ch) {
                    case '+':
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case '-':
                        stack.push(stack.pop() - stack.pop());
                        break;
                    case '*':
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case '/':
                        stack.push(stack.pop() * stack.pop());
                        break;      
                    default:
                        System.out.println("Invalid Expression");
                        break;
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<T;i++){
            String str = sc.nextLine();
            int result = evaluatePostfix(str);
            System.out.println(result);
        }
        sc.close();
    }
}