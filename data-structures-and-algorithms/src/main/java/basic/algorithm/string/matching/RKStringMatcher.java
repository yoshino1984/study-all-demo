package basic.algorithm.string.matching;

import com.google.common.math.IntMath;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * RK算法 Rabin-Karp算法
 *
 * @author wangxin
 * 2020/5/10 16:09
 * @since
 **/
public class RKStringMatcher {

    private static int primeNumber = 0;
    private static char[] chars = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static Map<Character, Integer> charMap = new HashMap<>();

    static {
        init();
    }
    static void init() {
        for (char item : chars) {
            charMap.put(item, getNestPrime());
        }
    }

    /**
     * RK算法，使用哈希算法对对每个字符进行编码，对结果进行相加，直接对比主串和匹配串的hash值，
     * 如果不相等：则直接匹配下一个主串中的子串，相邻子串的有 m - 1 的字符都是匹配的，可以减少冲突
     * 如果相等：因为可能会有hash冲突问题，需要重新对比原字符串
     * @param s1 主串
     * @param s2 匹配串
     * @return
     */
    private static boolean match(String s1, String s2) {
        int s2Sum = 0;
        for (char item : s2.toCharArray()) {
            s2Sum += charMap.get(item);
        }

        int hashSum = 0;
        for (int i = 0; i <= (s1.length() - s2.length()); i++) {
            // 计算字符串的哈希值
            hashSum = getCurHash(s1, s2, hashSum, i);
            if (hashSum == s2Sum && isEqual(s1, s2, i)) {
                return true;
            }
        }
        return false;
    }

    private static int getCurHash(String s1, String s2, int lastSum, int i) {
        if (i == 0) {
            for (int j = 0; j < s2.length(); j++) {
                lastSum += charMap.get(s1.charAt(j));
            }
        } else {
            lastSum = lastSum - charMap.get(s1.charAt(i - 1)) + charMap.get(s1.charAt(i + s2.length() - 1));
        }
        return lastSum;
    }

    private static boolean isEqual(String s1, String s2, int i) {
        return s1.substring(i, i + s2.length()).endsWith(s2);
    }

    private static int getNestPrime() {
        while (true) {
            if (IntMath.isPrime(++primeNumber)) {
                break;
            }
        }
        return primeNumber;
    }

    public static void main(String[] args) {
//        System.out.println(match("s1", "1"));
//        System.out.println(match("s1", ""));
        System.out.println(match("s1dfsdferwedfsfddjvhsfeooruwe", "fddj"));
        System.out.println(match("s1dfsdferwedfsfddjvhsfeooruwe", "fddi"));
        System.out.println(match("s1dfsdferwedfsfddjvhsfeooruwe", "oo"));
    }

}
