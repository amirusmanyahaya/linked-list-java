import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // prompts a user a returns an array of user input
    public static String [] promptValues() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the list of numbers: ");
        String stringNumbers = scanner.nextLine();
        System.out.println();
        String [] stringArray = stringNumbers.split(" ", -1);
        return stringArray;
    }

    // converts string numbers to an int array
    public static int [] getIntArray(String [] array){
        int [] numArray = new int[array.length];
        for(int i = 0; i < numArray.length; ++i){
            numArray[i] = Integer.parseInt(array[i]);
        }
        return numArray;
    }

    // deep copies one a list to another list
    public static void deepCopy(LinkedList source, LinkedList destination){
        if (source.getHead() == null) {
            return;
        }

        Node currentSourceNode = source.getHead();
        Node currentDestNode = new Node(4);
        while(currentSourceNode != null) {
            currentDestNode.setValue(currentSourceNode.getValue());
            currentDestNode.setNext(currentSourceNode.getNext());
            currentSourceNode = currentSourceNode.getNext();
            currentDestNode = currentDestNode.getNext();
        }
    }

    public static LinkedList addItems(int [] numbers){
        LinkedList list = new LinkedList();
        for(int i: numbers){
            list.addNode(i);
        }
        return list;
    }
    public static void main(String[] args) {
        String [] stringArray;
        int [] numArray;
        while(true){
            stringArray = promptValues();
            try{
                numArray = getIntArray(stringArray);
            }catch(Exception e){
                System.out.println("Exception: "+e);
                continue;
            }
            break;
        }

        LinkedList list = addItems(numArray);
        list.printList();
        LinkedList listDest = new LinkedList();
        deepCopy(list,listDest);
        list.printList();
        listDest.printList();
    }
}
