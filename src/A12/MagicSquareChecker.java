package A12;

import java.io.PrintWriter;
import java.util.Scanner;

public class MagicSquareChecker{
    public static void main(String[] args){
        int[][] s;
        int n = 0;
        Scanner in = new Scanner(System.in);
        while (n<2||n>10){
            System.out.println("Give an n");
            n = in.nextInt();
        }
        s = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                s[i][j] = in.nextInt();
            }
        }
       for(int i=0;i<n;i++) {
           System.out.print("------------------------\n");
           for (int j = 0; j < n; j++) {
               System.out.print("|" + s[i][j]);
           }
           System.out.print("|\n");
       }
       System.out.println("------------------------");
       if(hasDuplicates(s)){
           System.out.print("The numbers you gave contain duplicates\n");
           System.out.print("The square isn't magic!");
       }else {
           if (checkIsMagic(s)) {
               int M_num = getMagicNumber(s);
               System.out.println("The square is magic and the magic element is: "+M_num);
           } else {
                System.out.println("The square isn't magic because at least one of the sums isn't equal to the others!");
           }
       }
    }
    private static int sumOfRow(int[][] s,int k){
        int sum=0;
        for(int j=0;j<s.length;j++){
            sum+=s[k][j];
        }
        return sum;
    }
    private static int sumOfColumn (int[][] s,int k){
        int sum=0;
        for(int i=0;i<s.length;i++){
            sum+=s[i][k];
        }
        return sum;
    }
    private static int sumOfDiagonal1(int[][] s){
        int sum=0;
        for(int i=0;i<s.length;i++){
            sum+=s[i][i];
        }
        return sum;
    }
    private static int sumOfDiagonal2(int[][] s){
        int sum=0;
        for(int i=0;i<s.length;i++){
            for(int j=0;j<s.length;j++){
                if((i+j)==(s.length-1)){
                    sum+=s[i][j];
                }
            }
        }
        return sum;
    }
    public static int getMagicNumber(int[][] s){
        return sumOfRow(s,0);
    }
    private static boolean hasDuplicates(int[][] s){
        boolean d = false;
        for(int k=0;k<s.length;k++){
            for(int l=0;l<s.length;l++){
                for(int i=0;i<s.length;i++){
                    for(int j=0;j<s.length;j++){
                        if((s[k][l]==s[i][j]) && i!=k && j!=l){
                            d=true;
                            break;
                        }
                    }
                }
            }
        }
        return d;
    }
    public static boolean checkIsMagic(int[][] s){
        boolean Magic =false;
        int SR=0,SC=0,SD1,SD2;
        for(int i=0;i<s.length;i++){
            SR+=sumOfRow(s,i);
            SC+=sumOfColumn(s,i);
        }
        SD1 = sumOfDiagonal1(s);
        SD2 = sumOfDiagonal2(s);

        if((SR%s.length==0)&&(SC%s.length==0)&&(SR==SC)==(SD1==SD2)){
            Magic = true;
        }
        return Magic;
    }
}