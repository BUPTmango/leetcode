package middle_level.jianzhi_offer;

/**
 *
 * ��ָ Offer 12. �����е�·��
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ��ʼ��ÿһ�������ھ����������ҡ��ϡ����ƶ�һ�����һ��·�������˾����ĳһ����ô��·�������ٴν���ø��ӡ����磬�������3��4�ľ����а���һ���ַ�����bfce����·����·���е���ĸ�üӴֱ������
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * �������в������ַ�����abfb����·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���������ӡ�
 *
 * ʾ�� 1��
 *
 * ���룺board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * �����true
 * ʾ�� 2��
 *
 * ���룺board = [["a","b"],["c","d"]], word = "abcd"
 * �����false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/29 4:14 ����
 */
public class Exist {
    /**
     * DFS
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                // ע�⣡���� board����ʹ��ȫ�ֱ��� Ҫͨ������������
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
