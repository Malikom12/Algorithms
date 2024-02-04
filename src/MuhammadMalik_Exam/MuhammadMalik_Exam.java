package MuhammadMalik_Exam;

import java.util.Scanner;
import main.java.Utilities;
import main.java.FileHandlingUtilities;


public class MuhammadMalik_Exam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] fileBased = FileHandlingUtilities.readTextFile("SampleInput/Part2SampleInput1.txt");
        String[] fileBased2 = FileHandlingUtilities.readTextFile("SampleInput/Part2SampleInput2.txt");

        for (int i = 0; i < fileBased.length; i++){
            System.out.println(fileBased[i]);
        }

        for (int i = 0; i < fileBased2.length; i++){
            System.out.println(fileBased2[i]);
        }

        System.out.println("Please enter number of Strings to take from first array");
        int count1 = sc.nextInt();

        System.out.println("Please enter number of strings to take from second array");
        int count2 = sc.nextInt();

        String[] merged = Utilities.merge(fileBased, fileBased2, count1, count2);

        sc.nextLine();

        System.out.println("Please enter the value you would like to search for");
        String value = sc.nextLine();
        int location = Utilities.locateString(merged, value);



        if (location == -1){
            String[] deduplicated = Utilities.deduplicate_ArrayGrowth(merged, 0);
            for (int i = 0; i < deduplicated.length; i++){
                System.out.println(deduplicated[i]);
            }

            int numDeleted = merged.length - deduplicated.length;
            System.out.println("The number of deleted duplicates is: " + numDeleted);
        }
        else{
            String[] deduplicated = Utilities.deduplicate_ArrayGrowth(merged, location);
            for (int i = 0; i < deduplicated.length; i++){
                System.out.println(deduplicated[i]);
            }

            int numDeleted = merged.length - deduplicated.length;
            System.out.println("The number of deleted duplicates is: " + numDeleted);
        }






    }

}
