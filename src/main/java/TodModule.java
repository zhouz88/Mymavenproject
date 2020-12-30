import Calculators.Calculator;
import Calculators.CalculatorGeneral;
import Calculators.CalculatorNoMultiplyAndDivide;
import Calculators.CalculatorNoParanthesis;
import Calculators.annotations.NoMultiplyAndDivide;
import Calculators.annotations.NoParenthesis;
import Interceptors.ChinaDogInterceptor;
import annotations.ChinaDogIntercept;
import annotations.Unitesstates;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

public class TodModule extends AbstractModule {
    protected void configure() {
        bindConstant().annotatedWith(Names.named("chinadog")).to(13);
        bindConstant().annotatedWith(Names.named("usdog")).to(15);
        bind(Calculator.class).annotatedWith(NoMultiplyAndDivide.class).to(CalculatorNoMultiplyAndDivide.class).asEagerSingleton();
        bind(Calculator.class).annotatedWith(NoParenthesis.class).to(CalculatorNoParanthesis.class).asEagerSingleton();
        bind(Calculator.class).to(CalculatorGeneral.class).asEagerSingleton();
        bind(Age.class).asEagerSingleton();
        bind(Dog.class).toProvider(TodProvider.class).asEagerSingleton();
        bind(Dog.class).annotatedWith(Unitesstates.class).toProvider(USDogProvider.class).asEagerSingleton();
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(ChinaDogIntercept.class), new ChinaDogInterceptor());
    }
}
