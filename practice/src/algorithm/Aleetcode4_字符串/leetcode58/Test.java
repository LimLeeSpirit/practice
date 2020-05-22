package algorithm.Aleetcode4_字符串.leetcode58;

public class Test {
    public static void main(String[] args) {
        // System.out.println(MyStack.lengthOfLastWord("dqw "));

        // 以空格切割
        String s1 = "dew qefdewrfr freqg gtrh yt hy";
        String[] words1 = s1.split("\\s+");

        // 以 . 切割
        String s2 = "dew.qefdewrfr.freqg.gtrh.yt.hy";
        String[] words2 = s2.split("\\.");

        // 以 * 切割
        String s3 = "dew*qefdewrfr*freqg*gtrh.yt.hy";
        String[] words3 = s3.split("\\*");

        // 以 " 切割
        String s4 = "dewqe\"fdewrfr\"freqg.gtrh.yt.hy";
        String[] words4 = s4.split("\\\"");
        //String[] words44 = s4.split("\"");

        // 以普通字符 '（f） 切割
        String s5 = "dew'qefdewrfr'freqg.gtrh.yt.hy";
        String[] words5 = s5.split("'");
        String[] words6 = s5.split("f");

        for(String s: words4) {
            System.out.println(s);
        }

    }
}
