package jp.ac.uryukyu.ie.e185718;

public class Main {
    public static void main(String[] args) {
        System.out.println("オセロを開始します");
        Osero osero = new Osero(1);
        osero.play();
        System.out.println("オセロを終了します");
    }

}