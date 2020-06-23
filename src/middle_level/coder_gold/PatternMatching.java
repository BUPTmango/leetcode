package middle_level.coder_gold;

/**
 * 面试题 16.18. 模式匹配
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 示例 1：
 *
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * 示例 2：
 *
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * 示例 3：
 *
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * 示例 4：
 *
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/23 4:10 下午
 */
public class PatternMatching {
    public boolean patternMatching(String pattern, String value) {
        String s[]=new String[2];
        return solve(s,pattern,0,value,0);
    }
    /**
     * 回溯遍历设置a,b的对应值，尝试每一种可能。
     * @param s   s[0]=a对应的字符串 s[1]=b对应的字符串
     * @param pattern 模式串
     * @param index1 模式串匹配位置
     * @param value 匹配串（待匹配的字符串）
     * @param index2 匹配串匹配位置
     * @return
     */
    public boolean solve(String []s,String pattern,int index1,String value,int index2){
        //匹配完成
        if(index1==pattern.length()&&index2==value.length()) return true;
        //注意匹配串匹配位置等于长度的时候也可以继续匹配，因为模式串的a，b可以匹配空串。
        if(index1>=pattern.length()||index2>value.length()) return false;
        int num=pattern.charAt(index1)-'a';
        if(s[num]==null){
            //从当前尝试a或b对应的字符串的每一种可能
            for(int i=index2;i<=value.length();i++){
                s[num]=value.substring(index2,i);
                //(!s[num].equals(s[num^1]))  [是指a，b对应的字符串不可相等]
                if(!s[num].equals(s[num^1])&&solve(s,pattern,index1+1,value,i)) return true;
            }
            //失配时应将设置过的对应字符串为空
            s[num]=null;
            return false;
        }else{
            //若此前a或b已有对应的字符串匹配了，则查看当前位置时候能够匹配上。
            int end=index2+s[num].length();
            if(end> value.length()||!value.substring(index2,end).equals(s[num])) return false;
            return solve(s,pattern,index1+1,value,end);
        }
    }
}
