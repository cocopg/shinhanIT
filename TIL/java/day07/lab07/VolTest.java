package com.shinhan.day07.lab07;

public class VolTest {

	public static void main(String args[]){
		//Volume은 interface나 추상클래스로 만들수 있다.
		//추상class이였다면 상속받아서 Speaker,Radio,Tv
		//interface였다면 implements
		 Volume[] v = new Volume[3];
		 v[0] = new Speaker();
		 v[1] = new Radio();
		 v[2] = new TV();
		 for(int i = 0; i < v.length; i++){
			 for(int j = 1; j <= 3; j++){
		       		v[i].volumeUp(200);
		      }
			 for(int j = 1; j <= 3; j++){
			  	v[i].volumeDown(300);
			 }
		 }
		}


}
