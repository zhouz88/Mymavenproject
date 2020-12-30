import Calculators.Calulators;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Injector i = Guice.createInjector(new TodModule());
        DogSolutions s = i.getInstance(DogSolutions.class);
        s.chinavow();
        s.usvow();
        Calulators cals = i.getInstance(Calulators.class);
        System.out.println("Let's calculate, input a formula");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String next = scanner.nextLine();
            System.out.println(next);
            if (!next.contains("(") && !next.contains(")") ) {
                System.out.println("result" + cals.getNoParenthesisCalculator().calculate(next));
            } else if (!next.contains("*") && !next.contains("/")) {
                System.out.println("result" + cals.getNoMultiplyAndDivideCalculator().calculate(next));
            } else {
                System.out.println("result" + cals.getGeneralCalculator().calculate(next));
            }
        }
    }
}

