package simple_level;

/**
 * 268
 * ȱʧ����
 * ����һ������ 0, 1, 2, ..., n?��?n?���������У��ҳ� 0 .. n?��û�г����������е��Ǹ�����
 *
 * ʾ�� 1:
 *
 * ����: [3,0,1]
 * ���: 2
 * ʾ��?2:
 *
 * ����: [9,6,4,2,3,5,7,0,1]
 * ���: 8
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/20 10:50 ����
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int subSum = 0;
        int sum = 0;
        for (int i : nums) {
            subSum += i;
        }
        for (int j = 0; j <= nums.length; j++) {
            sum += j;
        }
        return sum - subSum;
    }
}
