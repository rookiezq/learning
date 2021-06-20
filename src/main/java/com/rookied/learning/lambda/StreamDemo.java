package com.rookied.learning.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhangqiang
 * @date 2021/4/23
 */
public class StreamDemo {

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "e"};
        Stream<String> arr1 = Stream.of(arr);

        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
        Stream<String> stream = strings.stream();

        Stream<Integer> generate = Stream.generate(() -> 1).limit(10);

        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1).limit(10);
        iterate.forEach(System.out::println);

        String str = "abcde";
        IntStream chars = str.chars();

        //打印所有偶数
        Stream.of(1, 2, 3, 4, 5).filter((x) -> x % 2 == 0).forEach(System.out::println);
        //求偶数的和
        int sum = Stream.of(1, 2, 3, 4, 5).filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        //求集合最大值 最小值
        Optional<Integer> max = Stream.of(1, 2, 3, 4, 5).max((a, b) -> a - b);
        Optional<Integer> min = Stream.of(1, 2, 3, 4, 5).sorted((a, b) -> a - b).findFirst();
        System.out.println(max.get());
        System.out.println(min.get());
        //findAny是终止操作,所以在找到第一个2后,就结束了,后面的都不遍历了
        Stream.of(1, 2, 3, 4, 5).filter(x -> {
            System.out.println("运行代码");
            return x % 2 == 0;
        }).findAny();
        //自然序,字典序
        Stream.of("java", "c#", "python", "scala").sorted().forEach(System.out::println);
        //元素长度排序
        Stream.of("java", "c#", "python", "scala").sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);
        Stream.of("java", "c#", "python", "scala").sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
        //去重
        Stream.of(1, 2, 3, 4, 5, 4, 5, 2, 3).distinct().forEach(System.out::println);
        //转为Set自动去重
        Stream.of(1, 2, 3, 4, 5, 4, 5, 2, 3).collect(Collectors.toSet()).forEach(System.out::println);
        //打印20-30这样的集合数据
        Stream.iterate(1, x -> x + 1).skip(20).limit(10).forEach(System.out::println);
        //字符串转数组求和
        Stream.of("11,22,33,44,55".split(",")).mapToInt(x-> Integer.parseInt(x)).sum();
        Stream.of("11,22,33,44,55".split(",")).mapToInt(Integer::parseInt).sum();
        //将str中的每一个数值都打印出来，同时算出最终的求和结果
        Stream.of("11,22,33,44,55".split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum();
    }
}
