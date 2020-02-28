package app;
import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {

    public static class Hero{

        private String name;
    
        public Hero(String name) {
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
    
    }

    public static void main(String[] args) throws IOException {
        // StringBuilder sb = new StringBuilder();
		
		// for(int i = 1; i <=100; i++){
		//     sb.append(i).append(",");
		// }
		// String s = sb.toString();
		// // System.out.print(s);
		// String[] list = s.split(",");
        // System.out.println(list[0]);

        // System.out.print(createPath("file", "folder"));
        
        // Date date = new Date();
        // Calendar cal = Calendar.getInstance();
        
        // cal.setTime(date);
        // int day = cal.get(Calendar.DAY_OF_MONTH);
        // System.out.println(day);
        // day += 100;
        // cal.set(Calendar.DAY_OF_MONTH, day);

        // Date future = cal.getTime();
        // System.out.println(future);
        
        // SimpleDateFormat f = new SimpleDateFormat("YYYY/MM/dd");
        // System.out.println(f.format(future));

        ArrayList<Hero> heroList = new ArrayList<Hero>();
        Hero h1 = new Hero("suzuki");
        Hero h2 = new Hero("tanaka");
        heroList.add(h1);
        heroList.add(h2);
        System.out.println(heroList);

        for(Hero h : heroList){
            System.out.println(h.getName());
        }

        Map<Hero, Integer> heroMap = new HashMap<Hero, Integer>();
        heroMap.put(h1, 3);
        heroMap.put(h2, 7);

        for(Hero key : heroMap.keySet()) {
            int value = (int) heroMap.get(key);
            System.out.println(key.getName() + value);

        }


    }

    static String createPath(String file, String folder){
	    String path;
	    if(folder.endsWith("\\")){
	        path = folder + file;
	    }else{
	        path = folder + "\\" + file;
	    }
	    
	    return path;
	}

}

