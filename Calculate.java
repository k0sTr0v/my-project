import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String input = sc.nextLine();
        String[] str = input.split(" ");
        int result;
        int a, b;

        if(str.length != 3) {
            throw new Exception("Выражение должно состоять из двух чисел");
        }

        if (Roma.isRoman(str[0]) == Roma.isRoman(str[2])) {
            boolean isRoman = Roma.isRoman(str[0]);

            if (isRoman) {
                a = Roma.convertToArabian(str[0]);
                b = Roma.convertToArabian(str[2]);
            } else {
                a = Integer.parseInt(str[0]);
                b = Integer.parseInt(str[2]);
            }
            switch (str[1]) {
                case "+":
                    if ((a <= 10 && b <= 10) && (a > 0 && b > 0)) {
                        result = a + b;
                        break;
                    }
                    throw new Exception("Число > 10 или <0");
                case "-":
                    if ((a <= 10 && b <= 10) && (a > 0 && b > 0)) {
                        result = a - b;
                        break;
                    }
                    throw new Exception("Число > 10 или <0");
                case "*":
                    if ((a <= 10 && b <= 10) && (a > 0 && b > 0)) {
                        result = a * b;
                        break;
                    }
                    throw new Exception("Число > 10 или <0");
                case "/":
                    if ((a <= 10 && b <= 10) && (a > 0 && b > 0)) {
                        result = a / b;
                        break;
                    }
                    throw new Exception("Число > 10 или <0");
                default:
                    throw new Exception("НЕИЗВЕСТНЫЙ ЗНАК");
            }
            if (isRoman) {
                if (result > 0) {
                    System.out.println(Roma.convertToRoman(result));
                }else {
                    throw new Exception("Римские числа не могут быть отрицательными и равными 0!");
                }
            } else{
                System.out.println(result);
            }


        }else {
            throw new Exception("Числа дожны быть в одной системе исчисления!");
        }
    }

    class Roma {
        static String[] romanArray = new String[]{"Rjcnthtd", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};


        public static boolean isRoman(String val) {
            for (int i = 0; i < romanArray.length; i++) {
                if (val.equals(romanArray[i])) {
                    return true;
                }
            }
            return false;
        }

        public static int convertToArabian(String roman) {
            for (int i = 0; i < romanArray.length; i++) {
                if (roman.equals(romanArray[i])) {
                    return i;
                }
            }
            return -1;
        }

        public static String convertToRoman(int arabian) {
            return romanArray[arabian];
        }

    }
}