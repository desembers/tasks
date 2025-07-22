package kiosk;
import java.util.*;

class MenuItem2 {
    private String name;
    private int price;
    private String contents;
    private int num;

    public MenuItem2(int num, String name, int price, String contents) {
        this.num = num;
        this.name = name;
        this.price = price;
        this.contents = contents;
    }

    @Override
    public String toString() {
        return num + "이름 : " + name + "가격 : " + price + "설명 : " + contents;
    }

}

class kiosks {
    private ArrayList<MenuItem2> menuItem;
    private Scanner scanner;

    public kiosks(ArrayList<MenuItem2> menuItem2) {
        this.menuItem = menuItem2;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while(true) {
            displayMenu();
            selectNumber();
            System.out.println("주문을 계속하시겠습니까?");
            Integer ints = scanner.nextInt();
            if(ints == 0) {
                System.out.println("종료되었습니다.");
                break;
            }
        }
        System.out.println("이용했습니다. ");
    }
    private void displayMenu() {
        System.out.println("===========메뉴============");
        for (int i=0; i<menuItem.size(); i++) {
            System.out.println((i+1)+". " + menuItem.get(i).toString());
        }
    }
    int num = scanner.nextInt();
    private void selectMenu() {
        if(num >= 1 && num <= menuItem.size()) {
            MenuItem2 select = menuItem.get(num - 1);
            System.out.println(select.toString());
        } else {
            System.out.println("유효하지 않는 번호입니다.");
        }
    }
    private boolean selectNumber() {
        System.out.println("번호를 입력하세요 : (0을 누르면 뒤로가기 및 종료)");
        //뒤로가기 기능을 리턴값이 ture 아니면 false로
        try {
            if (num == 0) {
                return true;
            } else {
                selectMenu();
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자 입력해주세요:");
            scanner.nextInt();
            return false;
        }
    }

}

public class Kiosk {
    public static void main(String[] args) {
        List<MenuItem2> items = Arrays.asList(
                new MenuItem2(0, "zeroburger", 0, "제로버거"),
                new MenuItem2(1,"ShackBurger", 3000, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem2(2,"SmokeShack", 3500, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem2(3,"Cheeseburger", 4000, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem2(4,"Hamburger", 4000 , "비프패티를 기반으로 야채가 들어간 기본버거")
        );
        kiosks kiosk = new kiosks((ArrayList<MenuItem2>) items);
        kiosk.start();
    }
}
