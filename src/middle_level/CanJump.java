package middle_level;

/**
 * 55. ��Ծ��Ϸ
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * �ж����Ƿ��ܹ��������һ��λ�á�
 *
 * ʾ��?1:
 *
 * ����: [2,3,1,1,4]
 * ���: true
 * ����: ���ǿ������� 1 ������λ�� 0 ���� λ�� 1, Ȼ���ٴ�λ�� 1 �� 3 ���������һ��λ�á�
 * ʾ��?2:
 *
 * ����: [3,2,1,0,4]
 * ���: false
 * ����: �������������ܻᵽ������Ϊ 3 ��λ�á�����λ�õ������Ծ������ 0 �� ��������Զ�����ܵ������һ��λ�á�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/7 9:57 ����
 */
public class CanJump {
    /**
     * �Ӻ���ǰ��
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int[] check = new int[len];
        // �������һ���ǿ϶��ܵ����
        check[len - 1] = 1;
        // 0:unknown 1:reachable 2:unreachable
        for (int i = len - 1; i >= 0; i--) {
            int l = nums[i];
            for (int j = 0; j <= l; j++) {
                // ��һ�ַ�ʽ���Ե��Ｔ��
                if (check[i + j] == 1) {
                    check[i] = 1;
                    break;
                }
            }
        }
        return check[0] == 1 ? true : false;
    }

    public boolean canJump_better(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        // ����һ���Ѿ��ܵ���ı���
        int lastPos = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0 ? true : false;
    }

}
