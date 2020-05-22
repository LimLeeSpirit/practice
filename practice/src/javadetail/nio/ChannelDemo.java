package javadetail.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelDemo {
    public static void main(String[] args) throws IOException {
        String relativelyPath = System.getProperty("user.dir");
        System.out.println(relativelyPath);

        FileInputStream input = new FileInputStream(relativelyPath + "/filein.txt");
        ReadableByteChannel source = input.getChannel();

        FileOutputStream output = new FileOutputStream(relativelyPath + "/fileout.txt");
        WritableByteChannel destination = output.getChannel();

        copyData(source, destination);
        source.close();
        destination.close();
        System.out.println("copy success");
    }

    private static void copyData(ReadableByteChannel source, WritableByteChannel destination) throws IOException {
        //
        ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024);
        while (source.read(buffer) != -1) {
            // The buffer is used to drained
            buffer.flip();
            // keep sure that buffer was fully drained
            while (buffer.hasRemaining()) {
                destination.write(buffer);
            }
            buffer.clear(); // Now the buffer is empty, ready for the filling
        }
    }

}
