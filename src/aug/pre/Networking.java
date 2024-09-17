package aug.pre;

import java.net.URL;
import java.net.URLConnection;

public class Networking {

	public static void main(String[] args) throws Exception {
		URL obj = new URL("https://leetcode.com");
		URLConnection obj1 = obj.openConnection();
		int len=obj1.getContentLength();
		System.out.println(len);
	}
}
