package weekly_contest.week_214;

import java.util.Arrays;

/**
 * 5563. ���ۼ�ֵ���ٵ���ɫ��
 * ����һЩ��Ŀ�� inventory ����������Ų�ͬ��ɫ����һ���˿���Ҫ ������ɫ ����Ϊ orders ����
 *
 * ��λ�˿���һ������ķ�ʽ������ļ�ֵ��ÿ����ļ�ֵ��Ŀǰʣ�µ� ͬɫ�� ����Ŀ���ȷ�˵��ʣ�� 6 ��������ô�˿����һ�������ʱ��û���ļ�ֵΪ 6 ����ʽ����Ժ�ֻʣ�� 5 �������ˣ�������һ������ļ�ֵΪ 5 ��Ҳ������ļ�ֵ���Ź˿͹���ͬɫ���ǵݼ��ģ�
 *
 * ������������ inventory ������ inventory[i] ��ʾ�� i ����ɫ��һ��ʼ����Ŀ��ͬʱ�������� orders ����ʾ�˿��ܹ����������Ŀ������԰��� ����˳�� ����
 *
 * ���㷵������ orders �����Ժ� ��� �ܼ�ֵ֮�͡����ڴ𰸿��ܻ�ܴ����㷵�ش𰸶� 109 + 7 ȡ���� �Ľ����
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺inventory = [2,5], orders = 4
 * �����14
 * ���ͣ��� 1 ����һ����ɫ���򣨼�ֵΪ 2 )���� 3 ���ڶ�����ɫ���򣨼�ֵΪ 5 + 4 + 3����
 * ����ܺ�Ϊ 2 + 5 + 4 + 3 = 14 ��
 * ʾ�� 2��
 *
 * ���룺inventory = [3,5], orders = 6
 * �����19
 * ���ͣ��� 2 ����һ����ɫ���򣨼�ֵΪ 3 + 2������ 4 ���ڶ�����ɫ���򣨼�ֵΪ 5 + 4 + 3 + 2����
 * ����ܺ�Ϊ 3 + 2 + 5 + 4 + 3 + 2 = 19 ��
 * ʾ�� 3��
 *
 * ���룺inventory = [2,8,4,10,6], orders = 20
 * �����110
 * ʾ�� 4��
 *
 * ���룺inventory = [1000000000], orders = 1000000000
 * �����21
 * ���ͣ��� 1000000000 �ε�һ����ɫ�����ܼ�ֵΪ 500000000500000000 �� 500000000500000000 �� 109 + 7 ȡ��Ϊ 21 ��
 *
 *
 * ��ʾ��
 *
 * 1 <= inventory.length <= 105
 * 1 <= inventory[i] <= 109
 * 1 <= orders <= min(sum(inventory[i]), 109)
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/8 11:30 ����
 */
public class MaxProfit {
    public int maxProfit(int[] inventory, int orders) {
        int n = inventory.length;
        int mod = (int)1e9 + 7;
        Arrays.sort(inventory);
        int[] times = new int[n];
        // ͳ�ƴ���
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                times[i] += inventory[j] - inventory[i] + 1;
            }
        }
        // �鿴orders�����ĸ���Χ
        int upper = -1;
        for (int i = 0; i < times.length; i++) {
            if (orders >= times[i]) {
                upper = i;
                break;
            }
        }
        // ���㵽��ǰλ�õĺ�
        long sum = 0;
        for (int i = upper + 1; i < n; i++) {
            sum += (inventory[upper] + inventory[i]) * (inventory[i] - inventory[upper] + 1) / 2;
        }
        // ȡ������ĸ���
        int take = times[upper];
        if (take == orders) {
            return (int)(sum % mod);
        }
        // ���ϵ�ǰ��value
        sum += inventory[upper];
        take++;
        if (take == orders) {
            return (int)(sum % mod);
        }
        // ѭ�����Ԫ��
        // ʣ����Ҫȡ�����������
        int remains = orders - take;
        // ѭ����ӵ�����
        int add = inventory[upper] - 1;
        // һ����ӵĸ���
        int numbers = n - upper;
        // ��Ҫ��Ӷ�����
        int rounds = remains / numbers;
        // ʣ�µĵ�����
        int single = remains % numbers;
        while (rounds > 0) {
            sum += add * numbers;
            add--;
            rounds--;
        }
        sum += single * add;
        return (int)(sum % mod);
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] inventory = new int[]{497978859,167261111,483575207,591815159};
        int orders = 836556809;
        System.out.println(maxProfit.maxProfit(inventory, orders));
    }
}
