package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category {
    private final Map<String, List<String>> menuMap;
    private List<String> selectedCategories;

    public Category() {
        menuMap = new HashMap<>();
        selectedCategories = new ArrayList<>();
        menuMap.put("일식", Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        menuMap.put("한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        menuMap.put("중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        menuMap.put("아시안", Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠양꿍", "반미", "월남쌈", "분짜"));
        menuMap.put("양식", Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }

    public List<String> getMenu(String categoryName) {
        List<String> menu = menuMap.get(categoryName);

        return menu;
    }

    public void addSelectedCategory(String categoryName) {
        selectedCategories.add(categoryName);
    }

    public List<String> getSelectedCategories() {
        return selectedCategories;
    }
}