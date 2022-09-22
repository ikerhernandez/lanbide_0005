package com.ipartek.formacion.mf0967.uf2216;

import java.math.BigInteger;

public class Recursividad {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE + 1);
		System.out.println(factorial(new BigInteger("10")));
	}
	
	/*
	 * 3! = 3 * 2 * 1<br/>
	 * 3! = 3 * 2!
	 * 2! = 2 * 1! 2!
	 * 
	 * 
	 * 
	 * n! = n * !n-1
	 */
	
	public static BigInteger factorial(BigInteger n) {
		if (BigInteger.ONE.compareTo(n) == 0) 
			return BigInteger.ONE;
			return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}

}
