package middle_level;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. 单词接龙
 * 给定两个单词（beginWord?和 endWord）和一个字典，找到从?beginWord 到?endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例?1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出:?0
 *
 * 解释:?endWord "cog" 不在字典中，所以无法进行转换。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/13 11:10 上午
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将wordList转换成wordSet
        Set<String> wordSet = new HashSet<>(wordList.size());
        wordSet.addAll(wordList);
        // 已经存在就不需要转换
        if (!wordSet.contains(endWord)) return 0;
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add(beginWord);
        s2.add(endWord);
        int n = beginWord.length();
        int step = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            step++;
            // 优先扩展小的set，相当于balance
            if (s1.size() > s2.size()) {
                Set<String> tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
            Set<String> s = new HashSet<>();
            for (String word : s1) {
                // 对其每一位
                for (int i = 0; i < n; i++) {
                    // 复制一份，不在原来的word上面操作
                    char[] chars = word.toCharArray();
                    // 更改为a到z全部试一下
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String tmp = new String(chars);
                        // 如果在另一个set中出现说明碰到一起了也就是找到了
                        if (s2.contains(tmp)) return step + 1;
                        if (!wordSet.contains(tmp)) continue;
                        // 如果在字典中那就删掉，防止出现环
                        wordSet.remove(tmp);
                        s.add(tmp);
                    }
                }
            }
            // 将临时的s赋值给s1
            s1 = s;
        }
        return 0;
    }
}
