package jp.ac.uryukyu.ie.e185718;

import java.util.Scanner;

/**
 * Solveクラス
 * int xnum; //盤のx軸の数
 * int ynum; //盤のx軸の数
 * int[][] board; //盤面のデータを保存する
 * int space; //空白=0
 * int White; //白コマ=1
 * int black; //黒コマ=2
 * int wall; //壁=3
 * int turn; //コマを置くプレイヤー
 */
public class Osero {
    int xnum = 10;
    int ynum = 10;
    public int[][] board = new int[xnum][ynum];
    int space = 0;
    int white = 1;
    int black = 2;
    int wall = 3;
    int turn;
    int che[][] = {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};
    Scanner sc = new Scanner(System.in);

    /**
     * 初期盤面を準備するメソッド
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

    /**
     * オセロ盤面を表示する
     */
    public void show() {
        System.out.println("    1  2  3  4  5  6  7  8  x");
        for (int y = 0; y < ynum; y++) {
            System.out.print(y);
            for (int x = 0; x < xnum; x++) {
                if (board[x][y] == white) {
                    System.out.print("● |");
                } else if (board[x][y] == black) {
                    System.out.print("◯ |");
                } else if (board[x][y] == wall) {
                    System.out.print(" ＊");
                } else {
                    System.out.print("  |");
                }
            }
            System.out.println();
            System.out.println("　 +--+--+--+--+--+--+--+--+");
        }
        System.out.println("y");
        System.out.println();
    }

    /**
     * コマをセットするメソッド
     * @param x　x軸
     * @param y　y軸
     * @param koma　コマの種類
     */
    public void koma_set(int x, int y, int koma) {
        board[x][y] = koma;
    }

    /**
     * コマを置くプレイヤーを決める
     */
    public void turn_play() {
        turn = 3 - turn;
        if (turn == 2) {
            System.out.println("黒の番");

        } else {
            System.out.println("白の番");
        }
    }

    /**
     * コマを入力してそこに置けるかどうかチェックする
     */
    public void koma_check() {
        int d = 0;
        while (d == 0) {
            System.out.print("xを入力：");
            int s = sc.nextInt();
            System.out.print("yを入力：");
            int c = sc.nextInt();
            if (board[s][c] != space) {
                System.out.println("ここには置けません");
                continue;
            }
            for (int i = 0; i < che.length; i++) {
                int a=0,b=0,h,g,f=0;
                h = che[i][0];
                g = che[i][1];
                while (true) {
                    a += che[i][0];
                    b += che[i][1];
                    f += 1;
                    if (board[s + a][c + b] == 3 - turn) {
                        if (board[s + a + h][c + b + g] == turn) {
                            for(int j=0;j <= f;j++) {
                                koma_set(s + j*h,c + j*g, turn);
                            }
                            show();
                            d += 1;
                            break;

                        }else if (board[s + a + h][c + b + g] == 3 - turn){
                            continue;
                        }
                    }else {
                        break;
                    }
                }
            }
            if (d == 0) {
                System.out.println("ここには置けません");
            }
        }
        System.out.println("ターン終了");
    }
}




