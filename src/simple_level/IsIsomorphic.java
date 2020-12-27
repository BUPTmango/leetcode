package simple_level;

/**
 * 205. 同构字符串
 * 给定两个字符串?s?和?t，判断它们是否是同构的。
 *
 * 如果?s?中的字符可以被替换得到?t?，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/14 8:59 下午
 */
public class IsIsomorphic {
    /**
     * 我们找一个第三方来解决，即，按照字母出现的顺序，把两个字符串都映射到另一个集合中。
     * 将第一个出现的字母映射成 1，第二个出现的字母映射成 2
     *
     * 对于 egg
     * e -> 1
     * g -> 2
     * 也就是将 egg 的 e 换成 1, g 换成 2, 就变成了 122
     *
     * 对于 add
     * a -> 1
     * d -> 2
     * 也就是将 add 的 a 换成 1, d 换成 2, 就变成了 122
     *
     * egg -> 122, add -> 122
     * 都变成了 122，所以两个字符串同构。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //当前的映射值是否相同
            if (mapS[c1] != mapT[c2]) {
                return false;
            } else {
                //是否已经修改过，修改过就不需要再处理
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }
}
