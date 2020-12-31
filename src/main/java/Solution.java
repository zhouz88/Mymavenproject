import Calculators.Calulators;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Solution {
    private static Logger logger = LoggerFactory.getLogger(Solution.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("hello sb");
        System.getProperty("user.dir");
        System.out.println(System.getenv("HOME"));
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
