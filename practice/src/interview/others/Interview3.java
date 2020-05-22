package interview.others;

/**
 * 阿里二面
 * ipv4 encode to int
 * 要求还能将 int decode 为 ip，没做出来
 *
 * 类似的ipv6 encode to long，只不过是用128位ip地址保存到一个long数组里，一个long保存64位
 * https://blog.csdn.net/dadiyang/article/details/88285937#comments
 */
public class Interview3 {
    public static void main(String[] args) {
        String[] ips = {"255.255.255.254", "127.0.0.1", "134.34.65.76", "169.23.12.11"};
//        for (String s : ips) {
//            System.out.println(s.equals(Int2Ip(Ip2Int(s))));
//        }
        String ip = "134.34.65.76";
        int a = Ip2Int(ip);
        String s = Int2Ip(a);
        System.out.println(s);
    }

    public static long IP2Long(String ip) {
        String[] strs = ip.split("\\.");
        long ans = (Long.parseLong(strs[0]) << 24) + (Long.parseLong(strs[1]) << 16) + (Long.parseLong(strs[2]) << 8) + (Long.parseLong(strs[3]));
        System.out.println(ans);
        return ans;
    }


    // 32位IP地址 保存到一个int里
    public static int Ip2Int(String ipString) {
        // 取 ip 的各段
        String[] ipSlices = ipString.split("\\.");
        int ans = 0;
        for (int i = 0; i < ipSlices.length; i ++) {
            int cur = Integer.parseInt(ipSlices[i]);
            System.out.println("cur binary:" + Integer.toBinaryString(cur));
            // 将 ip 的每一段解析为 int，并根据位置左移 8 位
            int intSlice = cur << 8 * i;
            System.out.println("huo before:" + Integer.toBinaryString(intSlice));
            // 或运算
            ans |= intSlice;
            System.out.println("huo after: " + Integer.toBinaryString(ans));
        }
        System.out.println(ans);
        System.out.println(Integer.toBinaryString(ans));

        return ans;
    }

    public static String Int2Ip(int ip) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            // 每 8 位为一段，这里取当前要处理的最高位的位置
            int pos = i * 8;
            // 取当前处理的 ip 段的值
            int cur = ip & (255 << pos);
            System.out.println("cur: " + cur);
            // 将当前 ip 段转换为 0 ~ 255 的数字，注意这里必须使用无符号右移
            System.out.println("cur >>> is :" + (cur >>> pos));
            sb.append(cur >>> pos).append('.');
        }

        return sb.toString().substring(0, sb.length() -1);
    }


    // wrong 无法处理255开头的IP，对应32位整形是个1开头的有符号数，是个负数，
    public static int MyIP2Int(String ip) {
        String[] strs = ip.split("\\.");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i ++) {
            int tmp = Integer.valueOf(strs[i]);
            StringBuilder sb_tmp = new StringBuilder();
            String tmp_str = Integer.toBinaryString(tmp);
            int len = tmp_str.length();
            if (len < 8) {
                int need = 8 - len;
                while (need > 0) {
                    sb_tmp.append('0');
                    need --;
                }
            }
            sb_tmp.append(tmp_str);
            sb.append(sb_tmp);
            System.out.println("cur str is:" + sb_tmp);
        }
        //  32 位01010101111 str -&gt; int  "234353" -&gt; 234353
        return (int)str2int(sb.toString());
    }

    private static long str2int(String s) {
        System.out.println(s);
        long ans = 0;
        for (int i = 0; i < s.length(); i ++) {
            int tmp = s.charAt(i) - '0';
            ans = ans * 2 + tmp;
        }
        System.out.println(ans);
        return ans;
    }
}
