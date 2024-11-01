import java.util.*;

public class PRG_17686 {
    public static String splitHead(String file) {
        int idx = 0;
        for(; idx<file.length(); idx++) if(Character.isDigit(file.charAt(idx))) break;
        return file.substring(0, idx);
    }
    
    public static String splitNumber(String file) {
        boolean isNum = false;
        int startIdx = 0;
        int endIdx = file.length();
        for(int idx=0; idx<file.length(); idx++) {
            if(!isNum && Character.isDigit(file.charAt(idx))) {
                isNum = true;
                startIdx = idx;
            } else if(isNum && (Character.isLetter(file.charAt(idx)) || file.charAt(idx) == ' ' || file.charAt(idx) == '-' || file.charAt(idx) == '.')) {
                endIdx = idx;
                break;
            }
        }
        return file.substring(startIdx, endIdx);
    }
    
    public static void swap(String[] files, int i, int j) {
        String temp = files[i];
        files[i] = files[j];
        files[j] = temp;
    }

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        Map<String, Integer> index = new HashMap<>();
        
        for(int k=0; k<files.length; k++) index.put(files[k], k);
        
        for(int i=0; i<files.length-1; i++) {
            for(int j=i+1; j<files.length; j++) {
                String head1 = splitHead(files[i]);
                String head2 = splitHead(files[j]);
                int number1 = Integer.parseInt(splitNumber(files[i]));
                int number2 = Integer.parseInt(splitNumber(files[j]));
                
                if(head1.compareToIgnoreCase(head2) > 0 ||
                    (head1.compareToIgnoreCase(head2) == 0 && number1 > number2) ||
                    (head1.compareToIgnoreCase(head2) == 0 && number1 == number2 && index.get(files[i]) > index.get(files[j]))) {
                    swap(files, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(files));
    }
}
