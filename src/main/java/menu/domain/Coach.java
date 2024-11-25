package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {
    private String name;
    private List<String> inedibleMenus;
    private List<String> selectedMenus;

    public Coach(String name, List<String> inedibleMenus) {
        this.name = name;
        this.inedibleMenus = inedibleMenus;
        this.selectedMenus = new ArrayList<>();
    }

    public void addMenu(String menu) {
        validateDuplicateMenu(menu);
        validateInedibleMenu(menu);

        selectedMenus.add(menu);
    }

    public String getName() {
        return name;
    }

    public List<String> getSelectedMenus() {
        return selectedMenus;
    }

    private void validateDuplicateMenu(String menu) {
        if (Collections.frequency(selectedMenus, menu) >= 2) {
            throw new IllegalArgumentException("[ERROR] 중복되는 메뉴는 2개까지만 추천 가능하다.");
        }
    }

    private void validateInedibleMenu(String menu) {
        if (inedibleMenus.contains(menu)) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 추천해 줄 수 없다.");
        }
    }

}
