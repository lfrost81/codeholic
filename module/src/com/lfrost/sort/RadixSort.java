package com.lfrost.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RadixSort {
	static public void sort(int[] arr) {
		int cipher = 1;
		ArrayList<Queue<Integer>> queues = new ArrayList<Queue<Integer>> ();
		for( int i = 0; i < 10; i++ ) {
			queues.add( new LinkedList<Integer> () );
		}
		
		while (true) {
			if( cipher == 1000000000 )
				break;
			cipher *= 10;
			for (int a : arr) {
				int i = (a % cipher) / (cipher / 10);
				queues.get(i).offer(a);
			}
			if( queues.get(0).size() == arr.length )
				break;
			
			int i = 0;
			for (Queue<Integer> q : queues) {
				while( !q.isEmpty() ) {
					arr[i++] = q.poll();
				}
			}
		}
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int[] arr = new int[10];
		for( int i = 0; i < 10; i++ ) {
			arr[i] = Math.abs(rand.nextInt() % 10000);
		}
		RadixSort.sort(arr);
		for( int a : arr ) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
