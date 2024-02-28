package com.ds.stringalgo;

import java.util.Stack;

/**
 * @author Bharani Tharan 
 * 
 * Time: O(n) for Reading the Word of n character.
 *     : O(1) for pop() from Stack 
 *     : O(n) for Reading the Stack / Reversing the Stack
 *     ======================================================
 *       O(n) 
 *     ======================================================
 * 
 * Space:O(n) [Char Stack]
 *       O(n) [Count Stack]
 *       ====================
 *       O(n)
 *       ====================
 */
public class RemoveKAdjacentCharacterOptimized {
	
	public static String removeKadjacent(String word, int k) {
		
		Stack<Character> charStack = new Stack<>();
		Stack<Integer> countStack = new Stack<Integer>();
		
		
		for(Character c : word.toCharArray()) {
			if(!charStack.isEmpty() && charStack.peek() == c) {
				countStack.push(countStack.peek() + 1);
			} else {
				countStack.push(1);
			}
			charStack.push(c);
			
			if(countStack.peek() == k) {
				for(int i=1;i<=k;i++) {
					countStack.pop();
					charStack.pop();
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!charStack.isEmpty()) {
			sb.insert(0, charStack.pop());
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String word = "ACCBBBCBA";
		int k =3;
		
		System.out.println("String after adjacent Removed : " + removeKadjacent(word, k));
	}

}
