package lambda;

import entity.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 学习lambda的简单使用
 *
 * @author Wang Guolong
 * @create 2019-03-28 2:00 PM
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<String> stringList  = new ArrayList<>();
        stringList.add("QEWRWFfdgfsgsd");
        stringList.add("AA");
        stringList.add("dfd");
        stringList.forEach(System.out::println);
        //将原来list中的所有元素变成小写
        List<String> newList = stringList.stream()
                .map(s -> s.toLowerCase()).collect(Collectors.toList());//当lambda表达式只包含一条语句时，可以省略大括号、return和语句结尾的分号
        //s -> s.toLowerCase() 这是单语句的写法
        newList.forEach(System.out::println);
        //对于方法的调用 Class or instance :: method
        Student stu1 = new Student("uf081271", "wgl", "BUPT", 50);
        Student stu2 = new Student("uf081272", "ggg", "BFSU", 60);
        Student stu3 = new Student("uf081273", "eee", "BJTU", 54);
        List<Student> students = new ArrayList<>();
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        List<String> introductions = students.stream().map(Student::introduction).collect(Collectors.toList());
        //lambda foreach用法
        introductions.forEach(System.out::println);
        introductions.forEach(introduction -> System.out.println("hahaha : " + introduction));
        //stream
        //大家可以把Stream当成一个装饰后的Iterator。
        // 原始版本的Iterator，用户只能逐个遍历元素并对其执行某些操作；
        // 包装后的Stream，用户只要给出需要对其包含的元素执行什么操作，
        // 比如“过滤掉长度大于10的字符串”、“获取每个字符串的首字母”等，
        // 具体这些操作如何应用到每个元素上，就给Stream就好了！
        // 原先是人告诉计算机一步一步怎么做，现在是告诉计算机做什么，计算机自己决定怎么做。
        // 当然这个“怎么做”还是比较弱的。
        //nums.stream().filter(num -> num != null).count();
        //      创建stream 转换stream         聚合
        System.out.println(students.stream().filter(student -> student.getName().equals("wgl")).count());
        //获取对象属性到新的集合
        List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());
        names.forEach(System.out::println);
        //新建线程 使用匿名内部类
        new Thread(() -> System.out.println("thread haha")).start();
        Runnable runTest = () -> System.out.println("runnable haha");
        runTest.run();
        //进行排序
        students.sort((Student s1, Student s2) -> (s1.getSchool().compareTo(s2.getSchool())));
        students.forEach(student -> System.out.println(student));
        //filter
        //遍历体重大于52的学生
        System.out.println("weight >= 52 : ");
        students.stream().filter(stu -> stu.getWeight() >= 52).forEach(System.out::println);
        //每人增重5公斤
        students.stream().forEach(student -> student.setWeight(student.getWeight() + 5));
        System.out.println("after add weight : ");
        students.forEach(System.out::println);
        //limit
        List<Student> limitStudents = students.stream().limit(2).collect(Collectors.toList());
        System.out.println("limit 2 : ");
        limitStudents.forEach(System.out::println);
        //按体重排序 并打印
        System.out.println("sorted by weight");
        students.stream().sorted(Comparator.comparing(Student::getWeight)).collect(Collectors.toList()).forEach(System.out::println);
        //得到体重最低的学生
        System.out.println("min weight : ");
        Student minWeight = students.stream().min(Comparator.comparing(Student::getWeight)).get();
        System.out.println(minWeight);
        //将结果收集到string或者set中
        String schools = students.stream().map(Student::getSchool).collect(Collectors.joining(";"));
        System.out.println("schools : " + schools);
        Set<String> nameSet = students.stream().map(Student::getName).collect(Collectors.toSet());
        nameSet.forEach(System.out::println);
        //计算总体重
        int weight_sum = students.stream().mapToInt(Student::getWeight).sum();
        System.out.println("total weight : " + weight_sum);
    }
}