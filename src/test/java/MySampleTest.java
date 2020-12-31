import Calculators.*;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.testng.annotations.Guice;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@Guice(modules = TodModule.class)
public class MySampleTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private CalculatorNoMultiplyAndDivide calculator1;
    @Mock
    private CalculatorNoParanthesis calculator2;
    @Mock
    private CalculatorGeneral calculator3;
//    @InjectMocks
//    private Calulators cals;

    @Test
    public void test() {
        when(calculator1.calculate(anyString())).thenReturn(122);

        assertEquals(calculator1.calculate("1+3"), 122);
    }
}