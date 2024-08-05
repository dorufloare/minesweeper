package minesweeperswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalButtonUI;

public class Cell extends JButton {
    int row;
    int collumn;
    int value;
    int fontSize;
    boolean revealed;
    boolean flagged;
    
    Color unrevealedColor = new Color(102,255,51);
    Color revealedColor = new Color(20,20,20);
    Color foregroundColor = new Color(102,255,51);
    
    public Cell(int row, int collumn, int size) {
        this.revealed = false;
        this.flagged = false;
        this.row = row;
        this.collumn = collumn;
        this.setFocusPainted(false);
        this.setBackground(unrevealedColor);
        this.fontSize = 320 / size;
        this.setFont(new Font("Monospaced", Font.BOLD, fontSize));
        this.setBorder( new LineBorder(Color.BLACK) );
        this.setText("");
        
        this.setUI (new MetalButtonUI () {
            protected void paintButtonPressed (Graphics g, AbstractButton b) { }
        });
    }
    
    public void reveal() {
        this.revealed = true;
        this.setBackground(revealedColor);
        this.setForeground(foregroundColor);
        if (this.isMine()) {
            this.setForeground(Color.red);     
            this.setText("X");
        } else if (this.value > 0) {
            this.setText(String.valueOf(this.value));
        }
    }
    public boolean isRevealed() {
        return this.revealed;
    }
    public boolean isBlank() {
        return (this.value == 0);
    }
    public void flag() {
        this.flagged = true;
        this.setBackground(Color.red);
    }
    public void unflag() {
        this.flagged = false;
        this.setBackground(unrevealedColor);
    }
    public boolean isFlagged() {
        return this.flagged;
    }
    public void reset() {
        this.revealed = false;
        this.flagged = false;
        this.value = 0;
        this.setBackground(unrevealedColor);
        this.setText("");
    }
    public void setMine() {
        this.value = 10;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
    public boolean isMine() {
        return (this.value == 10);
    }
    public int getRow() {
        return this.row;
    }
    public int getCollumn() {
        return this.collumn;
    }
}
