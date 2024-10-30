import java.util.ArrayList;
import java.util.List;

public class PRG_67257 {
    public static long calc(long a, long b, String op) {
        switch(op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                return 0;
        }
    }
    public static void main(String[] args) {
        final String[][] operations = {
            {"+", "-", "*"}, {"+", "*", "-"},
            {"-", "+", "*"}, {"-", "*", "+"},
            {"*", "-", "+"}, {"*", "+", "-"}
        };

        String expression = "100-200*300-500+20";
        
        long answer = 0;
        List<String> op = new ArrayList<>();
        List<Long> temp = new ArrayList<>();

        // 연산 기호 분리
        for(int idx=0; idx<expression.length(); idx++) {
            char e = expression.charAt(idx);
            if(e == '+' || e == '-' || e == '*') op.add(String.valueOf(e));
        }
        
        // 피연산자 분리
        for(String exp : expression.split("\\+|\\-|\\*")) temp.add(Long.parseLong(exp));
        
        for(String[] operation : operations) {
            List<Long> numbers = new ArrayList<>(temp);
            List<String> ops = new ArrayList<>(op);
            
            for(int i=0; i<operation.length; i++) {
                for(int j=0; j<ops.size(); j++) {
                    if(operation[i].equals(ops.get(j))) {
                        long value = calc(numbers.get(j), numbers.get(j+1), ops.get(j));
                        numbers.set(j, value);
                        numbers.remove(j+1);
                        ops.remove(j);    
                        j--;
                    }
                }
            }
            if(ops.size() > 0) numbers.set(0, calc(numbers.get(0), numbers.get(1), ops.get(0)));
            answer = Math.max(answer, Math.abs(numbers.get(0)));
        }
        System.out.println(answer);
    }
}
