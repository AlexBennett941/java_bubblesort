import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



class bubbleSort {
    
    public static int[] createRandonArray(int arrayLength){
        int[] randArray = new int[arrayLength];
        Random rand = new Random();
        for (int i = 0; i < arrayLength; i++){
            randArray[i] = rand.nextInt(100)+1;
        }
        return randArray;
    } 

    public static void writeArrayToFile(int[] array, String filename){
        try{
            File newFile = new File(filename + ".txt");
            if (newFile.createNewFile()){
                System.out.println("File Created.");
                }
            else{
                System.out.println("File already exists."); 
            }
        }  
        catch (IOException e){
            System.out.println("Unable to create file");
            e.printStackTrace();
        } 
        try{
            FileWriter newWriter = new FileWriter(filename + ".txt");
            for (int i = 0; i < array.length; i++){
                newWriter.write(array[i] + " " + '\n');
            }
            newWriter.close();
            System.out.println("Successfully wrote to file.");
        }
        catch(IOException e){
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
    public static int[] readFileToArray(int length, String filename){
        int[] readArray = new int[length] ;
        try{
            File myObj = new File(filename + ".txt");
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while(myReader.hasNextInt()){
                readArray[i++] = myReader.nextInt();
            }
            myReader.close();
       }
       catch (FileNotFoundException e){
        System.out.println("An error occured.");
        e.printStackTrace();
       }
       return readArray;
    }
    //method for bubblesort
    public static void bubble_Sort(int[] array){
        int i = 0;
        int k = 0;
        int temp = 0;
        //loop to sort
        while (i < array.length-1){
            
            while (k < array.length-1){
                if (array[k] > array[k+1]){
                    temp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = temp;
                }
            k++;
            }
            k = 0;
            i++;
        }
        bubbleSort testing = new bubbleSort();
        testing.writeArrayToFile(array,"SortedArray.txt");

    }


    public static void main(String[] args){
        //inputting length and file name
        Scanner scnr = new Scanner(System.in);
        System.out.print("How many numbers do you want to sort?: ");
        int length = scnr.nextInt();
        System.out.print("Name your text file to save the numbers to (no spaces): ");
        String myFile = scnr.next();
        
        //create arrays
        int[] newArray;
        int[] readArray;
        
        //calling methods
        bubbleSort testing = new bubbleSort();
        newArray = testing.createRandonArray(length);
        testing.writeArrayToFile(newArray, myFile);
        readArray = testing.readFileToArray(length, myFile);
        testing.bubble_Sort(readArray);
        
    }
}