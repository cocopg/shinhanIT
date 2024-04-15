package com.shinhan.day07;

public class Chatting {
	class Chat{
		void start() {}
		void sendMessage(String message) {}
	}
	
	void startChat(String chatId) {
		String nickname = null;
		//nickname = chatId;
		
		//익명구현클래스,  local inner class는 지역변수를 참조하는 경우 무조건 지역변수는 final이다.
		Chat chat = new Chat() {
			public void start() {
				while(true) {
					String inputData = "안녕하세여";
					String message = "[" + nickname + "]" + inputData;
					sendMessage(message);
				}
			}
		};
		chat.start();
	}

}
