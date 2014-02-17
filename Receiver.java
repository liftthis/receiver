import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Receiver {
  public static void main(String[] args) {
    try {
      DatagramSocket s = new DatagramSocket(4444);
      byte[] data = new byte[12];
      DatagramPacket p = new DatagramPacket(data, 12);
      s.receive(p);
      System.out.println("got packet");
      ByteBuffer bb = ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN);
      bb.put(data);
      bb.rewind();
      System.out.println(bb.getFloat());
      System.out.println(bb.getFloat());
      System.out.println(bb.getFloat());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}