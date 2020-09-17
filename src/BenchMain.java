import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class BenchMain {
    public static void main(String[] args) throws FileNotFoundException {

        //set new file to user chosen file
        File input = getFile();
        assert input != null;

        LinkedList<Integer> list = createList(input);

        System.out.println(list.toString());
    }

    /**
     * Creates a JFileChooser GUI that returns that user selected file.
     * @return selected File
     */
    static File getFile(){

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

    /**
     * Takes a File parameter and returns a sorted linked list with the file's contents.
     * @param input The file to be read from.
     * @return LinkedList list, Integer list of the file's contents.
     * @throws FileNotFoundException
     */
    static LinkedList<Integer> createList(File input) throws FileNotFoundException {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner inputScanner = new Scanner(input);

        //check if has int
        if (inputScanner.hasNextInt()) {
            list.add(inputScanner.nextInt());

            while (inputScanner.hasNextInt()) {

                ListIterator<Integer> listIterator = list.listIterator();

                int current = inputScanner.nextInt();

                //sort ints as inserted
                for (int i = 0; i < list.size(); i++){
                    if (listIterator.next() > current){
                        list.add(i, current);
                        break;
                    }
                }

            }
            return list;
        }
        return null;
    }
}
