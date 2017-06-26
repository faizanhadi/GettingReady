import java.util.HashMap;

/**
 * Created by mfaiz on 6/24/2017.
 */


public class CriteriaCheck {

    //to append outputs to final result string
    public static String append(String result, int entry, int weather) {
        String newResult=null;
        //for HOT weather= 0 and for cold weather=1
        if (weather == 0)
            newResult = new StringBuilder(result).append(", ").append(FailOrNot.hotMap.get(entry)).toString();
        else
            newResult = new StringBuilder(result).append(", ").append(FailOrNot.coldMap.get(entry)).toString();

        return newResult;
    }


    //Every time  command comes it is checked for:
    //1: This command is coming for the first time. Checked with flag-Map
    //2: Related commands have already been processed
    //3: Fail flag is updated appropriately
    //4: Flag-Map is updated
    //5: Result is appended

    //Dealing with command #2, #4, #5 for HOT and COLD

    public static boolean fourTwoFive(boolean fail, int command, HashMap<Integer, Boolean> tMap, int weather) {
        if (command == 2) {
            if (tMap.get(2))
                fail = true;
            else if (tMap.get(4) && !tMap.get(2)) {
                tMap.put(2, true);
                FailOrNot.result = append(FailOrNot.result, 2, weather);
            } else
                fail = true;
        }
        if (command == 5) {
            if (tMap.get(5))
                fail = true;
            else if (tMap.get(4) && !tMap.get(5)) {
                tMap.put(5, true);
                FailOrNot.result = append(FailOrNot.result, 5, weather);
            } else
                fail = true;
        }
        if (command == 4 ) {
            if ( tMap.get(4))
                fail = true;
            else {
                tMap.put(4, true);
                FailOrNot.result = append(FailOrNot.result, 4, weather);
            }
        }
        //else
        //  fail = true;
        return fail;
    }

    //Dealing with command #1, #6 for HOT
    public static boolean sixOne(boolean fail, int command, HashMap<Integer, Boolean> tMap, int weather) {
        if (command == 1) {

            if (tMap.get(1))
                fail = true;
            else if (tMap.get(6) && !tMap.get(1)) {
                tMap.put(1, true);
                FailOrNot.result = append(FailOrNot.result, 1, weather);
            } else
                fail = true;
        }
        if (command == 6 ) {
            if (tMap.get(6))
                fail = true;
            else {
                tMap.put(6, true);
                FailOrNot.result = append(FailOrNot.result, 6, weather);
            }
        }
        //else
        //  fail = true;
        return fail;
    }

    //Dealing with command #1, #3, #6 for COLD
    public static boolean sixOneThree(boolean fail, int command, HashMap<Integer, Boolean> tMap,int weather) {
        if (command == 1) {

            if (tMap.get(1))
                fail = true;
            else if (tMap.get(6) && tMap.get(3) && !tMap.get(1)) {
                tMap.put(1, true);
                FailOrNot.result = append(FailOrNot.result, 1, weather);
            } else
                fail = true;
        }
        if (command == 3) {

            if (tMap.get(3))
                fail = true;
            else if (tMap.get(6) && !tMap.get(3) && !tMap.get(1)) {
                tMap.put(3, true);
                FailOrNot.result = append(FailOrNot.result, 3, weather);
            } else
                fail = true;
        }
        if (command == 6 ) {
            if (tMap.get(6))
                fail = true;
            else {
                tMap.put(6, true);
                FailOrNot.result = append(FailOrNot.result, 6, weather);
            }
        }
        //else
        //  fail = true;
        return fail;
    }

    //Dealing with command #7 for HOT and COLD
    public static boolean seven(boolean fail, int command, HashMap<Integer, Boolean> tMap, int length, int weather) {

        if (weather ==0){
            if (!tMap.get(7) && length == 6) {
                tMap.put(7, true);
                FailOrNot.result = append(FailOrNot.result, 7,weather);
            } else
                fail = true;
        }
        else if (weather ==1){
            if (!tMap.get(7) && length == 8) {
                tMap.put(7, true);
                FailOrNot.result = append(FailOrNot.result, 7,weather);
            } else
                fail = true;
        }
        return fail;
    }

}
