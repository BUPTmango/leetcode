package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. ������ĸ����
 * �ַ��� S ��Сд��ĸ��ɡ�����Ҫ������ַ�������Ϊ�����ܶ��Ƭ�Σ�ͬһ����ĸֻ����������е�һ��Ƭ�Ρ�����һ����ʾÿ���ַ���Ƭ�εĳ��ȵ��б�
 *
 * ʾ�� 1��
 *
 * ���룺S = "ababcbacadefegdehijhklij"
 * �����[9,7,8]
 * ���ͣ�
 * ���ֽ��Ϊ "ababcbaca", "defegde", "hijhklij"��
 * ÿ����ĸ��������һ��Ƭ���С�
 * �� "ababcbacadefegde", "hijhklij" �Ļ����Ǵ���ģ���Ϊ���ֵ�Ƭ�������١�
 *
 * ��ʾ��
 *
 * S�ĳ�����[1, 500]֮�䡣
 * Sֻ����Сд��ĸ 'a' �� 'z' ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/22 9:15 ����
 */
public class PartitionLabels {
    /**
     * ̰���㷨 + ˫ָ��
     *
     * ʹ��̰�ĵ�˼��Ѱ��ÿ��Ƭ�ο��ܵ���С�����±꣬��˿��Ա�֤ÿ��Ƭ�εĳ���һ���Ƿ���Ҫ�����̳��ȣ�
     * ���ȡ���̵�Ƭ�Σ���һ�������ͬһ����ĸ�����ڶ��Ƭ���е������
     * ����ÿ��ȡ��Ƭ�ζ��Ƿ���Ҫ�����̵�Ƭ�Σ���˵õ���Ƭ����Ҳ�����ġ�
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        // ����ͬһ����ĸֻ�ܳ�����ͬһ��Ƭ�Σ���Ȼͬһ����ĸ�ĵ�һ�γ��ֵ��±�λ�ú����һ�γ��ֵ��±�λ�ñ��������ͬһ��Ƭ�Ρ�
        int[] last = new int[26];
        int length = S.length();
        // ��Ҫ�����ַ������õ�ÿ����ĸ���һ�γ��ֵ��±�λ�á�
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            // ����ÿ�����ʵ�����ĸ c���õ���ǰ��ĸ�����һ�γ��ֵ��±�λ��endc����ǰƬ�εĽ����±�һ������С��endc�� ����ȡmax
            end = Math.max(end, last[S.charAt(i) - 'a']);
            // �����ʵ��±� end ʱ����ǰƬ�η��ʽ�������ǰƬ�ε��±귶Χ��[start,end]
            if (i == end) {
                partition.add(end - start + 1);
                // ����Ѱ����һ��Ƭ��
                start = end + 1;
            }
        }
        return partition;
    }
}
