/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

/**
 *
 * @author Mag
 */
public class Ajuda extends javax.swing.JFrame {

    /**
     * Creates new form Ajuda
     */
    public Ajuda() {
        initComponents();
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
        tfHelp = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajuda");
        setResizable(false);

        tfHelp.setColumns(20);
        tfHelp.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tfHelp.setLineWrap(true);
        tfHelp.setRows(5);
        tfHelp.setText("- O que é, e por que usar Doctriz?\n\n    Doctriz (\"Geratriz de Documentos\") é uma simples solução para a criação consecutiva de vários arquivos padronizados. Com ela, você pode agilizar a criação de vários arquivos de qualquer extensão, utilizando nomes que seguem um padrão e/ou sequência numérica. Ex: documento1.dat, documento2.dat, documento3.dat.\n\n    Além disso, a plataforma permite o uso de um único modelo, completamente customizável para cada tipo de arquivo. Assim você pode escolher e criar sua própria padronização para cada documento gerado em seu respectivo formato e extensão. Ou seja, é possível se criar um modelo para arquivos html. Assim, todo arquivo .html que for criado após a definição do modelo, irá seguir este padrão.\n\n- Comandos Doctriz?\n\n    A Doctriz oferece alguns comandos para a inserção ou modificação de modelos de documento. Todo comando Doctriz, é iniciado com \"!dt-\" (sem aspas). Desta maneira, o interpretador interno da plataforma irá ler a instrução e executar o respectivo comando. Atualmente, existem apenas dois comandos Doctriz, sendo eles:\n\n-- !dt-docname: Ao passar pelo interpretador Doctriz, este comando será substituído pelo respectivo nome do arquivo que está sendo gerado. Ex: \"<title>!dt-docname</title>\", poderia ser substituído por \"<title>Nome-Do-Arquivo</title>.\n\n-- !dt-date: Ao ser lido pelo Interpretador Doctriz, este comando será substituído pela data atual do sistema, utilizando o formato dd/mm/yyyy.\n\n- Como usar Doctriz?\n\n    Doctriz é uma plataforma fácil e prática de ser utilizada. Inicialmente, executamos o arquivo .jar da plataforma. Com isso a janela principal será iniciada. O primeiro campo a ser preenchido é o campo \"Prefixo\", nele deverá ser inserido o padrão de nomeação dos arquivos. Exemplo: O prefixo \"arq\" irá gerar arquivos como \"arq1\", \"arq2\", \"arq3\"... Enquanto o prefixo \"doc\" irá gerar algo como \"doc1\", \"doc2\", e assim por diante. \n\t\n    O segundo campo é chamado \"Extensão.\" Como o próprio nome diz, nele deverá ser inserido a extenção dos arquivos. Não há necessidade do uso de pontos. Por fim, temos o campo \"Quantidade\", os botões \"Gerar Em\" e \"Customizar Modelo\". O campo serve para delimitar a quantidade de arquivos gerados por vez (não há limite). O primeiro botão irá abrir uma janela, pedindo o local onde os arquivos deverão ser gerados, e logo após irá gerar os  documentos. Já o botão \"Customizar Modelo\", te dará acesso ao modelo da Extensão que tiver inserida no instante do clique. Lembre-se que aplicar os comandos Doctriz nestes modelos.\n  \n");
        tfHelp.setWrapStyleWord(true);
        tfHelp.setCaretPosition(0);
        tfHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tfHelp.setDragEnabled(true);
        tfHelp.setFocusable(false);
        tfHelp.setOpaque(true);
        jScrollPane1.setViewportView(tfHelp);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ajuda - Doctriz");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ajuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ajuda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tfHelp;
    // End of variables declaration//GEN-END:variables
}
