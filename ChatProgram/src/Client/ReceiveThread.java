package Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveThread extends Thread {
	private final Socket socket;
	private String receiveString;

	// 매개변수 1개짜리 생성자
	public ReceiveThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// 네트워킄를 통해 받은 데이터를 준비하는 단계
			DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());
			
			while(true) {
				// 수신 메세지 읽기
				receiveString = tmpbuf.readUTF();
				if(receiveString == null) {
					System.out.println("상대방과의 연결이 종료되었습니다.");
				} else {
					System.out.println("상대방 : " + receiveString);
				}
			}
		} catch (IOException e) {
			// 에러 출력
			e.printStackTrace();
		}
	}
	
	
	
}
