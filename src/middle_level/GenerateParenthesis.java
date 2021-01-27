package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author Wang Guolong
 * @create 2019-05-08 11:34 AM
 */
public class GenerateParenthesis {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        backtrack(n, n, new StringBuilder());
        return res;
    }

    private void backtrack(int left, int right, StringBuilder sb) {
        // 数量小于0 肯定是不合法的
        if (left < 0 || right < 0) {
            return;
        }
        // 如果左括号剩下的多 不合法 剪枝！！！
        if (right < left) {
            return;
        }
        // 左右括号都用完的时候 找到一个合法的组合
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }

        // 尝试添加一个左括号
        sb.append("(");
        backtrack(left - 1, right, sb);
        sb.deleteCharAt(sb.length() - 1);

        // 尝试添加一个右括号
        sb.append(")");
        backtrack(left, right - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.generateParenthesis(3));
    }
}