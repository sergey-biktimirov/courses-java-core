package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game;

import java.util.Arrays;

public class Cell {
    /**
     * Ссылка на поле
     */
    Field field;
    /**
     * Ссылка левую ячейку
     */
    private Cell leftCell;
    /**
     * Ссылка на верхнюю ячейку
     */
    private Cell topCell;
    /**
     * Ссылка нижнюю ячейку
     */
    private Cell bottomCell;
    /**
     * Ссылка на правую ячейку
     */
    private Cell rightCell;
    /**
     * Текущее положение ячейки по осям x и y.
     * По умолчанию -1, не задано.
     */
    int x, y;

    /**
     * Числовое значение ячейки
     * 0, ячейка пустая
     * 1, в ячейке нолик
     * 2, в ячейке крестик
     */
    private int value = 0;

    /**
     * Главный конструктор
     *
     * @param field Ссылка на поле в котором находится ячейка
     * @param x     Координата по оси x
     * @param y     Координата по оси y
     */
    public Cell(Field field, int x, int y) {
        this.field = field;
        this.x = x;
        this.y = y;
    }

    /**
     * Обзор ячеек вокруг текущей
     */
    private void lookAround() {
        leftCell = x - 1 >= 0 ? field.cellList[y][x - 1] : null;

        rightCell = x + 1 < field.width ? field.cellList[y][x + 1] : null;

        topCell = y - 1 >= 0 ? field.cellList[y - 1][x] : null;

        bottomCell = y + 1 < field.height ? field.cellList[y + 1][x] : null;
    }

    public void setValue(int value) {
        this.value = value;
        lookAround();
        findWinner();
    }

    public int getValue() {
        return value;
    }

    private void findWinner() {
        int[][] cells = getAroundCellsValues(this);
        System.out.println("");
        for (int[] cell : cells) {
            System.out.println(Arrays.toString(cell));
        }

        // Счетчик занятых ячеек для подсчета победы, снизу в верх.
        int winScoreFromTopToBottom = 0;
        // Счетчик занятых ячеек для подсчета победы, слева на право.
        int winScoreFromLeftToRight = 0;
        // Счетчик занятых ячеек для подсчета победы, снизу слева на вверх вправо.
        int winScoreFromLeftTopToBottomRight = 0;
        // Счетчик занятых ячеек для подсчета победы, снизу справа на вверх влево.
        int winScoreFromRightTopToBottomLeft = 0;

        for (int i = 0; i < cells.length; i++) {
            // Если началась новая строка, тогда сброс счета с лево на право, на ноль
            winScoreFromLeftToRight = 0;

            for (int j = 0; j < cells.length; j++) {
                // Счет слева на право, если текущее значение ячейки равно значению ячейки поля, тогда +1,
                // иначе сброс счета на 0
                winScoreFromLeftToRight = cells[i][j] == value ? winScoreFromLeftToRight += 1 : 0;
                // Счет сверху в низ, если новый столбец, тогда счетчик сбрасывается на 0
                winScoreFromTopToBottom = j == 0 ? 0 : winScoreFromTopToBottom;
                // Счет сверху в низ, если текущее значение ячейки равно значению ячейки поля, тогда +1,
                // иначе сброс счета на 0
                winScoreFromTopToBottom = cells[j][i] == value ? winScoreFromTopToBottom += 1 : 0;

                if (winScoreFromTopToBottom == 3 || winScoreFromLeftToRight == 3) {
                    setWinner();
                    break;
                }
            }

            // Счет сверху слева к низ справа, если текущее значение ячейки равно значению ячейки поля, тогда +1,
            // иначе сброс счета на 0
            winScoreFromLeftTopToBottomRight = cells[i][i] == value ? winScoreFromLeftTopToBottomRight += 1 : 0;
            // Счет сверху справа к низ слева, если текущее значение ячейки равно значению ячейки поля, тогда +1,
            // иначе сброс счета на 0
            winScoreFromRightTopToBottomLeft = cells[cells.length - 1 - i][i] == value ? winScoreFromRightTopToBottomLeft += 1 : 0;

            if (winScoreFromLeftTopToBottomRight == 3 || winScoreFromRightTopToBottomLeft == 3) {
                setWinner();
                break;
            }
        }
    }

    private void setWinner() {
        field.winner = value;
        field.isGameOver = true;
        field.isHadWinner = true;
    }

    private int[][] getAroundCellsValues(Cell cell) {
        return new int[][]{
                /*+ 2 от текущей*/
                {
                        getTopCell().getTopCell().getLeftCell().getLeftCell().value,
                        getTopCell().getTopCell().getLeftCell().value,
                        getTopCell().getTopCell().value,
                        getTopCell().getTopCell().getRightCell().value,
                        getTopCell().getTopCell().getRightCell().getRightCell().value
                },
                /*+ 1 от текущей*/
                {
                        getTopCell().getLeftCell().getLeftCell().value,
                        getTopCell().getLeftCell().value,
                        getTopCell().value,
                        getTopCell().getRightCell().value,
                        getTopCell().getRightCell().getRightCell().value
                },
                /*+ 0 от текущей*/
                {
                        getLeftCell().getLeftCell().value,
                        getLeftCell().value,
                        value,
                        getRightCell().value,
                        getRightCell().getRightCell().value
                },
                /*- 1 от текущей*/
                {
                        getBottomCell().getLeftCell().getLeftCell().value,
                        getBottomCell().getLeftCell().value,
                        getBottomCell().value,
                        getBottomCell().getRightCell().value,
                        getBottomCell().getRightCell().getRightCell().value
                },
                /*- 2 от текущей*/
                {
                        getBottomCell().getBottomCell().getLeftCell().getLeftCell().value,
                        getBottomCell().getBottomCell().getLeftCell().value,
                        getBottomCell().getBottomCell().value,
                        getBottomCell().getBottomCell().getRightCell().value,
                        getBottomCell().getBottomCell().getRightCell().getRightCell().value
                }
        };
    }


    private Cell getLeftCell() {
        int x = this.x - 1, y = this.y;
        return leftCell = checkCell(x, y) ? field.cellList[y][x] : new Cell(field, x, y);
    }

    private Cell getTopCell() {
        int x = this.x, y = this.y - 1;
        return topCell = checkCell(x, y) ? field.cellList[y][x] : new Cell(field, x, y);
    }

    private Cell getBottomCell() {
        int x = this.x, y = this.y + 1;
        return bottomCell = checkCell(x, y) ? field.cellList[y][x] : new Cell(field, x, y);
    }

    private Cell getRightCell() {
        int x = this.x + 1, y = this.y;
        return rightCell = checkCell(x, y) ? field.cellList[y][x] : new Cell(field, x, y);
    }

    /**
     * Проверка того, что заданные координаты не выходят за пределы массива.
     *
     * @param x - Координата по оси x
     * @param y - Координата по оси y
     * @return boolean - true - ячейка не выходит за приделы массива, иначе false.
     */
    private boolean checkCell(int x, int y) {
        boolean b = true;
        try {
            field.checkXCoordinate(x);
            field.checkYCoordinate(y);
        } catch (Exception e) {
            b = false;
        }
        return b;
    }
}
