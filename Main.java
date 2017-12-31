package database;

import java.awt.Color;

public class Main extends javax.swing.JFrame {
    
    public Main() {
        initComponents();
        this.setResizable(false);
        this.setTitle("مشروع قواعد المعطيات 2");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        member = new javax.swing.JButton();
        closure = new javax.swing.JButton();
        key = new javax.swing.JButton();
        ifmin = new javax.swing.JButton();
        schema = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        input_status = new javax.swing.JLabel();
        input = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("مشروع قواعد المعطيات 2");

        jLabel2.setText("جامعة تشرين - كلية الهندسة المعلوماتية ");

        jLabel3.setText("إشراف");

        jLabel4.setText("الدكتور أنور أبو  نقطة");

        jLabel5.setText("تقديم");

        jLabel6.setText("رهف بدور");

        jLabel7.setText("نور الهادي محمود");

        member.setText("العضوية");
        member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberActionPerformed(evt);
            }
        });

        closure.setText("اللصاقة");
        closure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closureActionPerformed(evt);
            }
        });

        key.setText("المفتاح");
        key.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyActionPerformed(evt);
            }
        });

        ifmin.setText("الاختصار");
        ifmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ifminActionPerformed(evt);
            }
        });

        schema.setText("التقسيم");
        schema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schemaActionPerformed(evt);
            }
        });

        jLabel8.setText("الوضع الحالي للدخل :");

        input_status.setForeground(new java.awt.Color(255, 0, 0));
        input_status.setText("غير جاهز :(");

        input.setText("تجهيز الدخل");
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        jButton1.setText("مسح الدخل");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(schema, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ifmin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(member, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(closure, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 417, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel6)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jLabel4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(234, 234, 234)
                                    .addComponent(jLabel7))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 247, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(input_status)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(input_status)
                    .addComponent(input)
                    .addComponent(jButton1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closure)
                    .addComponent(key)
                    .addComponent(member)
                    .addComponent(ifmin)
                    .addComponent(schema))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void closureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closureActionPerformed
        Closure cl = new Closure(this);
        cl.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_closureActionPerformed

    private void memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberActionPerformed
        Membership m = new Membership(this);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_memberActionPerformed

    private void keyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyActionPerformed
        Key k = new Key(this);
        k.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_keyActionPerformed

    private void ifminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ifminActionPerformed
        FMin f = new FMin(this);
        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ifminActionPerformed

    private void schemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemaActionPerformed
        Schema s = new Schema(this);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_schemaActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        Input in = new Input(this);
        in.setVisible(true);
    }//GEN-LAST:event_inputActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        helper = null;
        updateState();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
    }
    
    public Helper setHelper(Helper h){
        return this.helper = h;
    }
    public Helper getHelper(){
        return this.helper;
    }

    public void updateState() {
        if (helper == null) {
            input_status.setText("غير جاهز :( ");
            input_status.setForeground(Color.red);
        }else{
            input_status.setText("جاهز :D ");
            input_status.setForeground(Color.green);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closure;
    private javax.swing.JButton ifmin;
    private javax.swing.JButton input;
    private javax.swing.JLabel input_status;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton key;
    private javax.swing.JButton member;
    private javax.swing.JButton schema;
    // End of variables declaration//GEN-END:variables
    Helper helper;

    
}
