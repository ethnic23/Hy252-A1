package A13;
import javafx.stage.FileChooser;

import javax.swing.JFileChooser;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static A12.MagicSquareChecker.checkIsMagic;
import static A12.MagicSquareChecker.getMagicNumber;

public class MagicSquareCheckerFromFile extends Component {
    public void main(String[] args) throws IOException {
        int i=0,j=0, count =0;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a file:");
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filepath = file.getAbsolutePath();
            System.out.println("The path of the selected file is: " + filepath);
            Scanner scanner = new Scanner(file);

            Path path = Paths.get(filepath);
            int lines =0;
            lines = (int) Files.lines(path).count();
            int[][] Sqr= new int[lines][lines];

            while (scanner.hasNextLine()){
                 scanner.nextInt();
                 count++;
            }

            if(count<lines||count>lines){
                System.out.println("wrong count of numbers in a line");
                System.exit(10);
            }
            for(i=0;i<lines;i++){
                for(j=0;j<lines;j++){
                    Sqr[i][j]= scanner.nextInt();
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

            if (checkIsMagic(Sqr)) {
                int M_num = getMagicNumber(Sqr);
                    JFileChooser chooser = new JFileChooser();
                    chooser.setCurrentDirectory(new java.io.File("."));
                    chooser.setDialogTitle("Choose Folder to put file:");
                    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                   File file1 = new File(chooser.getCurrentDirectory()+"/MagicSquareSavedFile.txt");
                    try {
                        FileReader fr = new FileReader(file);
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
                    writer.append("\"The square is magic and the magic element is: \"+M_num");
                }
            } else {
                System.out.println("The square isn't magic because at least one of the sums isn't equal to the others!");
            }

            scanner.close();
        }
    }

}