import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine(); // A:피로도 B:처리일 C:회복피로도 M:최대 피로도

        String[] inputArray = input.split(" ");

        int a = Integer.parseInt(inputArray[0]);
        int b = Integer.parseInt(inputArray[1]);
        int c = Integer.parseInt(inputArray[2]);
        int m = Integer.parseInt(inputArray[3]);

        int sumWork = 0; //지금까지 처리한 일
        int sumTired = 0; //현재 피로도


        for(int i = 0; i < 24; i++){   //최선의 선택을 위한 로직

            if(a > m){ //애초에 말이 안되는 경우
                System.out.print(0);
                return;
            }

            if(sumTired+a <= m){ //1.일해도 피로도가 max 넘지 않으면 일해라
                sumWork += b;
                sumTired += a;
            }else{
                sumTired -= c;
                if(sumTired < 0){
                    sumTired = 0;
                }
            }
        }

        System.out.println(sumWork);

    }
}
