package Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {
	private final Socket socket;
	private Scanner scanner = new Scanner(System.in);
	
	// 생성자
	public SendThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			
			// 네트웍 패킷 전송 준비
			DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
			
			String sendString;
			while(true) {
				sendString = scanner.nextLine();
				// 네트웍으로 문자열 전송
				sendWriter.writeUTF(sendString);
				sendWriter.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
