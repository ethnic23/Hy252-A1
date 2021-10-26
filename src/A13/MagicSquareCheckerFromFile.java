package A13;



import A12.MagicSquareChecker;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



public class MagicSquareCheckerFromFile extends Component {
    public static void main(String[] args) throws IOException {
        int i,j,count=0;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a file:");
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();
            String filepath = file.getAbsolutePath();
            System.out.println("The path of the selected file is: " + filepath);
            Path path = Paths.get(filepath);

            int lines;
            lines = (int) Files.lines(path).count();
            int[][] Sqr= new int[lines][lines];
            FileReader fr = new FileReader(file);

            BufferedReader lineReader = new BufferedReader(fr);
            String line;

            String[] d;
            String[] l=new String[lines];
            i=0;

            while((line=lineReader.readLine())!=null){
                Scanner scanner = new Scanner(line);
                line=scanner.nextLine();
                l[i] = line;
                d =line.split(",");
                count += d.length;

                i++;
            }

            if((count%lines)!=0){
                System.out.println("wrong count of numbers in a line");
                System.exit(10);
            }

           for(i=0;i<lines;i++){
               d = l[i].split(",");
               for(j=0;j<lines;j++){
                   Sqr[i][j] = Integer.parseInt(d[j]);
               }
           }



        for( i=0;i<lines;i++) {
            System.out.print("------------------------\n");
            for (j = 0; j < lines; j++) {
                System.out.print("|" + Sqr[i][j]);
            }
            System.out.print("|\n");
        }
        System.out.println("------------------------");

            if (MagicSqrChecker(Sqr)) {
                int M_num = Magic_num(Sqr);
                    JFileChooser chooser = new JFileChooser();
                    chooser.setCurrentDirectory(new File("."));
                    chooser.setDialogTitle("Choose Folder to put file:");
                    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                   File file1 = new File(chooser.getSelectedFile().getAbsolutePath()+"\\MagicSquareSavedFile.txt");
                    try {
                        FileWriter fw = new FileWriter(file1);
                        int c = fr.read();
                        while(c!=-1) {
                            fw.write(c);
                            c = fr.read();
                        }
                        fw.close();
                        fr.close();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                    PrintWriter writer = new PrintWriter(file1);
                    for(i=0;i<lines;i++){
                        for(j=0;j<lines;j++){
                            if(j==(lines-1)){
                                writer.print(String.valueOf(Sqr[i][j]+"\n"));
                            }else{
                                writer.print(String.valueOf(Sqr[i][j])+",");
                            }
                        }
                    }
                    writer.print("\nThe square is magic and the magic element is: "+String.valueOf(M_num));
                    writer.close();
                }
            } else {
                System.out.println("\nThe square isn't magic because at least one of the sums isn't equal to the others!");
            }


        }
        }
    private static boolean MagicSqrChecker(int[][] Sqr) {
       return MagicSquareChecker.checkIsMagic(Sqr);
    }



    private static int Magic_num(int[][] Sqr){
        return MagicSquareChecker.getMagicNumber(Sqr);
    }
}

