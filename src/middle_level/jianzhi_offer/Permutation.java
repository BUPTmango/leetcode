package middle_level.jianzhi_offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/23 5:59 下午
 */
public class Permutation {
    List<String> res = new LinkedList<>();
    char[] c;

    /**
     * 排列方案数量： 对于一个长度为 nn 的字符串（假设字符互不重复），其排列共有 n \times (n-1) \times (n-2) … \times 2 \times 1n×(n?1)×(n?2)…×2×1 种方案。
     * <p>
     * 排列方案的生成方法： 根据字符串排列的特点，考虑深度优先搜索所有排列方案。即通过字符交换，先固定第 1 位字符（ nn 种情况）、再固定第 2 位字符（ n-1 种情况）、... 、最后固定第 n 位字符（ 1 种情况）。
     * <p>
     * 重复方案与剪枝： 当字符串存在重复字符时，排列方案中也存在重复方案。为排除重复方案，需在固定某位字符时，保证 “每种字符只在此位固定一次” ，即遇到重复字符时不交换，直接跳过。从 DFS 角度看，此操作称为 “剪枝” 。
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    /**
     * x表示固定字符的index
     *
     * @param x
     */
    void dfs(int x) {
        if (x == c.length - 1) {
            // 添加排列方案
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            // 重复，因此剪枝
            if (set.contains(c[i])) {
                continue;
            }
            // 将 c[i] 加入 Set ，以便之后遇到重复字符时剪枝
            set.add(c[i]);
            // 固定字符： 将字符 c[i] 和 c[x] 交换，即固定 c[i] 为当前位字符
            swap(i, x);
            // 开启下层递归： 调用 dfs(x + 1) ，即开始固定第 x + 1 个字符
            dfs(x + 1);
            // 还原交换： 将字符 c[i] 和 c[x] 交换（还原之前的交换）
            swap(i, x);
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
