package menu.controller;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Result;
import menu.domain.SelectedCategory;
import menu.service.MenuRecommendationService;
import menu.service.SelectCategoryService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        outputView.startMessage();

        Coaches coaches = readCoaches();
        readAndSetUnAvailableMenu(coaches);

        SelectedCategory selectedCategory = SelectCategoryService.generateSelectedCategory();
        MenuRecommendationService menuRecommendationService = new MenuRecommendationService(coaches, selectedCategory);
        List<Result> results = menuRecommendationService.menuRecommend();
        outputView.printResult(results, selectedCategory);
    }

    private Coaches readCoaches() {
        String input = inputView.readCoaches();

        return new Coaches(input);
    }

    private void readAndSetUnAvailableMenu(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            String input = inputView.readUnAvailableMenu(coach);
            coach.setUnAvailableMenu(input);
        }
    }
}
