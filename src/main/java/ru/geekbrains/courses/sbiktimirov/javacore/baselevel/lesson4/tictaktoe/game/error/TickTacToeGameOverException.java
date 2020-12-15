package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error;

public class TickTacToeGameOverException extends Exception {
    /**
     * Победитель - 0 - Нет победителя, 1 - победитель нолик, 2 - победитель крестик
     */
    private int winner = 0;

    public TickTacToeGameOverException(String s, int winner) {
        super(s);
        this.winner = winner;
    }

    /**
     * Возвращает номер победителя
     *
     * @return int - 0 - Нет победителя, 1 - победитель нолик, 2 - победитель крестик
     */
    public int getWinner() {
        return winner;
    }
}
