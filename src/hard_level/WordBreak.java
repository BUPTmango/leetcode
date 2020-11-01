package hard_level;

import java.util.*;

/**
 * 140. ���ʲ�� II
 * ����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict�����ַ��������ӿո�������һ�����ӣ�ʹ�þ��������еĵ��ʶ��ڴʵ��С�����������Щ���ܵľ��ӡ�
 *
 * ˵����
 *
 * �ָ�ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
 * ����Լ����ֵ���û���ظ��ĵ��ʡ�
 * ʾ�� 1��
 *
 * ����:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * ���:
 * [
 *  "cats and dog",
 *  "cat sand dog"
 * ]
 * ʾ�� 2��
 *
 * ����:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * ���:
 * [
 *  "pine apple pen apple",
 *  "pineapple pen apple",
 *  "pine applepen apple"
 * ]
 * ����: ע��������ظ�ʹ���ֵ��еĵ��ʡ�
 * ʾ��3��
 *
 * ����:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * ���:
 * []
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/1 8:49 ����
 */
public class WordBreak {
    /**
     * ���仯����
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<>(wordDict), 0, map);
        List<String> breakList = new LinkedList<>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        // ��������Ѿ����ʹ����±꣬�����ֱ�Ӵӹ�ϣ��õ������������Ҫ�ظ�����
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<>();
            if (index == length) {
                wordBreaks.add(new LinkedList<>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }
}
