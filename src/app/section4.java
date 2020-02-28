package app;
import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;

public class section4 {

    public static void main(String[] args) throws IOException {
        Date date = new Date();
        Book ex = new Book("yaa", date, "interesting!");

        // System.out.printlnは全てのClassの親である，
        // ObjectクラスのtoString()メソッドを内部で行っている．(ex.toString()が実行されている．)
        System.out.println(ex.toString());
        Book ex2 = ex.clone();
        System.out.println(ex2.toString());
        
    }

    // class クラス名　implements インターフェイス名
    // インターフェイスとは，定数とメソッド名のみを定義したもの．to
    // インターフェイスに定義されている抽象メソッドの内容を実際に作らなければ，コンパイルエラーになる．
    // つまり，インタフェースのオーバーライドを"強制的"に行わなければならず，書き忘れ？などの防止に繋がる．
    // Comparableは，クラスの自然順序を宣言するためのインタフェース．

    static public class Book implements Comparable<Book>, Cloneable{
        private String title;
        private Date publishDate;
        private String comment;
    
        public Book(String title, Date date, String comment){
            this.title = title;
            this.publishDate = date;
            this.comment = comment;
        }
        
        // オーバーライドを(親切に)伝える．
        // toString()のオーバーライド(全てのクラスの親となるObject classに定義されいる)
        @Override
        public String toString(){
            return (title + "Date:" +publishDate.toString()+ comment);
        }

        // equalsのオーバーライド(全てのクラスの親となるObject classに定義されいる)
        // 自信でclassを作成する際は，何をもって"等価"とみなすかは，classを作成した人が定義する必要がある．
        // equalsのオーバーライド
        public boolean equlas(Object o){
            if(o == this) return true;
            if(o == null) return false;
            // 型が同じかどうか
            if(!(o instanceof Book)) return false;
            // oをBookクラスにキャスト
            Book r = (Book) o;
            if(this.publishDate.equals(r.publishDate) && this.title.equals(r.title)) return true;
            return false; 
        }

        // hashCoode()のオーバーライド(全てのクラスの親となるObject classに定義されいる)
        // インスタンスからハッシュ値を計算
        // 使用例としては，インスタンスが等価かを調べるときに，ハッシュ値を元に「大体同じか？」を調べ，等価かどうかを調べる．
        // 等価かどうかを調べるのは，計算コストがかかるため，ハッシュ値を使うと効率がいい．
        public int hashCode() {
            // ここの計算は適当に定義してOK(数字自体に意味はないので)
            int result = 37; 
            result = result * 31 + this.title.hashCode(); // String型のhashCodeを使用
            result = result * 11 + this.comment.hashCode();
            return result;
        }

        // Comparableインターフェイスのオーバーライド
        // comparaTo()メソッドは，引数で渡されたインスタンスobjと自分自身とを比較し，大小関係を±1, 0で返すように，定義する必要がある．
        public int compareTo(Book obj){
            // DateクラスのcompareTo()メソッドを呼び出し，比較．
            return this.publishDate.compareTo(obj.publishDate);
        }

        // インスタンスをコピーするには，new で新たにインスタンスを作成し，コピーしたいインスタンスの内容をコピーしなければならない．
        // clone()メソッドはObjectクラスから継承されたもので，インスタンスのコピーを返す．
        // 自分でClassを作成する際は，clone()をオーバーライドしなければならない．
        public Book clone(){
            Book c = new Book(this.title, this.publishDate, this.comment);
            return c;
        }
    }

}

