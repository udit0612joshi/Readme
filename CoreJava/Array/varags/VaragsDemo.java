package com.example.varags;

class Calc {
	public int addNum(int... n) {
		int sum = 0;
		for (int k : n) {
			sum = sum + k;
		}
		return sum;
	}

}

public class VaragsDemo {

	public static void main(String[] args) {
		Calc c = new Calc();
		System.out.println(c.addNum(45, 69, 51, 33, 888, 77, 66));

	}

}
