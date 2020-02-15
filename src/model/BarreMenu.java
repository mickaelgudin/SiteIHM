/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javafx.scene.control.MenuBar;

/**
 *
 * @author MGud
 */
public class BarreMenu extends MenuBar{
    
    public BarreMenu(List<Menu> menus){
        super();
        this.getMenus().addAll(menus);
        this.setMinHeight(50);
    }
}
