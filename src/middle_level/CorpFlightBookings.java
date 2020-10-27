package middle_level;

/**
 * ������鷨
 * 1109. ����Ԥ��ͳ��
 * ������n�����࣬���Ƿֱ�� 1 �� n ���б�š�
 *
 * ���������һ�ݺ���Ԥ�������е�i��Ԥ����¼bookings[i] = [i, j, k]��ζ�������ڴ�i��j��ÿ��������Ԥ���� k ����λ��
 *
 * ���㷵��һ������Ϊ n ������answer����������˳�򷵻�ÿ��������Ԥ������λ����
 *
 * ʾ����
 *
 * ���룺bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * �����[10,55,45,25,25]
 * 
 *
 * ��ʾ��
 *
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/27 7:39 ����
 */
public class CorpFlightBookings {
    /**
     * ������鷨
     *
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];

        // ������������
        // ����bookings ���㺽��i+1 �Ժ���i �仯��Ԥ����
        for (int[] b : bookings) {
            // ���ӵ�Ԥ����
            answer[b[0] - 1] += b[2];
            // ��ֹ����Խ��
            if (b[1] < n) {
                // ���ٵ�Ԥ������
                answer[b[1]] -= b[2];
            }
        }

        // �Բ��������л�ԭ
        // ����i��Ԥ��������,i-1��Ԥ��������iʱ�̱仯��Ԥ����
        for (int i = 1; i < n; i++) {
            answer[i] += answer[i - 1];
        }
        return answer;
    }
}
