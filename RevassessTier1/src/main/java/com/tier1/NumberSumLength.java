package com.tier1;

public class NumberSumLength {

	public static boolean checkNumberPowerLength(long num) {
		long n, m, a;
		int counter = 0;
		int total = 0;
		boolean compare = false;
		n = num;
		m = n;
		while (n > 0) {
			n = n / 10;
			counter++;
		}
		int power = counter;
		while (m > 0) {
			a = m % 10;
			System.out.println("Digits at position " + counter + ":" + a);
			System.out.println(a + " to the power of " + power + " equals " + Math.pow(a, power));
			total += Math.pow(a, power);
			m = m / 10;
			counter--;
		}
		System.out.println("Total of digits to the first power equals " + total);
		if (num == total){
			System.out.println("true");
			compare = true;
		} else {
			System.out.println("false");
			compare = false;
		}
		System.out.println(num);
		return compare;
	}
}
