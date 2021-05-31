package middle_level;

/**
 * 165. �Ƚϰ汾��
 * ���������汾�� version1 �� version2 ������Ƚ����ǡ�
 * <p>
 * �汾����һ�������޶�����ɣ����޶�����һ�� '.' ���ӡ�ÿ���޶����� ��λ���� ��ɣ����ܰ��� ǰ���� ��ÿ���汾�����ٰ���һ���ַ����޶��Ŵ����ұ�ţ��±�� 0 ��ʼ������ߵ��޶����±�Ϊ 0 ����һ���޶����±�Ϊ 1 ���Դ����ơ����磬2.5.33 �� 0.1 ������Ч�İ汾�š�
 * <p>
 * �Ƚϰ汾��ʱ���밴�����ҵ�˳�����αȽ����ǵ��޶��š��Ƚ��޶���ʱ��ֻ��Ƚ� �����κ�ǰ����������ֵ ��Ҳ����˵���޶��� 1 ���޶��� 001 ��� ������汾��û��ָ��ĳ���±괦���޶��ţ�����޶�����Ϊ 0 �����磬�汾 1.0 С�ڰ汾 1.1 ����Ϊ�����±�Ϊ 0 ���޶�����ͬ�����±�Ϊ 1 ���޶��ŷֱ�Ϊ 0 �� 1 ��0 < 1 ��
 * <p>
 * ���ع������£�
 * <p>
 * ���version1>version2����1��
 * ���version1<version2 ���� -1��
 * ����֮�ⷵ�� 0��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺version1 = "1.01", version2 = "1.001"
 * �����0
 * ���ͣ�����ǰ���㣬"01" �� "001" ����ʾ��ͬ������ "1"
 * ʾ�� 2��
 * <p>
 * ���룺version1 = "1.0", version2 = "1.0.0"
 * �����0
 * ���ͣ�version1 û��ָ���±�Ϊ 2 ���޶��ţ�����Ϊ "0"
 * ʾ�� 3��
 * <p>
 * ���룺version1 = "0.1", version2 = "1.1"
 * �����-1
 * ���ͣ�version1 ���±�Ϊ 0 ���޶����� "0"��version2 ���±�Ϊ 0 ���޶����� "1" ��0 < 1������ version1 < version2
 * ʾ�� 4��
 * <p>
 * ���룺version1 = "1.0.1", version2 = "1"
 * �����1
 * ʾ�� 5��
 * <p>
 * ���룺version1 = "7.5.2.4", version2 = "7.5.3"
 * �����-1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/31 09:25
 */
public class CompareVersion {
    /**
     * �Լ�������
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion_own(String version1, String version2) {
        // ע��!!!!! ��.����split��ʱ��Ҫ����ת��� \\
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int len = Math.min(strs1.length, strs2.length);
        for (int i = 0; i < len; i++) {
            int v1 = Integer.valueOf(strs1[i]);
            int v2 = Integer.valueOf(strs2[i]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        if (strs1.length > len) {
            // Ѱ�ҷ�0
            for (int i = len; i < strs1.length; i++) {
                int v = Integer.valueOf(strs1[i]);
                if (v != 0) {
                    return 1;
                }
            }
        }
        if (strs2.length > len) {
            // Ѱ�ҷ�0
            for (int i = len; i < strs2.length; i++) {
                int v = Integer.valueOf(strs2[i]);
                if (v != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        // compare versions
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // the versions are equal
        return 0;
    }

    public static void main(String[] args) {
        CompareVersion v = new CompareVersion();
        System.out.println(v.compareVersion("0.1", "1.1"));
    }
}
