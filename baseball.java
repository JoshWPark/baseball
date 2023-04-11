package BaseBall;

import java.security.SecureRandom;
import java.util.Scanner;

public class baseball {
    // 필드 값
    int[] num = new int[3]; // 컴퓨터가 생성한 랜덤 숫자
    String result;          // checkNum 함수에서 받아올 String 값
    int count = 0;          // 추측 횟수 세어주는 카운터
    int countLimit;     // 추측 횟수 제한


    public baseball(int countLimit){
        this.countLimit = countLimit;
    }
    // 초기 설정
    public void generateRandomNum() {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 3; i++) {
            this.num[i] = random.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (this.num[j] == this.num[i]) {
                    i--;
                }
            }
        }
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요! 총 " + countLimit +"번의 기회!");
    }

    public void startGame(){
        Scanner sc = new Scanner(System.in);
        while (count<countLimit) {           // flag 가 true 가 될때 까지 프로그램 무한 반복
            System.out.print(count + 1 + "번째 시도 : ");
            int guess = sc.nextInt();
            this.result = checkNum(guess);
            System.out.println(result);
            this.count++;        // 추측 횟수 올려주기
            if (result.equals("3S0B")) {      // 추측이 맞으면 몇번째에 맞추었는지 표시 후 flag == true 해서 반복문 종료
                System.out.println(count + 1 + "번만에 맞히셨습니다.");
                break;
            }
            if (countLimit-count==1){
                System.out.println("마지막 기회 입니다!");
            }
            if (count==countLimit){
                System.out.println("실패하셨습니다. 조금 더 강해져서 돌아오세요");
            }
        }
        System.out.println("게임을 종료합니다.");
    }

    // 사용자의 추측이 맞는지 확인하는 함수
    private String checkNum(int x) {
        int[] temp = new int[3];
        int strike = 0;
        int ball = 0;
        // 사용자 입력 값을 컴퓨터 랜덤 값과 비교하기 위해 배열에 넣기
        for (int i = temp.length - 1; i >= 0; i--) {
            temp[i] = x % 10;
            x = x / 10;
        }
        //Strike, Ball 학인하기
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (temp[i] == this.num[j]) {  // 숫자가 랜덤 값에 포함되어있으면 Ball + 1
                    ball++;
                }
            }
            if (temp[i] == this.num[i]) {       // 숫자가 맞는 자리에 있으면 Strike + 1, Ball - 1
                strike++;
                ball--;
            }
        }
        return strike + "S" + ball + "B";
    }
}
