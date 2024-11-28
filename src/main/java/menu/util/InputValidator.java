package menu.util;

import java.util.List;

public class InputValidator {
    private final Parser parser;

    public InputValidator(Parser parser) {
        this.parser = parser;
    }

    // try-catch 문으로 재입력 기능을 구현해야 한다.
    public void validateCoachNames(List<String> coachNames) {
        checkCoachCounts(coachNames);

        for (String coachName : coachNames) {
            checkNameLength(coachName);
        }
    }

    // 못 먹는 메뉴 입력 기능은 나중에 구현한다.
    public void validateInedibleMenus(List<String> inedibleMenus) {
        checkInedibleMenusCounts(inedibleMenus);
    }

    // 코치 인원 수 검증
    private void checkCoachCounts(List<String> coachNames) {
        if (coachNames.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 2명 이상이어야 합니다. 혼밥시키게요?");
        }
        else if (coachNames.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 5명 이하여야 합니다.");
        }
    }

    // 코치 이름 글자 수 검증
    private void checkNameLength(String coachName) {
        if (coachName.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2자 이상이어야 합니다. 이름이 어떻게 한 글자겠습니까?");
        }
        else if (coachName.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 4자 이하여야 합니다.");
        }
    }

    // 못 먹는 메뉴 개수 검증
    private void checkInedibleMenusCounts(List<String> inedibleMenus) {
        if (inedibleMenus.size() > 3) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 최대 2개까지입니다. 코치나 돼서 편식 좀 하지 마세요.");
        }
    }

    // 못 먹는 메뉴가 실제 존재하는 메뉴인지 검증
    private void checkMenuName() {

    }
}
