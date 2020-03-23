package simple_level.coder_gold;

/**
 * 面试题 10.05. 稀疏数组搜索
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 * 示例2:
 *
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 * 提示:
 *
 * words的长度在[1, 1000000]之间
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/23 10:33 下午
 */
public class FindString {
    public int findString(String[] words, String s) {
        return findString_sub(words,s,0,words.length-1);
    }

    public static int findString_sub(String[] words, String s, int left, int right) {
        while(left<right){
            int middle=(left+right)/2;

            if(words[middle].equals("")){
                int leftIndex=findString_sub(words, s, left, middle - 1);
                return leftIndex!=-1?leftIndex:findString_sub(words, s, middle+1, right);
            }

            if(words[middle].equals(s)){
                return middle;
            }else if(words[middle].compareTo(s)>0){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        return words[left].equals(s)?left:-1;

    }
}
