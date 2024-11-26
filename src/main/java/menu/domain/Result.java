package menu.domain;

import java.util.List;

public class Result {
    private final Coach coach;
    private final List<String> selectMenus;

    public Result(Coach coach, List<String> selectMenus) {
        this.coach = coach;
        this.selectMenus = selectMenus;
    }

    public Coach getCoach() {
        return coach;
    }

    public List<String> getSelectMenus() {
        return selectMenus;
    }

    @Override
    public String toString() {
        return "Result{" +
                "coach=" + coach +
                ", selectMenus=" + selectMenus +
                '}';
    }
}
