package javadetail.basic.string;

public class test {
    public static void main(String[] args) {
        // StringBuffer 和 StringBuilder
        // 不同点：但是 StringBuilder 线程不安全，StringBuffer线程安全，因为其方法都使用synchronized修饰，达到线程安全；
        // 相同点：均是可变字符串，是指长度可变，都继承自 AbstractStringBuilder，他是字符的可变序列。
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
    }
}
