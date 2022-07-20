import java.util.Arrays;

public class ArrayDelete {

	public static void main(String[] args) {
		
		int[] iArr = {1,3,5,7,9,11,13};
		System.out.println(Arrays.toString(iArr));
		
		for(int i=3; i<iArr.length-1; i++) {
			iArr[i] = iArr[i+1];
		}
//		iArr[1] = iArr[2];
//		iArr[2] = iArr[3];
//		iArr[3] = iArr[4];
//		iArr[4] = iArr[5];
//		iArr[5] = iArr[6];
		System.out.println(Arrays.toString(iArr));
		
		String[] nameList = new String[100];
		nameList[0] = "홍길동";
		nameList[1] = "신사임당";
		nameList[2] = "이순신";
		nameList[3] = "강감찬";
		System.out.println(Arrays.toString(nameList));
		
		int count = 4;
		for(int i=1; i<count-1; i++) {
			nameList[i] = nameList[i+1];
		}
		System.out.println(Arrays.toString(nameList));
		

	}

}
