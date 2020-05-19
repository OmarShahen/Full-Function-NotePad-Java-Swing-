/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynotepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class FileFunctions {
    
    MainFrame gui;
    String fileName;
    String fileAddress;
    
    FileFunctions(MainFrame gui)
    {
        this.gui = gui;
    }
    
    public void newFile()
    {
        gui.textArea.setText("");
        gui.frame.setTitle("New");
        fileName = fileAddress = null;
    }
    public void open()
    {
        FileDialog fd = new FileDialog(gui.frame,"Open",FileDialog.LOAD);
        fd.setVisible(true);
        
        if(fd.getFile() != null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.frame.setTitle(fileName);
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");
            String line = null;
            while((line = br.readLine()) != null)
            {
                gui.textArea.append(line + "\n");
            }
            br.close();
        }catch(Exception e)
        {
            System.out.println("File Not Found.");
        }
    }
    public void save()
    {
        if(fileName == null)
        {
            saveAs();
        }
        else
        {
            try{
                    FileWriter fw = new FileWriter(fileAddress + fileName);
                    fw.write(gui.textArea.getText());
                    fw.close();
            }catch(Exception e)
            {
                System.out.println("Something Wrong");
            }
        }
    
    }
    public void saveAs()
    {
        FileDialog fd = new FileDialog(gui.frame,"Save",FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile() != null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.frame.setTitle(fileName);
        }
        try{
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        }catch(Exception e)
        {
            System.out.println("SomeThing Wrong!");
        }
    }
    public void exit()
    {
        System.exit(0);
    }
    
    
    
}
