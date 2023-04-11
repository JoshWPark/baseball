package BaseBall;

public class Checker {
    int size;
    int[] temp;
    int strike;
    int ball;
    public Checker (int size){
        this.size = size;
    }

    // 사용자의 추측이 맞는지 확인하는 함수
    public String checkNum(int [] num, int x) {
        temp = new int[this.size];
        strike = 0;
        ball = 0;
        // 사용자 입력 값을 컴퓨터 랜덤 값과 비교하기 위해 배열에 넣기
        for (int i = temp.length - 1; i >= 0; i--) {
            temp[i] = x % 10;
            x = x / 10;
        }
        //Strike, Ball 학인하기
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (temp[i] == num[j]) {  // 숫자가 랜덤 값에 포함되어있으면 Ball + 1
                    ball++;
                }
            }
            if (temp[i] == num[i]) {       // 숫자가 맞는 자리에 있으면 Strike + 1, Ball - 1
                strike++;
                ball--;
            }
        }
        return strike + "S" + ball + "B";
    }

    public boolean checkResult(String s){
        // 추측이 맞으면 몇번째에 맞추었는지 표시 후 flag == true 해서 반복문 종료
        return s.equals("3S0B");
    }
}
