package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;

public class InputView {
    public static final String COACH_NAME_INPUT_MESSAGE = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String USER_UNAVAILABLE_MENU_PROMPT_MESSAGE = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";


    public String readCoaches() {
        System.out.println(COACH_NAME_INPUT_MESSAGE);

        return Console.readLine();
    }

    public String readUnAvailableMenu(Coach coach) {
        System.out.printf(USER_UNAVAILABLE_MENU_PROMPT_MESSAGE, coach.getName());

        return Console.readLine();
    }

}
