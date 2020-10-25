package weekly_contest.week_212;

import java.util.HashMap;
import java.util.Map;

/**
 * 5546. ��������ʱ����ļ�
 * LeetCode �����һ����ʽ���̣����ڲ���������ԡ�������Ա������һϵ�м����ܼ� n ������ÿ��һ����
 *
 * ����һ������Ϊ n ���ַ��� keysPressed ������ keysPressed[i] ��ʾ���������е� i �������µļ���releaseTimes ��һ���������е��б����� releaseTimes[i] ��ʾ�ɿ��� i ������ʱ�䡣�ַ���������� �±궼�� 0 ��ʼ ���� 0 ������ʱ��Ϊ 0 ʱ�����£�������ÿ������ ǡ�� ��ǰһ�����ɿ�ʱ�����¡�
 *
 * ������Ա��Ҫ�ҳ����� ����ʱ��� �ļ����� i �ΰ����ĳ���ʱ��Ϊ releaseTimes[i] - releaseTimes[i - 1] ���� 0 �ΰ����ĳ���ʱ��Ϊ releaseTimes[0] ��
 *
 * ע�⣬�����ڼ䣬ͬһ���������ڲ�ͬʱ�̱���ΰ��£���ÿ�εĳ���ʱ�䶼���ܲ�ͬ��
 *
 * �뷵�ذ��� ����ʱ��� �ļ�������ж�������ļ����򷵻� ����ĸ˳��������� ���Ǹ�����
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺releaseTimes = [9,29,49,50], keysPressed = "cbcd"
 * �����"c"
 * ���ͣ�����˳��ͳ���ʱ�����£�
 * ���� 'c' ������ʱ�� 9��ʱ�� 0 ���£�ʱ�� 9 �ɿ���
 * ���� 'b' ������ʱ�� 29 - 9 = 20���ɿ���һ������ʱ�� 9 ���£�ʱ�� 29 �ɿ���
 * ���� 'c' ������ʱ�� 49 - 29 = 20���ɿ���һ������ʱ�� 29 ���£�ʱ�� 49 �ɿ���
 * ���� 'd' ������ʱ�� 50 - 49 = 1���ɿ���һ������ʱ�� 49 ���£�ʱ�� 50 �ɿ���
 * ��������ʱ����ļ��� 'b' �� 'c'���ڶ��ΰ���ʱ��������ʱ�䶼�� 20
 * 'c' ����ĸ˳�����б� 'b' �����Դ��� 'c'
 * ʾ�� 2��
 *
 * ���룺releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
 * �����"a"
 * ���ͣ�����˳��ͳ���ʱ�����£�
 * ���� 's' ������ʱ�� 12
 * ���� 'p' ������ʱ�� 23 - 12 = 11
 * ���� 'u' ������ʱ�� 36 - 23 = 13
 * ���� 'd' ������ʱ�� 46 - 36 = 10
 * ���� 'a' ������ʱ�� 62 - 46 = 16
 * ��������ʱ����ļ��� 'a' ������ʱ�� 16
 *
 *
 * ��ʾ��
 *
 * releaseTimes.length == n
 * keysPressed.length == n
 * 2 <= n <= 1000
 * 0 <= releaseTimes[i] <= 109
 * releaseTimes[i] < releaseTimes[i+1]
 * keysPressed ����СдӢ����ĸ���
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/25 10:35 ����
 */
public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] keys = keysPressed.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put(keys[0], releaseTimes[0]);

        for (int i = 1; i < keys.length; i++) {
            Integer time = map.getOrDefault(keys[i], 0);
            map.put(keys[i], Math.max(time, releaseTimes[i] - releaseTimes[i - 1]));
        }

        char res = 'a';
        int maxTime = 0;
        for (char key : map.keySet()) {
            Integer holdTime = map.get(key);
            if (holdTime > maxTime) {
                res = key;
                maxTime = holdTime;
            } else if (holdTime == maxTime) {
                res = res > key ? res : key;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SlowestKey key = new SlowestKey();
        System.out.println(key.slowestKey(new int[]{12,23,36,46,62}, "spuda"));
    }
}
