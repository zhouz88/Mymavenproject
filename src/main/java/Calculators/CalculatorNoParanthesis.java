package Calculators;

import Calculators.Exceptions.CalculateExeption;

import java.util.Stack;

public class CalculatorNoParanthesis extends Calculator {
    public int calculate(String s) {
        try {
            Stack<Object> stack = new Stack<Object>();
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    int temp = s.charAt(i) - '0';
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        temp = 10 * temp + s.charAt(++i) - '0';
                    }
                    mergeToStack(temp, stack);
                } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                    stack.push(s.charAt(i));
                } else if (s.charAt(i) == ' ') {
                    continue;
                }
            }
            int total = 0;
            while (!stack.isEmpty()) total += (Integer) stack.pop();
            return total;
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
                stack.add(temp);
            } else if (stack.peek().equals('-')) {
                stack.pop();
                stack.add(-temp);
            } else if (stack.peek().equals('*')) {
                stack.pop();
                int f = (Integer) stack.pop();
                stack.add(f * temp);
            } else if (stack.peek().equals('/')) {
                stack.pop();
                int f = (Integer) stack.pop();
                stack.add(f / temp);
            }
        } else {
            stack.add(temp);
        }
    }
}
