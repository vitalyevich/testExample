import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String S = "uid,sname,mass,single,room,dep\n3,Jon,89,T,12,13\n14,Alex,101,F,18,4";
        String C ="mass";

        if (checkToInput(S, C)) {
            System.out.println(solution(S, C));
        }
    }

    /***
     * Checking for correct data entry
     * @param S is name table .csv
     * @param C is name column
     * @return true or false
     */
    public static boolean checkToInput(String S, String C) {

        String[] values = S.split("\n");
        String columnName = values[0];
        String[] col = columnName.split(",");

        // Brute Force
        for (int i = 0; i < col.length; i++) {
            for (int j = i + 1; j < col.length; j++) {
                if(col[i].equals(col[j])) {
                    return false;
                }
            }
        }

        if (col.length >= 2) {
            for (String c : col) {
                if (c.matches("(.*)[!@\"№;%:_?+`@#$%^&='<>()*\\/[ ]](.*)")) {
                    return false;
                }
            }

            for (String c : values) {
                if (!(c.length() >= 4 && c.length() <= 10000)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /***
     * Finding in column max value
     * @param S is name table .csv
     * @param C is name column
     * @return max value in column
     */
    public static int solution(String S, String C) {
        String[] values = S.split("\n");
        String columnName = values[0];
        String[] col = columnName.split(",");

        int max = 0;

        int i = 0;
        for (String c : col) {
            if (c.equals(C)) {

                String[] numbers = values[1].split(",");
                max = Integer.parseInt(numbers[i]);

                for (int g = 2; g < values.length; g++) {
                    numbers = values[g].split(",");

                    if (Integer.parseInt(numbers[i]) > max) {
                        max = Integer.parseInt(numbers[i]);
                    }
                }
            }
            i++;
        }
        return max;
    }

}
