import java.util.Scanner;

/**
 * Created by JafarAtili on 15/05/2016.
 */
public class Driver {

    public static void main (String[] args) {

        int numOfData = 1000;
        int [] arr;
        int choise;
        String instruction = "Instructions:\n" +
                "1. Print Instructions\n" +
                "2. Insert(int x)\n" +
                "3. FindMax()\n" +
                "4. FindMin()\n" +
                "5. DeleteMax()\n" +
                "6. DeleteMin()\n"+
                "7. Exit\n";

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of your data:\n ");

        numOfData = in.nextInt();

        arr = new int [numOfData];


        System.out.println("Enter your data, number by number (with Space or Enter between):");

        for (int i = 0 ; i < arr.length ; i++){
            arr[i] = in.nextInt();
        }

        System.out.print("Building the data set from your data...");
        S.Build(arr);
        System.out.println(instruction);


        while (true) {

            switch (choise = in.nextInt()) {

                case 1: System.out.println(instruction);
                    break;
                case 2:
                    System.out.println("Insert a number: ");
                    S.Insert(in.nextInt());
                    System.out.println("\nData: "+ S.Print());
                    break;
                case 3:
                    System.out.println("Maximum is: " + S.FindMax());
                    System.out.println("\nData: "+ S.Print());

                    break;
                case 4:
                    System.out.println("Minimum is: " + S.FindMin());
                    System.out.println("\nData: "+ S.Print());

                    break;
                case 5:
                    System.out.print(S.DeleteMax() + " Deleted");
                    System.out.println("\nData: "+ S.Print());

                    break;
                case 6:
                    System.out.print(S.DeleteMin() + " Deleted");
                    System.out.println("\nData: "+ S.Print());
                    break;

                case 7:
                    System.out.print("Bye...");
                    return;
                default: System.out.print(choise+" is an illegal option!, you can enter 1 to view the options.");

            }
        }

    }




// For debugging purposes!
    public static void PrintMinMax(){
        System.out.println("MAX IS:" + S.FindMax()+"\nMIN IS:" + S.FindMin()+"\n");
    }

    public static void PrintHeaps(){
        System.out.println("Printing Heaps:\n"+S.PrintMaxHeap()+"\n"+S.PrintMinHeap()+"\n");
    }


}

