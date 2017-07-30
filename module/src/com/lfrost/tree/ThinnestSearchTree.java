package com.lfrost.tree;

import java.util.Arrays;
import java.util.Random;

import com.lfrost.tree.BinarySearchTree;

public class ThinnestSearchTree {
	public BinarySearchTree bst = new BinarySearchTree();

	public void makeTree( int[] arr, int start, int end ) {
		if( end < start )
			return;
		

		int mid = (end + start)/2;
		bst.insert( arr[mid] );
		System.out.println(arr[mid]);
		makeTree( arr, start, mid-1 );
		makeTree( arr, mid+1, end );
		return;
	}
	

	public static void main(String[] args) {
		int len = 4;
		int[] arr = new int[len];
		Random rand = new Random();
		for( int i = 0; i < arr.length; i++ ) {
			arr[i] = i;
		}
		Arrays.sort(arr);
		
		//for( int n : arr )
		//	System.out.print(String.format("%d ", n));
		//System.out.println();
		
		new ThinnestSearchTree().makeTree( arr, 0, arr.length-1 );
	}
}
