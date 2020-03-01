import java.util.*;
import java.io.*;


class Department implements Serializable{
    String name;
    Employee leader;

    Department(String name, Employee o){
        this.name = name;
        this.leader = o;
    }
}