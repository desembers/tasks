package encapsulation;

import java.util.Scanner;

class kiosk7 {
    private Menu5 burger;
    private Menu5 drink;
    private Menu5 dessert;
    Scanner scanner;

    public kiosk7() {
        scanner = new Scanner(System.in);
        burger = new Menu5();
        drink = new Menu5();
        dessert = new Menu5();
        MenuList();
    }

    private void MenuList() {
        burger.addItem(new MenuItem4("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.addItem(new MenuItem4("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burger.addItem(new MenuItem4("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burger.addItem(new MenuItem4("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void start() {
        while(true) {
            System.out.println("\n[ MAIN MENU ]");
            System.out.println("1. Burgers");
            System.out.println("2. Drinks");
            System.out.println("3. Desserts");
            System.out.println("0. 종료      | 종료");
            System.out.print("입력: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    selectMenu(burger);
                    break;
                case 2:
                    selectMenu(drink);
                    break;
                case 3:
                    selectMenu(dessert);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
    private void selectMenu(Menu5 menu5) {
        menu5.displayMenu();
        System.out.println("입력 : ");
        int choice = scanner.nextInt();
        if(choice == 0) return;

        MenuItem4 selected = menu5.getItem(choice -1);
        if(selected != null) {
            System.out.printf("선택한 메뉴: %s | W %.1f | %s\n", selected.getName(), selected.getPrice(), selected.getContnets());
        }else {
            System.out.println("잘못선택된 메뉴입니다.");
        }
    }
}

public class Kiosk5 {
    public static void main(String[] args) {
         kiosk7 kiosk = new kiosk7();
         kiosk.start();
    }
}
