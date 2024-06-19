package com.demoblaze.enums;

public enum MenuOption {

    HOME("Home"),
    CONTACT("Contact"),
    ABOUT_US("About us"),
    CART("Cart"),
    LOG_IN("Log in"),
    SING_UP("Sign up");

    private final String menuOption;

    MenuOption(String menuOption) {
        this.menuOption = menuOption;
    }

    public String getMenuOption() {
        return menuOption;
    }
}
