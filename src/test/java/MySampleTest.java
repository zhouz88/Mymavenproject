import Calculators.*;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MySampleTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private CalculatorNoMultiplyAndDivide calculator1;
    @Mock
    private CalculatorNoParanthesis calculator2;
    @Mock
    private CalculatorGeneral calculator3;
    @InjectMocks
    private Calulators cals;

    @Test
    public void test() {
        //MockitoAnnotations.initMocks(this);
        when(cals.getGeneralCalculator().calculate(anyString())).thenReturn(122);

        assertEquals(cals.getGeneralCalculator().calculate("1+3"), 122);
    }
}