package middle_level;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. ��������ؽ�����
 *
 * �����д���˳���һȺ��վ��һ�����С� ÿ������һ��������(h, k)��ʾ������h������˵���ߣ�k�����������ǰ������ߴ��ڻ����h�������� ��дһ���㷨���ؽ�������С�
 *
 * ע�⣺
 * ����������1100�ˡ�
 *
 ����:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 ���:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/16 9:04 ����
 */
public class ReconstructQueue {
    /**
     * �㷨��
     * ����
     * ���߶Ƚ������С�
     * ��ͬһ�߶ȵ����У��� k ֵ���������С�
     * ����ذ����Ƿ�����������У������������ǵ� k ֵ��
     * �����������
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            // if the heights are equal, compare k-values
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });

        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);

    }
}
