package middle_level;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 649. Dota2 ����Ժ
 * Dota2 ����������������Ӫ��Radiant(���)��Dire(ҹ��)
 *
 * Dota2 ����Ժ���������ɵĲ���Ա��ɡ����ڲ���Ժϣ����һ�� Dota2 ��Ϸ��ĸı�����������������һ��������Ϊ���̵�ͶƱ���С���ÿһ���У�ÿһλ����Ա��������ʹ����Ȩ���е�һ�
 *
 * ��ֹһ������Ա��Ȩ����
 *
 * ����Ա��������һλ����Ա����һ�ֺ����ļ�����ɥʧ���е�Ȩ����
 *
 * ����ʤ����
 *
 *      �������Ա������Ȩ��ͶƱ�Ĳ���Ա����ͬһ����Ӫ�ģ�����������ʤ������������Ϸ�е��йر仯��
 *
 * ����һ���ַ�������ÿ������Ա����Ӫ����ĸ ��R�� �� ��D�� �ֱ������Radiant����ԣ���Dire��ҹ�ʣ���Ȼ������� n ������Ա�������ַ����Ĵ�С����n��
 *
 * ����Ϊ�����Ĺ��̴Ӹ���˳��ĵ�һ������Ա��ʼ�����һ������Ա��������һ���̽�������ͶƱ����������ʧȥȨ���Ĳ���Ա���ڹ����б�������
 *
 * ����ÿһλ����Ա���㹻��������Ϊ�Լ�������������õĲ��ԣ�����ҪԤ����һ�����ջ�����ʤ������ Dota2 ��Ϸ�о����ı䡣���Ӧ����Radiant��Dire��
 *
 * ʾ�� 1��
 *
 * ���룺"RD"
 * �����"Radiant"
 * ���ͣ���һ������Ա���� Radiant ��Ӫ����������ʹ�õ�һ��Ȩ���õڶ�������ԱʧȥȨ������˵ڶ�������Ա����������Ϊ��û���κ�Ȩ����Ȼ���ڵڶ��ֵ�ʱ�򣬵�һ������Ա��������ʤ������Ϊ����Ψһһ����ͶƱȨ����
 * ʾ�� 2��
 *
 * ���룺"RDD"
 * �����"Dire"
 * ���ͣ�
 * ��һ����,��һ������ Radiant ��Ӫ�Ĳ���Ա����ʹ�õ�һ��Ȩ����ֹ�ڶ�������Ա��Ȩ��
 * �ڶ������� Dire ��Ӫ�Ĳ���Ա�ᱻ������Ϊ����Ȩ������ֹ
 * ���������� Dire ��Ӫ�Ĳ���Ա����ʹ�����ĵ�һ��Ȩ����ֹ��һ������Ա��Ȩ��
 * ����ڵڶ���ֻʣ�µ���������Աӵ��ͶƱ��Ȩ��,��������������ʤ��
 * 
 * ��ʾ��
 *
 * �����ַ����ĳ����� [1, 10,000] ֮��.
 * 
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/11 9:10 ����
 */
public class PredictPartyVictory {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        // ʹ���������� radiant �� dire �ֱ���ͶƱ˳��洢��Է���ҹ�ʷ�ÿһ����Ա��ͶƱʱ��
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        // Ӧ��̰�ĵ���ѡ����ͶƱ˳�����һ���Է�����Ա
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
}
