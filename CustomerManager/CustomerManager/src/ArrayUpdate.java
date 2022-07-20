import java.util.Arrays;

public class ArrayUpdate {

	public static void main(String[] args) {
		String[] names = {"kim", "lee", "park"};
		System.out.println(Arrays.toString(names));
		
		names[1] = "song";
		System.out.println(Arrays.toString(names));
		
		names[2] = "lim";
		System.out.println(Arrays.toString(names));
		

	}

}
