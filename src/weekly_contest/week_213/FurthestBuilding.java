package weekly_contest.week_213;

/**
 * 5556. ���Ե������Զ����
 * ����һ���������� heights ����ʾ������ĸ߶ȡ�����һЩש�� bricks ������ ladders ��
 * <p>
 * ��ӽ����� 0 ��ʼ�ọ́����������Ľ������ƶ����ڼ���ܻ��õ�ש������ӡ�
 * <p>
 * ���ӽ����� i �ƶ��������� i+1���±� �� 0 ��ʼ ��ʱ��
 * <p>
 * �����ǰ������ĸ߶� ���ڻ���� ��һ������ĸ߶ȣ�����Ҫ���ӻ�ש��
 * �����ǰ�����ĸ߶� С�� ��һ�������ĸ߶ȣ�������ʹ�� һ������ �� (h[i+1] - h[i]) ��ש��
 * �������ѷ�ʽʹ�ø��������Ӻ�ש�飬��������Ե������Զ��������±꣨�±� �� 0 ��ʼ ����
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * �����4
 * ���ͣ��ӽ����� 0 ����������԰��˷�������ọ́�
 * - ��ʹ��ש������ӵ��ｨ���� 1 ����Ϊ 4 >= 2
 * - ʹ�� 5 ��ש�鵽�ｨ���� 2 �������ʹ��ש������ӣ���Ϊ 2 < 7
 * - ��ʹ��ש������ӵ��ｨ���� 3 ����Ϊ 7 >= 6
 * - ʹ��Ψһ�����ӵ��ｨ���� 4 �������ʹ��ש������ӣ���Ϊ 6 < 9
 * �޷�Խ�������� 4 ����Ϊû�и���ש������ӡ�
 * ʾ�� 2��
 * <p>
 * ���룺heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * �����7
 * ʾ�� 3��
 * <p>
 * ���룺heights = [14,3,19,3], bricks = 17, ladders = 0
 * �����3
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= heights.length <= 105
 * 1 <= heights[i] <= 106
 * 0 <= bricks <= 109
 * 0 <= ladders <= heights.length
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/1 11:44 ����
 */
public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        return backtrack(heights, bricks, ladders, 1);
    }

    private int backtrack(int[] heights, int bricksRemain, int laddersRemain, int index) {
        // �ߵ������
        if (index == heights.length - 1) {
            return index;
        }
        // שͷ�����Ӷ�������
        if (bricksRemain <= 0 && laddersRemain <= 0) {
            return index - 1;
        }

        int pre = heights[index - 1];
        int cur = heights[index];
        if (cur <= pre) {
            return backtrack(heights, bricksRemain, laddersRemain, index + 1);
        }
        // ʹ��שͷ
        int brickWay = 0;
        if (bricksRemain - (cur - pre) >= 0) {
            brickWay = backtrack(heights, bricksRemain - (cur - pre), laddersRemain, index + 1);
        }
        // ʹ������
        int ladderWay = 0;
        if (laddersRemain > 0) {
            ladderWay = backtrack(heights, bricksRemain, laddersRemain - 1, index + 1);
        }
        return Math.max(brickWay, ladderWay);
    }

    public static void main(String[] args) {
        FurthestBuilding building = new FurthestBuilding();
        int[] heights = new int[]{4,12,2,7,3,18,20,3,19};
        System.out.println(building.furthestBuilding(heights, 10, 2));
    }
}
