package com.shinhan.day13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		System.out.println("-------------------------------------------");
		System.out.println("서버를 종료하려면 q또는 Q를 입력하고 엔터키를 입력하세요");
		System.out.println("-------------------------------------------");

		startServer();

		Scanner sc = new Scanner(System.in);
		while (true) {
			String key = sc.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}

		}
		sc.close();
		stopServer();
	}

	private static void startServer() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// ServerSocker및 port바인딩
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버]시작됨");

					while (true) {
						System.out.println("\n [서버]연결 요청을 기다림\n");
						// 연결수락
						Socket socket = serverSocket.accept();

						// 연결된 클라이언트 정보 얻기
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버]" + isa.getHostName() + "의 연결요청을 수락함");

						// 네트워크에서 들어온 문자를 읽기
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String receiveMessage = dis.readUTF();
						System.out.println("클라이언트가 메세지를 받음:" + receiveMessage);
						// 보내기
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						String message = dis.readUTF();
						dos.writeUTF(message + "@@@@");
						dos.flush();

						System.out.println("받은 메세지:" + message);

						// 연결끊기
						socket.close();
						System.out.println("[서버]" + isa.getHostName() + "의 연결을 끊음");
					}
				} catch (IOException e) {
					System.out.println("[서버]" + e.getMessage());
				}
			}
		};
		thread.start();

	}

	private static void stopServer() {
		try {
			// ServerSocket을 닫고 Port 인바인딩
			serverSocket.close();
			System.out.println("[서버]종료됨");
		} catch (IOException e1) {
		}

	}

}
