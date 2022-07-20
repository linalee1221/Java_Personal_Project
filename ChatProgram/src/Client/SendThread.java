package Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {
	private final Socket socket;
	
	// 콘솔 입력 받기
	Scanner scanner = new Scanner(System.in);

	public SendThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// 네트워크 전송을 위한 패킷 설정 부분 : 준비 단계
			DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
			
			String sendString;
			while(true) {
				// 콘솔입력처리
				sendString = scanner.nextLine();
				
				// 콘솔입력 받은부분을 전송
				sendWriter.writeUTF(sendString);
				
				// 버퍼에 있는 메세지를 즉시 전송
				sendWriter.flush();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
