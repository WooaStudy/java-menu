package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

import java.util.List;

public class RandomGenerator {
    private static final List<String> categories = List.of("null", "일식", "한식", "중식", "아시안", "양식");

    public static String generateRandomCategory() {
        return categories.get(Randoms.pickNumberInRange(1, 5));
    }

    public static String generateRandomMenu(String categoryName) {
        Category category = Category.getCategory(categoryName);
        List<String> menus = category.getMenus();

        return Randoms.shuffle(menus).get(0);
    }
}
