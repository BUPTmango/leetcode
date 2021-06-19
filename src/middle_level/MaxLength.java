package middle_level;

import hard_level.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1239. �����ַ�������󳤶�
 * ����һ���ַ������� arr���ַ��� s �ǽ� arr ĳһ�������ַ����������õ��ַ�������� s �е�ÿһ���ַ���ֻ���ֹ�һ�Σ���ô������һ�����н⡣
 * <p>
 * �뷵�����п��н� s ������ȡ�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr = ["un","iq","ue"]
 * �����4
 * ���ͣ����п��ܵĴ�������� "","un","iq","ue","uniq" �� "ique"����󳤶�Ϊ 4��
 * ʾ�� 2��
 * <p>
 * ���룺arr = ["cha","r","act","ers"]
 * �����6
 * ���ͣ����ܵĽ���� "chaers" �� "acters"��
 * ʾ�� 3��
 * <p>
 * ���룺arr = ["abcdefghijklmnopqrstuvwxyz"]
 * �����26
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i]��ֻ����СдӢ����ĸ
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/6/19 11:39
 */
public class MaxLength {
    int ans = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<Integer>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                // �� mask ���� ch����˵�� s �����ظ���ĸ���޷����ɿ��н�
                if (((mask >> ch) & 1) != 0) {
                    mask = 0;
                    break;
                }
                // �� ch ���� mask ��
                mask |= 1 << ch;
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }

        backtrack(masks, 0, 0);
        return ans;
    }

    public void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        // mask �� masks[pos] �޹���Ԫ��
        if ((mask & masks.get(pos)) == 0) {
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        backtrack(masks, pos + 1, mask);
    }
}
