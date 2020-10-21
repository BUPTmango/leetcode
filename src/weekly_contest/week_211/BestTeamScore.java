package weekly_contest.week_211;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 5545. ��ì�ܵ�������
 * ����������ӵľ������ڼ��������Ľ��������������һ֧����÷���ߵ���ӡ���ӵĵ÷��������������Ա�ķ��� �ܺ� ��
 * <p>
 * Ȼ��������е�ì�ܻ�������Ա�ķ��ӣ����Ա���ѡ��һ֧ û��ì�� ����ӡ����һ�������С��Ա�ķ��� �ϸ���� һ������ϴ����Ա�������ì�ܡ�ͬ����Ա֮�䲻�ᷢ��ì�ܡ�
 * <p>
 * ���������б� scores �� ages������ÿ�� scores[i] �� ages[i] ��ʾ�� i ����Ա�ķ��������䡣���㷵�� ���п��ܵ���ì������е÷������֧�ķ��� ��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * �����34
 * ���ͣ������ѡ��������Ա��
 * ʾ�� 2��
 * <p>
 * ���룺scores = [4,5,6,5], ages = [2,1,2,1]
 * �����16
 * ���ͣ���ѵ�ѡ���Ǻ� 3 ����Ա��ע�⣬�����ѡ�ж��ͬ����Ա��
 * ʾ�� 3��
 * <p>
 * ���룺scores = [1,2,3,5], ages = [8,9,10,1]
 * �����6
 * ���ͣ���ѵ�ѡ����ǰ 3 ����Ա��
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= scores.length, ages.length <= 1000
 * scores.length == ages.length
 * 1 <= scores[i] <= 106
 * 1 <= ages[i] <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/18 11:08 ����
 */
public class BestTeamScore {
    /**
     * 300 ����������б�����
     *
     * @param scores
     * @param ages
     * @return
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        if (scores.length == 1) {
            return scores[0];
        }

        int[][] arr = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        // �������������������ͬ�İ�������������
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int[] dp = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            dp[i] = arr[i][1];
        }

        int ans = 0;
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < i; j++) { // ����i֮ǰ��û�б�iС��
                if (arr[j][1] <= arr[i][1]) {
                    dp[i] = Math.max(dp[j] + arr[i][1], dp[i]);
                }
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,3,2};
        Arrays.sort(array, Comparator.comparingInt(o -> o));
        for (int i : array) {
            System.out.println(i);
        }
    }
}
