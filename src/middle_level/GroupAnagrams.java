package middle_level;

import java.util.*;

/**
 * 《玩转算法面试视频例题》查找表 灵活处理键值
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/21 8:25 下午
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        // 26个字母的出现次数作为key， 出现字母次数相同的list作为value
        Map<String, List> ans = new HashMap<>();
        // 用来存储每个str中每个字母的出现次数
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // 将26个字母每个字母出现的次数用#相连接
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
        // 按照排好序的string放入map
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
