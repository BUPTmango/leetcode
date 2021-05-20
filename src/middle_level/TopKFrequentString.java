package middle_level;

import java.util.*;

/**
 * 692. ǰK����Ƶ����
 * ��һ�ǿյĵ����б�����ǰk�����ִ������ĵ��ʡ�
 * ���صĴ�Ӧ�ð����ʳ���Ƶ���ɸߵ������������ͬ�ĵ�������ͬ����Ƶ�ʣ�����ĸ˳������
 *
 * ʾ�� 1��
 *
 * ����: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * ���: ["i", "love"]
 * ����: "i" �� "love" Ϊ���ִ��������������ʣ���Ϊ2�Ρ�
 *     ע�⣬����ĸ˳�� "i" �� "love" ֮ǰ��
 * 
 * ʾ�� 2��
 *
 * ����: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * ���: ["the", "is", "sunny", "day"]
 * ����: "the", "is", "sunny" �� "day" �ǳ��ִ��������ĸ����ʣ�
 *     ���ִ�������Ϊ 4, 3, 2 �� 1 �Ρ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/20 09:04
 */
public class TopKFrequentString {
    public List<String> topKFrequent(String[] words, int k) {
        // ͳ�Ƶ��ʳ��ִ���
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // �Զ������򲢷������
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o2.compareTo(o1);
            } else {
                return map.get(o1).compareTo(map.get(o2));
            }
        });
        for (String word : map.keySet()) {
            queue.add(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        // �������
        List<String> top_k = new ArrayList<>();
        while (!queue.isEmpty()) {
            top_k.add(queue.poll());
        }
        // ����
        Collections.reverse(top_k);
        return top_k;
    }

    public static void main(String[] args) {
        TopKFrequentString top = new TopKFrequentString();
        List<String> strings = top.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        strings.forEach(System.out::println);
    }
}
