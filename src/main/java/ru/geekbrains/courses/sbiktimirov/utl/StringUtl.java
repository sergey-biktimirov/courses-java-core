package ru.geekbrains.courses.sbiktimirov.utl;

public class StringUtl {

    /**
     * Возвращает множественной представление числа
     *
     * @param number - число
     * @param p1     - представление числа 1
     *               пример: 1 килограмм
     * @param p2     - представление чисел от 2 по 4
     *               пример: 3 килограмма
     * @param p3     - представление чисел от 5 по 19, и 0
     *               пример: 0 килограммов
     * @return - представление числа
     */
    public static String getMeterWord(int number, String p1, String p2, String p3) {
        String msg = "";
        int chkNum = Math.abs(number);
        for (int i = String.valueOf(number).length() - 1; i > 0; i--) {
            int d = Integer.parseInt("1" + "0".repeat(i));
            chkNum = chkNum % d;
        }
        if (chkNum == 1){
            msg = p1;
        } else if (chkNum >= 2 && chkNum <= 4) {
            msg = p2;
        } else if (chkNum >= 5 && chkNum <= 19 || chkNum == 0) {
            msg = p3;
        }
        return msg;
    }
}
