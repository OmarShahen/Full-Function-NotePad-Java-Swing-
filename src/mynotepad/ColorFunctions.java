/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynotepad;

import java.awt.Color;


public class ColorFunctions {
    
    
    MainFrame gui;
    
    public ColorFunctions(MainFrame gui)
    {
        this.gui = gui;
    }
    
    public void setBackgroundColor(String color)
    {
        if(color.equals("BBlack"))
          gui.textArea.setBackground(Color.BLACK);
        else if(color.equals("BWhite"))
            gui.textArea.setBackground(Color.WHITE);
            
    }
    public void setForeGroundColor(String color)
    {
        switch(color)
        {
            case "Black":
                gui.textArea.setForeground(Color.BLACK);
            break;
             case "Blue":
                gui.textArea.setForeground(Color.BLUE);
            break;
             case "Green":
                gui.textArea.setForeground(Color.GREEN);
            break;
             case "Red":
                gui.textArea.setForeground(Color.RED);
            break;
             case "Pink":
                gui.textArea.setForeground(Color.PINK);
            break;
             case "Yellow":
                gui.textArea.setForeground(Color.YELLOW);
            break;
             case "White":
                gui.textArea.setForeground(Color.WHITE);
            break;
                
        }
    
    }
    
    
    
    
    
}
