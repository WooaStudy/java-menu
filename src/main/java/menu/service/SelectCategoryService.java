package menu.service;

import menu.domain.SelectedCategory;
import menu.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class SelectCategoryService {

    public static SelectedCategory generateSelectedCategory() {
        List<String> categories = new ArrayList<>();

        while (categories.size() != 5) {
            String category = RandomGenerator.generateRandomCategory();
            if (canSelectCategory(categories, category)) {
                categories.add(category);
            }
        }

        return new SelectedCategory(categories);
    }

    private static boolean canSelectCategory(List<String> categories, String category) {
        if (categories.isEmpty()) {
            return true;
        }
        int numberOfDuplication = 0;

        for (String s : categories) {
            if (s.equals(category)) {
                numberOfDuplication++;
            }
        }

        return numberOfDuplication < 2;
    }
}
