package org.example.dataStructure_01;

/*
스페이스로 띄어쓰기 된 단어들의 리스트가 주어질때, 단어들을 반대 순서로 뒤집어라.
각 라인은 w개의 영단어로 이루어져 있으며, 총 L개의 알파벳을 가진다.
각 행은 알파벳과 스페이스로만 이루어져 있다. 단어 사이에는 하나의 스페이스만 들어간다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[][] lines = new String[n][];
        for (int i=0 ; i<n ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            ArrayList<String> tokenList = new ArrayList<>();

            while (st.hasMoreElements()){
                tokenList.add(st.nextToken());
            }

            Collections.reverse(tokenList);


            lines[i] = tokenList.toArray(new String[0]);
        }

        for (int i=0 ; i<n ; i++){
            System.out.print("Case #"+ (i+1) + ": ");
            for (String l : lines[i]){
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }
}
