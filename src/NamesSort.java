import java.util.*;

public class NamesSort {
    public static void main(String[] args) {
        Name nameArray[] = {
        		new Name("john", "smith"),
        		new Name("karl", "ng"),
        		new Name("jeff", "smith"),
        		new Name("cindy", "smith"),
        		new Name("tom", "rich")
            
          //  new Name("Sam", "Davis"),
          //  new Name("Cindy", "Jones"),
          //  new Name("Dave", "Jones"),
          //  new Name("Sally", "Smith"),
          //  new Name("Rodney", "Smith")
        };

        List<Name> names = Arrays.asList(nameArray);
        Collections.sort(names);
        System.out.println(names);
    }
}