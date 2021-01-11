package middle_level;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1202. �����ַ����е�Ԫ��
 * ����һ���ַ���s���Լ����ַ����е�һЩ�������ԡ�����pairs������pairs[i] =[a, b]��ʾ�ַ����е�������������Ŵ� 0 ��ʼ����
 * <p>
 * ����� �����ν��� ��pairs������һ�����������ַ���
 * <p>
 * �����ھ������ɴν�����s���Ա�ɵİ��ֵ�����С���ַ�����
 * <p>
 * <p>
 * <p>
 * ʾ�� 1:
 * <p>
 * ���룺s = "dcab", pairs = [[0,3],[1,2]]
 * �����"bacd"
 * ���ͣ�
 * ���� s[0] �� s[3], s = "bcad"
 * ���� s[1] �� s[2], s = "bacd"
 * ʾ�� 2��
 * <p>
 * ���룺s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * �����"abcd"
 * ���ͣ�
 * ���� s[0] �� s[3], s = "bcad"
 * ���� s[0] �� s[2], s = "acbd"
 * ���� s[1] �� s[2], s = "abcd"
 * ʾ�� 3��
 * <p>
 * ���룺s = "cba", pairs = [[0,1],[1,2]]
 * �����"abc"
 * ���ͣ�
 * ���� s[0] �� s[1], s = "bca"
 * ���� s[1] �� s[2], s = "bac"
 * ���� s[0] �� s[1], s = "abc"
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] <s.length
 * s��ֻ����СдӢ����ĸ
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/11 9:08 ����
 */
public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }

        // �� 1 ���������⽻���Ľ������벢�鼯
        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            int index1 = pair.get(0);
            int index2 = pair.get(1);
            unionFind.union(index1, index2);
        }

        // �� 2 ��������ӳ���ϵ
        char[] charArray = s.toCharArray();
        // key����ͨ�����Ĵ���Ԫ��value��ͬһ����ͨ�������ַ����ϣ�������һ�����ȶ����У�
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            if (hashMap.containsKey(root)) {
                hashMap.get(root).offer(charArray[i]);
            } else {
                // PriorityQueue<Character> minHeap = new PriorityQueue<>();
                // minHeap.offer(charArray[i]);
                // hashMap.put(root, minHeap);
                // �������д���ȼ�������һ�д��룬JDK 1.8 �Լ��Ժ�֧�������д��
                hashMap.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(charArray[i]);
            }
        }

        // �� 3 ���������ַ���
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            stringBuilder.append(hashMap.get(root).poll());
        }
        return stringBuilder.toString();
    }

    private class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
}
