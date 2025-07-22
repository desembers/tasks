package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kiosk6 {

    private static Scanner sc = new Scanner(System.in);
    private static List<MenuItem5> burgers = Arrays.asList(
            new MenuItem5("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
            new MenuItem5("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
            new MenuItem5("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
            new MenuItem5("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
    );

    Cart cart = new Cart();
    public void run() {
         while(true) {
             mainmenu();
             int choice = getIntinput();
             switch(choice) {
                 case 1:
                     burgermenu();
                     break;
                 case 2:
                 case 3:
                     System.out.println("구현되지 않는 메뉴입니다.");
                     break;
                 case 4:
                 case 5:
                     if (cart.isEmpty()) {
                         System.out.println("장바구니가 비어있습니다. 먼저 메뉴를 선택하세요.");
                         break;
                     }
                     if(choice == 4) ordermenu();
                     else cancelorder();
                     break;
                 case 0:
                     System.out.println("프로그램을 종료합니다.");
                     return;
                 default:
                     System.out.println("잘못된 입력입니다.");
             }
         }
    }

    public void mainmenu() {
        System.out.println("\n[ MAIN MENU ]");
        System.out.println("1. Burgers");
        System.out.println("2. Drinks");
        System.out.println("3. Desserts");
        if(!cart.isEmpty()) {
            System.out.println("4. Orders | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel | 진행중인 주문을 취소합니다.");
        }
        System.out.println("0. 종료 | 종료");
        System.out.print("선택: ");
    }

    private void burgermenu() {
        while(true) {
            System.out.println("\n[ BURGERS MENU ]");
            for (int i = 0; i < burgers.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, burgers.get(i));
            }
            System.out.println("0. 뒤로가기");
            System.out.print("선택: ");
            int input = getIntinput();
            if(input == 0) break;
            if (input < 1 || input > burgers.size()) {
                System.out.println("유효하지 않은 메뉴 번호입니다.");
                continue;
            }
            MenuItem5 selected = burgers.get(input -1);
            System.out.println("선택한 메뉴 : " + selected);
            System.out.println("메뉴에 장바구니 추가하시겠습니까?");
            System.out.println("1.확인 2.취소");
            int confirm = getIntinput();
            if (confirm == 1) {
                cart.addItems(selected);
                System.out.println(selected.getName() + "이 장바구니에 추가되었습니다.");
                break;
            } else if(confirm == 2) {
                System.out.println("추가가 취소되었습니다.");
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void ordermenu() {
        System.out.println("\n아래와 같이 주문 하시겠습니까?");
        cart.printCart();
        System.out.println("\n1. 주문      2. 메뉴판");
        int input = getIntinput();
        if (input == 1) {
            System.out.printf("주문이 완료되었습니다. 금액은 W %.2f 입니다.\n", cart.getTotalPrice());
            cart.clear();
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
        }
    }

    private void cancelorder() {
        cart.clear();
        System.out.println("진행중인 주문이 취소되었습니다.");
    }

    private int getIntinput() {
        while (true) {
            try {
                String line = sc.nextLine();
                int val = Integer.parseInt(line.trim());
                return val;
            } catch (NumberFormatException e) {
                System.out.print("숫자를 입력해주세요: ");
            }
        }
    }

    public static void main(String[] args) {
        Kiosk6 kiosk = new Kiosk6();
        kiosk.run();
    }
}
