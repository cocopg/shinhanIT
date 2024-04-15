package com.shinhan.day10;

//타입파라메터는 영문자 대문자 아무거나 <A>
public interface Rentable<P> {
	P rent();
}
