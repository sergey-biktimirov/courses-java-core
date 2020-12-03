package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson3;

import java.io.InputStream;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        ConsoleGame game = new ConsoleGame(System.in);
        game.start();
    }
}

class ConsoleGame extends Game {

    Scanner scanner;

    public ConsoleGame(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    String quitCommandHelpMessage = "/q для выхода из игры";
    String newGameCommandHelpMessage = "/n для начала новой игры";
    String promptCommandMessage = "/p для подсказки";

    public String commandHelpMessage() {
        return String.format("Введите: %s%n" +
                "         %s%n" +
                "         %s", quitCommandHelpMessage, newGameCommandHelpMessage, promptCommandMessage);
    }

    public String winnerMessage() {
        return String.format("Введите: %s%n" +
                "         %s%n", quitCommandHelpMessage, newGameCommandHelpMessage);
    }

    public void consoleWelcomeMassage() {
        System.out.printf("%s%n%s%n", super.name, commandHelpMessage());
    }

    public void consolePrintWords() {
        System.out.println(wordListAsString());
    }

    public void start() {
        consoleWelcomeMassage();
        System.out.println(super.guessMessage());
        consolePrintWords();
        consoleNewGame();
    }

    public void consoleNewGame() {
        super.newGame();
        loop:
        while (scanner.hasNext()) {
            String inStr = scanner.next().toLowerCase();
            switch (inStr) {
                case "/q":
                    break loop;
                case "/n":
                    start();
                    break loop;
                case "/p":
                    System.out.println(super.prompt());
                    break;
                default:
                    super.checkWord(inStr);
                    if (super.isWin) {
                        System.out.println("Вы угадали!");
                        System.out.println(winnerMessage());
                    } else {
                        System.out.println(super.checkedWord);
                    }
            }
        }
    }
}

class Game {

    String name = "Приветствуем вас в игре \"Отгадай слово\"\n";

    String[] wordsList = {"apple", "orange", "lemon",
            "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape",
            "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    char[] guessWord;
    char[] checkedWord;
    boolean isWin = false;
    int maxWordLength = 15;
    int guessMinIdx;
    int guessMaxIdx;
    int maxIdx = wordsList.length - 1;

    public void newGame() {
        maxIdx = wordsList.length - 1;
        checkedWord = new char[maxWordLength];
        isWin = false;
        for (int i = 0; i < maxWordLength; i++) {
            checkedWord[i] = '#';
        }
        guessTheWord();
    }

    public String wordListAsString() {
        int digitSize = String.valueOf(wordsList.length).length();
        StringBuilder words = new StringBuilder();
        for (int i = 0; i < maxIdx; i++) {
            words.append(String.format("%" + digitSize + "d: %s%n", i + 1, wordsList[i]));
        }
        return words.toString();
    }

    public void guessTheWord() {
        guessMaxIdx = nextRandomInt(maxIdx);
        guessMinIdx = nextRandomInt(guessMaxIdx);
        guessWord = wordsList[nextRandomInt(guessMinIdx, guessMaxIdx)].toCharArray();
    }

    public int nextRandomInt(int max) {
        return (int) (Math.random() * (max + 1));
    }

    public int nextRandomInt(int min, int max) {
        return (int) (Math.random() * (max + 1 - (min)) + (min));
    }

    public String guessMessage() {
        return "Отгадайте одно из загаданных слов: ";
    }

    public String prompt() {
        return String.format("Загаданное слово находится между %d и %d", guessMinIdx + 1, guessMaxIdx + 1);
    }

    public void checkWord(String word) {
        isWin = word.equals(String.valueOf(guessWord));
        if (isWin) {
            checkedWord = guessWord;
        } else {
            char[] wordArr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                if (wordArr[i] == guessWord[i]) {
                    checkedWord[i] = wordArr[i];
                } else {
                    break;
                }
            }
        }
    }
}
