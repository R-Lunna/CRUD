/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;

public class JFrameRoot
{
    private static JFrame frame = null;
    
    public JFrameRoot()
    {
    }
    
    public void setFrame( JFrame frame )
    {
        this.frame = frame;
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
    
}
