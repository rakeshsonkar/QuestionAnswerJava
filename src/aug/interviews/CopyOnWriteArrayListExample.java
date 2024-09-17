package aug.interviews;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

	public static void main(String[] args) {
		List<Integer> ls= new CopyOnWriteArrayList<Integer>();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		for(Integer num :ls) {
			System.out.println(num);
		}
	}
}
