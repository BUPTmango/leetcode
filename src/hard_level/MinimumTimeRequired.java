package hard_level;

import java.util.Arrays;

/**
 * 1723. ������й��������ʱ��
 * ����һ���������� jobs ������ jobs[i] ����ɵ� i ���Ҫ���ѵ�ʱ�䡣
 * ���㽫��Щ��������� k λ���ˡ����й�����Ӧ�÷�������ˣ���ÿ���ֻ�ܷ����һλ���ˡ����˵� ����ʱ�� ����ɷ�������ǵ����й�������ʱ����ܺ͡��������һ����ѵĹ������䷽����ʹ���˵� �����ʱ�� ���� ��С�� ��
 * ���ط��䷽���о����� ��С �� �����ʱ�� ��
 *
 * ʾ�� 1��
 *
 * ���룺jobs = [3,2,3], k = 3
 * �����3
 * ���ͣ���ÿλ���˷���һ����������ʱ���� 3 ��
 * ʾ�� 2��
 *
 * ���룺jobs = [1,2,4,7,8], k = 2
 * �����11
 * ���ͣ���������ʽ���乤����
 * 1 �Ź��ˣ�1��2��8������ʱ�� = 1 + 2 + 8 = 11��
 * 2 �Ź��ˣ�4��7������ʱ�� = 4 + 7 = 11��
 * �����ʱ���� 11 ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/8 09:24
 */
public class MinimumTimeRequired {
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int left = jobs[jobs.length - 1], right = Arrays.stream(jobs).sum() + 1;
        // Ѱ����߽�
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(jobs, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] jobs, int k, int limit) {
        int[] workloads = new int[k];
        return backtrack(jobs, workloads, 0, limit);
    }

    private boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
        if (i >= jobs.length) {
            return true;
        }
        int cur = jobs[i];
        for (int j = 0; j < workloads.length; ++j) {
            if (workloads[j] + cur <= limit) {
                workloads[j] += cur;
                if (backtrack(jobs, workloads, i + 1, limit)) {
                    return true;
                }
                workloads[j] -= cur;
            }
            // �����ǰ����δ�����乤������ô��һ������Ҳ��Ȼδ�����乤��
            // ���ߵ�ǰ����ǡ��ʹ�ù��˵Ĺ������ﵽ������
            // ������������������賢�Լ������乤��
            if (workloads[j] == 0 || workloads[j] + cur == limit) {
                break;
            }
        }
        return false;
    }
}
