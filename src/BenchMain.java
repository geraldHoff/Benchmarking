import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Timer;

/**
 * Advanced Data Structures Java
 * Gerald Hoff
 * PA1 BenchMarking
 * 9/17/2020
 * Read oracle documentation for fileChooser and Timer Class.
 */

public class BenchMain {
    public static void main(String[] args) throws FileNotFoundException {

        //set new file to user chosen file
        File input = getFile();
        assert input != null;

        long start = System.currentTimeMillis();
        LinkedList<Integer> list = createList(input);
        long stop = System.currentTimeMillis();
        System.out.println("Completed reading and sorting to list in " + (stop - start) + " milliseconds.");

        assert list != null;

        System.out.println("peek: " + list.peek());

        //print the list
        printIntLinkedList(list);
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
     * @throws FileNotFoundException, if the file is missing.
     */
    static LinkedList<Integer> createList(File input) throws FileNotFoundException {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner inputScanner = new Scanner(input);

        //check if has int
        if (inputScanner.hasNextInt()) {

            //put the first value onto the begining of the list.
            list.add(inputScanner.nextInt());

            //until all values of the file have been read,
            while (inputScanner.hasNextInt()) {

                ListIterator<Integer> listIterator = list.listIterator();

                int current = inputScanner.nextInt();

                //if succeeded in adding current int.
                boolean success = false;

                //sort ints as inserted
                for (int i = 0; i < list.size(); i++){
                    if (listIterator.next() > current){
                        list.add(i, current);
                        success = true;
                        break;
                    }
                }
                //if there was no larger value, add to end.
                if (!success){
                    list.add(list.size(), current);
                }
            }
            return list;
        }
        return null;
    }

    /**
     * Uses a ListIterator to print the list.
     * Useful for debugging.
     * @param list The LinkedList with values to be printed.
     */
    static void printIntLinkedList(LinkedList<Integer> list){
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
