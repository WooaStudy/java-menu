package menu.domain;

import menu.util.CoachValidator;
import menu.util.Parser;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(String coaches) {
        CoachValidator.validateCoach(coaches);
        this.coaches = Parser.convertStringToCoaches(coaches);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    @Override
    public String toString() {
        return "Coaches{" +
                "coaches=" + coaches +
                '}';
    }
}
