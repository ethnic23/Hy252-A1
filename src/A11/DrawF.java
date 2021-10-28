package A11;

import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;

public class DrawF {
    public static void main(String[] args) throws Exception {
        char M;
        int L;
        Scanner in = new Scanner(System.in);

        System.out.println("Give a character for M: ");
        M = in.next().charAt(0);
        System.out.println("Give an integer for L: ");
        L = in.nextInt();

        if ((M != 'c') && (M != 'w') && (M != 'f') && (M != 'g')) {
            throw new Exception("Not permitted input for M");
        } else if (L < 3 || L > 20) {
            throw new Exception("Not permitted input for L");
        }
        if (M == 'c') {
            console(M, L);
        } else if (M == 'w') {
            window(M, L);
        }else if(M =='f'){
            file(M,L);
        }
    }

    private static void console(char M, int L) {
        String ast = "*";
        for (int i = 0; i < L; i++) {
            if (i == 0) {
                for (int j = 0; j < L; j++) {
                    System.out.print(ast);
                }
                System.out.print("\n");
            } else if (i == ((L * 3) / 4) - 1) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(ast);
                }
                System.out.print("\n");
            } else {
                System.out.println(ast);
            }

        }
    }
    private static void window(char M,int L) {
        String ast = "*";
        String str = "";
        for (int i = 0; i < L; i++) {
            if (i == 0) {
                for (int j = 0; j < L; j++) {
                    str = str + ast;
                }
                str += "\n";
            } else if (i == ((L * 3) / 4) - 1) {
                for (int j = 0; j <= i; j++) {
                    str += ast;
                }
                str += "\n";
            } else {
                str += ast + "\n";
            }
        }
        JOptionPane.showMessageDialog(null,str,"Παραθυρο Εξοδου",JOptionPane.INFORMATION_MESSAGE);
    }
    private static void file(char M,int L) throws FileNotFoundException, UnsupportedEncodingException {
        try {
            File Ffile = new File("C:\\temp\\F.html");
            String data = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\"/>\n" +
                    "</head>\n" +
                    "<body><font size="+L+">F with font size ="+L+"</font></body>\n" +
                    "</html>";
            PrintWriter writer =new PrintWriter(Ffile);
            writer.write(data);
            writer.close();
        }catch(Exception e){
            System.out.println("Problem: "+e);
        }

    }
    private static void graphics(char M,int L){

    }
}