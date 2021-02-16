package dataStructures.test;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        //split 中多分割出的"",会被忽略，不会计入结果中
        String t = "1,2,3,,";
        String[] split = t.split(",");
        System.out.println(Arrays.toString(split));
        System.out.println(split.length);
    }
}
