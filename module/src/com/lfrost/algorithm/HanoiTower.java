package com.lfrost.algorithm;

import java.util.Stack;

public class HanoiTower {
	Stack<Integer> a = new Stack<Integer> ();
	Stack<Integer> b = new Stack<Integer> ();
	Stack<Integer> c = new Stack<Integer> ();
	
	HanoiTower(int n) {
		while( n > 0 ) {
			a.push(n);
			n--;
		}
	}
	
	void move(Stack<Integer> from, Stack<Integer> to, Stack<Integer> by, int n) {
		if( n <= 0 )
			return;

		move(from, by, to, n-1);
		to.push(from.pop());
		move(by, to, from, n-1);
	}
	
	void move(Stack<Integer> from, Stack<Integer> to) {

	}
	
	public void print() {
		System.out.print(a + ", ");
		System.out.print(b + ", ");
		System.out.println(c);
	}

	public static void main(String[] args) {
		HanoiTower ht = new HanoiTower(4);
		
		ht.print();
		ht.move(ht.a, ht.c, ht.b, 4);
		ht.print();
	}
}
