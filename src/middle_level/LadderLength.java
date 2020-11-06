package middle_level;

import javafx.util.Pair;

import java.util.*;

/**
 * 双向BFS
 * 《玩转算法面试视频例题》队列 图的BFS
 * 127. 单词接龙
 * 给定两个单词（beginWord?和 endWord）和一个字典，找到从?beginWord 到?endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例?1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出:?0
 * <p>
 * 解释:?endWord "cog" 不在字典中，所以无法进行转换。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/13 11:10 上午
 */
public class LadderLength {
    /**
     * 双向BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将wordList转换成wordSet
        Set<String> wordSet = new HashSet<>(wordList.size());
        wordSet.addAll(wordList);
        // 如果不在set中就无法转换
        if (!wordSet.contains(endWord)) {
            return 0;
        }
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
                        if (s2.contains(tmp)) {
                            return step + 1;
                        }
                        if (!wordSet.contains(tmp)) {
                            continue;
                        }
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


    public static int ladderLength_BFS(String beginWord, String endWord, List<String> wordList) {
        // 给定单词列表中不包括endword，直接返回
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 题目说明，每个单词长度相同
        int len = beginWord.length();
        // 处理给出的单词字典，转换为全部的通用状态及每个通配词映射的单词集合
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();
        // lambda表达式遍历，curWord是当前正在遍历的单词
        wordList.forEach(curWord -> {
            // 每个单词能得到len种通配词(每个位置字符都可变为*)
            for (int i = 0; i < len; i++) {
                // 得到通配词
                String comboWord = curWord.substring(0, i) + "*" + curWord.substring(i + 1, len);
                // 从通配字典全集中拿到这个通配词对应的单词集合，如果是空(第一次得到通配词时)就创建一个新的
                ArrayList<String> comboWordList = allComboDict.getOrDefault(comboWord, new ArrayList<>());
                // 把当前这个单词加进去，因此从这个单词得到了这个通配词
                comboWordList.add(curWord);
                // 更新一个通配字典全集中这个通配词对应的单词集合
                allComboDict.put(comboWord, comboWordList);
            }
        });
        // 广度优先遍历队列
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        // 记录已遍历过的单词,为什么不用List，因为之后判断节点是否已遍历过时，ArrayList的contains方法太低效了，它的底层是数组，或者直接用TreeSet也可以
        // ArrayList<String> hasVisitedList = new ArrayList<>();
        HashMap<String, Boolean> hasVisitedList = new HashMap<>();
        // 开始词作为第一个节点加入队列,深度level是1，标记其已访问
        queue.add(new Pair<>(beginWord, 1));
        // hasVistedList.add(beginWord);
        hasVisitedList.put(beginWord, true);
        // 广度优先遍历，逐个取出队列中元素进行操作
        while (!queue.isEmpty()) {
            // 取出queue中的节点
            Pair<String, Integer> node = queue.remove();
            // 当前节点对应的<单词，层级>
            String currWord = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; i++) {
                // 从当前单词，得到len个通配词
                String currComboWord = currWord.substring(0, i) + "*" + currWord.substring(i + 1, len);
                // 拿到这个通配词映射的单词集合(也就是从当前单词一次转换能得到哪些单词)
                ArrayList<String> currComboWordList = allComboDict.getOrDefault(currComboWord, new ArrayList<>());
                // 遍历其中是否包含目标单词
                for (String word : currComboWordList) {
                    // 包含目标单词，说明当前单词能一次转换到目标单词，经历的步骤数是当前单词的层级 + 1
                    if (word.equals(endWord)) {
                        return level + 1;
                    }
                    // 否则，当前单词能得到这个单词，如果它还没被访问过
                    // if (!hasVistedList.contains(word)){
                    // HashMap.containsKey方法效率远高于ArrayList.contains
                    if (!hasVisitedList.containsKey(word)) {
                        // 把这个单词加入到队列中
                        queue.add(new Pair<>(word, level + 1));
                        // 标记它为已访问
                        // hasVistedList.add(word);
                        hasVisitedList.put(word, true);
                    }
                }
            }
        }
        return 0;
    }
}
