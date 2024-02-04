package main.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michelle
 */
public class FileHandlingUtilities {
    // NOTE: The use of the arraylist here DOES NOT MEAN you should use it 
    // elsewhere. This is just to keep the code short and readable for you
    // We're still all about arrays!
    public static int [] readNumericFile(String filename){
        ArrayList<Integer> temp = new ArrayList();
        
        Scanner inputFile;
        try
        {
            inputFile = new Scanner(new FileReader(filename));
            while(inputFile.hasNextInt()){
                temp.add(inputFile.nextInt());
            }
        } catch (FileNotFoundException ex){
            // This is not the way to handle this issue in proper code!!
            // As you don't know how to recover from exceptions occurring yet, 
            // I just want you to see the error, then have the program end
            Logger.getLogger(FileHandlingUtilities.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception occurred when reading from file: " + ex.getMessage());
            ex.printStackTrace();
            // We usually DO NOT WANT TO DO THIS
            System.exit(1);
        }
        
        int [] finalArray = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            finalArray[i] = temp.get(i);
        }
        
        return finalArray;
    }
    
    public static String [] readTextFile(String filename){
        ArrayList<String> temp = new ArrayList();
        
        Scanner inputFile;
        try
        {
            inputFile = new Scanner(new FileReader(filename));
            while(inputFile.hasNextLine()){
                temp.add(inputFile.nextLine());
            }
        } catch (FileNotFoundException ex){
            // This is not the way to handle this issue in proper code!!
            // As you don't know how to recover from exceptions occurring yet, 
            // I just want you to see the error, then have the program end
            Logger.getLogger(FileHandlingUtilities.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception occurred when reading from file: " + ex.getMessage());
            ex.printStackTrace();
            // We usually DO NOT WANT TO DO THIS
            System.exit(1);
        }
        String [] text = new String[temp.size()];
        return temp.toArray(text);
    }
}
