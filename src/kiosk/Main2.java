package kiosk;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    public String burger_name;
    public int burger_price;
    public String burger_content;
    public int num;

    MenuItem(int num, String burger_name, int burger_price, String burger_content) {
        this.num = num;
        this.burger_name = burger_name;
        this.burger_price = burger_price;
        this.burger_content = burger_content;
    }
    public void selectnumber() {
        System.out.println(num + ". 이름 : " + burger_name + "가격 : " + burger_price + "설명 : " + burger_content);
    }

}

public class Main2 {
    public static void main(String[] args) {

        List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem(0,"가져오기",0,"가져오기"));
        items.add(new MenuItem(1,"ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem(2,"SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem(3,"Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        items.add(new MenuItem(4,"Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);
        while(true) {
            int number = sc.nextInt();
            System.out.println("[ SHAKESHACK MENU ]");
                if(number >= 1 && number <= items.size()) {
                    MenuItem select = items.get(number);
                    select.selectnumber();
                } else if(number == 0) {
                System.out.println("종료되었습니다.");
                break;
            }
        }
    }
}
