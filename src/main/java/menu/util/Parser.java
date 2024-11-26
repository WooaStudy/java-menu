package menu.util;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<Coach> convertStringToCoaches(String input) {
        List<Coach> coaches = new ArrayList<>();
        String[] split = input.split(",");

        for (String coachName : split) {
            coaches.add(new Coach(coachName));
        }

        return coaches;
    }

    public static List<String> convertStringToList(String input) {
        String[] split = input.split(",");

        return Arrays.asList(split);
    }
}
