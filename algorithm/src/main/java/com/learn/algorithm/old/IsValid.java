package com.learn.algorithm.old;

import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("{[}]"));
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                case '[':
                case '{':
                    stack.push(chars[i]);
                    break;
                case ')':
                    if (stack.size() <= 0 || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.size() <= 0 || stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.size() <= 0 || stack.pop() != '{')
                        return false;
                    break;
                default:
                    break;
            }
        }
        if (stack.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
