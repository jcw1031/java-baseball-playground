package calculator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.BiFunction;

public class StringCalculator {

    private final Queue<Integer> operands = new LinkedList<>();
    private final Queue<String> operators = new LinkedList<>();
    private final Map<String, BiFunction<Double, Double, Double>> functions = new HashMap<>();

    public StringCalculator() {
        functions.put("+", (operand1, operand2) -> operand1 + operand2);
        functions.put("-", (operand1, operand2) -> operand1 - operand2);
        functions.put("*", (operand1, operand2) -> operand1 * operand2);
        functions.put("/", (operand1, operand2) -> operand1 / operand2);
    }

    public double calculate(String formula) {
        String[] values = formula.split(" ");
        for (String value : values) {
            if (!Character.isDigit(value.charAt(0))) {
                operators.add(value);
                continue;
            }
            operands.add(Integer.parseInt(value));
        }

        double result = operands.remove();
        while (!operators.isEmpty()) {
            int operand = operands.remove();
            String operator = operators.remove();

            result = functions.get(operator)
                    .apply(result, (double) operand);
        }

        return result;
    }
}
