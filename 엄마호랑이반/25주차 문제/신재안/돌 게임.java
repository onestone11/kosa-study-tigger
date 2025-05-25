import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(n % 2 == 0 ? "CY" : "SK");
        
        return;
    }
}
