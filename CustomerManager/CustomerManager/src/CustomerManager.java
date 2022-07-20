import java.util.Arrays;
import java.util.Scanner;

public class CustomerManager {

	//프로그램 전체에서 사용할 변수들은 클래스 블록 바로 아래에 선언합니다.
	//static이 붙은 블록에서는 static변수와 static메서드만 사용할 수 있음.
	static String[] nameList = new String[100];
	static char[] genderList = new char[100];
	static String[] emailList = new String[100];
	static int[] birthList = new int[100];


	//현재 고객 데이터가 몇 명 저장되었는지 알기 위한 변수 count 선언
	static int count = 0;

	//배열의 인덱스를 조작하기 위해 인덱스를 변수화 시킴.
	//배열의 인덱스는 0번부터 출발하므로 초기값을 0 바로 이전값인 -1로 
	//세팅하여 초기에 next를 실행했을 때 인덱스가 0이되어 첫번째 고객을
	//조회하기 위함.
	static int index = -1;

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		while(true) {
			System.out.println("\n[INFO] 고객 수: " + count 
					+ ", 인덱스: " + index);
			System.out.println("메뉴를 입력하세요.");
			System.out.println("(I)nsert, (P)revious, "
					+ "(N)ext, (C)urrent, (U)pdate, "
					+ "(D)elete, (Q)uit");
			System.out.print("메뉴 입력: ");
			String menu = scan.next();
			menu = menu.toLowerCase();
			char m = menu.charAt(0);

			switch(m) {
			case 'ㅑ':
			case 'i':
				System.out.println("\n고객 정보 입력을 시작합니다.");
				insertData();
				System.out.println("고객정보가 정상적으로 입력되었습니다.");
//				System.out.println(Arrays.toString(nameList));
				break;
			case 'ㅔ':
			case 'p':
				System.out.println("\n이전 고객정보를 조회합니다.");
				if(index <= 0) {
					System.out.println("이전 고객정보가 존재하지 않습니다.");
				}else {
					index--;
					printData(index);
				}
				break;
			case 'ㅜ':
			case 'n':
				System.out.println("\n다음 고객정보를 조회합니다.");
				if(index >= count-1) {
					System.out.println("다음 고객정보가 존재하지 않습니다.");
				}else {
					index++;
					printData(index);
				}
				break;
			case 'ㅊ':
			case 'c':
				System.out.println("\n현재 고객정보를 조회합니다.");			
				if(index >= 0 && index < count) {
					printData(index);
				}else {
					System.out.println("현재 고객정보가 존재하지 않습니다.");
				}
				break;
			case 'ㅕ':
			case 'u':
				System.out.println("\n현재 고객정보를 수정합니다.");
				if(index >= 0 && index < count) {
					updateData(index);
				}else {
					System.out.println("현재 고객정보가 존재하지 않습니다.");
				}
				break;
			case 'ㅇ':
			case 'd':
				System.out.println("\n현재 고객정보를 삭제합니다.");
				if(index >= 0 && index < count) {
					deleteData(index);
				}else {
					System.out.println("현재 고객정보가 존재하지 않습니다.");
				}
				break;
			case 'ㅂ':
			case 'q':
				System.out.println("프로그램을 종료합니다.");
				scan.close();
				System.exit(0); //프로그램을 강제종료하는 구문
				break;
			default:
				System.out.println("메뉴를 잘못 입력했습니다.");
			}//end switch

		}//end while

	}//end main

	//고객 정보를 입력받는 메서드 선언
	public static void insertData() {

		System.out.println("========고객 정보 입력========");
		System.out.print("이름: ");
		String name = scan.next();

		System.out.print("성별(M/F): ");
		String s = scan.next();
		char gender = s.charAt(0);

		System.out.print("이메일: ");
		String email = scan.next();

		System.out.print("출생년도: ");
		int birth = scan.nextInt();
		System.out.println("==========================");

		nameList[count] = name;
		genderList[count] = gender;
		emailList[count] = email;
		birthList[count] = birth;

		count++;

	}

	//고객 정보를 인덱스에 맞게 출력하는 메서드 선언.
	public static void printData(int index) {

		System.out.println("\n======고객 정보======");
		System.out.println("이름: " + nameList[index]);
		System.out.println("성별: " + genderList[index]);
		System.out.println("이메일: " + emailList[index]);
		System.out.println("출생년도: " + birthList[index]);
		System.out.println("=====================");
	}
	
	//고객 정보를 수정하는 메서드 선언.
	public static void updateData(int index) {
		System.out.println("\n========고객 정보 수정========");
		
		//새로운 정보들을 입력받아 각각의 배열의 수정 인덱스에 있는 데이터를
		//변경시키세요. 수정 시에는 수정 전의 정보들이 출력되도록 하세요.
		//ex)이름(홍길동): ______
		System.out.printf("이름(%s): ", nameList[index]);
		nameList[index] = scan.next(); 

		System.out.printf("성별(%s): ", genderList[index]);
		genderList[index] = scan.next().charAt(0);
		
		System.out.printf("이메일(%s): ", emailList[index]);
		emailList[index] = scan.next(); 
		
		System.out.printf("출생년도(%d): ", birthList[index]);
		birthList[index] = scan.nextInt(); 
	}
	
	//고객 정보를 삭제하는 메서드 선언
	public static void deleteData(int index) {
		
		for(int i=index; i<count-1; i++) {
			nameList[i] = nameList[i+1];
			genderList[i] = genderList[i+1];
			emailList[i] = emailList[i+1];
			birthList[i] = birthList[i+1];
		}
		count--;
	}

}//end class







