package Calculators;

import lombok.Getter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorProxy implements Calculator {
    public InvocationHandler handler = new InvocationHandler() {
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return 888888888;
        }
    };

    public CalculatorProxy(InvocationHandler handler) {
        this.handler = handler;
    }

    public int calculate(String name) throws Throwable {
        return (Integer) handler.invoke(
                this,
                Calculator.class.getMethod("calculate", String.class),
                new Object[]{name});
    }
}
