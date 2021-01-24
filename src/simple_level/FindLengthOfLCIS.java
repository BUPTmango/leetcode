package simple_level;

/**
 * 674. �������������
 * ����һ��δ��������������飬�ҵ���� ���������������У������ظ����еĳ��ȡ�
 *
 * ���������������� �����������±� l �� r��l < r��ȷ�����������ÿ�� l <= i < r������ nums[i] < nums[i + 1] ����ô������ [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] �����������������С�
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,3,5,4,7]
 * �����3
 * ���ͣ���������������� [1,3,5], ����Ϊ3��
 * ���� [1,3,5,7] Ҳ�������������, �������������ģ���Ϊ 5 �� 7 ��ԭ�����ﱻ 4 ������
 * ʾ�� 2��
 *
 * ���룺nums = [2,2,2,2,2]
 * �����1
 * ���ͣ���������������� [2], ����Ϊ1��
 *
 * ��ʾ��
 *
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/24 4:46 ����
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            // �������С���� ��Ҫ���¿�ʼ���㳤��
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
