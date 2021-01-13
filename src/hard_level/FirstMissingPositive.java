package hard_level;

/**
 * 41. ȱʧ�ĵ�һ������
 * ����һ��δ������������飬�����ҳ�����û�г��ֵ���С����������
 *
 * ʾ��1:
 *
 * ����: [1,2,0]
 * ���: 3
 * ʾ��2:
 *
 * ����: [3,4,-1,1]
 * ���: 2
 * ʾ��3:
 *
 * ����: [7,8,9,11,12]
 * ���: 1
 *
 * ��ʾ��
 *
 * ����㷨��ʱ�临�Ӷ�ӦΪO(n)������ֻ��ʹ�ó�������Ķ���ռ䡣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/14 8:13 ����
 */
public class FirstMissingPositive {
    /**
     * �û�
     * �ڻָ�������Ӧ���� [1, 2, ..., N] ����ʽ�������������ɸ�λ���ϵ����Ǵ���ģ�ÿһ�������λ�þʹ�����һ��ȱʧ��������
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // ÿ�ν�������һ��Ԫ�ص���ȷ��λ����
        for (int i = 0; i < n; ++i) {
            // ע�⣡������ ע�����������Ž��� ������ж�����Ϊ��һ���Ž�������ֹ��ѭ��
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        // �ҵ�������ļ�һ
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // ������ ֱ�Ӽ�һ
        return n + 1;
    }
}
