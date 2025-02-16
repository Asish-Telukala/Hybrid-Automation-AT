package base;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Atsample {


    public void testMethod() {
        System.out.println("Running Test");
    }

    public static void main(String[] args) {

        String str1 = "Asish";
        String strr2  = "Kumara";

        str1 = str1.toLowerCase();
        strr2 = strr2.toLowerCase();

        Set<Character> char1 = new HashSet<>();
        Set<Character> Dup = new HashSet<>();

        for (char ch : str1.toCharArray()){
            char1.add(ch);
        }

        for (char ch : strr2.toCharArray()){
            if(char1.contains(ch)){
                Dup.add(ch);

            }

        }
        System.out.println(Dup);
    }
}
