package menu;

public enum MenuCategory {
    JAPANESE(1,"일식"),
    KOREAN(2,"한식"),
    CHINESE(3,"중식"),
    ASIAN(4,"아시안"),
    WESTERN(5,"양식");

    private int index;
    private String menuCategory ;

    MenuCategory(int index, String menuCategory) {
        this.index = index;
        this.menuCategory = menuCategory;
    }

    public static String findCategory(int menuCategoryIndex) {
        for (MenuCategory value : MenuCategory.values()) {
            if (value.index == menuCategoryIndex) {
                return value.menuCategory;
            }
        }
        throw new IllegalArgumentException("없는 메뉴입니다.");
    }

    public static MenuCategory findMenuCategory(String menuCategory) {
        for (MenuCategory value : MenuCategory.values()) {
            if (value.menuCategory.equals(menuCategory)) {
                return value;
            }
            
        }

        throw new IllegalArgumentException("메뉴 카테고리 찾기 오류");
    }
    


}
