import java.util.Stack;
import java.util.HashMap;

public class Balanced{

  /**
	 Checks if a string is balanced or not.

   @param s is a non-null string
   @return true of the input <code>s</code> is balanced and false otherwise.
  **/
  public static boolean isBalanced(String s){
    Stack<Character> stack = new Stack<Character>();
    HashMap<Character, Character> symbols = new HashMap<Character, Character>();

    symbols.put(')' , '(');
    symbols.put('}' , '{');
    symbols.put(']' , '[');

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (symbols.containsValue(c)) {
        stack.push(c);
      }
      if (symbols.containsKey(c)) {
        if (stack.empty()) {
          return false;
        } else {
          Character temp = stack.pop();
          if (temp != symbols.get(c)) {
            return false;
          }
        }
      }
    }
    if (stack.empty()) {
      return true;
    }
    return false;
  }

  /**
	 Counts the number of balanced strings in the input array.

	 @param in is a non-null array of strings
   @return the number of strings in the input <code>in</code> that are balanced.
  **/
  public static int numberOfBalancedStrings(String[] in){
    int count = 0;
    System.out.println("Incorrect:");
    for (String s : in) {
      if (isBalanced(s)) {
        count += 1;
      } else {
        System.out.println(s);
      }
    }
    System.out.println("Correct:");
    for (String s : in) {
      if (isBalanced(s)) {
        System.out.println(s);
      }
    }
    return count;
  }


}
