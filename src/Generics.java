import java.util.ArrayList;

public class Generics {
	
public static <E> void main(String[] args) {
	ArrayList<E> list = new ArrayList<E>();
	list.add((E) "Hello"); 
	String s = (String)(list.get(0));
}
}
