/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynotepad;

import java.awt.Font;


public class FontFunctions {
    
    
    MainFrame gui;
    
    String fontFamily = "Arial";
    int setSize = 20;
    int setFontStyle = Font.PLAIN;
    
    
    public FontFunctions(MainFrame gui)
    {
        this.gui = gui;
    }
    public void setFontStyle(String fontStyle)
    {
        switch(fontStyle){
            
        case "Bold":
            setFontStyle = Font.BOLD;
            gui.textArea.setFont(new Font(fontFamily,setFontStyle,setSize));
        break;
        case "Plain":
            setFontStyle = Font.PLAIN;
            gui.textArea.setFont(new Font(fontFamily,setFontStyle,setSize));
        break;
        case "Italic":
            setFontStyle = Font.ITALIC;
            gui.textArea.setFont(new Font(fontFamily,setFontStyle,setSize));
        break;
    }
        
    }
    public void setFontFamily(String FontFamily)
    {
        
        fontFamily = FontFamily;
        gui.textArea.setFont(new Font(fontFamily,setFontStyle,setSize));
            
    }
    public void setFontSize(int size)
    {
        setSize = size;
        gui.textArea.setFont(new Font(fontFamily,setFontStyle,setSize));
    }

}
    
    
    
    
  
