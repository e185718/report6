package jp.ac.uryukyu.ie.e185718;

/**
 * Solveクラス
 * int xnum; //盤のx軸の数
 * int ynum; //盤のx軸の数
 * int[][] board; //盤面のデータを保存する
 * int space; //空白=0
 * int White; //白コマ=1
 * int black; //黒コマ=2
 * int wall; //壁=3
 */
public class Osero {
    int xnum = 10;
    int ynum = 10;
    public int[][] board = new int[xnum][ynum];
    int space = 0;
    int white = 1;
    int black = 2;
    int wall = 3;

    /**
     * 初期盤面を準備する
     */
    public void prepare() {
        for (int x = 0; x < xnum; x++) {
            for (int y = 0; y < ynum; y++) {
                board[x][y] = space;
            }
        }
        for (int x = 0; x < xnum; x++) {
            board[x][0] = wall;
            board[x][9] = wall;
        }
        for (int y = 0; y < ynum; y++) {
            board[0][y] = black;
            board[9][y] = black;

        }
        board[4][4] = white;
        board[5][5] = white;
        board[4][5] = black;
        board[5][4] = black;
    }
}


