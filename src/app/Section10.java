import java.util.*;
import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Section10{
    public static void main(String args[]) throws IOException{
        System.out.println("yaa");
        String s = "aiko,takashi,musashi,kozirou";
        // StringTokenizerクラスを使って文字列の分割
        // 指定したデリミタで文字列を分割，それぞれのデータ順次取得する
        StringTokenizer st = new StringTokenizer(s, ",");
        while(st.hasMoreTokens()){ // 次のトークンがあるかどうか
            String t = st.nextToken();
            System.out.println(t);
        }

        // プロパティ形式(key: value)のファイルの読み込み
        FileReader fr = new FileReader("propertiesFileSample.properties");
        Properties p = new Properties();
        p.load(fr); // load of file
        System.out.println(p.getProperty("name")); // キーを入力して，バリューを取得
        System.out.println(p.getProperty("age")); // キーを入力して，バリューを取得
        System.out.println(p.getProperty("from")); // キーを入力して，バリューを取得
        fr.close();

        // プロパティ形式の書き込み
        FileWriter fw = new FileWriter("sampleOutput.properties");
        Properties p1 = new Properties();
        p1.setProperty("key", "value");
        p1.setProperty("name", "hoge");
        p1.store(fw, "practice writeing propaties file");
        fw.close();

        // practice10.1
        FileReader fr2 = new FileReader("section10.properties");
        Properties p2 = new Properties();
        p2.load(fr2);
        System.out.println(p2.getProperty("aichi.capital")+":"+p2.getProperty("aichi.food"));
        fr2.close();

        // practice10.2(クラスを読み込めない)
        Employee emp = new Employee("takashi", 22);
        FileOutputStream fo2 = new FileOutputStream("practice10-2.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fo2); // シリアライズ化のためのクラス
        oos.writeObject(emp);
        oos.flush();
        oos.close();
        fo2.close();
        

    }

}