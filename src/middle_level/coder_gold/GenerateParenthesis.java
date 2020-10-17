package middle_level.coder_gold;

import java.util.ArrayList;
import java.util.List;

/**
 * ������ 08.09. ����
 * ���š����һ���㷨����ӡn�����ŵ����кϷ��ģ����磬����һһ��Ӧ����ϡ�
 *
 * ˵�����⼯���ܰ����ظ����Ӽ���
 *
 * ���磬����n = 3�����ɽ��Ϊ��
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
 * @date 2020/10/17 10:58 ����
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
        // ���������(
        if (deep + 1 <= n) {
            backtrack(n, index + 1, deep + 1, str + "(");
        }
        // ���������)
        if (deep - 1 >= 0) {
            backtrack(n, index + 1, deep - 1, str + ")");
        }

    }
}
