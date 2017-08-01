import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jackg on 6/23/2017.
 */
public class StatisticalMethods {

    public static void printArray(double[] array) {
        System.out.println("There are " + array.length + " elements in the array, and they are: ");
        System.out.print("[");
        for(int i=0; i<array.length; i++){
            System.out.print((int)array[i]);
            if(i!=(array.length-1)){
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    //a method to get an array of numbers by asking a user to enter a string of numbers seperated by spaces
    public static double[] getArrayOfNums() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string of numbers seperated by spaces: ");
        String stringOfNums = input.nextLine();
        String[] listOfNums = stringOfNums.split(" ");
        double[] arrayOfNums = new double[listOfNums.length];
        for(int i=0; i<listOfNums.length; i++){
            arrayOfNums[i] = Double.parseDouble(listOfNums[i]);
        }
        Arrays.sort(arrayOfNums);
        //printArray(arrayOfNums); //uncomment this line if you want to print the array upon immediately creating it
        return arrayOfNums;
    }

    //a method to compute the mean of a list
    public static double MeanOfList(double[] list) {
        double mean;
        mean = sum(list)/list.length;
        return mean;
    }

    //a method to compute the standard deviation of a list
    public static double STD(double[] list) {
        double standardDeviation;
        double[] newList = new double[list.length];
        for(int i=0; i<list.length; i++){
            newList[i] = Math.pow((list[i]-MeanOfList(list)), 2);
        }
        standardDeviation = Math.sqrt(sum(newList)/list.length);
        return standardDeviation;
    }

    //a method to compute the sum of a list
    public static double sum(double[] list) {
        double sumOf = 0;
        for(double i : list){
            sumOf +=i;
        }
        return sumOf;
    }

    //a method to compute the sample standard deviation
    public static double SampleSD(double[] list) {
        double standardDeviation;
        double[] newList = new double[list.length];
        for(int i=0; i<list.length; i++){
            newList[i] = Math.pow((list[i]-MeanOfList(list)), 2);
        }
        standardDeviation = Math.sqrt(sum(newList)/(list.length-1));
        return standardDeviation;
    }

    public static void printStats(double[] numListA) {
        System.out.println("The sum of the elements in the list is " + sum(numListA));
        System.out.println("The mean of the list is " + MeanOfList(numListA));
        System.out.println("The standard deviation of the list is " + STD(numListA));
        System.out.println("The sample standard deviation of the list is " + SampleSD(numListA));
    }

    //a method that converts an int array into an array of doubles
    public static double[] convertIntArrayToDoubleArray(int[] list) {
        double[]arrayOutput = new double[list.length];
        for(int i=0; i<list.length; i++){
            arrayOutput[i] = (double)list[i];
        }
        return arrayOutput;
    }

    //a method that determines the number of possible ways to arrange n objects without using any knowledge of factorial or the recursive factorial function
    public static int factorial(int[] numListA) {
        int count = 0;

        return count;
    }

    //a method that converts an array of doubles into and int array
    public static int[] convertDoubleArrayToIntArray(double[] list) {
        int[]arrayOutput = new int[list.length];
        for(int i=0; i<list.length; i++){
            arrayOutput[i] = (int)list[i];
        }
        return arrayOutput;
    }
}
