package menu.domain;

import menu.util.Parser;

import java.util.List;

public class Coach {
    private final String name;
    private List<String> unAvailableMenu;
    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getUnAvailableMenu() {
        return unAvailableMenu;
    }

    public void setUnAvailableMenu(String unAvailableMenu) {
        this.unAvailableMenu = Parser.convertStringToList(unAvailableMenu);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", unAvailableMenu=" + unAvailableMenu +
                '}';
    }
}
