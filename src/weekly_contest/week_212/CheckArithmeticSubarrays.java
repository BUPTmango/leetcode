package weekly_contest.week_212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5547. �Ȳ�������
 * ���һ����������������Ԫ����ɣ���ÿ��������Ԫ��֮��Ĳ�ֵ����ͬ����ô������о��� �Ȳ����� ������ʽ�أ����� s �ǵȲ����У�ֻ��Ҫ���㣺����ÿ����Ч�� i �� s[i+1] - s[i] == s[1] - s[0] ��������
 *
 * ���磬������Щ���� �Ȳ����� ��
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * ��������� ���ǵȲ����� ��
 *
 * 1, 1, 2, 5, 7
 * ����һ���� n ��������ɵ����� nums���������� m ��������ɵ����� l �� r�������������ʾ m �鷶Χ��ѯ�����е� i ����ѯ��Ӧ��Χ [l[i], r[i]] ������������±궼�� �� 0 ��ʼ �ġ�
 *
 * ���� boolean Ԫ�ع��ɵĴ��б� answer ����������� nums[l[i]], nums[l[i]+1], ... , nums[r[i]] ���� �������� �γ� �Ȳ����� ��answer[i] ��ֵ���� true������answer[i] ��ֵ���� false ��
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
 * �����[true,false,true]
 * ���ͣ�
 * �� 0 ����ѯ����Ӧ������ [4,6,5] ��������������Ϊ�Ȳ����� [6,5,4] ��
 * �� 1 ����ѯ����Ӧ������ [4,6,5,9] ���޷����������γɵȲ����С�
 * �� 2 ����ѯ����Ӧ������ [5,9,3,7] ��������������Ϊ�Ȳ����� [3,5,7,9] ��
 * ʾ�� 2��
 *
 * ���룺nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
 * �����[false,true,false,false,true,true]
 *
 *
 * ��ʾ��
 *
 * n == nums.length
 * m == l.length
 * m == r.length
 * 2 <= n <= 500
 * 1 <= m <= 500
 * 0 <= l[i] < r[i] < n
 * -105 <= nums[i] <= 105
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/25 10:58 ����
 */
public class CheckArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            res.add(isEqualDifferenceSequence(nums, l[i], r[i]));
        }
        return res;
    }

    private boolean isEqualDifferenceSequence(int[] nums, int l, int r) {
        // ���Ƴ�����������
        int[] array = new int[r - l + 1];
        System.arraycopy(nums, l, array, 0, r - l + 1);
        Arrays.sort(array);
        // �鿴�ǲ��ǵȲ�
        int difference = array[1] - array[0];
        for (int i = 2; i < array.length; i++) {
            if (array[i] - array[i - 1] != difference) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckArithmeticSubarrays check = new CheckArithmeticSubarrays();
        int[] nums = new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = new int[]{0,1,6,4,8,7};
        int[] r = new int[]{4,4,9,7,9,10};
        List<Boolean> booleans = check.checkArithmeticSubarrays(nums, l, r);
        for (boolean bool : booleans) {
            System.out.println(bool);
        }
    }
}
