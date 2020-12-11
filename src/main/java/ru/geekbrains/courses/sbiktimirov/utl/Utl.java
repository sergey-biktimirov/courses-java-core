package ru.geekbrains.courses.sbiktimirov.utl;

import java.util.HashMap;

public class Utl {

    static String[] fullNameList = {
            "Меркушев Юстин Проклович",
            "Лебедев Донат Владленович",
            "Комаров Александр Пётрович",
            "Зуев Аввакуум Анатольевич",
            "Васильев Григорий Федотович",
            "Устинов Петр Дмитриевич",
            "Никонов Климент Дмитриевич",
            "Соколов Вячеслав Всеволодович",
            "Исаков Оскар Христофорович",
            "Королёв Артем Германович",
            "Лихачёв Мечислав Улебович",
            "Кулагин Ефим Ярославович",
            "Гусев Остап Артёмович",
            "Тарасов Денис Филиппович",
            "Ефимов Аверкий Тарасович",
            "Сорокин Максимилиан Мэлсович",
            "Белов Абрам Федосеевич",
            "Павлов Артур Егорович",
            "Чернов Устин Геннадьевич",
            "Кудрявцев Терентий Альвианович",
            "Самсонов Иван Владленович",
            "Бирюков Авраам Арсеньевич",
            "Аксёнов Соломон Робертович",
            "Селиверстов Вениамин Романович",
            "Аксёнов Ростислав Демьянович",
            "Морозов Эрнест Аристархович",
            "Гришин Самуил Евгеньевич",
            "Мухин Игорь Эльдарович",
            "Виноградов Вениамин Дмитриевич",
            "Сорокин Лавр Альвианович",
            "Сафонов Гордей Тимурович",
            "Брагин Наум Павлович",
            "Наумов Азарий Проклович",
            "Щербаков Тимофей Иринеевич",
            "Самсонов Мстислав Игнатьевич",
            "Рыбаков Лазарь Никитевич",
            "Комаров Герасим Романович",
            "Зимин Аким Глебович",
            "Блинов Ростислав Степанович",
            "Дементьев Эрик Олегович",
            "Пономарёв Арсений Аристархович",
            "Тарасов Болеслав Лаврентьевич",
            "Герасимов Исаак Михаилович",
            "Кабанов Владимир Федосеевич",
            "Ершов Демьян Михайлович",
            "Сорокин Севастьян Игоревич",
            "Кабанов Леонард Аристархович",
            "Молчанов Назарий Тихонович",
            "Пестов Владислав Митрофанович",
            "Мухин Герман Демьянович",
    };

    /**
     * Получение email из ФИО
     *
     * @param s String - Фамилия Имя Отчество
     * @return String - ИОФамилия@monetka.org
     */
    public static String getEmail(String s) {
        return String.format("%s@monetka.org", translateRU(getShortFullName(s)));
    }

    /**
     * Получение короткого ФИО
     *
     * @param s String - Фамилия Имя Отчество
     * @return String - ИОФамилия
     */
    public static String getShortFullName(String s) {
        String[] fio = s.split("\\s+");
        String f = fio.length > 0 ? fio[0] : "";
        String i = fio.length > 1 ? String.valueOf(fio[1].charAt(0)) : "";
        String o = fio.length == 3 ? String.valueOf(fio[2].charAt(0)) : "";
        return i + o + f;
    }

    /**
     * Транслит кириллицы в латиницу
     *
     * @param s String
     * @return String
     */
    public static String translateRU(String s) {
        HashMap<String, String> trMap = new HashMap<>();
        trMap.put("Ё", "YO");
        trMap.put("Й", "I");
        trMap.put("Ц", "TS");
        trMap.put("У", "U");
        trMap.put("К", "K");
        trMap.put("Е", "E");
        trMap.put("Н", "N");
        trMap.put("Г", "G");
        trMap.put("Ш", "SH");
        trMap.put("Щ", "SCH");
        trMap.put("З", "Z");
        trMap.put("Х", "H");
        trMap.put("Ъ", "'");
        trMap.put("ё", "yo");
        trMap.put("й", "i");
        trMap.put("ц", "ts");
        trMap.put("у", "u");
        trMap.put("к", "k");
        trMap.put("е", "e");
        trMap.put("н", "n");
        trMap.put("г", "g");
        trMap.put("ш", "sh");
        trMap.put("щ", "sch");
        trMap.put("з", "z");
        trMap.put("х", "h");
        trMap.put("ъ", "'");
        trMap.put("Ф", "F");
        trMap.put("Ы", "I");
        trMap.put("В", "V");
        trMap.put("А", "a");
        trMap.put("П", "P");
        trMap.put("Р", "R");
        trMap.put("О", "O");
        trMap.put("Л", "L");
        trMap.put("Д", "D");
        trMap.put("Ж", "ZH");
        trMap.put("Э", "E");
        trMap.put("ф", "f");
        trMap.put("ы", "i");
        trMap.put("в", "v");
        trMap.put("а", "a");
        trMap.put("п", "p");
        trMap.put("р", "r");
        trMap.put("о", "o");
        trMap.put("л", "l");
        trMap.put("д", "d");
        trMap.put("ж", "zh");
        trMap.put("э", "e");
        trMap.put("Я", "Ya");
        trMap.put("Ч", "CH");
        trMap.put("С", "S");
        trMap.put("М", "M");
        trMap.put("И", "I");
        trMap.put("Т", "T");
        trMap.put("Ь", "'");
        trMap.put("Б", "B");
        trMap.put("Ю", "YU");
        trMap.put("я", "ya");
        trMap.put("ч", "ch");
        trMap.put("с", "s");
        trMap.put("м", "m");
        trMap.put("и", "i");
        trMap.put("т", "t");
//        trMap.put("ь", "'");
        trMap.put("б", "b");
        trMap.put("ю", "yu");
        StringBuilder trStr = new StringBuilder();
        for (char ch : s.toCharArray()) {
            trStr.append(trMap.get(String.valueOf(ch)));
        }
        return trStr.toString();
    }

    /**
     * Получить случайное ФИО из списка
     *
     * @return String
     */
    public static String getRandomFullName() {
        return fullNameList[nextRandomInt(fullNameList.length - 1)];
    }

    /**
     * Генератор зарплаты
     *
     * @return double
     */
    public static double getRandomSalary() {
        return Math.random() * 1000000;
    }

    /**
     * Генератор целого числа
     *
     * @param max int - Максимальное значение
     * @return int
     */
    public static int nextRandomInt(int max) {
        return (int) (Math.random() * (max + 1));
    }


    /**
     * Генератор целого числа
     *
     * @param min int - Минимальное значение
     * @param max int - Максимальное значение
     * @return int
     */
    public static int nextRandomInt(int min, int max) {
        return (int) (Math.random() * (max + 1 - (min)) + (min));
    }

    /**
     * Генератор номера телефона
     *
     * @return String - +7(950)-447-53-990
     */
    public static String getRandomPhoneNumber() {
        return String.format("+7(%3s)-%3s-%2s-%3s",
                substrRight(getRandomNumber(1950, 1960), 3),
                substrRight(getRandomNumber(1000, 1999), 3),
                substrRight(getRandomNumber(100, 199), 2),
                substrRight(getRandomNumber(1000, 1999), 3)
        );
    }

    /**
     * Генератор целого числа
     *
     * @param min int - Минимальное значение
     * @param max int - Максимальное значение
     * @return String
     */
    public static String getRandomNumber(int min, int max) {
        return String.valueOf(nextRandomInt(min, max));
    }

    /**
     * Обрезает строку справа на указанную длину
     *
     * @param s   String - Входящая строка
     * @param len int - Количество символов от конца строки
     * @return String
     */
    public static String substrRight(String s, int len) {
        return s.substring(s.length() - len);

    }

    /**
     * Обрезает строку сktdf на указанную длину
     *
     * @param s   String - Входящая строка
     * @param len int - Количество символов от начала строки
     * @return String
     */
    public static String substrLeft(String s, int len) {
        return s.substring(0, len);
    }
}
