package com.frequem.epic;

import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class JMenuItem extends JSpritePanelComponent implements MouseListener{
    private final static int ICONSIZE = 24;
    
    public JMenuItem(JSpritePanel spritePanel){
        super(spritePanel);
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel label = new JLabel(this.getLabelText());
        
        ImageIcon icon = this.getIcon();
        if(icon != null){
            label.setIcon(new ImageIcon(getScaledImage(icon.getImage(), ICONSIZE, ICONSIZE)));
        }
        this.add(label);
        this.addMouseListener(this);
    }
    
    protected String getLabelText(){
        return "";
    }
    
    protected ImageIcon getIcon(){
        return null;
    }
    
    private static Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("click 1");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        this.setBackground(UIManager.getColor("Panel.background").darker());
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        this.setBackground(UIManager.getColor("Panel.background"));
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
