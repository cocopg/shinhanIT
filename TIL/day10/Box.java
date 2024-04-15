package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Box<T> {

	private T content;

	@Override
	public String toString() {
		return "Box [content=" + content + "]";
	}

	
}
