package middle_level;

/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨 ��άƽ��
 * 79. ��������
 * ����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�
 * <p>
 * ���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
 * <p>
 * ʾ��:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * ���� word = "ABCCED", ���� true
 * ���� word = "SEE", ���� true
 * ���� word = "ABCB", ���� false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/13 10:50 ����
 */
public class Exist {
    /**
     * DFS
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // Խ����ߵ�ǰ����Ԫ�غ�Ŀ�겻ͬ
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        // �ַ����Ѿ�ȫ��ƥ��
        if(k == word.length - 1) {
            return true;
        }
        // ��¼��ǰ����Ԫ��
        char tmp = board[i][j];
        // �޸�Ϊ/ ��ʾ�Ѿ����ʹ�
        board[i][j] = '/';
        // �����������ĸ��������ݹ�
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        // ��ԭ����Ԫ��
        board[i][j] = tmp;
        return res;
    }
}
