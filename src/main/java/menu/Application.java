package menu;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printWelcomeMessage();
        String nameStr;
        List<Name> names;
        while (true) {
            try {
                nameStr = inputView.getName();
                names = Parser.parse(nameStr);
                break;
            } catch (IllegalArgumentException e) {
                // 예외 발생 시 메시지 출력 및 재시도
                System.out.println("에러: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }

        }


        //미리 카테고리 5일치를 정함..
        List<String> categories = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            while (true) {
                String category = MenuCategory.findCategory(Randoms.pickNumberInRange(1, 5));
                int count = Collections.frequency(categories, category);
                if (count > 1) {
                    continue;
                }
                categories.add(category);
                break;
            }

        }
        for (String category : categories) {
            System.out.println(category);
        }


        //각자 싫어하는 메뉴를 담고 있어야 하는 리스트
        Map<Name, List<String>> hateMenus = new HashMap<>();
        Map<Name, List<String>> fixedMenus = new HashMap<>();

        for (Name name : names) {
            name.displayName();
            String hateMenuStr;
            List<String> hateMenuItems = new ArrayList<>();
            while (true) {
                try {
                    hateMenuStr = inputView.getHateMenu(name);
                    //메뉴 이름 검증 필요
                    hateMenuItems = Parser.parseHateMenu(hateMenuStr);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            //map에 들어갔다고 가정
            hateMenus.put(name, hateMenuItems);
            fixedMenus.put(name, new ArrayList<>());

        }

        for (int i = 0; i < 5; i++) {
            for (Name name : names) {
                String category;
                List<String> menus;
                List<String> shuffledMenu;
                String pickedMenu;
                while (true) {
                    category = categories.get(i);
                    // 랜덤 카테고리에 해당하는 메뉴들 리턴
                    MenuCategory menuCategory = MenuCategory.findMenuCategory(category);
                    menus = Menu.getCategoryMenuList(menuCategory);
                    // 랜덤 메뉴를 선정
                    shuffledMenu = Randoms.shuffle(menus);
                    //0번째가 뽑힘
                    pickedMenu = shuffledMenu.get(0);

                    // 아래는 추가해도 되는 메뉴인지 확인

                    //싫어하는 메뉴가 아니라면 ok
                    if (hateMenus.get(name).contains(pickedMenu)) {
                        continue;
                    }
                    //이미 골라진 메뉴가 아니라면 ok
                    if (fixedMenus.get(name).contains(pickedMenu)) {
                        continue;
                    }

                    if (fixedMenus.get(name).isEmpty()) {
                        fixedMenus.get(name).add(pickedMenu);
                        break;
                    }

                    //오케이 넣음
                    fixedMenus.get(name).add(pickedMenu);
                    break;
                }


            }
        }
        outputView.displayFixedMenu(fixedMenus, categories);


    }

    static class InputView {
        public String getName() {
            System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
            String input = Console.readLine();
            return input;
        }

        public String getHateMenu(Name name) {
            System.out.println(name.getName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            String input = Console.readLine();
            return input;
        }
    }

    static class OutputView {
        public void printWelcomeMessage() {
            System.out.println("점심 메뉴 추천을 시작합니다.");
        }

        public void displayFixedMenu(Map<Name, List<String>> fixedMenu, List<String> categories) {
            System.out.println("메뉴 추천 결과입니다.");
            System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
            StringBuilder builder = new StringBuilder();
            builder.append("[ 카테고리 | ");
            builder.append(String.join(" | ", categories));
            builder.append(" ]");
            builder.append("\n");
            for (Map.Entry<Name, List<String>> entry : fixedMenu.entrySet()) {
                builder.append("[ ");
                builder.append(entry.getKey().getName());
                builder.append(" | ");
                builder.append(String.join(" | ", entry.getValue()));
                builder.append(" ]");

                builder.append("\n");

            }
            System.out.println(builder.toString());
            System.out.println("추천을 완료했습니다.");
//            [ 구구 | 김치찌개 | 스파게티 | 규동 | 짜장면 | 카오 팟 ]
        }
    }


}
