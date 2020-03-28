package middle_level;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 820. ���ʵ�ѹ������
 * ����һ�������б����ǽ�����б�����һ�������ַ���?S?��һ�������б� A��
 *
 * ���磬�������б��� ["time", "me", "bell"]�����ǾͿ��Խ����ʾΪ S = "time#bell#" �� indexes = [0, 2, 5]��
 *
 * ����ÿһ�����������ǿ���ͨ�����ַ��� S?��������λ�ÿ�ʼ��ȡ�ַ�����ֱ�� "#" ���������ָ�����֮ǰ�ĵ����б�
 *
 * ��ô�ɹ��Ը��������б���б������С�ַ��������Ƕ����أ�
 *
 * ?
 *
 * ʾ����
 *
 * ����: words = ["time", "me", "bell"]
 * ���: 10
 * ˵��: S = "time#bell#" �� indexes = [0, 2, 5] ��
 * ?
 *
 * ��ʾ��
 *
 * 1 <= words.length?<= 2000
 * 1 <=?words[i].length?<= 7
 * ÿ�����ʶ���Сд��ĸ ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/28 9:49 ����
 */
public class MinimumLengthEncoding {
    /**
     * Ŀ����Ǳ������в����������ʺ�׺�ĵ��ʣ����Ľ��������Щ���ʳ��ȼ�һ���ܺͣ�
     * ��Ϊÿ�����ʱ������滹��Ҫ��һ�� # ���š�
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k) {
                good.remove(word.substring(k));
            }
        }

        int ans = 0;
        for (String word: good) {
            ans += word.length() + 1;
        }
        return ans;
    }
}
