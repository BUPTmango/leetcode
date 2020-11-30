package hard_level.coder_gold;

/**
 * Ѱ����ʧ������
 * ������ 17.19. ��ʧ����������
 * ����һ�����飬������ 1 �� N ���е�������������ȱ���������֡������� O(N) ʱ����ֻ�� O(1) �Ŀռ��ҵ�������
 *
 * ������˳�򷵻����������־��ɡ�
 *
 * ʾ�� 1:
 *
 * ����: [1]
 * ���: [2,3]
 * ʾ�� 2:
 *
 * ����: [2,3]
 * ���: [1,4]
 * ��ʾ��
 *
 * nums.length <=30000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/30 7:37 ����
 */
public class MissingTwo {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        // nums�������
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // �������ʧ������Ԫ�صĺ�
        int sumTwo = (int) (n * (n + 1) / 2 - sum);
        int limits = sumTwo / 2;
        sum = 0;
        for (int num : nums) {
            // ����������ͬ ��ôһ������ һ��С��
            if (num <= limits) {
                sum += num;
            }
        }
        int one = (int) (limits * (limits + 1) / 2 - sum);
        return new int[]{one, sumTwo - one};
    }
}
