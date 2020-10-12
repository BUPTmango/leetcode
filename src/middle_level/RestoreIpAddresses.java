package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨
 * 93. ��ԭIP��ַ
 * ����һ��ֻ�������ֵ��ַ�������ԭ�����������п��ܵ� IP ��ַ��ʽ��
 *
 * ��Ч�� IP ��ַ �������ĸ�������ÿ������λ�� 0 �� 255 ֮����ɣ��Ҳ��ܺ���ǰ�� 0��������֮���� '.' �ָ���
 *
 * ���磺"0.1.2.201" �� "192.168.1.1" �� ��Ч�� IP ��ַ������ "0.011.255.245"��"192.168.1.312" �� "192.168@1.1" �� ��Ч�� IP ��ַ��
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "25525511135"
 * �����["255.255.11.135","255.255.111.35"]
 * ʾ�� 2��
 *
 * ���룺s = "0000"
 * �����["0.0.0.0"]
 * ʾ�� 3��
 *
 * ���룺s = "1111"
 * �����["1.1.1.1"]
 * ʾ�� 4��
 *
 * ���룺s = "010010"
 * �����["0.10.0.10","0.100.1.0"]
 * ʾ�� 5��
 *
 * ���룺s = "101023"
 * �����["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * ��ʾ��
 *
 * 0 <= s.length <= 3000
 * s �����������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/11 8:17 ����
 */
public class RestoreIpAddresses {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    /**
     * ��segStart��ʼ ����ip��ַ�еĵ�segId��
     * @param s
     * @param segId
     * @param segStart
     */
    public void dfs(String s, int segId, int segStart) {
        // ����ҵ��� 4 �� IP ��ַ���ұ��������ַ�������ô����һ�ִ�
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            // ע�⣡���� ��ֹ��������return
            return;
        }

        // �����û���ҵ� 4 �� IP ��ַ���Ѿ����������ַ�������ô��ǰ����
        if (segStart == s.length()) {
            // ע�⣡���� ��ֹ��������return
            return;
        }

        // ���ڲ�����ǰ���㣬�����ǰ����Ϊ 0����ô��һ�� IP ��ַֻ��Ϊ 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // һ�������ö��ÿһ�ֿ����Բ��ݹ�
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                // ע�⣡���� �ǵ��ȱ��棬�ٻ���
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
