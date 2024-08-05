package minesweeperswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.xml.transform.Source;

public class MainFrame extends javax.swing.JFrame {
    final int[] deltaX = {1, 0, -1, 0, 1, 1, -1, -1};
    final int[] deltaY = {0, 1, 0, -1, 1, -1, 1, -1};
    
    private int SIZE = 800;
    
    private int gridSize;
    private int nrMines; 
    private int flagsLeft;
    private int cellsLeft;
    
    Cell[][] cell;
    
    public MainFrame(int gridSize) {
        initComponents();
        getContentPane().setBackground(Color.black);
        this.gridSize = gridSize;
        nrMines = (int)(1.2 * gridSize);

        flagsLeft = nrMines;
        cellsLeft = gridSize * gridSize - nrMines;
        
        cell = new Cell[gridSize][gridSize];

        lblMines.setText(String.valueOf(flagsLeft));
        setSize(SIZE, SIZE);
        setLayout(new BorderLayout());
        setResizable(false);
        
        initializeGrid();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeGrid() {
        grid.setLayout(new GridLayout(gridSize, gridSize));
        for (int x = 0; x < gridSize; ++x) {
            for (int y = 0; y < gridSize; ++y) {
                cell[x][y] = new Cell(x, y, gridSize);
                cell[x][y].addMouseListener(new MouseAdapter() {
                   public void mousePressed(MouseEvent e) {
                       Cell c = (Cell)e.getSource();
                       if (c.isRevealed()) {
                           return;
                       }
                       if (SwingUtilities.isRightMouseButton(e)) {
                           if (c.isFlagged()) {
                               ++flagsLeft;
                               c.unflag();
                               lblMines.setText(String.valueOf(flagsLeft));
                           } else if (flagsLeft > 0) {
                               --flagsLeft;
                               c.flag();
                               lblMines.setText(String.valueOf(flagsLeft));
                               checkForWin();
                           }
                       } else if (!c.isFlagged()) {
                           handleCell(c);
                       }
                   } 
                });
                grid.add(cell[x][y]);
            }
        }

        addMines(nrMines);
        setCellValues();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grid = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        lblMines = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 800));

        grid.setBackground(new java.awt.Color(0, 0, 0));
        grid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 51), 3));

        javax.swing.GroupLayout gridLayout = new javax.swing.GroupLayout(grid);
        grid.setLayout(gridLayout);
        gridLayout.setHorizontalGroup(
            gridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        gridLayout.setVerticalGroup(
            gridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        btnReset.setBackground(new java.awt.Color(20, 20, 20));
        btnReset.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 255, 51));
        btnReset.setText("RESET");
        btnReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnResetMousePressed(evt);
            }
        });
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblMines.setBackground(new java.awt.Color(20, 20, 20));
        lblMines.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblMines.setForeground(new java.awt.Color(0, 255, 51));
        lblMines.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMines.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 418, Short.MAX_VALUE)
                .addComponent(lblMines, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMines, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetGame();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame(10);
            }
        });
    }

    private void setCellValues() {
        for (int x = 0; x < gridSize; ++x) {
            for (int y = 0; y < gridSize; ++y) {
                if (!cell[x][y].isMine()) {
                    cell[x][y].setValue(neighbouringMines(x, y));
                }
            }
        }
    }
    
    private void fillCells(int x, int y) {
        for (int i = 0; i < 4; ++i) {
            int newX = x + deltaX[i];
            int newY = y + deltaY[i];
            if (validCoordonates(newX, newY) && !cell[newX][newY].isRevealed() && !cell[newX][newY].isFlagged()) {
                cell[newX][newY].reveal();
                --cellsLeft;
                if (cell[newX][newY].isBlank()) {
                    fillCells(newX, newY);
                }
            }
        }
    }
    
    private int neighbouringMines(int x, int y) {
        int counter = 0;
        for (int i = 0; i < 8; ++i) {
            int newX = x + deltaX[i];
            int newY = y + deltaY[i];
            if (validCoordonates(newX, newY) && cell[newX][newY].isMine()) {
                counter++;
            }
        }
        return counter;
    }
    
    private void addMines(int nrMines) {
        Random rand = new Random();
        int placedMines = 0;
        while (placedMines < nrMines) {
           int x = rand.nextInt(gridSize);
           int y = rand.nextInt(gridSize);
           if (!cell[x][y].isMine()) {
               ++placedMines;
               cell[x][y].setMine();
           }
         }
    }

    private boolean validCoordonates(int x, int y) {
        return (x >= 0 && x < gridSize && y >= 0 && y < gridSize);
    }

    private void resetGame() { 
                flagsLeft = nrMines;
        cellsLeft = gridSize * gridSize - nrMines;
        for (int x = 0; x < gridSize; ++x) {
            for (int y = 0; y < gridSize; ++y) {
                cell[x][y].reset();
            }
        }
        addMines(nrMines);
        setCellValues();

    }

    private void handleCell(Cell cell) {
        cell.reveal();
        
        if (cell.isMine()) {
            gameLost();
            return;
        }
        
        --cellsLeft;
        if (cell.isBlank()) {
            fillCells(cell.getRow(), cell.getCollumn());
        }
        checkForWin();
    }
    
    private void checkForWin() {
        if (flagsLeft == 0 && cellsLeft == 0) {
            gameWon();
        }
    }
    
    private void gameWon() {
        JOptionPane.showMessageDialog(this, "You Won", "Respect", JOptionPane.PLAIN_MESSAGE);
        resetGame();
    }
    
    private void gameLost() {        
        JOptionPane.showMessageDialog(this, "You Lost", "Game Over", JOptionPane.ERROR_MESSAGE);
        resetGame();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel grid;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMines;
    // End of variables declaration//GEN-END:variables

}
