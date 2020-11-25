package lesson1;

public class Main {

    /*
     * 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
     */
    public static void main(String[] args) {

        // Проверка задания 3
        printTaskNumber(3);
        double a3 = 1.;
        double b3 = 2.;
        double c3 = 3.;
        double d3 = 4.;
        printTaskMsg(String.format("Вычисление выражения a * (b + (c / d)),\n" +
                        "где\n" +
                        "   a = %s\n" +
                        "   b = %s\n" +
                        "   c = %s\n" +
                        "   d = %s\n" +
                        "Результат: %s * (%s + (%s / %s)) = %s",
                a3, b3, c3, d3,
                a3, b3, c3, d3,
                calculateExpression(1., 2., 3., 4.)));
        printNextTaskLine();

        // Проверка задания 4
        printTaskNumber(4);
        int a4 = 10;
        int b4 = 5;
        printTaskMsg("Проверка вхождения суммы чисел " + a4 + " и " + b4 + " в диапазон от 10 до 20(включительно)\n" +
                "Если число входит в данный диапазон, тогда возвращается true, иначе false");
        System.out.println(isSumInBetweenTenAndTwenty(a4, b4));
        printNextTaskLine();

        // Проверка задания 5
        printTaskNumber(5);
        int a5 = 1;
        printTaskMsg("Проверка на знак числа " + a5);
        isPositive(a5);
        printNextTaskLine();

        // Проверка задания 6
        printTaskNumber(6);
        int a6 = 1;
        printTaskMsg("Проверка, что число " + a6 + " отрицательное.\n" +
                "Если возвращено true, тогда число отрицательное, иначе false.");
        System.out.println(isNegative(a6));
        printNextTaskLine();

        // Проверка задания 7
        printTaskNumber(7);
        printTaskMsg("Приветствие");
        greeting("Петр");
        printNextTaskLine();

        // Проверка задания 8
        printTaskNumber(8);
        printTaskMsg("Проверка 5 случайных года на високостность");
        for (int i = 1; i <= 5; i++) {
            int year = (int) (Math.random() * 2000);
            System.out.println("--------------- " +
                    "проверка года " +
                    year +
                    " на високостность" +
                    ", итерация №" + i +
                    " ---------------");
            yearIsLeapByCondition(year);
            printNextTaskLine();
        }
    }

    /*
     * 2. Создать переменные всех пройденных типов данных,
     * и инициализировать их значения;
     */
    private static byte aByte = -128;
    private static short aShort = 3267;
    private static int aInt = 2147483647;
    private static long aLong = 9223372036854775807L;
    private static float aFloat = 9223372036854775807.000f;
    private static double aDouble = 9223372036854775807.000d;
    private static char aChar1 = 'W';
    private static char aChar2 = '\u0057'; // Символ "W"
    private static boolean trueBoolean = true;
    private static boolean falseBoolean = false;
    private static String aString = "aString";

    /*
     * 3. Написать метод вычисляющий выражение a * (b + (c / d))
     * и возвращающий результат, где a, b, c, d – входные параметры этого метода;
     */
    public static double calculateExpression(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    /*
     * 4. Написать метод, принимающий на вход два числа,
     * и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
     * если да – вернуть true, в противном случае – false;
     */
    public static boolean isSumInBetweenTenAndTwenty(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    /*
     * 5. Написать метод, которому в качестве параметра передается целое число,
     * метод должен напечатать в консоль положительное ли число передали,
     * или отрицательное;
     * Замечание: ноль считаем положительным числом.
     */
    public static void isPositive(int a) {
        System.out.println("Число " + a + (a < 0 ? " отрицательное" : " положительное"));
    }

    /*
     * 6. Написать метод,
     * которому в качестве параметра передается целое число,
     * метод должен вернуть true, если число отрицательное;
     */
    public static boolean isNegative(int a) {
        return a < 0;
    }

    /*
     * 7. Написать метод,
     * которому в качестве параметра передается строка,
     * обозначающая имя,
     * метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     */
    public static void greeting(String yourName) {
        System.out.println("Привет, " + yourName);
    }

    /*
     * 8. * Написать метод,
     * который определяет является ли год високосным,
     * и выводит сообщение в консоль.
     * Каждый 4-й год является високосным,
     * кроме каждого 100-го,
     * при этом каждый 400-й – високосный.
     */
    public static void yearIsLeapByCondition(int year) {
        String msg = year + " год, високостный";

        if ((year % 4) == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                msg = year + " год, не високостный";
            }
        } else {
            msg = year + " год, не високостный";
        }

        System.out.println(msg);
    }

    public static void printTaskNumber(int taskNum) {
        System.out.println("Задание № " + taskNum);
    }

    public static void printTaskMsg(String taskMsg) {
        System.out.println(taskMsg);
    }

    private static void printNextTaskLine() {
        System.out.println("--------------------------------\n");
    }

}
