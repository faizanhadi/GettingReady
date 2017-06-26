import java.util.Scanner;

/**
 * Created by mfaiz on 6/20/2017.
 */

public class GettingReady {

    public static void main (String[] args){
        System.out.println("\n1: Run with builtIn test cases");
        System.out.println("2: Run with custom test cases");
        System.out.println("Enter your choice ! \n'1' or '2' !");
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        System.out.println();

        //'1' for in built Tests
        if (n == 1){
            String input[] = {
                    "HOT 8, 6, 4, 2, 1, 7",
                    "COLD 8, 6, 3, 4, 2, 5, 1, 7",
                    "HOT 8, 6, 6",
                    "HOT 8, 6, 3",
                    "COLD 8, 6, 3, 4, 2, 5, 7",
                    "COLD 6"
            };
            int count =1;
            while (count < input.length+1){
                System.out.println("Test Case "+count);
                String[] inputNew = StringParse.parsing(input[count-1]);
                FailOrNot failOrNot = new FailOrNot();
                String result = failOrNot.passOrFail(inputNew);
                System.out.println("result " +result+"\n");
                count++;
            }
        }
        //'2' for Custom inputs
        if (n==2){
            System.out.println("Give input in the format:\nHOT 8, 6, 4, 2, 1, 7");
            Scanner read = new Scanner(System.in);
            String input = read.nextLine();
            String[] inputNew = StringParse.parsing(input);
            String result = FailOrNot.passOrFail(inputNew);
            System.out.println("result " +result+"\n");
        }
    }
}
