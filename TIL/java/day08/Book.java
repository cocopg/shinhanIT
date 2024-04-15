package com.shinhan.day08;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
//@EqualsAndHashCode(of = {"title","author"})
//@EqualsAndHashCode(exclude = {"price"})

public class Book {
	private String title;
	private int price;
	private String author;

	public Book() {
		System.out.println("com.shinhan.day08패키지에 있는 Book");
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && price == other.price && Objects.equals(title, other.title);
	}

}
