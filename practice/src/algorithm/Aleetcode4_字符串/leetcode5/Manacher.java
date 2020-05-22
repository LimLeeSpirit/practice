package algorithm.Aleetcode4_字符串.leetcode5;

/**
 *  求解最长回文子串的长度
 */
public class Manacher {
    /*
     * 马拉车法，巧妙利用已知回文字符串的信息，且在寻找过程中一直更新 目前为止最长的回文字符子串的两个量：
     * id：当前位置最长回文子串的中心位置
     * mx：当前位置最长回文子串的边界位置
     */
    public static String manacher(String s) {
        String curLongestSubStr = "";

        // 将字符串更改为奇数长度的字符串，由于需要频繁地拼接字符串，用StringBuilder更好，速度更快,不用频繁创建对象
        StringBuilder newStr = new StringBuilder("#");
        for(int i = 0; i<s.length(); i++) {
            newStr.append(s.charAt(i));
            newStr.append("#");
        }
        System.out.println(newStr);

        // 求出新字符串的数组p[i]
        int[] p = new int[newStr.length()];
        // id、mx的作用：求出p[i]，但是并不是求出最长子串
        int id = 0, mx=0;
        // 随着p[i]的逐步求解，找到最大的p[i]和i,这里才是求出最长子串的关键。
        int center = 0, len = 0;

        for(int i =0; i<newStr.length();i++) {
            p[i] = i<mx ? Math.min(p[2*id-i],mx-i) : 1;

            while (i-p[i]>=0 && i+p[i]<newStr.length() && newStr.charAt(i-p[i])==newStr.charAt(i+p[i])) {
                p[i] += 1;
            }

            // 当以i处的字符为中心的最大子串的边界超过了之前的边界：更新这层的中心与边界
            if (i+p[i]>mx) {
                mx=i+p[i];
                id = i;
                System.out.println("id:"+ id +" "+"mx:"+mx);
            }

            // 更新整个字符串的最长子串的中心和半径

                // 法1 每次都更新最长子串
            if(1 + 2 * p[i] > curLongestSubStr.length()) {
                curLongestSubStr = newStr.substring(i - p[i]+1, i + p[i]);
                System.out.println(curLongestSubStr);
            }

                // 法2 保存最长子串的中心和半径
            if(len<p[i]){
                center=i;
                len = p[i];
            }
        }

        for(int a : p){
            System.out.print(a);
        }
        System.out.println();

        System.out.println("center:"+ center +" "+"len:"+len);

        return newStr.substring(center-len+1, center+len).replace("#","");
        // return curLongestSubStr.replace("#","");
    }
}
