package menu.view;

import menu.domain.Result;
import menu.domain.SelectedCategory;

import java.util.List;

public class OutputView {
    private final String LUNCH_MENU_PROMPT_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private final String MENU_RECOMMENDATION_RESULT_MESSAGE = "\n메뉴 추천 결과입니다.";
    private final String DAY_OF_THE_WEEK_CLASSIFICATION_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private final String CATEGORY_CLASSIFICATION = "[ 카테고리 | %s | %s | %s | %s | %s ]\n";
    private final String MENU_RECOMMENDATION_RESULT = "[ %s | %s | %s | %s | %s | %s ]\n";
    private final String END_RECOMMENDATION_MESSAGE = "\n추천을 완료했습니다.";

    public void startMessage() {
        System.out.println(LUNCH_MENU_PROMPT_MESSAGE);
    }

    public void printResult(List<Result> results, SelectedCategory selectedCategory) {
        System.out.println(MENU_RECOMMENDATION_RESULT_MESSAGE);
        System.out.println(DAY_OF_THE_WEEK_CLASSIFICATION_MESSAGE);
        printCatrgoy(selectedCategory);
        printRecommendationResults(results);
        System.out.println(END_RECOMMENDATION_MESSAGE);

    }

    private void printRecommendationResults(List<Result> results) {
        for (Result result : results) {
            List<String> selectMenus = result.getSelectMenus();
            System.out.printf(MENU_RECOMMENDATION_RESULT, result.getCoach().getName(), selectMenus.get(0), selectMenus.get(1), selectMenus.get(2), selectMenus.get(3), selectMenus.get(4));
        }
    }

    private void printCatrgoy(SelectedCategory selectedCategory) {
        List<String> categories = selectedCategory.getCategories();
        System.out.printf(CATEGORY_CLASSIFICATION, categories.get(0), categories.get(1), categories.get(2), categories.get(3), categories.get(4));
    }
}
