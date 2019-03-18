package effectivejava.third.chapter7.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sorting with function objects (Pages 193-4)
 * 使用函数对象排序
 */
public class SortFourWays {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(args);

        // Anonymous class instance as a function object - obsolete! (Page 193)
        // 匿名类实例作为函数对象 - 已过时！
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println(words);
        Collections.shuffle(words);

        // Lambda expression as function object (replaces anonymous class) (Page 194)
        // Lambda表达式作为函数对象（替换匿名类）
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(words);
        Collections.shuffle(words);

        // Comparator construction method (with method reference) in place of lambda (Page 194)
        // 比较器构造方法（使用方法引用）代替lambda
        Collections.sort(words, Comparator.comparingInt(String::length));
        System.out.println(words);
        Collections.shuffle(words);

        // Default method List.sort in conjunction with comparator construction method (Page 194)
        // 默认方法List.sort与比较器构造方法一起使用
        words.sort(Comparator.comparingInt(String::length));
        System.out.println(words);
    }
}
