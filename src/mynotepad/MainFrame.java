/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynotepad;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;



public class MainFrame implements ActionListener{
    
    JFrame frame;
    JMenuBar menuBar;
    JMenu file,edit,font,size,fontType,color,undo_redo;
    JMenuItem fnew,fopen,fsave,fsaveAs,fexit;
    JMenuItem cut,copy,paste,selectAll;
    JMenuItem bold,plain,italic,size10,size12,size14,size16,size18,size20,size22,size24,size26,size28;
    JMenuItem timesnewroman,courier,arial,arialBlack,century;
    JMenu FBackGround,FForeGround;
    JMenuItem black,blue,green,red,pink,yellow,white;
    JMenuItem iundo,iredo;
    JMenuItem bblack,bwhite;
    JTextArea textArea;
    
    FontFunctions fontfn = new FontFunctions(this);
    ColorFunctions colorfn = new ColorFunctions(this);
    UndoManager um = new UndoManager();
    UndoRedoFunctions undoredo = new UndoRedoFunctions(this);
    FileFunctions filefn = new FileFunctions(this);
    
    public MainFrame()
    {
        setFrame();
        setMenuBar();
    
    }
    
    public void setFrame()
    {
        frame = new JFrame("NotePad");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
    public void setMenuBar()
    {
        menuBar = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        font = new JMenu("Font");
        size = new JMenu("Size");
        fontType = new JMenu("Font Type");
        color = new JMenu("Color");
        undo_redo = new JMenu("Undo&Redo");
        
        frame.setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(font);
        menuBar.add(fontType);
        menuBar.add(color);
        menuBar.add(undo_redo);
        
        setFileItems();
        setEditItems();
        setFontItems();
        setFontTypeItems();
        setColorItems();
        setredo_undoItems();
        
        setTextArea();
       
      
    }
    public void setFileItems()
    {
        fnew = new JMenuItem("New");
        fopen = new JMenuItem("Open");
        fsave = new JMenuItem("Save");
        fsaveAs = new JMenuItem("Save As");
        fexit = new JMenuItem("Exit");
        
        file.add(fnew);
        file.add(fopen);
        file.add(fsave);
        file.add(fsaveAs);
        file.add(fexit);
        
        fnew.addActionListener(this);
        fnew.setActionCommand("New");
        fopen.addActionListener(this);
        fopen.setActionCommand("Open");
        fsave.addActionListener(this);
        fsave.setActionCommand("Save");
        fsaveAs.addActionListener(this);
        fsaveAs.setActionCommand("Save As");
        fexit.addActionListener(this);
        fexit.setActionCommand("Exit");
        
  }
    public void setEditItems()
    {
        cut = new JMenuItem("Cut         Ctrl + X");
        copy = new JMenuItem("Copy       Ctrl + C");
        paste = new JMenuItem("Paste     Ctrl + V");
        selectAll = new JMenuItem("Select All");
        
        cut.addActionListener(this);
        cut.setActionCommand("Cut");
        copy.addActionListener(this);
        copy.setActionCommand("Copy");
        paste.addActionListener(this);
        paste.setActionCommand("Paste");
        selectAll.addActionListener(this);
        selectAll.setActionCommand("SelectAll");
        
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        
    }
    
    public void setFontItems()
    {
        size = new JMenu("Size");
        bold = new JMenuItem("Bold");
        plain = new JMenuItem("Plain");
        italic = new JMenuItem("Italic");
        
        font.add(bold);
        font.add(plain);
        font.add(italic);
        font.add(size);
        
        bold.addActionListener(this);
        bold.setActionCommand("Bold");
        plain.addActionListener(this);
        plain.setActionCommand("Plain");
        italic.addActionListener(this);
        italic.setActionCommand("Italic");
        
        size10 = new JMenuItem("10");
        size12 = new JMenuItem("12");
        size14 = new JMenuItem("14");
        size16 = new JMenuItem("16");
        size18 = new JMenuItem("18");
        size20 = new JMenuItem("20");
        size22 = new JMenuItem("22");
        size24 = new JMenuItem("24");
        size26 = new JMenuItem("26");
        size28 = new JMenuItem("28");
        
        size.add(size10);
        size.add(size12);
        size.add(size14);
        size.add(size10);
        size.add(size16);
        size.add(size18);
        size.add(size20);
        size.add(size22);
        size.add(size24);
        size.add(size26);
        size.add(size28);
        
        size10.addActionListener(this);
        size10.setActionCommand("10");
        size12.addActionListener(this);
        size12.setActionCommand("12");
        size14.addActionListener(this);
        size14.setActionCommand("14");
        size16.addActionListener(this);
        size16.setActionCommand("16");
        size18.addActionListener(this);
        size18.setActionCommand("18");
        size20.addActionListener(this);
        size20.setActionCommand("20");
        size22.addActionListener(this);
        size22.setActionCommand("22");
        size24.addActionListener(this);
        size24.setActionCommand("24");
        size26.addActionListener(this);
        size26.setActionCommand("26");
        size28.addActionListener(this);
        size28.setActionCommand("28");
       
    }
    
    public void setFontTypeItems()
    {
        timesnewroman = new JMenuItem("Times New Roman");
        courier = new JMenuItem("Courier");
        arial = new JMenuItem("Arial");
        arialBlack = new JMenuItem("Arial Black");
        century = new JMenuItem("Century");      
        
        fontType.add(timesnewroman);
        fontType.add(courier);
        fontType.add(arial);
        fontType.add(arialBlack);
        fontType.add(century);
        
        timesnewroman.addActionListener(this);
        timesnewroman.setActionCommand("Times New Roman");
        courier.addActionListener(this);
        courier.setActionCommand("Courier");
        arial.addActionListener(this);
        arial.setActionCommand("Arial");
        arialBlack.addActionListener(this);
        arialBlack.setActionCommand("Arial Black");
        century.addActionListener(this);
        century.setActionCommand("Century");
        
    }
    public void setColorItems()
    {
        FBackGround = new JMenu("Background");
        FForeGround = new JMenu("Foreground");
        
        color.add(FBackGround);
        color.add(FForeGround);
        
        bblack = new JMenuItem("Black");
        bwhite = new JMenuItem("White");
        black = new JMenuItem("Black");
        blue = new JMenuItem("Blue");
        green = new JMenuItem("Green");
        red = new JMenuItem("Red");
        pink = new JMenuItem("Pink");
        yellow = new JMenuItem("Yellow");
        white = new JMenuItem("White");
        
        FBackGround.add(bblack);
        FBackGround.add(bwhite);
        
        bblack.addActionListener(this);
        bblack.setActionCommand("BBlack");
        bwhite.addActionListener(this);
        bwhite.setActionCommand("BWhite");
        
        FForeGround.add(black);
        FForeGround.add(blue);
        FForeGround.add(green);
        FForeGround.add(red);
        FForeGround.add(pink);
        FForeGround.add(yellow);
        FForeGround.add(white);
        
        black.addActionListener(this);
        black.setActionCommand("Black");
        blue.addActionListener(this);
        blue.setActionCommand("Blue");
        green.addActionListener(this);
        green.setActionCommand("Green");
        red.addActionListener(this);
        red.setActionCommand("Red");
        pink.addActionListener(this);
        pink.setActionCommand("Pink");
        yellow.addActionListener(this);
        yellow.setActionCommand("Yellow");
        white.addActionListener(this);
        white.setActionCommand("White");
     
    }
    public void setredo_undoItems()
    {
        iundo = new JMenuItem("Undo");
        iredo = new JMenuItem("Redo");
        
        iundo.addActionListener(this);
        iundo.setActionCommand("Undo");
        iredo.addActionListener(this);
        iredo.setActionCommand("Redo");
                
        undo_redo.add(iundo);
        undo_redo.add(iredo);
        
    }
    public void setTextArea()
    {
        textArea = new JTextArea(400,400);
        textArea.setFont(new Font("Arial",Font.PLAIN,20));
        frame.add(textArea);
        JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);                                                                                                                                                                                                                                                                                                                                         
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane);
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener(){public void undoableEditHappened(UndoableEditEvent e){um.addEdit(e.getEdit());}});      
    
    }
    
    public void actionPerformed(ActionEvent e)
    {
        switch(e.getActionCommand())
        {
            case "Bold":
                fontfn.setFontStyle("Bold");
            break;
            case "Italic":
                fontfn.setFontStyle("Italic");
            break;
            case "Plain":
                fontfn.setFontStyle("Plain");
            break;
            case "Times New Roman":
                fontfn.setFontFamily(e.getActionCommand());
            break;
            case "Courier":
                fontfn.setFontFamily(e.getActionCommand());
            break;
            case "Arial":
                fontfn.setFontFamily(e.getActionCommand());
            break;
            case "Arial Black":
                fontfn.setFontFamily(e.getActionCommand());
            break;
            case "Century":
                fontfn.setFontFamily(e.getActionCommand());
            break;
            case "10":
                fontfn.setFontSize(Integer.parseInt(e.getActionCommand()));
            break;
            case "12":
                fontfn.setFontSize(Integer.parseInt(e.getActionCommand()));
            break;
            case "14":
                fontfn.setFontSize(Integer.parseInt(e.getActionCommand()));
            break;
            case "16":
                fontfn.setFontSize(Integer.parseInt(e.getActionCommand()));
            break;
            case "18":
                fontfn.setFontSize(Integer.parseInt(e.getActionCommand()));
            break;
            case "20":
                fontfn.setFontSize(Integer.parseInt(e.getActionCommand()));
            break;
            case "22":
                fontfn.setFontSize(Integer.parseInt(e.getActionCommand()));
            break;
            case "24":
                fontfn.setFontSize(Integer.parseInt(e.getActionCommand()));
            break;
            case "26":
                fontfn.setFontSize(Integer.parseInt(e.getActionCommand()));
            break;
            case "28":
                fontfn.setFontSize(Integer.parseInt(e.getActionCommand()));
            break;
            case "BBlack":
                colorfn.setBackgroundColor(e.getActionCommand());
            break;
            case "BWhite":
                colorfn.setBackgroundColor(e.getActionCommand());
            break;
            case "Black":
                colorfn.setForeGroundColor(e.getActionCommand());
            break;
            case "Blue":
                colorfn.setForeGroundColor(e.getActionCommand());
            break;
            case "Green":
                colorfn.setForeGroundColor(e.getActionCommand());
            break;
            case "Red":
                colorfn.setForeGroundColor(e.getActionCommand());
            break;
            case "Pink":
                colorfn.setForeGroundColor(e.getActionCommand());
            break;
            case "Yellow":
                colorfn.setForeGroundColor(e.getActionCommand());
            break;
            case "White":
                colorfn.setForeGroundColor(e.getActionCommand());
            break;
            case "Undo":
                undoredo.undo();
            break;
            case "Redo":
                undoredo.redo();
            break;
            case "Copy":
                textArea.copy();
            break;
            case "Paste":
                textArea.paste();
            break;
            case "Cut":
                textArea.cut();
            break;
            case "selectAll":
                textArea.selectAll();
            break;
            case "New":
                filefn.newFile();
            break;
            case "Open":
                filefn.open();
            break;
            case "Save":
                filefn.save();
            break;
            case "Save As":
                filefn.saveAs();
            break;
            case "Exit":
                filefn.exit();
            break;
                
        }
    
    }
  
}
