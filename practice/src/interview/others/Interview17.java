package interview.others;


import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 最大的考试分数
 * 输入例子2:
 *
 * 3 3  // 分别是 班级人数 和 选择题题数，注意每个题的答案都是不相干的，所以考虑每个的最优解就行了
 * ABC
 * BCD
 * CDE
 * 5 4 12
 *
 * 输出例子:
 * 21
 *
 * 例子说明:
 * 最优的答案是CCC，3个学生的总分是5+4+12=21
 * 
 * 
 */
public class Interview17 {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n 个学生
        int m = sc.nextInt(); // m 个题
        String[] str = new String[n];
        int[] score = new int[m];

        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        for (int i = 0; i < m; i++) {
            score[i] = sc.nextInt();
        }
        System.out.println(MaxScore(n, m, str, score));
    }
    public static int MaxScore(int n, int m, String[] answer, int[] score) {
        int res = 0;
        int idx = 0;
        // 针对每个题，求该题的可能的最大分数
        for (int i = 0; i < m; i++) {
            /*每道题有5个答案*/
            int[] cnt = {0, 0, 0, 0, 0};
            int max = 0;
            // 针对每个学生
            for (int j = 0; j < n; j++) {
                if (answer[j].charAt(i) == 'A') {
                    max = max > ++cnt[0] ? max : cnt[0];
                } else if (answer[j].charAt(i) == 'B') {
                    max = max > ++cnt[1] ? max : cnt[1];
                } else if (answer[j].charAt(i) == 'C') {
                    max = max > ++cnt[2] ? max : cnt[2];
                } else if (answer[j].charAt(i) == 'D') {
                    max = max > ++cnt[3] ? max : cnt[3];
                } else if (answer[j].charAt(i) == 'E') {
                    max = max > ++cnt[4] ? max : cnt[4];
                }
            }
            System.out.println("res : " + res);
            res += max * score[idx++];
        }
        return res;
    }

}
