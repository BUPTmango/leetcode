package middle_level;

import java.util.*;

/**
 * ����ת�㷨������Ƶ���⡷���ұ� �����ֵ
 * 49. ��ĸ��λ�ʷ���
 * ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
 *
 * ʾ��:
 *
 * ����: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * ���:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * ˵����
 *
 * ���������ΪСд��ĸ��
 * �����Ǵ������˳��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/21 8:25 ����
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        // 26����ĸ�ĳ��ִ�����Ϊkey�� ������ĸ������ͬ��list��Ϊvalue
        Map<String, List> ans = new HashMap<>();
        // �����洢ÿ��str��ÿ����ĸ�ĳ��ִ���
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // ��26����ĸÿ����ĸ���ֵĴ�����#������
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public List<List<String>> groupAnagrams_another(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // �����ź����string����map
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
