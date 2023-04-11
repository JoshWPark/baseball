package BaseBall;
import java.security.SecureRandom;

public class Generator {
    int size;
    public Generator(int size){
        this.size = size;
    }

    public int[] generateRandomNum(int [] num) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < size; i++) {
            num[i] = random.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (num[j] == num[i]) {
                    i--;
                }
            }
        }
        return num;
    }
}

