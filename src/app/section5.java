package app;
import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;

public class section5 {

    public static void main(String[] args) throws IOException {
        System.out.println("section5");
        
        
    }

    public enum KeyType{
        PADLOCK, BUTTON, DIAL, FINGER;
    }

    public class StrongBox<E>{
        private KeyType kt;
        private E instanceData;
        private int count;

        public void put(E d) {this.instanceData = d;}

        StrongBox(KeyType kt) {
            this.kt = kt;
        }

        public E get() {
            this.count++;
            switch (this.kt) {
                case value: PADLOCK:
                    if(count < 1024){
                        return null;
                    }
                    
                    break;

                case value: BUTTON:
                    if(count < 10000){
                        return null;
                    }
                
                    break;


                case value: DIAL:
                    if(count < 30000){
                        return null;
                    }
                
                    break;

                case value: FINGER:
                    if(count < 100000){
                        return null;
                    }
                
                    break;
            }
            this.count = 0;
            return this.instanceData;
        }


    }

}