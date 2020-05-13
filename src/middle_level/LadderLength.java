package middle_level;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. ���ʽ���
 * �����������ʣ�beginWord?�� endWord����һ���ֵ䣬�ҵ���?beginWord ��?endWord �����ת�����еĳ��ȡ�ת������ѭ���¹���
 *
 * ÿ��ת��ֻ�ܸı�һ����ĸ��
 * ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
 * ˵��:
 *
 * ���������������ת�����У����� 0��
 * ���е��ʾ�����ͬ�ĳ��ȡ�
 * ���е���ֻ��Сд��ĸ��ɡ�
 * �ֵ��в������ظ��ĵ��ʡ�
 * ����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
 * ʾ��?1:
 *
 * ����:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * ���: 5
 *
 * ����: һ�����ת�������� "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      �������ĳ��� 5��
 * ʾ�� 2:
 *
 * ����:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * ���:?0
 *
 * ����:?endWord "cog" �����ֵ��У������޷�����ת����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/13 11:10 ����
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // ��wordListת����wordSet
        Set<String> wordSet = new HashSet<>(wordList.size());
        wordSet.addAll(wordList);
        // �Ѿ����ھͲ���Ҫת��
        if (!wordSet.contains(endWord)) return 0;
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add(beginWord);
        s2.add(endWord);
        int n = beginWord.length();
        int step = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            step++;
            // ������չС��set���൱��balance
            if (s1.size() > s2.size()) {
                Set<String> tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
            Set<String> s = new HashSet<>();
            for (String word : s1) {
                // ����ÿһλ
                for (int i = 0; i < n; i++) {
                    // ����һ�ݣ�����ԭ����word�������
                    char[] chars = word.toCharArray();
                    // ����Ϊa��zȫ����һ��
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String tmp = new String(chars);
                        // �������һ��set�г���˵������һ����Ҳ�����ҵ���
                        if (s2.contains(tmp)) return step + 1;
                        if (!wordSet.contains(tmp)) continue;
                        // ������ֵ����Ǿ�ɾ������ֹ���ֻ�
                        wordSet.remove(tmp);
                        s.add(tmp);
                    }
                }
            }
            // ����ʱ��s��ֵ��s1
            s1 = s;
        }
        return 0;
    }
}
