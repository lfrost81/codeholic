package com.lfrost.algorithm;

public class Fibonazzi {
	public static int run(int n) {
		if( n == 0 )
			return 0;
		if( n == 1 )
			return 1;
		
		int prev = 0;
		int cur = 1;
		for(int i=1; i<n; i++) {
			int tmp = cur;
			cur = prev + cur;
			prev = tmp;
		}
		
		return cur;
	}

	public static long run_recursively(int n) {
        if (n <= 1) {
        	return n;
        }
        else {
        	return run_recursively(n-1) + run_recursively(n-2);
        }
    }

	public static void main(String[] args) {
		System.out.println(run_recursively(3));
		System.out.println(run(3));

	}
}
