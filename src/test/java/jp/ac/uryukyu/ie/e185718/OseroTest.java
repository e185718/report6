package jp.ac.uryukyu.ie.e185718;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OseroTest {

    @Test
    void pass() {
        int test_turn = 2;
        Osero osero = new Osero(1);
        osero.prepare();
        osero.board[4][4] = 2;
        osero.board[5][5] = 2;
        osero.pass();
        assertEquals(test_turn,osero.turn);
    }
}