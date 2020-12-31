package Calculators;

import Calculators.annotations.NoMultiplyAndDivide;
import Calculators.annotations.NoParenthesis;
import com.google.inject.Inject;
import lombok.Data;

@Data
public class Calulators {
    @Inject
    @NoParenthesis
    CalculatorNoParanthesis noParenthesisCalculator;

    @Inject
    @NoMultiplyAndDivide
    CalculatorNoMultiplyAndDivide noMultiplyAndDivideCalculator;

    @Inject
    CalculatorGeneral generalCalculator;
}
