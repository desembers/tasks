package kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem3 {
    private double price;
    private String name;
    private String contents;

    public MenuItem3(String name, double price ,String contents) {
        this.price = price;
        this.name = name;
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getContents() {
        return contents;
    }

    public void Info() {
        System.out.printf("%s | W %.1f | %s\n", name, price, contents);
    }

    public String getInfo() {
        return String.format("%s | W %.1f | %s\n", name, price, contents);
    }

    public static class Menu {
       private String category;
       private List<MenuItem3> menuItem3;

       public Menu(String category) {
           this.category = category;
           this.menuItem3 = new ArrayList<>();
       }

       public String getCategory() {
           return category;
       }

       public void addMenu2(MenuItem3 menuitem) {
           menuItem3.add(menuitem);
       }

       public List<MenuItem3> getMenuItem3() {
           return menuItem3;
       }

       public void showMenu() {
           for(int i=0; i<menuItem3.size(); i++) {
               MenuItem3 item3 = menuItem3.get(i);
               System.out.printf("%d. %s\n", i+1, item3.getInfo());
           }
       }

    }

    public static class Kiosk {
        private List<Menu> menus;
        public Kiosk() {
            menus = new ArrayList<>();
        }

        public void addMenu(Menu menu) {
            menus.add(menu);
        }

        public void start() {
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("[ MAIN MENU ]");
                for(int i=0; i<menus.size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, menus.get(i).category);
                }
                System.out.println("종료");

                int choice = scanner.nextInt();
                if(choice == 0) {
                    System.out.println("프로그램 종료합니다.");
                    break;
                }

                Menu selectedMenu = menus.get(choice - 1);

                System.out.println("\n[ " + selectedMenu.getCategory().toUpperCase() + " MENU ]");
                selectedMenu.showMenu();
                System.out.println("0. 뒤로가기");

                int itemChoice = scanner.nextInt();

                if (itemChoice == 0) {
                    System.out.println();
                    continue;
                }

                if (itemChoice < 0 || itemChoice > selectedMenu.getMenuItem3().size()) {
                    System.out.println("잘못된 입력입니다. 다시 선택하세요.\n");
                    continue;
                }

                MenuItem3 chosenItem = selectedMenu.getMenuItem3().get(itemChoice - 1);
                System.out.print("선택한 메뉴: ");
                chosenItem.Info();
                System.out.println();
            }
        }
    }

}

public class
kiosk4 {
    public static void main(String[] args) {
        MenuItem3.Menu burgers = new MenuItem3.Menu("Burgers");
        burgers.addMenu2(new MenuItem3("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenu2(new MenuItem3("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenu2(new MenuItem3("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenu2(new MenuItem3("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        MenuItem3.Menu drinks = new MenuItem3.Menu("Drinks");
        drinks.addMenu2(new MenuItem3("Cola", 1.5, "시원한 탄산음료"));
        drinks.addMenu2(new MenuItem3("Americano", 2.0, "진한 커피"));

        MenuItem3.Menu desserts = new MenuItem3.Menu("Desserts");
        desserts.addMenu2(new MenuItem3("Shake", 4.5, "달콤한 쉐이크"));
        desserts.addMenu2(new MenuItem3("Cookie", 2.5, "바삭한 쿠키"));

        MenuItem3.Kiosk kiosk = new MenuItem3.Kiosk();
        kiosk.addMenu(burgers);
        kiosk.addMenu(drinks);
        kiosk.addMenu(desserts);

        kiosk.start();
    }
}
