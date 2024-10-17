package systemnegro.currencyconverter;


import systemnegro.currencyconverter.utils.CurrencyConverterUtils;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int option = 0;

            while (option != 7) {
                CurrencyConverterUtils.showMenu();
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    try {
                        CurrencyConverterUtils.handleMenuOption(option, scanner);

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println("Por favor, insira um número válido.");
                    scanner.next();
                }

            }
        }
    }
}
