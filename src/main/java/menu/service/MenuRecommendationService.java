package menu.service;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Result;
import menu.domain.SelectedCategory;
import menu.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommendationService {
    private final Coaches coaches;
    private final SelectedCategory selectedCategory;

    public MenuRecommendationService(Coaches coaches, SelectedCategory selectedCategory) {
        this.coaches = coaches;
        this.selectedCategory = selectedCategory;
    }

    public List<Result> menuRecommend() {
        List<Result> results = new ArrayList<>();
        List<String> categories = selectedCategory.getCategories();

        for (int i = 0; i < 5; i++) {
            String category = categories.get(i);
            assignMenusToCoaches(category, results);
        }

        return results;
    }

    private void assignMenusToCoaches(String category, List<Result> results) {
        for (Coach coach : coaches.getCoaches()) {
            String menu = selectMenuForCoach(category, coach, results);
            addMenuToResults(coach, menu, results);
        }
    }

    private String selectMenuForCoach(String category, Coach coach, List<Result> results) {
        while (true) {
            String menu = RandomGenerator.generateRandomMenu(category);
            if (canSelectMenu(menu, coach, results)) {
                return menu;
            }
        }

    }

    private boolean canSelectMenu(String menu, Coach coach, List<Result> results) {
        if (!canEat(menu, coach)) {
            return false;
        }

        for (Result result : results) {
            if (result.getCoach().equals(coach) && result.getSelectMenus().contains(menu)) {
                return false;
            }
        }

        return true;
    }

    private void addMenuToResults(Coach coach, String menu, List<Result> results) {
        for (Result result : results) {
            if (result.getCoach().equals(coach)) {
                result.getSelectMenus().add(menu);
                return;
            }
        }

        results.add(new Result(coach, new ArrayList<>(List.of(menu))));
    }

    private boolean canEat(String menu, Coach coach) {
        return !coach.getUnAvailableMenu().contains(menu);
    }
}
