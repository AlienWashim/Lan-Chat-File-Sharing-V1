
package Lan_Chat_and_File_Sharing;

import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wsakr
 */
public class client_chat extends javax.swing.JFrame {

    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;

    public client_chat() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        msg_send = new javax.swing.JButton();
        msg_text = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lan Chat & File Sharing");

        msg_area.setBackground(new java.awt.Color(204, 255, 255));
        msg_area.setColumns(20);
        msg_area.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        msg_send.setBackground(new java.awt.Color(102, 255, 153));
        msg_send.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        msg_send.setText("Send");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });

        msg_text.setBackground(new java.awt.Color(226, 255, 255));
        msg_text.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        msg_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                msg_textKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Client");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(msg_text)
                        .addGap(18, 18, 18)
                        .addComponent(msg_send, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(msg_send, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(msg_text))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed

        try {
            String msg = "";
            msg = msg_text.getText();
            dout.writeUTF(msg);
            msg_text.setText(msg);
            msg_area.setText(msg_area.getText() + "\n Sharmin : " + msg);
            msg_text.setText("");
        } catch (IOException ex) {
            Logger.getLogger(chat_server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_msg_sendActionPerformed

    private void msg_textKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_msg_textKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                String msg = "";
                msg = msg_text.getText();
                dout.writeUTF(msg);
                msg_text.setText(msg);
                msg_area.setText(msg_area.getText() + "\n Sharmin : " + msg);
                msg_text.setText("");
            } catch (IOException ex) {
                Logger.getLogger(chat_server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_msg_textKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client_chat().setVisible(true);
            }
        });
        try {
            String msgin = "";
            s = new Socket("192.168.0.102", 2034);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            while (!msgin.equals("exit")) {
                msgin = din.readUTF();
                msg_area.setText(msg_area.getText() + "\n Washim : " + msgin);
            }
        } catch (IOException ex) {
            Logger.getLogger(chat_server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    // End of variables declaration//GEN-END:variables
}
