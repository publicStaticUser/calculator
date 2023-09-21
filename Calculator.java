import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = scanner.nextLine();

        try {
            String result = calculate(expression);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calculate(String expression) throws Exception {
        String[] parts = expression.split(" ");
        if (parts.length != 3) {
            throw new Exception("Неверный формат выражения");
        }

        String st1 = parts[0];
        String operator = parts[1];
        String st2 = parts[2];


        if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
            throw new Exception("Неподдерживаемый оператор");
        }

        if ((operator.equals("*") || operator.equals("/")) && (Integer.parseInt(st2) < 1 || Integer.parseInt(st2) > 10)) {
            throw new Exception("Число должно быть от 1 до 10");
        }

        if ((operator.equals("*") || operator.equals("/")) && Integer.parseInt(st2) < 0) {
            throw new Exception("Число должно быть положительным");
        }

        if (st1.charAt(0) != '"' || st1.charAt(st1.length() - 1) != '"') {
            throw new Exception("Первый аргумент должен быть строкой");
            }

        if (st2.charAt(0) == '"' && st2.charAt(st2.length() - 1) == '"') {
                st2 = st2.substring(1, st2.length() - 1);
            }

        if (operator.equals("/") && st2.length() == 0) {
            throw new Exception("Деление на пустую строку недопустимо");
            }

            String firstValue = st1.substring(1, st1.length() - 1);

        if (firstValue.length() > 10 || st2.length() > 10) {
                throw new Exception("Длина строки превышает 10 символов");
            }


            String result;
            switch (operator) {
                case "+":
                    result = firstValue + st2;
                    break;
                case "-":
                    if (firstValue.contains(st2)) {
                        result = firstValue.replace(st2, "");
                    } else {
                        result = firstValue;
                    }
                    break;
                case "*":
                    int multipliсation = Integer.parseInt(st2);
                    StringBuilder a = new StringBuilder();
                    for (int i = 0; i < multipliсation; i++) {
                        a.append(firstValue);
                    }
                    result = a.toString();
                    break;
                case "/":
                    int divider = Integer.parseInt(st2);
                    int quotient = firstValue.length() / divider;
                    result = firstValue.substring(0, quotient);
                    break;
                default:
                    throw new Exception("Неподдерживаемый оператор");
            }

            if (result.length() > 40) {
                result = result.substring(0, 40) + "...";
            }

            return result;
        }
    }


