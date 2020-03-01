import java.util.*;
import java.io.*;

class Employee implements Serializable{
    String name;
    int age;
    Employee(String name, int age){
        this.name = name;
        this.age = age;
    }
}
