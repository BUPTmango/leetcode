package simple_level.coder_gold;

import java.util.HashMap;
import java.util.Map;

/**
 * ������ 01.02. �ж��Ƿ�Ϊ�ַ�����
 * ���������ַ��� s1 �� s2�����дһ������ȷ������һ���ַ������ַ��������к��ܷ�����һ���ַ�����
 *
 * ʾ�� 1��
 *
 * ����: s1 = "abc", s2 = "bca"
 * ���: true
 * ʾ�� 2��
 *
 * ����: s1 = "abc", s2 = "bad"
 * ���: false
 * ˵����
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/19 10:20 ����
 */
public class CheckPermutation {
    /**
     * �Ⱦ�������������������Сһ����
     * ��ϣ��洢ÿ����ĸ���ֵĴ�����ֻҪ�κ�һ���ַ����ֵĴ�������ȣ�����Խ��������еõ���
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkPermutation(String s1, String s2) {
        if(s1.length()!=s2.length()) {
            return false;
        }

        int hash1[] = new int[128];
        int hash2[] = new int[128];
        for(int j=0;j<s1.length(); j++){
            hash1[s1.charAt(j)]++;
            hash2[s2.charAt(j)]++;
        }

        for(int a=0; a<128; a++){
            if(hash1[a]!=hash2[a]) {
                return false;
            }
        }
        return true;
    }

}
