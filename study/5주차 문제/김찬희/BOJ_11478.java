package study.5주차 문제.김찬희;

public class BOJ_11478 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Set<String> set = new HashSet<>();

        int step = 1;

        while(step <= str.length()) {
            for(int i=0; i<str.length()-step+1; i++) {
                set.add(str.substring(i, i+step));
            }
            step++;
        }

        System.out.println(set.size());
        scanner.close();
    }
}
