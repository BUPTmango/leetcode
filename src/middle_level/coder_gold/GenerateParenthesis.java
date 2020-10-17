package middle_level.coder_gold;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.09. 括号
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/17 10:58 上午
 */
public class GenerateParenthesis {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        backtrack(n, 0, 1, "(");
        return res;
    }

    private void backtrack(int n, int index, int deep, String str) {
        if (str.length() == n * 2) {
            if (deep == 0) {
                res.add(str);
            }
            return;
        }
        // 还可以添加(
        if (deep + 1 <= n) {
            backtrack(n, index + 1, deep + 1, str + "(");
        }
        // 还可以添加)
        if (deep - 1 >= 0) {
            backtrack(n, index + 1, deep - 1, str + ")");
        }

    }
}
