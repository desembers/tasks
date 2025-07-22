package encapsulation;

import java.util.ArrayList;

public class Menu5 {
     public ArrayList<MenuItem4> items;

    public Menu5() {
         items = new ArrayList<>();
     }

     public void addItem(MenuItem4 menuItem4) {
         items.add(menuItem4);
     }

     public MenuItem4 getItem(int num) {
         if (num >= 0 && num < items.size()) {
             return items.get(num);
         }
         return null;
     }

     public ArrayList<MenuItem4> getItems() {
         return items;
     }

     public void displayMenu() {
         for(int i=0; i<items.size(); i++) {
             MenuItem4 item = items.get(i);
             System.out.printf("%d. %s | W %.1f | %s\n", i+1, item.getName(), item.getPrice(), item.getContnets());
         }
         System.out.println("0 뒤로가기");
     }
}
