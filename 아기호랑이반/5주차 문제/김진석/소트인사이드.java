import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int[] array = new int[10];
 
        while(n > 0){
            array[n % 10]++;
            n = n / 10;
        }
 
        for(int i = array.length - 1; i >= 0; i--){
            while (array[i] > 0) {
                System.out.print(i);
                array[i]--;
            }
        }
    }
}
