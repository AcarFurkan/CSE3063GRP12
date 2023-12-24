package features.main_menu;

import java.util.ArrayList;

public class MenuView {

 // show menu list
 public void showMenuList(ArrayList<String> menuList) {
    // Simply print out each menu item
    // i for indexing
    System.out.println("###===>>> Main Menu <<<===###");
    for (int i=1; i<=menuList.size(); i++) {
        System.out.println("\t[" + i + "] " + menuList.get(i-1));
    }
    System.out.println("###===>>> Main Menu <<<===###");
}

// show error message
public void showErrorMessage(Exception e) {
    System.out.println("Error: " + e.getMessage());
}

public void showPromptMessage() {
    System.out.print("Please enter your selection: ");
}

}