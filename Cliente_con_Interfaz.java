import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class cliente extends javax.swing.JFrame {

  public cliente() {
    initComponents();

    try {
      Socket socket = new Socket("127.0.0.1", 8189);
      BufferedReader br = new BufferedReader(
        new InputStreamReader(socket.getInputStream())
      );

      PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
      Mandar.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String Servidorboton = Mensaje.getText();
            pw.println(Servidorboton);
          }
        }
      );
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    Mandar = new javax.swing.JButton();
    Mensaje = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    Mandar.setText("ENVIAR");

    Mensaje.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          MensajeActionPerformed(evt);
        }
      }
    );

    jLabel1.setText("Di algo:");

    jLabel2.setText("CONEXION CON SERVIDOR.");

    jLabel3.setText("Rosales Sedano");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
      getContentPane()
    );
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addContainerGap(106, Short.MAX_VALUE)
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                  javax.swing.GroupLayout.Alignment.TRAILING,
                  layout
                    .createSequentialGroup()
                    .addComponent(Mandar)
                    .addGap(215, 215, 215)
                )
                .addGroup(
                  javax.swing.GroupLayout.Alignment.TRAILING,
                  layout
                    .createSequentialGroup()
                    .addComponent(jLabel1)
                    .addGap(61, 61, 61)
                    .addGroup(
                      layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addComponent(jLabel2)
                        .addComponent(
                          Mensaje,
                          javax.swing.GroupLayout.PREFERRED_SIZE,
                          282,
                          javax.swing.GroupLayout.PREFERRED_SIZE
                        )
                    )
                    .addGap(30, 30, 30)
                )
                .addGroup(
                  javax.swing.GroupLayout.Alignment.TRAILING,
                  layout
                    .createSequentialGroup()
                    .addComponent(jLabel3)
                    .addGap(62, 62, 62)
                )
            )
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
          layout
            .createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(jLabel2)
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.RELATED,
              88,
              Short.MAX_VALUE
            )
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                  Mensaje,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(jLabel1)
            )
            .addGap(69, 69, 69)
            .addComponent(Mandar)
            .addGap(37, 37, 37)
            .addComponent(jLabel3)
            .addContainerGap()
        )
    );

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void MensajeActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_MensajeActionPerformed
    // TODO add your handling code here:
  } //GEN-LAST:event_MensajeActionPerformed

  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger
        .getLogger(cliente.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(cliente.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(cliente.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(cliente.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Crear y mostrar el FORM */
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new cliente().setVisible(true);
        }
      }
    );
  }

  // Declaración de las vaciables//GEN-BEGIN:variables
  private javax.swing.JButton Mandar;
  private javax.swing.JTextField Mensaje;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  //GEN-END:variables
}
