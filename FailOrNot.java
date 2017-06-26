/**
 * Created by mfaiz on 6/21/2017.
 */
import java.util.HashMap;


public class FailOrNot {


    static HashMap<Integer, Boolean> hotCheckMap = new HashMap<>();
    static HashMap<Integer, Boolean> coldCheckMap = new HashMap<>();
    static HashMap<Integer, String> hotMap = new HashMap<>();
    static HashMap<Integer, String> coldMap = new HashMap<>();
    static String result = null;

    public static String passOrFail(String[] input) {
        //Checking if its HOT or COLD
        //the result returned is the final output string
        if (input[0].equals("HOT")) {
            result = hotDetected(input);
        }
        else if (input[0].equals("COLD")){
            result = coldDetected(input);
        }
        else
            return "Wrong Input";
        //returning the result to be displayed
        return result;
    }


    public static String hotDetected(String[] input) {

        hotCriteria();              //initializing the Hashmaps
        boolean fail = false;       //Monitoring if there was any fail condition recognized
        int weather = 0;            //weather HOT = 0

        //Checking if PJs are removed first
        if (input[1].equals("8")) {
            int count = 2;
            //'Removing PJs' added in output string
            result = hotMap.get(8);

            //running while for rest of the inputs
            //until the input length is reached and
            //there is no fail case !
            //Every input command is dealt separately
            while (count < input.length && fail == false) {

                int command = Integer.parseInt(input[count]);

                if ((command == 4) || (command == 2)) {     //Checking for head wear and t-shirt
                    fail = CriteriaCheck.fourTwoFive(fail, command, hotCheckMap, weather);
                }

                else if ((command == 1) || (command == 6)) {    //Checking for sandals and shorts
                    fail = CriteriaCheck.sixOne(fail, command, hotCheckMap, weather);
                }

                else if (command == 7) {        //Checking for leaving house
                    int length = count;
                    fail = CriteriaCheck.seven(fail, command, hotCheckMap, length, weather);
                }
                else if (command == 3 || command == 5) {    //Checking for socks and jackets, failing the result
                    result = result + ", fail";
                    return result;
                }
                else if (command < 1 || command >7)
                    fail = true;

                //After each command, fail flag is checked !
                //if fail is true the program stops and returns with the result and fail flag
                if (fail == true) {
                    result = new StringBuilder(result).append(", ").append("fail").toString();
                    return result;
                }

                count++;
            }
        } else {        //if first input is not Taking off PJs, the program fails
            return "fail";
        }
        return result;
    }


    public static String coldDetected(String[] input) {

        //initializing hashmaps
        coldCriteria();

        boolean fail = false;
        int weather =1;

        //Checking if PJs are removed first
        if (input[1].equals("8")) {
            int count = 2;
            result = coldMap.get(8);

            //running while for rest of the inputs
            //until the input length is reached and
            //there is no fail case !
            //Every input command is dealt separately
            while (count < input.length && fail == false) {

                int command = Integer.parseInt(input[count]);

                if ((command == 4) || (command == 2) || (command == 5)) {   //Checking for shirt, hat and jacket
                    fail = CriteriaCheck.fourTwoFive(fail, command, coldCheckMap, weather);
                }

                else if ((command == 1) || (command == 6) || (command == 3)) {  //Checking for boots, socks and pants
                    fail = CriteriaCheck.sixOneThree(fail, command, coldCheckMap, weather);
                }

                else if (command == 7) {    //Checking for leaving house
                    int length = count;     //to check '7' is at the last index.
                    fail = CriteriaCheck.seven(fail, command, coldCheckMap, length, weather);
                }
                else if (command < 1 || command >7)
                    fail = true;


                //After each command, fail flag is checked !
                //if fail is true the program stops and returns with the result and fail flag
                if (fail == true) {
                    result = new StringBuilder(result).append(", ").append("fail").toString();
                    return result;
                }

                count++;
            }
        } else {    //if first input is not Taking off PJs, the program fails
            return "fail";
        }
        return result;
    }

    //Initializing HOT Maps
    public static void hotCriteria() {
        hotCheckMap.put(1, false);
        hotCheckMap.put(2, false);
        //hotCheckMap.put(3, false);
        hotCheckMap.put(4, false);
        //hotCheckMap.put(5, false);
        hotCheckMap.put(6, false);
        hotCheckMap.put(7, false);
        hotCheckMap.put(8, false);

        hotMap.put(1, "sandals");
        hotMap.put(2, "sun visor");
        //hotMap.put(3,"socks");
        hotMap.put(4, "t-shirt");
        //hotMap.put(5,"jacket");
        hotMap.put(6, "shorts");
        hotMap.put(7, "leaving house");
        hotMap.put(8, "Removing PJs");
    }

    //Initializing COLD Maps
    public static void coldCriteria(){
        coldCheckMap.put(1, false);
        coldCheckMap.put(2, false);
        coldCheckMap.put(3, false);
        coldCheckMap.put(4, false);
        coldCheckMap.put(5, false);
        coldCheckMap.put(6, false);
        coldCheckMap.put(7, false);
        coldCheckMap.put(8, false);

        coldMap.put(1,"boots");
        coldMap.put(2,"hat");
        coldMap.put(3,"socks");
        coldMap.put(4,"shirt");
        coldMap.put(5,"jacket");
        coldMap.put(6,"pants");
        coldMap.put(7,"leaving house");
        coldMap.put(8,"Removing PJs");
    }



    }

