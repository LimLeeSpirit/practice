package designPattern.adapter;

/**
 * 结构型设计模式
 *
 * 适配器模式，知道他是用来干嘛的：
 * 作为两个不兼容的接口之间的桥梁。这种类型的设计模式属于结构型模式，它结合了两个独立接口的功能
 * 意图：将一个类的接口转换成客户希望的另外一个接口，
 * 适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 *
 * 优点： 1、可以让任何两个没有关联的类一起运行。 2、提高了类的复用。 3、增加了类的透明度。 4、灵活性好。
 * 使用场景：有动机地修改一个正常运行的系统的接口，这时应该考虑使用适配器模式。
 *
 * 比如又有一个音乐播放器接口MediaPlayer，其实现类 AudioPlayer 只能播放MP3格式的音乐，
 * 但还有一个更高级的媒体播放器接口 AdvancedMediaPlayer，该接口的实现类可以支持播放 vlc 和 mp4 格式的文件；
 * 如果此时想要让 AudioPlayer 播放其他格式的音频文件，
 * 此时需要创建一个实现了 MediaPlayer 接口的适配器类 MediaAdapter，
 * 并使用 AdvancedMediaPlayer 对象来播放所需的格式。
 */
public class adapter {
    public static void main(String[] args) {

    }
}
