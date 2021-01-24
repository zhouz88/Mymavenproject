import Calculators.Calculator;
import Calculators.CalculatorProxy;
import Calculators.Calulators;
import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Getter;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Solution {
    private static Logger logger = LoggerFactory.getLogger(Solution.class);

    public static void main(String[] args) throws Throwable {
        BasicConfigurator.configure();
        logger.info("https://dillinger.io/ is a good place for readme");
        System.getProperty("user.dir");
        System.out.println(System.getenv("HOME"));
        Injector i = Guice.createInjector(new TodModule());
        DogSolutions s = i.getInstance(DogSolutions.class);
        s.chinavow();
        s.usvow();
        Calulators cals = i.getInstance(Calulators.class);
        runCalProxy(cals.getNoMultiplyAndDivideCalculator());
        System.out.println("Input a formula to start the simulation");
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

    private static void runCalProxy(Calculator cal) throws Throwable {
        System.out.println("Proxy**************");
        Calculator cals = Generate(cal);
        System.out.println(cals.calculate("1+1"));
        System.out.println("Proxy**************");
    }

    private static Calculator Generate(Calculator cal) {
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Too hard for me 8888888");
                return 888888888;
            }
        };
        Calculator cals = (Calculator) Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                new Class[] { Calculator.class },
                handler);
        return cals;
    }
}
