package BaseBall;

import java.util.Scanner;

public class Menu {


    public void showMenu(){
        System.out.println("BaseBall Game!");
        System.out.println("1. 게임 시작");
        System.out.println("2. 기회 횟수 바꾸기");
        System.out.println("3. 종료");
    }

    public int getChoice(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
