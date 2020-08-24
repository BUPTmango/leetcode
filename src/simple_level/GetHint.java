package simple_level;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 299. 猜数字游戏
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 *
 * 你写出一个秘密数字，并请朋友猜这个数字是多少。
 * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 朋友根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用?B?表示奶牛。
 *
 * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
 *
 * ?
 *
 * 示例 1:
 *
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 1?公牛和?3?奶牛。公牛是 8，奶牛是 0, 1?和 7。
 * 示例 2:
 *
 * 输入: secret = "1123", guess = "0111"
 * 输出: "1A1B"
 * 解释: 朋友猜测数中的第一个 1?是公牛，第二个或第三个 1?可被视为奶牛。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/24 9:34 上午
 */
public class GetHint {
    public String getHint(String secret, String guess) {
        int aCount = 0;
        int bCount = 0;
        ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        // 先遍历一次字符串，如果两个字符串当前索引字符相同，则将"公牛数"加一；否则，将秘密字符串的字符放入HashMap中，进行次数统计，将猜的字符放入一个Array中。
        for (int i = 0; i < secret.length(); i++) {
            char temp = secret.charAt(i);
            if (temp == guess.charAt(i)) {
                aCount++;
            } else {
                list.add(guess.charAt(i));
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        // 第一次遍历完毕后进行第二次遍历，此时的array中是猜的字符串中没有对上号的字符，依次获取array中的字符，看HashMap中是否有该字符，
        // 如果有，则让"母牛数"加一，然后将该字符的次数减一，如果该字符在Map中的次数为零则清除。
        for (Character c : list) {
            if (map.containsKey(c)) {
                bCount++;
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        return aCount + "A" + bCount + "B";
    }
}
