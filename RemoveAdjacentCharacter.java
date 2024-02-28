package com.ds.stringalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveAdjacentCharacter {

	public static void main(String[] args) {
		String word = "ACCBBBCBA";
		int k =3;
		
		Stack<Character> s = new Stack<>();
		List<Character> pairs = new ArrayList<>();
		
		int charIndex =0;
		for(Character c : word.toCharArray()) {
			charIndex++;
			if(pairs.isEmpty()) {
				if(s.isEmpty()) {
					s.push(c);
				} else if(s.peek() == c) {
					pairs.add(c);
					while(!s.isEmpty() && s.peek() == c)
						pairs.add(s.pop());
				} else {
					s.push(c);
				}
			} else {
				if( pairs.get(0) == c) {
					pairs.add(c);
				} else {
					for(int index = 0; index <pairs.size();index++) {
						s.push(pairs.get(index));
					}
					s.push(c);
					pairs.clear();
				}
			}
			
			if( k == pairs.size()) {
				pairs.clear();
			}
		}
		
		Stack<Character> reverseStack = new Stack<>();
		while(!s.isEmpty()) {
			reverseStack.push(s.pop());
		}
		StringBuilder sb = new StringBuilder();
		
		while (!reverseStack.isEmpty()) {
			sb.append(reverseStack.pop());
		}
		
		System.out.println("final String : " +sb.toString());
	}
}
