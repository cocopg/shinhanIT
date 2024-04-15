package com.shinhan.day12;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Comparable<Student>, Serializable {
	private String name;
	private int score;
	private String gender;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public Student(String name, int score, String gender) {
		super();
		this.name = name;
		this.score = score;
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gender, name, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(gender, other.gender) && Objects.equals(name, other.name) && score == other.score;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=");
		builder.append(name);
		builder.append(", score=");
		builder.append(score);
		builder.append(", gender=");
		builder.append(gender);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Student obj) {
		// score ascending, name descending
		if (score == obj.score)
			return obj.name.compareTo(name);
		return score - obj.score;
	}
}