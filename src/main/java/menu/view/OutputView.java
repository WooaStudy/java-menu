package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;

public class OutputView {
    private final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private final String RESULT_HEADER_MESSAGE = "\n메뉴 추천 결과입니다.\n"
            + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n"
            + "[ 카테고리 | %s | %s | %s | %s | %s ]%n";
    // 이름, 월 메뉴, 화 메뉴, 수 메뉴, 목 메뉴, 금 메뉴
    private final String RESULT_FORMAT = "[ %s | %s | %s | %s | %s | %s ]%n";
    private final String ENDING_MESSAGE = "\n추천을 완료했습니다.";

    public void printGreeting() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(List<Coach> coaches, Category category) {
        List<String> selectedCategories = category.getSelectedCategories();
        System.out.printf(RESULT_HEADER_MESSAGE,
                selectedCategories.get(0),
                selectedCategories.get(1),
                selectedCategories.get(2),
                selectedCategories.get(3),
                selectedCategories.get(4));
        for (Coach coach : coaches) {
            List<String> selectedMenus = coach.getSelectedMenus();
            System.out.printf(RESULT_FORMAT, coach.getName(),
                    selectedMenus.get(0),
                    selectedMenus.get(1),
                    selectedMenus.get(2),
                    selectedMenus.get(3),
                    selectedMenus.get(4));
        }
        System.out.println(ENDING_MESSAGE);
    }
}
