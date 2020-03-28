package simple_level.coder_gold;

/**
 * ������ 08.10. ��ɫ���
 * ��ɫ��䡣��д������ʵ�����ͼƬ�༭�����֧�ֵġ���ɫ��䡱���ܡ�����һ����Ļ���Զ�ά�����ʾ��Ԫ��Ϊ��ɫֵ����һ�����һ���µ���ɫֵ��������ɫֵ������������Χ����ֱ��ԭ������ɫֵȫ���ı䡣
 *
 * ʾ��1:
 *
 *  ���룺
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 *  �����[[2,2,2],[2,2,0],[2,0,1]]
 *  ����:
 * ��ͼ������м䣬(����(sr,sc)=(1,1)),
 * ��·�������з������������ص����ɫ�������ĳ�2��
 * ע�⣬���½ǵ�����û�и���Ϊ2��
 * ��Ϊ�����������������ĸ����������ʼ�����������ص㡣
 * ˵����
 *
 * image ��?image[0]?�ĳ����ڷ�Χ?[1, 50] �ڡ�
 * �����ĳ�ʼ�㽫����?0 <= sr < image.length ��?0 <= sc < image[0].length��
 * image[i][j] ��?newColor?��ʾ����ɫֵ�ڷ�Χ?[0, 65535]�ڡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/28 10:05 ����
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) {
                dfs(image, r-1, c, color, newColor);
            }
            if (c >= 1) {
                dfs(image, r, c-1, color, newColor);
            }
            if (r+1 < image.length) {
                dfs(image, r+1, c, color, newColor);
            }
            if (c+1 < image[0].length) {
                dfs(image, r, c+1, color, newColor);
            }
        }
    }
}
