package com.tier1;

public class SumOverArray {

	public static int IterateAndSum(int[] arr) {
		if (arr == null){
			return 0;
		} else {
			int sum = 0;
			for (int i=0; i<arr.length; i++) {
				sum += arr[i];
			}
			return sum;
		}		
	}
}
