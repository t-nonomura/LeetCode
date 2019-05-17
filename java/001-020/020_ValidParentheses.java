/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
 
class Solution {
  private HashMap<Character, Character> mappings;

  public Solution() {
    this.mappings = new HashMap<Character, Character>();
    this.mappings.put(')', '(');
    this.mappings.put('}', '{');
    this.mappings.put(']', '[');
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      // 閉じ括弧判定
      if (this.mappings.containsKey(c)) {
        // スタックが空の場合はダミーの文字でお茶を濁す
        char top = stack.empty() ? '-' : stack.pop();
        if (top != this.mappings.get(c)) {
          return false;
        }
      } else {
        // 開き括弧の場合はスタックに格納
        stack.push(c);
      }
    }
    // スタックが空の場合は括弧のペアリングを全て消化完了
    return stack.isEmpty();
  }
}