import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Map.entry;

@RestController
public class Demo {


    char theString;
    int un = 1;

    public void checkNullReference() {
        int titi;
        //int tutu = titi++;
        String name = null;
        addReference(name);

        //System.out.println(titi + name.length());
    }

    public void addReference(String name) {
        name = new String();
        name.substring(0);
    }

    public static void main(String[] args) {
        int b =5 ;
        System.out.println(6%5);
        int a =3 ;

        do {
            System.out.println("passage a=" +a);
            if ((a++%5) == 0)
                break;
        }while (a++<15);

        double x = 4, y = 10;
        try {
            y /= x;
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("y=" + y);
        System.out.println("x=" + x);

        x = 4; y = 10;
        try {
            y+= x;
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("y=" + y);
        System.out.println("x=" + x);

        x = 4; y = 10;
        try {
            y -= x;
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("y=" + y);
        System.out.println("x=" + x);

        x = 4; y = 10;
        try {
            y *= x;
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("y=" + y);
        System.out.println("x=" + x);

        Demo demo = new Demo();
        demo.checkNullReference();

        Map<Integer, String> hashmap = Map.ofEntries(entry(1, "A"), entry(2, "B"), entry(3, "C"));
        Set cles = hashmap.keySet();
        Iterator it = cles.iterator();
        while (it.hasNext()) {
            Integer cle = (Integer) it.next();
            String valeur = hashmap.get(cle);
        }
    }
}
