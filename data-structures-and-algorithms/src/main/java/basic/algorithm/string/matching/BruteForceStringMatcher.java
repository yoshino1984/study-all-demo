package basic.algorithm.string.matching;

/**
 * BF算法 暴力匹配
 * 时间复杂度 O(N*M)
 * @author wangxin
 * 2020/5/10 16:06
 * @since
 **/
public class BruteForceStringMatcher {

    /**
     * 字符串匹配
     * @param s1 主串
     * @param s2 匹配串
     * @return
     */
    private static boolean match(String s1, String s2) {
        for (int i = 0; i <= (s1.length() - s2.length()); i++) {
            if (s1.substring(i, i + s2.length()).endsWith(s2)) {
                return true;
            }
        }
        return false;
    }

}
