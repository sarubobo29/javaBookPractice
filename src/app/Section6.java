package app;
import java.io.*;
import java.util.Date;
import java.util.function.IntBinaryOperator;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;

public class Section6 {

    public static int func(int x, int y){
        return x*y;
    }
    
    // 関数funcのためのSAMインタフェース
    public interface Myfunc{
        public abstract int call(int x, int y);
    }

    // Section6's practice question
    public static class FuncList{
        public static boolean isOdd(int x){
            return (x % 2 == 1);
        }
        public static String addNamePrefix(boolean male, String name){
            if(male == true){ return "Mr."+ name; }
            else {return "Ms."+name;}
        }
    }
    public interface Func1{
        public abstract boolean call(int x);
    }

    public interface Func2{
        public abstract String call(boolean male, String name);
    }

    public static void main(String[] args) throws IOException {

        int a = 3;
        int b = 2;
        System.out.println(func(a, b));
        // 第1級オブジェクト：プログラムの実行中に生み出したり，変数を代入したりできる．
        // ex) データ(int, string)やデータ構造，インスタンスなど
        // java8以降，関数も変数に代入できるようになった．
        // 上で定義した関数funcを変数に代入．
        Myfunc funcObject = Section6::func;
        int result = funcObject.call(5, 2);
        System.out.println(result);
        
        // ラムダ式．その場で関数を作る
        // 上で定義したfuncはmainが実行されるときには既に生成されている．(ついでに，function objectは関数の実体のメモリを指しているだけ．)
        // 2つの引数の乗算を求めて処理する関数をラムダ式で書く
        Myfunc lambdaFunc = (int x, int y) -> {return x * y;};
        System.out.println(lambdaFunc.call(3, 11));
        // ラムダ式の省略形の書き方
        Myfunc lambdaShortFunc = (x, y) -> {return x *y;}; 
        System.out.println(lambdaShortFunc.call(4, 2));

        // ラムダ式のメリット
        ArrayList<Integer> intList= new ArrayList<Integer>();
        for (int i=0; i<10; i++){
            intList.add(i);
        }
        System.out.println(intList);
        // listの中身を2倍して表示(通常の書き方)
        for (Integer i: intList){
            System.out.println(i*2);
        }
        // lambda式を使った書き方.
        intList.stream().forEach(i -> System.out.println(i*2));


        // Section6's question
        Func1 ans1 = FuncList::isOdd;
        Func2 ans2 = FuncList::addNamePrefix;
        System.out.println(ans1.call(10));
        System.out.println(ans2.call(true, "bob"));
        
        Func1 ans3 = (int x) -> {return x%2 == 1;};
        Func2 ans4 = (boolean male, String name) -> {if(male==true){return "Mr."+name;}else{return "Ms."+name;}};

    }
}