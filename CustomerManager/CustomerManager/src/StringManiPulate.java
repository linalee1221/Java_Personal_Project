
public class StringManiPulate {

	public static void main(String[] args) {

		String str = "INSERT";
		//문자열을 일괄적으로 소문자로 변환하는 메서드는 toLowerCase()
		str = str.toLowerCase();//toUpperCase() 소문자를 대문자로
		System.out.println(str);
		//str에 있는 INSERT를 소문자로 변환해서 str에 다시 저장해라
		//문자열에서 특정 문자 하나만 가져오는 메서드는
		//charAt(문자열 인덱스번호)입니다.
		
		char c = str.charAt(0);
		System.out.println(c);

	}

}
