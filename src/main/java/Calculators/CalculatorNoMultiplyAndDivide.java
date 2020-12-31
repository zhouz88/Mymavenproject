package Calculators;

import Calculators.Exceptions.CalculateExeption;

import java.util.Stack;

public class CalculatorNoMultiplyAndDivide implements Calculator {
    public int calculate(String s) {
        try {
            Stack<Object> stack = new Stack<Object>();
            s = "(" + s + ")";
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    int temp = s.charAt(i) - '0';
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        temp = 10 * temp + s.charAt(++i) - '0';
                    }
                    mergeToStack(temp, stack);
                } else if (s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-') {
                    stack.push(s.charAt(i));
                } else if (s.charAt(i) == ' ') {
                    continue;
                } else {
                    int sum = 0;
                    while (!stack.peek().equals('(')) {
                        sum += (Integer) stack.pop();
                    }
                    stack.pop();
                    mergeToStack(sum, stack);
                }
            }
            return (Integer) stack.pop();
        } catch (CalculateExeption e) {
            System.out.println("Error" + e.getMessage());
            return -1;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return -1;
        }
    }

    private void mergeToStack(int temp, Stack<Object> stack) {
        if (!stack.isEmpty()) {
            if (stack.peek().equals('+')) {
                stack.pop();
                stack.push(temp);
            } else if (stack.peek().equals('-')) {
                stack.pop();
                stack.push(-temp);
            } else if (stack.peek().equals('(')) {
                stack.push(temp);
            }
        } else {
            stack.push(temp);
        }
    }
}
