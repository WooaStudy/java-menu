package menu.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public List<String> parseStringToNameList(String namesInput) {
        return Arrays.asList(namesInput.trim().split("\\s*,\\s*"));
    }

    public List<String> parseToInedibleMenuList(String menusInput) {
        return Arrays.asList(menusInput.trim().split("\\s*,\\s*"));
    }
}
