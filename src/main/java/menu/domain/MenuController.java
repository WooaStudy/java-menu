package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.util.InputValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final Category category;

    private List<Coach> coaches = new ArrayList<>();
    private List<String> coachNames;


    public MenuController(InputView inputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = new OutputView();
        this.inputValidator = inputValidator;

        this.category = new Category();
    }

    public void start() {
        outputView.printGreeting();

        readCoachNames();
        readInedibleMenus();

        processMenuSelection();

        outputView.printResult(coaches, category);
    }

    private void readCoachNames() {
        boolean validInput = false;

        while (!validInput) {
            try {
                coachNames = inputView.inputCoachNames();
                inputValidator.validateCoachNames(coachNames);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void readInedibleMenus() {
        for (String coachName : coachNames) {
            makeCoach(coachName);
        }
    }

    private void makeCoach(String coachName) {
        boolean validInput = false;

        while (!validInput) {
            try {
                List<String> inedibleMenus = inputView.inputInedibleMenus(coachName);
                inputValidator.validateInedibleMenus(inedibleMenus);
                coaches.add(new Coach(coachName, inedibleMenus));
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void processMenuSelection() {
        for (int i = 0; i < 5; i++) {
            String categoryName = pickCategory();
            category.addSelectedCategory(categoryName);

            for (Coach coach : coaches) {
                tryMenuAdditionUntilSuccess(coach, categoryName);
            }
        }
    }

    private void tryMenuAdditionUntilSuccess(Coach coach, String category) {
        boolean validMenu = true;

        while (validMenu) {
            try {
                String menu = pickOneMenu(category);
                coach.addMenu(menu);
                validMenu = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 카테고리 선택
    private String pickCategory() {
        List<String> categories = new ArrayList<>(Arrays.asList("","일식","한식","중식","아시안","양식"));

        return categories.get(Randoms.pickNumberInRange(1, 5));
    }

    // 해당 카테고리에 있는 메뉴 목록에서 단일 메뉴 선택
    private String pickOneMenu(String categoryName) {
        List<String> menus = new ArrayList<>(category.getMenu(categoryName));
        return Randoms.shuffle(menus).get(0);
    }
}
