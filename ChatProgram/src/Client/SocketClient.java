package Client;

import java.io.IOException;
import java.net.Socket;

public class SocketClient {
	
	public static void main(String[] args) throws IOException {
		// 소켓 생성시 클라이언트 쪽에서 ip, port번호를 설정함
		Socket sock = new Socket("localhost", 8888);
		
		System.out.println("서버와 접속되었습니다.");
		
		// 수신 메세지 처리 쓰레드 호출
		ReceiveThread receiveThread = new ReceiveThread(sock);
		receiveThread.start();
		
		// 전송 메세지 처리 쓰레드 호출
		SendThread sendThread = new SendThread(sock);
		sendThread.start();
		
	}

}
