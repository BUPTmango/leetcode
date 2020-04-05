package simple_level;

/**
 * 1013. ������ֳɺ���ȵ���������
 * ����һ����������?A��ֻ�п��Խ��仮��Ϊ��������ȵķǿղ���ʱ�ŷ���?true�����򷵻� false��
 *
 * ��ʽ�ϣ���������ҳ�����?i+1 < j?������?(A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])?�Ϳ��Խ��������ȷ֡�
 *
 * ʾ�� 1��
 *
 * �����[0,2,1,-6,6,-7,9,1,2,0,1]
 * �����true
 * ���ͣ�0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * ʾ�� 2��
 *
 * ���룺[0,2,1,-6,6,7,9,-1,2,0,1]
 * �����false
 * ʾ�� 3��
 *
 * ���룺[3,3,6,5,-2,2,5,1,-9,4]
 * �����true
 * ���ͣ�3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 * ��ʾ��
 *
 * 3 <= A.length <= 50000
 * -10^4?<= A[i] <= 10^4
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/5 10:02 ����
 */
public class CanThreePartsEqualSum {
    /**
     * �����ֺ���� ����ÿ����������͵�1/3
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        int target = sum / 3;
        int turn = 0;
        int count = 0;
        for (int item : A) {
            count += item;
            if (count == target) {
                count = 0;
                turn++;
            }
        }
        // ������>=3 ��Ϊ[-1,1,-1,1,-1,1,-1,1]
        return turn >= 3 && count == 0;
    }
}
