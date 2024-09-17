package july;

public class VariableScope {

	public static void main(String[] args) {
		int x;
		x=5;
		{
			int y=6;
			System.out.println(x+ " -> " +y);
		}
		//System.out.println(x+ " " +y);
	}

}
