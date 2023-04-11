package BaseBall;

import java.util.Scanner;

public class Baseball {
    // 필드 값
    protected int[] num = new int[3]; // 컴퓨터가 생성한 랜덤 숫자
    private boolean flag = true;
    private int count = 0;          // 추측 횟수 세어주는 카운터
    private int countLimit;     // 추측 횟수 제한

    protected Generator randomGenerator  = new Generator(3);
    protected Checker guessChecker  = new Checker(3);
    protected Menu mainMenu = new Menu();
    protected Scanner sc = new Scanner(System.in);
    public Baseball(int countLimit){
        this.countLimit = countLimit;
    }

    public int getCountLimit(){
        return countLimit;
    }
    public void setCountLimit(int countLimit){
        this.countLimit = countLimit;
    }

    public void run(){
        while(flag){
            mainMenu.showMenu();
            int choice = mainMenu.getChoice();
            switch (choice){
                case 1:
                    initialize();
                    System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요! 총 " + countLimit +"번의 기회!");
                    startGame();
                    System.out.println("메뉴로 다시 돌아갑니다.");
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("현재 기회 횟수: " + getCountLimit());
                    System.out.print("새로운 기회 횟수: ");
                    int x = sc.nextInt();
                    setCountLimit(x);
                    System.out.println("기회 횟수를 " + x+ "로 바꾸셨습니다.");
                    System.out.println();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("bye");
                    flag = false;
                    break;
                default:
                    System.out.println("Choose between 1,2,3");
                    System.out.println();
                    System.out.println();
                    break;
            }
        }

    }

    // 초기 설정
    private void initialize(){
        //게임 시작하기
        this.num = randomGenerator.generateRandomNum(num);
    }

    private void startGame(){
        String result;          // checkNum 함수에서 받아올 String 값
        while (count<countLimit) {           // flag 가 true 가 될때 까지 프로그램 무한 반복
            System.out.print(count + 1 + "번째 시도 : ");
            int guess = sc.nextInt();
            result = guessChecker.checkNum(num, guess);
            System.out.println(result);
            this.count++;        // 추측 횟수 올려주기
            if (guessChecker.checkResult(result)) {      // 추측이 맞으면 몇번째에 맞추었는지 표시 후 flag == true 해서 반복문 종료
                System.out.println(count + 1 + "번만에 맞히셨습니다.");
                break;
            } else {
                if (countLimit-count==1){
                    System.out.println("마지막 기회 입니다!");
                }
                if (count==countLimit){
                    System.out.println("실패하셨습니다. 조금 더 강해져서 돌아오세요");
                }
            }
        }
    }

}
