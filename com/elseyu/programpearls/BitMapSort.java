package com.elseyu.programpearls;

import java.util.Random;

/**
 * 编程珠玑第一章里面的位向量排序
 * 1.假如需要排序的数最大值为: N = 10000000,而且没有重复值，如果用位图来表示
 * 至多需要N个位，这里用32位整形int来表示，一个int有32位，需要多少个int才能表示
 * N个位呢？答案是N/32个，根据位移性质，即N/32=N>>5(因为移位比除法快得多)
 * 2.注意到32=2^5，这里令SHITF=5；所以需要的长度为(N>>5)+1的数组,即arr[(N>>SHIFT)+1]
 * 3.假如遇到一个数为i，如何在arr中找到对应的数呢？很简单，就是arr[i>>SHIFT]
 * 4.找到对应的数后，如何在相应的位初始化(清零)、置一、测试（是否为1）？
 * 清零：arr[i>>SHIFT] &= ~(1<<(i & MASK)),其中MASK = 31
 * 置一：arr[i>>SHIFT] |= (1<<(i & MASK))
 * 测试：arr[i>>SHIFT] & (1<<(i & MASK))
 */
public class BitMapSort {
	
	public static void bitSort(int[] a) {
		int N = 1000;
		int SHIFT = 5;
		int MASK = 31;
		int[] arr = new int[(N/32)+1];
		//清零
		for (int i = 0; i < N; i++) {
			arr[i >> SHIFT] &= ~(1<<(i & MASK));
		}
		//置一
		for (int i = 0; i < a.length; i++) {
			arr[a[i] >> SHIFT] |= (1<<(i & MASK));
		}
		//打印
		for (int i = 0; i < N; i++) {
			if ((arr[i>>SHIFT] & (1<<(i & MASK))) != 0) {
				System.out.print(i + ", ");
			}
		}
	}
	
	//测试
	public static void main(String[] args) {
		int N = 1000;
		int[] a = new int[10];
		
		Random random = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(N);
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		bitSort(a);
	}
}
