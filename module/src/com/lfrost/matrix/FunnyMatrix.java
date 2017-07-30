package com.lfrost.matrix;

public class FunnyMatrix {
	public int[][] mat = null;
	public int n;

	public FunnyMatrix(int n) {
		this.n = n;
		mat = new int[n][n];
		int element = 1;
		for(int i=0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				mat[i][j] = element++;
			}
		}
	}
	
	void rotateMatrix2() {
		for(int start=0, end=n-1; start < end; ++start, --end) {
			for(int pos=0; pos < end-start; pos++) {
				// l to t
				int tmp = mat[start][start+pos];
				mat[start][start+pos] = mat[end-pos][start];
				// t to r
				int tmp2 = mat[start+pos][end];
				mat[start+pos][end] = tmp;
				// r to b
				tmp = mat[end][end-pos];
				mat[end][end-pos] = tmp2;
				// b to l
				tmp2 = mat[end-pos][start];
				mat[end-pos][start] = tmp;
			}
		}
	}
	
	void rotateMatrix() {
		int start = 0, end = n-1;
		while(start < end) {
			int i = start, j = start;
			int[] tmp = new int[end-start];
			
			for(int k=0; k < end-start; k++) {
				tmp[k] = mat[end-k][start];
			}
			
			for(int k=0; j < end; j++) {
				int tmpElement;
				tmpElement = mat[i][j];
				mat[i][j] = tmp[k];
				tmp[k] = tmpElement;
				k++;
			}
			for(int k=0; i < end; i++) {
				int tmpElement;
				tmpElement = mat[i][j];
				mat[i][j] = tmp[k];
				tmp[k] = tmpElement;
				k++;
			}
			for(int k=0; j > start; j--) {
				int tmpElement;
				tmpElement = mat[i][j];
				mat[i][j] = tmp[k];
				tmp[k] = tmpElement;
				k++;
			}
			for(int k=0; i > start; i--) {
				int tmpElement;
				tmpElement = mat[i][j];
				mat[i][j] = tmp[k];
				tmp[k] = tmpElement;
				k++;
			}
			
			start++; end--;
		}
	}
	
	public void rotateOneElement() {
		int start = 0, end = n - 1;
		while(end-start > 0) {
			int i = start, j = start;
			int tmp;

			for(; i < end; i++) {
				tmp = mat[i+1][j];
				mat[i+1][j] = mat[i][j];
				mat[i][j] = tmp;
			}
			for(; j < end; j++) {
				tmp = mat[i][j+1];
				mat[i][j+1] = mat[i][j];
				mat[i][j] = tmp;
			}
			for(; i > start; i--) {
				tmp = mat[i-1][j];
				mat[i-1][j] = mat[i][j];
				mat[i][j] = tmp;
			}
			for(; j > start+1; j--) {
				tmp = mat[i][j-1];
				mat[i][j-1] = mat[i][j];
				mat[i][j] = tmp;
			}
								
			start++;
			end--;
		}
	}
	
	public void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
				System.out.print(String.format("%d", mat[i][j]) + '\t');
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		FunnyMatrix fm = new FunnyMatrix(4);
		fm.print();
		System.out.println();
		fm.rotateMatrix2();
//		fm.rotateOneElement();
		fm.print();
	}
}

enum Policy {
	TOP_TO_RIGHT, RIGHT_TO_BOTTOM, BOTTON_TO_LEFT, LEFT_TO_TOP
}