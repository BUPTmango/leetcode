package hard_level;

import java.util.*;

/**
 * ����ת�㷨������Ƶ���⡷���� ͼ��BFS
 * 126. ���ʽ��� II
 * �����������ʣ�beginWord �� endWord����һ���ֵ� wordList���ҳ����д� beginWord �� endWord �����ת�����С�ת������ѭ���¹���
 * <p>
 * ÿ��ת��ֻ�ܸı�һ����ĸ��
 * ת����õ��ĵ��ʱ������ֵ��еĵ��ʡ�
 * ˵��:
 * <p>
 * ���������������ת�����У�����һ�����б�
 * ���е��ʾ�����ͬ�ĳ��ȡ�
 * ���е���ֻ��Сд��ĸ��ɡ�
 * �ֵ��в������ظ��ĵ��ʡ�
 * ����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
 * ʾ�� 1:
 * <p>
 * ����:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * ���:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * ʾ�� 2:
 * <p>
 * ����:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * ���: []
 * <p>
 * ����:endWord "cog" �����ֵ��У����Բ����ڷ���Ҫ���ת�����С�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/2 6:52 ����
 */
public class FindLadders {
    private static final int INF = 1 << 20;
    // ���ʵ�id��ӳ��
    private Map<String, Integer> wordId;
    // id�����ʵ�ӳ��
    private ArrayList<String> idWord;
    // ͼ�ı�
    private ArrayList<Integer>[] edges;

    public FindLadders() {
        wordId = new HashMap<>();
        idWord = new ArrayList<>();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        // ��wordList���е��ʼ���wordId�� ��ͬ��ֻ����һ�� // ��Ϊÿһ�����ʷ���һ��id
        for (String word : wordList) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, id++);
                idWord.add(word);
            }
        }
        // ��endWord����wordList�� ���޽�
        if (!wordId.containsKey(endWord)) {
            return new ArrayList<>();
        }
        // ��beginWordҲ����wordId��
        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }

        // ��ʼ������õ�����
        edges = new ArrayList[idWord.size()];
        for (int i = 0; i < idWord.size(); i++) {
            edges[i] = new ArrayList<>();
        }
        // ��ӱ�
        for (int i = 0; i < idWord.size(); i++) {
            for (int j = i + 1; j < idWord.size(); j++) {
                // �����߿���ͨ��ת���õ� �������Ǽ佨һ�������
                if (transformCheck(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        // Ŀ��ID
        int dest = wordId.get(endWord);
        // ���
        List<List<String>> res = new ArrayList<>();
        // ��ÿ����Ĵ���
        int[] cost = new int[id];
        for (int i = 0; i < id; i++) {
            // ÿ����Ĵ��۳�ʼ��Ϊ�����
            cost[i] = INF;
        }

        // ����������� ������cost��Ϊ0
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordId.get(beginWord));
        q.add(tmpBegin);
        cost[wordId.get(beginWord)] = 0;

        // ��ʼ�����������
        while (!q.isEmpty()) {
            ArrayList<Integer> now = q.poll();
            // ������ʵĵ�
            int last = now.get(now.size() - 1);
            // ���õ�Ϊ�յ���������res��
            if (last == dest) {
                ArrayList<String> tmp = new ArrayList<>();
                for (int index : now) {
                    // ת��Ϊ��Ӧ��word
                    tmp.add(idWord.get(index));
                }
                res.add(tmp);
                // �õ㲻Ϊ�յ� ��������
            } else {
                for (int i = 0; i < edges[last].size(); i++) {
                    int to = edges[last].get(i);
                    // �˴�<=Ŀ�����ڰѴ�����ͬ�Ĳ�ͬ·��ȫ����������
                    if (cost[last] + 1 <= cost[to]) {
                        cost[to] = cost[last] + 1;
                        // ��to����·����
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(to);
                        // �����·���������
                        q.add(tmp);
                    }
                }
            }
        }
        return res;
    }

    /**
     * �����ַ����Ƿ����ͨ���ı�һ����ĸ�����
     * @param str1
     * @param str2
     * @return
     */
    boolean transformCheck(String str1, String str2) {
        int differences = 0;
        for (int i = 0; i < str1.length() && differences < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                ++differences;
            }
        }
        return differences == 1;
    }
}
