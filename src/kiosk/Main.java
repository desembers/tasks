package kiosk;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("[ SHAKESHACK MENU ]");
        Scanner sc = new Scanner(System.in);
        while(true) {
            int number = sc.nextInt();

            switch (number) {
                case 1:
                    System.out.println("1. ShackBurger | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    break;
                case 2:
                    System.out.println("2. SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                    break;
                case 3:
                    System.out.println("3. Cheeseburger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    break;
                case 4:
                    System.out.println("4. Hamburger | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                    break;
                default:
                    System.out.println("다시입력해주세요.");
                    break;
            }

            if(number == 0) {
                System.out.println("0. 프로그램을 종료합니다.");
            }
        }
    }
}
