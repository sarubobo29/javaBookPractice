import java.util.Date;
import java.io.*;
import java.util.zip.GZIPOutputStream;

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
        
        File file = new File("section9-3-2");
        if(file.exists() == true){
            System.out.println("ファイルは存在します");
            System.out.println(file.length());
        }
        
        // practice9-1
        String inFile = args[0];
        String outFile = args[1];
        // FileInputStream fis1 = new FileInputStream(inFile);
        // FileOutputStream fos1 = new FileOutputStream(outFile);
        
        // int i1 = fis1.read();
        // while(i1 != -1){
        //     System.out.print(i1);
        //     fos1.write(i1);
        //     i1 = fis1.read();
        // }
        // practice9-2
        FileInputStream fis2 = null;
        GZIPOutputStream gos =null;
        BufferedOutputStream bos = null;
        try{
            fis2 = new FileInputStream(inFile);
            FileOutputStream fos2 = new FileOutputStream(outFile);
            bos = new BufferedOutputStream(fos2);
            gos = new GZIPOutputStream(bos);
            int i1 = fis2.read();
            while(i1 != -1){
                System.out.print(i1);
                gos.write(i1);
                i1 = fis2.read();
            }
        }
        catch(IOException e){
            System.out.println("例外が発生しました");
            try {
                if(fis2 != null){fis2.close();}
                if(gos != null){gos.close();}
            }catch(IOException e2){}
        }finally{
            System.out.println("終了します");
        }

        fis2.close();
        //fos2.close();
        gos.close();
        bos.close();

    }
}