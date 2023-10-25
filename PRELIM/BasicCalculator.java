import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a mathematical expression: ");
        String expression = scanner.nextLine();

        double result = evaluateExpression(expression);

        System.out.println("Result: " + result);
    }

    public static double evaluateExpression(String expression) {
        try {
            return evaluate(expression);
        } catch (Exception e) {
            System.out.println("Invalid input expression.");
            return Double.NaN;
        }
    }

    private static double evaluate(String expression) {
        expression = expression.replaceAll("\\s+", ""); // Remove spaces

        if (expression.contains("+")) {
            String[] terms = expression.split("\\+");
            double result = 0;
            for (String term : terms) {
                result += Double.parseDouble(term);
            }
            return result;
        } else if (expression.contains("-")) {
            String[] terms = expression.split("-");
            double result = Double.parseDouble(terms[0]);
            for (int i = 1; i < terms.length; i++) {
                result -= Double.parseDouble(terms[i]);
            }
            return result;
        } else if (expression.contains("*")) {
            String[] factors = expression.split("\\*");
            double result = 1;
            for (String factor : factors) {
                result *= Double.parseDouble(factor);
            }
            return result;
        } else {
            return Double.parseDouble(expression);        }
    }
}
