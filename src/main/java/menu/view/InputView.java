package menu.view;

import java.util.List;
import java.util.Scanner;
import menu.util.Parser;

public class InputView {
    private final Parser parser;
    Scanner sc = new Scanner(System.in);

    public InputView(Parser parser) {
        this.parser = parser;
    }

    private final String COACH_INPUT_MESSAGE = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    private final String INEDIBLE_MENU_INPUT_MESSAGE = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.%n";

    public List<String> inputCoachNames() {
        System.out.println(COACH_INPUT_MESSAGE);

        String namesInput = sc.nextLine();
        List<String> coachNames = parser.parseStringToNameList(namesInput);

        return coachNames;
    }

    public List<String> inputInedibleMenus(String coachName) {
        System.out.printf(INEDIBLE_MENU_INPUT_MESSAGE, coachName);

        String inedibleMenusInput = sc.nextLine();
        List<String> inedibleMenus = parser.parseToInedibleMenuList(inedibleMenusInput);

        return inedibleMenus;
    }
}
