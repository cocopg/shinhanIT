package com.shinhan.day13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.0.64", 50001);

			System.out.println("[클라이언트]연결 성공");
			
			// 네트워크에서 들어온 문자를 읽기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			//String message = dis.readUTF();
			//보내기
			String message = "나는 자바가 좋ㅇ...ㅏ";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(message + "@@@@");
			dos.flush();

			System.out.println("받은 메세지:" + message);

			// socket닫기

			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (UnknownHostException e) {
			// IP표기 방법이 잘못됐을 경우
		} catch (IOException e) {

		}
	}
}
