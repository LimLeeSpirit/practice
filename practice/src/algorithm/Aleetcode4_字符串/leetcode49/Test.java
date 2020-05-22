package algorithm.Aleetcode4_字符串.leetcode49;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> re = Solution.groupAnagrams2(strs);
        for(List<String> l: re) {
            for(String s : l) {
                System.out.print(s+ " ");
            }
            System.out.println("----------");
        }
        System.out.println(strs.length);
    }
}
