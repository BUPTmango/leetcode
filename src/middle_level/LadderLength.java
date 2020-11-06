package middle_level;

import javafx.util.Pair;

import java.util.*;

/**
 * ˫��BFS
 * ����ת�㷨������Ƶ���⡷���� ͼ��BFS
 * 127. ���ʽ���
 * �����������ʣ�beginWord?�� endWord����һ���ֵ䣬�ҵ���?beginWord ��?endWord �����ת�����еĳ��ȡ�ת������ѭ���¹���
 * <p>
 * ÿ��ת��ֻ�ܸı�һ����ĸ��
 * ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
 * ˵��:
 * <p>
 * ���������������ת�����У����� 0��
 * ���е��ʾ�����ͬ�ĳ��ȡ�
 * ���е���ֻ��Сд��ĸ��ɡ�
 * �ֵ��в������ظ��ĵ��ʡ�
 * ����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
 * ʾ��?1:
 * <p>
 * ����:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * ���: 5
 * <p>
 * ����: һ�����ת�������� "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * �������ĳ��� 5��
 * ʾ�� 2:
 * <p>
 * ����:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * ���:?0
 * <p>
 * ����:?endWord "cog" �����ֵ��У������޷�����ת����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/13 11:10 ����
 */
public class LadderLength {
    /**
     * ˫��BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // ��wordListת����wordSet
        Set<String> wordSet = new HashSet<>(wordList.size());
        wordSet.addAll(wordList);
        // �������set�о��޷�ת��
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
                        if (s2.contains(tmp)) {
                            return step + 1;
                        }
                        if (!wordSet.contains(tmp)) {
                            continue;
                        }
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


    public static int ladderLength_BFS(String beginWord, String endWord, List<String> wordList) {
        // ���������б��в�����endword��ֱ�ӷ���
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // ��Ŀ˵����ÿ�����ʳ�����ͬ
        int len = beginWord.length();
        // ��������ĵ����ֵ䣬ת��Ϊȫ����ͨ��״̬��ÿ��ͨ���ӳ��ĵ��ʼ���
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();
        // lambda���ʽ������curWord�ǵ�ǰ���ڱ����ĵ���
        wordList.forEach(curWord -> {
            // ÿ�������ܵõ�len��ͨ���(ÿ��λ���ַ����ɱ�Ϊ*)
            for (int i = 0; i < len; i++) {
                // �õ�ͨ���
                String comboWord = curWord.substring(0, i) + "*" + curWord.substring(i + 1, len);
                // ��ͨ���ֵ�ȫ�����õ����ͨ��ʶ�Ӧ�ĵ��ʼ��ϣ�����ǿ�(��һ�εõ�ͨ���ʱ)�ʹ���һ���µ�
                ArrayList<String> comboWordList = allComboDict.getOrDefault(comboWord, new ArrayList<>());
                // �ѵ�ǰ������ʼӽ�ȥ����˴�������ʵõ������ͨ���
                comboWordList.add(curWord);
                // ����һ��ͨ���ֵ�ȫ�������ͨ��ʶ�Ӧ�ĵ��ʼ���
                allComboDict.put(comboWord, comboWordList);
            }
        });
        // ������ȱ�������
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        // ��¼�ѱ������ĵ���,Ϊʲô����List����Ϊ֮���жϽڵ��Ƿ��ѱ�����ʱ��ArrayList��contains����̫��Ч�ˣ����ĵײ������飬����ֱ����TreeSetҲ����
        // ArrayList<String> hasVisitedList = new ArrayList<>();
        HashMap<String, Boolean> hasVisitedList = new HashMap<>();
        // ��ʼ����Ϊ��һ���ڵ�������,���level��1��������ѷ���
        queue.add(new Pair<>(beginWord, 1));
        // hasVistedList.add(beginWord);
        hasVisitedList.put(beginWord, true);
        // ������ȱ��������ȡ��������Ԫ�ؽ��в���
        while (!queue.isEmpty()) {
            // ȡ��queue�еĽڵ�
            Pair<String, Integer> node = queue.remove();
            // ��ǰ�ڵ��Ӧ��<���ʣ��㼶>
            String currWord = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; i++) {
                // �ӵ�ǰ���ʣ��õ�len��ͨ���
                String currComboWord = currWord.substring(0, i) + "*" + currWord.substring(i + 1, len);
                // �õ����ͨ���ӳ��ĵ��ʼ���(Ҳ���Ǵӵ�ǰ����һ��ת���ܵõ���Щ����)
                ArrayList<String> currComboWordList = allComboDict.getOrDefault(currComboWord, new ArrayList<>());
                // ���������Ƿ����Ŀ�굥��
                for (String word : currComboWordList) {
                    // ����Ŀ�굥�ʣ�˵����ǰ������һ��ת����Ŀ�굥�ʣ������Ĳ������ǵ�ǰ���ʵĲ㼶 + 1
                    if (word.equals(endWord)) {
                        return level + 1;
                    }
                    // ���򣬵�ǰ�����ܵõ�������ʣ��������û�����ʹ�
                    // if (!hasVistedList.contains(word)){
                    // HashMap.containsKey����Ч��Զ����ArrayList.contains
                    if (!hasVisitedList.containsKey(word)) {
                        // ��������ʼ��뵽������
                        queue.add(new Pair<>(word, level + 1));
                        // �����Ϊ�ѷ���
                        // hasVistedList.add(word);
                        hasVisitedList.put(word, true);
                    }
                }
            }
        }
        return 0;
    }
}
