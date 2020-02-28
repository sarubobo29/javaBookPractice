import java.util.Date;
import java.io.*;

public class Section9 {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        FileWriter fw = new FileWriter("sectionSample.txt", true);
        fw.write('B');
        fw.flush();
        fw.close();
        FileReader fr = new FileReader("sectionSample.txt");
        int i = fr.read(); // 1文字読み込む
        while(i != -1){
            char c = (char) i;
            System.out.print(c);
            i = fr.read();
        }
        fr.close();

        FileOutputStream fos = new FileOutputStream("section9-3-2", true);
        fos.write(69);
        fos.flush();
        fos.close();

    }
}