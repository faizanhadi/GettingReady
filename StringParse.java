import java.util.Arrays;

/**
 * Created by mfaiz on 6/20/2017.
 */

//Parsing the input string

public class StringParse {
    public static String[] parsing(String input){
        input = input.toUpperCase();
        input = input.replace(",","");                                       //removing ','
        String[] inputNew = input.split("\\s+");                       //removing extra space
        String displayInput = Arrays.toString(inputNew).replace("[","");    //To display the input correctly
        displayInput = displayInput.replace("]","");
        System.out.println("Input: "+ displayInput);

        return inputNew;
    }
}
