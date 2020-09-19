import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Advanced Data Structures Java
 * Gerald Hoff
 * PA1 BenchMarking
 * 9/18/2020
 * Git Repo: https://github.com/geraldHoff/Benchmarking
 */
public class BenchMain {
    public static void main(String[] args) throws FileNotFoundException {

        //Creates file for the referenced file in args.
        File input = new File(args[0]);

        //read and sort the list. Also report how long the process takes in milliseconds.
        long firstTimeStamp = System.currentTimeMillis();
        LinkedList<Integer> list = createList(input);
        long secondTimeStamp = System.currentTimeMillis();
        System.out.println(
                "Completed reading and sorting to list in " + (secondTimeStamp - firstTimeStamp) + " milliseconds."
        );

        assert list != null;   

        //find min value and report on time taken.
        firstTimeStamp = System.nanoTime();
        System.out.println("\nMinimum value: " + list.peek());
        secondTimeStamp = System.nanoTime();
        System.out.println("Found minimum value in " + (secondTimeStamp - firstTimeStamp) + " nanoseconds.");

        //find max value and report on time taken.
        firstTimeStamp = System.nanoTime();
        System.out.println("\nMaximum value: " + list.get(list.size() - 1));
        secondTimeStamp = System.nanoTime();
        System.out.println("Found maximum value in " + (secondTimeStamp - firstTimeStamp) + " nanoseconds.");

        firstTimeStamp = System.nanoTime();
        System.out.println("\nMean value:" + getMean(list));
        secondTimeStamp = System.nanoTime();
        System.out.println("Found mean value in " + (secondTimeStamp - firstTimeStamp) + " nanoseconds.");
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
     * Finds the mean value of a LinkedList.
     * @param list The LinkList of integers.
     * @return The total of the integers divided by the number of integers.
     */
    static long getMean(LinkedList<Integer> list){
        ListIterator<Integer> linkedList = list.listIterator();
        int total = 0;
        int divisor = 0;

        while(linkedList.hasNext()){
            total = total + linkedList.next();
            divisor++;
        }
        return (total / divisor);
    }
}