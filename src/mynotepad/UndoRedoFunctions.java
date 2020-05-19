/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynotepad;


public class UndoRedoFunctions {
    
    MainFrame gui;
    
    public UndoRedoFunctions(MainFrame gui)
    {
        this.gui = gui;
    }
    
    public void undo()
    {
        gui.um.undo();
    }
    public void redo()
    {
        gui.um.redo();
    }
    
    
}
