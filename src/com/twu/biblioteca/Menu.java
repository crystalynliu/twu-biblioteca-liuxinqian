package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int menuId;
    private String menuName;

    private static String invalidMenuMessage = "Select a valid option!";

    public Menu(int menuId,String menuName){
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public void setMenuId(int menuId){
        this.menuId = menuId;
    }

    public int getMenuId(){
        return this.menuId;
    }

    public void setMenuName(String menuName){
        this.menuName = menuName;
    }

    public String getMenuName(){
        return this.menuName;
    }

    public static List<Menu> InitialMenuList(){
        List<Menu> menuList = new ArrayList<Menu>();
        menuList.add(new Menu(1, "LIST BOOKS"));
        menuList.add(new Menu(2, "CHOCK OUT BOOK"));
        menuList.add(new Menu(3, "RETURN BOOK"));
        menuList.add(new Menu(4, "QUIT"));

        return menuList;
    }

}
