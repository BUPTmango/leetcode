package interview;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 酷家乐一面
 *
 * 我们来模拟一下高铁乘车的行为，假设这趟高铁只有一个车厢，售票50张。
 *  需求： 1. 我们有一个文件A存放了已经买票了的乘客，文件里的格式是：
 * 张三 3100001990****0011
 * 李四 3200001988****2222
 * 文件有两列，第一列是乘客名字，第二列是身份证号。
 *
 * 2. 我们有一个文件B存放已经检票的乘客，文件格式和文件A一致，用于做检票记录。
 *
 * 3. 我们有一个检票器，是直接刷身份证： 输入：checkin <身份证号> 如：checkin 3100001990****0011
 * 输出：成功或者失败原因 与此同时，需要在文件B中增加一条检票记录
 * PS：自己考虑和定义可能的失败原因。
 *
 * 4. 买票功能 输入：buy <名字> <身份证号> 如：buy 张三 3100001990****0011
 * 输出：成功或者失败原因。
 *
 * 5. 退票功能 输入：refund <身份证号> 如：refund 3100001990****0011
 * 输出：成功或者失败原因
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/3/26 5:09 下午
 */
public class TicketService {
    /**
     * key 为身份证号    value为姓名
     */
    private static Map<String, String> buyMap = new ConcurrentHashMap<>();
    private static Map<String, String> checkInMap = new ConcurrentHashMap<>();

    public static void checkIn(String id) {
        if (buyMap.containsKey(id)) {
            // 检票成功
            checkInMap.put(id, buyMap.get(id));
            System.out.println("检票成功");
        } else {
            System.out.println("您未购买车票，无法检票");
        }
    }

    public static void buy(String name, String id) {
        if (!buyMap.containsKey(id)) {
            buyMap.put(id, name);
            System.out.println("购票成功");
        } else {
            System.out.println("您已经购买过车票，无需重复购买");
        }
    }

    public static void refund(String id) {
        if (checkInMap.containsKey(id)) {
            System.out.println("您已经检票，无法退票，请联系工作人员处理");
            return;
        }
        if (buyMap.containsKey(id)) {
            // 退票
            buyMap.remove(id);
            System.out.println("退票成功");
        } else {
            System.out.println("您尚未购票，无法办理退票业务");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            switch (strs[0]) {
                case "buy":
                    if (strs.length != 3) {
                        System.out.println("参数错误，输入：buy <名字> <身份证号>");
                    } else {
                        buy(strs[1], strs[2]);
                    }
                    break;
                case "checkin":
                    if (strs.length != 2) {
                        System.out.println("参数错误, 输入：checkin <身份证号> ");
                    } else {
                        checkIn(strs[1]);
                    }
                    break;
                case "refund":
                    if (strs.length != 2) {
                        System.out.println("参数错误, 输入：refund <身份证号> ");
                    } else {
                        refund(strs[1]);
                    }
                    break;
                default:
                    System.out.println("操作错误，请输入buy，checkin，refund等操作");
            }
        }
    }
}
