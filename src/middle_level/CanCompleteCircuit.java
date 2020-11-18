package middle_level;

/**
 * 134. ����վ
 * ��һ����·����N������վ�����е�i������վ������gas[i]����
 *
 * ����һ�������������޵ĵ��������ӵ� i ������վ������ i+1������վ��Ҫ��������cost[i]����������е�һ������վ��������ʼʱ����Ϊ�ա�
 *
 * ���������ƻ�·��ʻһ�ܣ��򷵻س���ʱ����վ�ı�ţ����򷵻� -1��
 *
 * ˵��:
 *
 * �����Ŀ�н⣬�ô𰸼�ΪΨһ�𰸡�
 * ���������Ϊ�ǿ����飬�ҳ�����ͬ��
 * ���������е�Ԫ�ؾ�Ϊ�Ǹ�����
 * ʾ��1:
 *
 * ����:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * ���: 3
 *
 * ����:
 * �� 3 �ż���վ(����Ϊ 3 ��)�������ɻ�� 4 �����͡���ʱ������ = 0 + 4 = 4 ������
 * ���� 4 �ż���վ����ʱ������ 4 - 1 + 5 = 8 ������
 * ���� 0 �ż���վ����ʱ������ 8 - 2 + 1 = 7 ������
 * ���� 1 �ż���վ����ʱ������ 7 - 3 + 2 = 6 ������
 * ���� 2 �ż���վ����ʱ������ 6 - 4 + 3 = 5 ������
 * ���� 3 �ż���վ������Ҫ���� 5 �����ͣ������㹻�㷵�ص� 3 �ż���վ��
 * ��ˣ�3 ��Ϊ��ʼ������
 * ʾ�� 2:
 *
 * ����:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 *
 * ���: -1
 *
 * ����:
 * �㲻�ܴ� 0 �Ż� 1 �ż���վ��������Ϊû���㹻�����Ϳ���������ʻ����һ������վ��
 * ���Ǵ� 2 �ż���վ���������Ի�� 4 �����͡� ��ʱ������ = 0 + 4 = 4 ������
 * ���� 0 �ż���վ����ʱ������ 4 - 3 + 2 = 3 ������
 * ���� 1 �ż���վ����ʱ������ 3 - 3 + 3 = 3 ������
 * ���޷����� 2 �ż���վ����Ϊ������Ҫ���� 4 �����ͣ������������ֻ�� 3 �����͡�
 * ��ˣ������������㶼�������ƻ�·��ʻһ�ܡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/18 9:00 ����
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // ������ʼ�ڵ�
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int index = i;
            while (index < i + n) {
                sum = sum + gas[index % n] - cost[index % n];
                if (sum >= 0) {
                    index++;
                } else {
                    break;
                }
            }
            if (sum >= 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * ʹ��ͼ��˼�����������
     * https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit_better(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        // �ܵ��յ�ʱ����ʣ�������� >= 0
        return spare < 0 ? -1 : (minIndex + 1) % len;
    }

    public static void main(String[] args) {
        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit.canCompleteCircuit(gas, cost));
    }
}
