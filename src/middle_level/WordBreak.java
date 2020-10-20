package middle_level;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ����ת�㷨������Ƶ���⡷��̬�滮 ��������
 * 139. ���ʲ��
 * ����һ���ǿ��ַ��� s ��һ�������ǿյ��ʵ��б� wordDict���ж�s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��ֵĵ��ʡ�
 *
 * ˵����
 *
 * ���ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
 * ����Լ����ֵ���û���ظ��ĵ��ʡ�
 * ʾ�� 1��
 *
 * ����: s = "leetcode", wordDict = ["leet", "code"]
 * ���: true
 * ����: ���� true ��Ϊ "leetcode" ���Ա���ֳ� "leet code"��
 * ʾ�� 2��
 *
 * ����: s = "applepenapple", wordDict = ["apple", "pen"]
 * ���: true
 * ����: ���� true ��Ϊ "applepenapple" ���Ա���ֳ� "apple pen apple"��
 *     ע��������ظ�ʹ���ֵ��еĵ��ʡ�
 * ʾ�� 3��
 *
 * ����: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * ���: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/20 9:25 ����
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        // dp[i] ��ʾ�ַ��� s ǰ i ���ַ���ɵ��ַ��� s[0..i-1] �Ƿ��ܱ��ո��ֳ����ɸ��ֵ��г��ֵĵ���
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // j֮ǰ�Ĵ��� �������һ������Ҳ���� ����iΪ����
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
