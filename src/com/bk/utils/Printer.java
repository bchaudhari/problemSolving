package com.bk.utils;

public class Printer {
	public static void printArray(int[] arr) {
		System.out.print("\n[");
		for(int i = 0; i < arr.length; i++) {
			if(i == arr.length - 1)
				System.out.print(arr[i]);
			else 
				System.out.print(arr[i] + ",");
		}
		System.out.print("]");
	}
	
	public static void printArray(char[] arr) {
		System.out.print("\n[");
		for(int i = 0; i < arr.length; i++) {
			if(i == arr.length - 1)
				System.out.print(arr[i]);
			else 
				System.out.print(arr[i] + ",");
		}
		System.out.print("]");
	}
}
