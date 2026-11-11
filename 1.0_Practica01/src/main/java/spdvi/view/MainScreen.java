/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package spdvi.view;

import spdvi.controller.DataStore;
import spdvi.model.Lloguer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import spdvi.model.Joc;
import spdvi.model.Usuari;


/**
 *
 * @author frand
 */
public class MainScreen extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainScreen.class.getName());
    private JTable taulaLloguers;
    private java.util.ResourceBundle bundle;
    
    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        canviarIdioma("ca");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/spdvi/resources/iconMain2.png")).getImage());
        setTitle("Gestió de Lloguer de Videojocs");
        
        
        DataStore.inicialitzarDades();
        carregarTaulaLloguers();
        configurarRenderitzadorTaula();
        
        
    }
    
    private void carregarTaulaLloguers() {
        
            String[] columnes = {"Num. Registre", "Títol del Joc", "Usuari", "Plataforma", "Data d'inici", "Data de Tornada", "Gènere"};
            DefaultTableModel model = new DefaultTableModel(columnes, 0) {
                
                @Override
                public boolean isCellEditable(int row, int column) { 
                    return false; 
                } // la tabla no se puede editar directamente
            };
            // esto es para ordenarl ode forma descendente
            for (int i = DataStore.lloguers.size() - 1; i >= 0; i--) {
                Lloguer ll = DataStore.lloguers.get(i);
                Object[] fila = {
                    String.format("%02d", ll.getNumRegistre()),
                    ll.getJoc().getTitol(),
                    ll.getUsuari().getNom() + " " + ll.getUsuari().getCognoms(),
                    ll.getPlataforma(),
                    ll.getDataInici().toString(),
                    ll.getDataPrevista().toString(),
                    ll.getJoc().getGenere()
                };
                model.addRow(fila);
            }
        jTableLloguers.setModel(model);
        jTableLloguers.setRowHeight(50);
        
        jLabelTotalLloguersValor.setText(DataStore.lloguers.size() + "");
    }
    
    private void configurarRenderitzadorTaula() { // el color de las filas
        jTableLloguers.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                
                int modelRow = table.convertRowIndexToModel(row);
                int numReg = Integer.parseInt(table.getModel().getValueAt(modelRow, 0).toString());

                
                Lloguer lloguer = DataStore.lloguers.stream().filter(l -> l.getNumRegistre() == numReg).findFirst().orElse(null);

                if (!isSelected && lloguer != null) {
                    if (lloguer.isRetornat()) {
                        c.setBackground(new Color(200, 255, 200));
                    } else if (LocalDate.now().isAfter(lloguer.getDataPrevista())) {
                        c.setBackground(new Color(255, 200, 200));
                    } else {
                        c.setBackground(Color.WHITE);
                    }
                }
                return c;
            }
            }
        );
    }
    
    
    /**
     * Como en la practica no se especifica una pantalla para borrar usuarios y juegos, voy a añadir pop ups, ya que es una funcionalidad simple
     * Pop up para borrar usuarios
     */
    private void borrarUsuari() {
        if (DataStore.usuaris.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hi ha usuaris per eliminar.", "Avís", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Usuari seleccionat = (Usuari) JOptionPane.showInputDialog(
                this,
                "Selecciona l'usuari que vols eliminar:",
                "Eliminar Usuari",
                JOptionPane.QUESTION_MESSAGE,
                null,
                DataStore.usuaris.toArray(),
                DataStore.usuaris.get(0)
        );

        if (seleccionat != null) {
            boolean teLloguersActius = DataStore.lloguers.stream()
                    .anyMatch(l -> l.getUsuari().equals(seleccionat) && !l.isRetornat());

            if (teLloguersActius) {
                JOptionPane.showMessageDialog(this,
                        "No es pot eliminar l'usuari perquè té lloguers actius.",
                        "Error d'eliminació",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                DataStore.usuaris.remove(seleccionat);
                JOptionPane.showMessageDialog(this,
                        "Usuari eliminat correctament.",
                        "Èxit",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Pop up para borrar juegos
     */
    private void borrarJoc() {
        if (DataStore.jocs.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hi ha jocs per eliminar.", "Avís", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Joc seleccionat = (Joc) JOptionPane.showInputDialog(
                this,
                "Selecciona el joc que vols eliminar:",
                "Eliminar Joc",
                JOptionPane.QUESTION_MESSAGE,
                null,
                DataStore.jocs.toArray(),
                DataStore.jocs.get(0)
        );

        if (seleccionat != null) {
            boolean teLloguersActius = DataStore.lloguers.stream()
                    .anyMatch(l -> l.getJoc().equals(seleccionat) && !l.isRetornat());

            if (teLloguersActius) {
                JOptionPane.showMessageDialog(this,
                        "No es pot eliminar el joc perquè té lloguers actius.",
                        "Error d'eliminació",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                DataStore.jocs.remove(seleccionat);
                JOptionPane.showMessageDialog(this,
                        "Joc eliminat correctament.",
                        "Èxit",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void canviarIdioma(String codiIdioma) {
        java.util.Locale locale = new java.util.Locale(codiIdioma);
        java.util.Locale.setDefault(locale);
        bundle = java.util.ResourceBundle.getBundle("spdvi/resources/Bundle", locale);
        actualitzarTextosPantalla();
    }

    private void actualitzarTextosPantalla() {
        if (bundle == null) return;
        
        setTitle(bundle.getString("Main.title"));
        
        menuLloguer.setText(bundle.getString("Main.menu.lloguer"));
        menuUsuari.setText(bundle.getString("Main.menu.usuari"));
        menuJoc.setText(bundle.getString("Main.menu.joc"));
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLloguers = new javax.swing.JTable();
        jLabelTotalLloguers = new javax.swing.JLabel();
        jLabelTotalLloguersValor = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuLloguer = new javax.swing.JMenu();
        jMenuItemRegistrarLloguer = new javax.swing.JMenuItem();
        jMenuItemTornarLloguer = new javax.swing.JMenuItem();
        menuUsuari = new javax.swing.JMenu();
        jMenuItemCrearUsuari = new javax.swing.JMenuItem();
        jMenuItemBorrarUsuari = new javax.swing.JMenuItem();
        menuJoc = new javax.swing.JMenu();
        jMenuItemCrearJoc = new javax.swing.JMenuItem();
        jMenuItemBorrarJoc = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableLloguers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Num. Registre", "Titol del Joc", "Usuari que l'ha llogat", "Plataforma", "Data d'inici", "Data de Tornada", "Gènere"
            }
        ));
        jScrollPane1.setViewportView(jTableLloguers);

        jLabelTotalLloguers.setText("Total de lloguers: ");

        jLabelTotalLloguersValor.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTotalLloguersValor.setText("0");

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));

        menuLloguer.setText("Lloguer");

        jMenuItemRegistrarLloguer.setText("Registrar...");
        jMenuItemRegistrarLloguer.addActionListener(this::jMenuItemRegistrarLloguerActionPerformed);
        menuLloguer.add(jMenuItemRegistrarLloguer);

        jMenuItemTornarLloguer.setText("Tornar...");
        jMenuItemTornarLloguer.addActionListener(this::jMenuItemTornarLloguerActionPerformed);
        menuLloguer.add(jMenuItemTornarLloguer);

        jMenuBar1.add(menuLloguer);

        menuUsuari.setText("Usuari");

        jMenuItemCrearUsuari.setText("Crear...");
        jMenuItemCrearUsuari.addActionListener(this::jMenuItemCrearUsuariActionPerformed);
        menuUsuari.add(jMenuItemCrearUsuari);

        jMenuItemBorrarUsuari.setText("Borrar...");
        jMenuItemBorrarUsuari.addActionListener(this::jMenuItemBorrarUsuariActionPerformed);
        menuUsuari.add(jMenuItemBorrarUsuari);

        jMenuBar1.add(menuUsuari);

        menuJoc.setText("Joc");

        jMenuItemCrearJoc.setText("Crear...");
        jMenuItemCrearJoc.addActionListener(this::jMenuItemCrearJocActionPerformed);
        menuJoc.add(jMenuItemCrearJoc);

        jMenuItemBorrarJoc.setText("Borrar...");
        jMenuItemBorrarJoc.addActionListener(this::jMenuItemBorrarJocActionPerformed);
        menuJoc.add(jMenuItemBorrarJoc);

        jMenuBar1.add(menuJoc);

        jMenu1.setText("Idioma");

        jMenuItem1.setText("Català");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Español");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("English");
        jMenuItem3.addActionListener(this::jMenuItem3ActionPerformed);
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelTotalLloguers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalLloguersValor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalLloguers)
                    .addComponent(jLabelTotalLloguersValor, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemRegistrarLloguerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistrarLloguerActionPerformed
        // TODO add your handling code here:
        LloguerScreen dialog = new LloguerScreen(this, true);
        dialog.setVisible(true);
        carregarTaulaLloguers();
    }//GEN-LAST:event_jMenuItemRegistrarLloguerActionPerformed

    private void jMenuItemTornarLloguerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTornarLloguerActionPerformed
        // TODO add your handling code here:
        TornarLloguerScreen dialog = new TornarLloguerScreen(this, true);
        dialog.setVisible(true);
        carregarTaulaLloguers();
    }//GEN-LAST:event_jMenuItemTornarLloguerActionPerformed

    private void jMenuItemCrearUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearUsuariActionPerformed
        // TODO add your handling code here:
        UsuariScreen dialog = new UsuariScreen(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemCrearUsuariActionPerformed

    private void jMenuItemBorrarUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBorrarUsuariActionPerformed
        // TODO add your handling code here:
        borrarUsuari();
    }//GEN-LAST:event_jMenuItemBorrarUsuariActionPerformed

    private void jMenuItemCrearJocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearJocActionPerformed
        // TODO add your handling code here:
        CrearJocScreen dialog = new CrearJocScreen(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemCrearJocActionPerformed

    private void jMenuItemBorrarJocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBorrarJocActionPerformed
        // TODO add your handling code here:
        borrarJoc();
    }//GEN-LAST:event_jMenuItemBorrarJocActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        canviarIdioma("ca");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        canviarIdioma("es");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        canviarIdioma("en");
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            // temas:
            // tema caro
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
            
            // tema mac claro
//            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.themes.FlatMacLightLaf());
            // tema mac oscuro
//            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.themes.FlatMacDarkLaf());
            

            
            // Si prefereixes el tema fosc, pots fer servir aquest:
            // javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("No s'ha pogut inicialitzar FlatLaf");
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTotalLloguers;
    private javax.swing.JLabel jLabelTotalLloguersValor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemBorrarJoc;
    private javax.swing.JMenuItem jMenuItemBorrarUsuari;
    private javax.swing.JMenuItem jMenuItemCrearJoc;
    private javax.swing.JMenuItem jMenuItemCrearUsuari;
    private javax.swing.JMenuItem jMenuItemRegistrarLloguer;
    private javax.swing.JMenuItem jMenuItemTornarLloguer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLloguers;
    private javax.swing.JMenu menuJoc;
    private javax.swing.JMenu menuLloguer;
    private javax.swing.JMenu menuUsuari;
    // End of variables declaration//GEN-END:variables
}
