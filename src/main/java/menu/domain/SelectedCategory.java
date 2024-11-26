package menu.domain;

import java.util.List;

public class SelectedCategory {
    private final List<String> categories;

    public SelectedCategory(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getCategories() {
        return categories;
    }
}
