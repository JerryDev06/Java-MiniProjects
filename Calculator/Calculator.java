import java.util.*;
class Intcheck {
    boolean isNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

public class Calculator {    
    static void endProgram() {
        System.out.println("Thank you for using my calculator.");
        System.out.println("Programmed by Chris Jericson. R");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Intcheck check = new Intcheck();
        System.out.println("Welcome to my Calculator");
        System.out.println("+ : Addition");
        System.out.println("- : Subtraction");
        System.out.println("* : Multiplication");
        System.out.println("/ : Division");
        System.out.println("^ : Exponent (power)");
        System.out.println("Type 'end' anytime to stop the calculator");
        System.out.print("Enter the first number: ");
        String first = in.nextLine();
        while (!check.isNumber(first)) {
            if (first.equalsIgnoreCase("end")) {
                endProgram();
                in.close();
                return;
            }
            System.out.print("Invalid input. Try again: ");
            first = in.nextLine();
        }
        double total = Double.parseDouble(first);
        while (true) {
            System.out.print("Choose the operation (+, -, *, /, ^): ");
            String operation = in.nextLine();
            if (operation.equalsIgnoreCase("end")) {
                endProgram();
                in.close();
                break;
            }
            if (!operation.matches("[+\\-*/^]")) {
                System.out.println("Invalid operation. No changes made.");
                continue;
            }
            System.out.print("Enter the next number: ");
            String num = in.nextLine();
            if (num.equalsIgnoreCase("end")) {
                endProgram();
                in.close();
                break;
            }
            if (!check.isNumber(num)) {
                System.out.println("Invalid number. Try again.");
                continue;
            }
            double value = Double.parseDouble(num);
            switch (operation) {
                case "+" -> total += value;
                case "-" -> total -= value;
                case "*" -> total *= value;
                case "/" -> {
                    if(value == 0){
                        System.out.println("Cannot divide by zero. Operation ignored.");
                    }
                    else{
                        total /= value;
                    }
                }
                case "^" -> total = Math.pow(total, value);
            }
            System.out.println("Current total: " + total);
        }
    }
}
