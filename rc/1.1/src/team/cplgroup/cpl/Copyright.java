package team.cplgroup.cpl;


@SuppressWarnings("serial")
public class Copyright extends javax.swing.JFrame {

    /**
     * Creates new form Copyright
     */
    public Copyright() {
        initComponents();
        jTextArea1.setEditable(false);
        this.setVisible(true);
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("   Copyright 2019 CPL Group\n\n"
        		+ "   Licensed under the Apache License, Version 2.0 (the \"License\");\n"
        		+ "   you may not use this file except in compliance with the License.\n"
        		+ "   You may obtain a copy of the License at\n\n"
        		+ "       http://www.apache.org/licenses/LICENSE-2.0\n\n"
        		+ "   Unless required by applicable law or agreed to in writing, software\n"
        		+ "   distributed under the License is distributed on an \"AS IS\" BASIS,\n"
        		+ "   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
        		+ "   See the License for the specific language governing permissions and\n"
        		+ "   limitations under the License.\n");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        



    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}
