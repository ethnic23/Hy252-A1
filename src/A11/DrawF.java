package A11;

import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

public class DrawF {
    public static void main(String[] args) throws Exception {
        String M=args[0];
        int L=Integer.parseInt(args[1]);
        while(L>=3&&L<=20) {
            Scanner in = new Scanner(System.in);

            if (M.equals("w") ){
                L = Integer.parseInt(JOptionPane.showInputDialog("Dwse enan ari8mo gia to L:",3));
            } else {
                System.out.println("Give an integer for L: ");
                L = in.nextInt();
            }
            if (M.equals("c")&&M.equals("w")&&M.equals("f")&&M.equals("g")) {
                throw new Exception("Not permitted input for M");
            } else if (L < 3 || L > 20) {
                throw new Exception("Not permitted input for L");
            }

            if (M.equals("c")) {
                console(L);
            } else if (M.equals("w")) {
                window(L);
            } else if (M.equals("f")) {
                file(L);
            } else if (M.equals("g")) {
                graphics(L);
            }
        }
    }

    private static void console(int L) {
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
    private static void window(int L) {
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
    private static void file(int L) throws FileNotFoundException, UnsupportedEncodingException {
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
    private static void graphics(int L){
        Frame f = new Frame("Zwgrafizontas to F"){
            public void paint (Graphics g){
                Graphics2D g2 = (Graphics2D) g;
                g2.draw(new Line2D.Double(50,30,30,50+L*10));
                g2.draw(new QuadCurve2D.Double(30,50,30,70,40+L*5,50));
                g2.draw(new QuadCurve2D.Double(20,100,40,120,40+L*5,90));
            }

        };
        f.setSize(400,400);
        f.setVisible(true);
    }
}