import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BenchMain {
    public static void main(String[] args) throws FileNotFoundException {

        //set new File to user chosen file
        File input = getFile();

        assert input != null;
        Scanner inputScanner = new Scanner(input);

        System.out.println(inputScanner.next());
        System.out.println(inputScanner.next());
        System.out.println(inputScanner.next());
        System.out.println(inputScanner.next());
        System.out.println(inputScanner.next());
        System.out.println(inputScanner.next());
    }

    /**
     * Creates a JFileChooser GUI that returns that user selected file.
     * @return
     */
    public static File getFile(){

        //create button and chooser objects.
        JButton button = new JButton();
        JFileChooser fileChooser = new JFileChooser();

        //specify the attributes of the JFileChooser
        fileChooser.setDialogTitle("Text File Selector");
        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //launch GUI and return file.
        if (fileChooser.showOpenDialog(button) == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile();
        }
        return null;
    }
}
