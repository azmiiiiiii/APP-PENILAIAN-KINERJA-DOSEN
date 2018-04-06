package com.app.siakad.views;

import com.app.siakad.entities.KategoriKriteriaNilai;
import com.app.siakad.entities.KriteriaNilaiDosen;
import javax.swing.JTable;
import com.app.siakad.database.AutoFitTableColumns;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class IfrKategoriKriteriaNilai extends javax.swing.JInternalFrame {

    KategoriKriteriaNilai kn = new KategoriKriteriaNilai();
    KriteriaNilaiDosen kd = new KriteriaNilaiDosen();
    
    public IfrKategoriKriteriaNilai() {
        initComponents();
        
    }
    
    private void clearInput(){
        cmbThAngkatan.setSelectedIndex(0);
        cmbProdi.setSelectedIndex(0);
        txtKdKriteria.setText("");
        txtKatPenilaian.setText("");
        txtBobot.setText("");
        lblTambah.setText("Tambah");
        lblTGbrTambah.setText("Tambah");
        lblGbrSimpan.setText("Simpan");
        lblTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.app.siakad.icons/icons8_Add_List_20px.png")));
        lblTGbrTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.app.siakad.icons/icons8_Add_List_20px.png")));
        
    }
    
    private void disableInput(){
        cmbThAngkatan.setEnabled(false);
        cmbProdi.setEnabled(false);
        txtKdKriteria.setEditable(false);
        txtKatPenilaian.setEnabled(false);
        txtBobot.setEnabled(false);
        lblGbrSimpan.setEnabled(false);
        lblGbrSilang.setEnabled(false);
    }
    
    private void enableInput(){
       cmbThAngkatan.setEnabled(true);
        cmbProdi.setEnabled(true);
        txtKdKriteria.setEditable(true);
        txtKatPenilaian.setEnabled(true);
        txtBobot.setEnabled(true);
        lblGbrSimpan.setEnabled(true); 
    }
    
    private void showDataKategoriKriteriaNilai(){
        tblKatPenilaian.setModel(kn.tblkatn);
        int row = kn.tblkatn.getRowCount();
        for(int i=0; i<row; i++){
            kn.tblkatn.removeRow(0);
        }
        kn.select();
        for(Object obj: kn.list){
            kn.tblthangkatan.addRow((Object[]) obj);
        }
        tblKatPenilaian.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        AutoFitTableColumns tca = new AutoFitTableColumns(tblKatPenilaian);
        tca.adjustColumns();
        lblRecord.setText("Record : "+ tblKatPenilaian.getRowCount());
    }
    
    private void showDataKriteria(){
        tblDataKriteria.setModel(kd.tblknd);
        int row = kd.tblknd.getRowCount();
        for(int i=0; i<row; i++){
            kd.tblknd.removeRow(0);
        }
        kd.select();
        for(Object obj: kd.list){
            kd.tblknd.addRow((Object[]) obj);
        }
        tblDataKriteria.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        AutoFitTableColumns tca = new AutoFitTableColumns(tblDataKriteria);
        tca.adjustColumns();
        lblRecord.setText("Record : "+ tblDataKriteria.getRowCount());
        
    }
    

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelAlpha21 = new com.app.siakad.views.PanelAlpha2();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cmbThAngkatan = new javax.swing.JComboBox<>();
        cmbProdi = new javax.swing.JComboBox<>();
        lblTambah = new javax.swing.JLabel();
        panelAlpha22 = new com.app.siakad.views.PanelAlpha2();
        p = new javax.swing.JScrollPane();
        tblKatPenilaian = new javax.swing.JTable();
        lblRecord = new javax.swing.JLabel();
        panelAlpha23 = new com.app.siakad.views.PanelAlpha2();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtKdKriteria = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtKatPenilaian = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtBobot = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        panelAlpha24 = new com.app.siakad.views.PanelAlpha2();
        q = new javax.swing.JScrollPane();
        tblDataKriteria = new javax.swing.JTable();
        lblRecordKriteria = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblGbrSimpan = new javax.swing.JLabel();
        lblTGbrTambah = new javax.swing.JLabel();
        lblGbrSilang = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Apekido v1.0");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/desktop_22651 (1).png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Navigasi :");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        cmbThAngkatan.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        cmbThAngkatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Tahun Ajaran --" }));
        cmbThAngkatan.setOpaque(false);

        cmbProdi.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        cmbProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Program Studi --" }));
        cmbProdi.setOpaque(false);
        cmbProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProdiActionPerformed(evt);
            }
        });

        lblTambah.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblTambah.setForeground(new java.awt.Color(255, 255, 255));
        lblTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Add_List_20px.png"))); // NOI18N
        lblTambah.setText("Tambah");

        javax.swing.GroupLayout panelAlpha21Layout = new javax.swing.GroupLayout(panelAlpha21);
        panelAlpha21.setLayout(panelAlpha21Layout);
        panelAlpha21Layout.setHorizontalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlpha21Layout.createSequentialGroup()
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAlpha21Layout.createSequentialGroup()
                                .addComponent(cmbThAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTambah)
                                .addGap(0, 29, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))))
        );
        panelAlpha21Layout.setVerticalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbThAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        p.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Kategori Penilaian : Klik 2x untuk mengubah data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        p.setOpaque(false);

        tblKatPenilaian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Kode Kategori", "Kategori Penilaian", "Bobot"
            }
        ));
        p.setViewportView(tblKatPenilaian);

        lblRecord.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lblRecord.setForeground(new java.awt.Color(255, 255, 255));
        lblRecord.setText("Record :");

        javax.swing.GroupLayout panelAlpha22Layout = new javax.swing.GroupLayout(panelAlpha22);
        panelAlpha22.setLayout(panelAlpha22Layout);
        panelAlpha22Layout.setHorizontalGroup(
            panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addGroup(panelAlpha22Layout.createSequentialGroup()
                        .addComponent(lblRecord)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAlpha22Layout.setVerticalGroup(
            panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha22Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRecord)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Input Kriteria Penilaian :");

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kode Kriteria");

        txtKdKriteria.setForeground(new java.awt.Color(0, 153, 153));
        txtKdKriteria.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtKdKriteria.setDisabledTextColor(new java.awt.Color(0, 153, 153));
        txtKdKriteria.setOpaque(false);
        txtKdKriteria.setSelectionColor(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kategori Penilaian :");

        txtKatPenilaian.setForeground(new java.awt.Color(0, 153, 153));
        txtKatPenilaian.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtKatPenilaian.setDisabledTextColor(new java.awt.Color(0, 153, 153));
        txtKatPenilaian.setOpaque(false);
        txtKatPenilaian.setSelectionColor(new java.awt.Color(255, 255, 255));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bobot [%] :");

        txtBobot.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtBobot.setOpaque(false);

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelAlpha23Layout = new javax.swing.GroupLayout(panelAlpha23);
        panelAlpha23.setLayout(panelAlpha23Layout);
        panelAlpha23Layout.setHorizontalGroup(
            panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(panelAlpha23Layout.createSequentialGroup()
                        .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(panelAlpha23Layout.createSequentialGroup()
                                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtKdKriteria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(txtKatPenilaian, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                    .addComponent(jSeparator4))
                                .addGap(18, 18, 18)
                                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBobot)
                                    .addComponent(jSeparator5))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAlpha23Layout.setVerticalGroup(
            panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(1, 1, 1)
                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKdKriteria)
                    .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKatPenilaian, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBobot, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
                        .addComponent(jSeparator5))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        q.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Data Kriteria Penilaian : Klik 2x untuk mengubah data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        q.setForeground(new java.awt.Color(255, 255, 255));
        q.setOpaque(false);

        tblDataKriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "No.", "Kriteria Penilaian"
            }
        ));
        q.setViewportView(tblDataKriteria);

        lblRecordKriteria.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lblRecordKriteria.setForeground(new java.awt.Color(255, 255, 255));
        lblRecordKriteria.setText("Record :");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("|");

        lblGbrSimpan.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblGbrSimpan.setForeground(new java.awt.Color(255, 255, 255));
        lblGbrSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Save_as_20px.png"))); // NOI18N
        lblGbrSimpan.setText("Simpan");

        lblTGbrTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Add_List_20px.png"))); // NOI18N

        lblGbrSilang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Delete_File_20px.png"))); // NOI18N

        javax.swing.GroupLayout panelAlpha24Layout = new javax.swing.GroupLayout(panelAlpha24);
        panelAlpha24.setLayout(panelAlpha24Layout);
        panelAlpha24Layout.setHorizontalGroup(
            panelAlpha24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(q, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                    .addGroup(panelAlpha24Layout.createSequentialGroup()
                        .addComponent(lblRecordKriteria)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(lblTGbrTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGbrSilang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGbrSimpan)))
                .addContainerGap())
        );
        panelAlpha24Layout.setVerticalGroup(
            panelAlpha24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlpha24Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(q, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblTGbrTambah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGbrSilang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGbrSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecordKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAlpha22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlpha21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelAlpha23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlpha24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelAlpha23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlpha21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelAlpha22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlpha24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProdiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbProdi;
    private javax.swing.JComboBox<String> cmbThAngkatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblGbrSilang;
    private javax.swing.JLabel lblGbrSimpan;
    private javax.swing.JLabel lblRecord;
    private javax.swing.JLabel lblRecordKriteria;
    private javax.swing.JLabel lblTGbrTambah;
    private javax.swing.JLabel lblTambah;
    private javax.swing.JScrollPane p;
    private com.app.siakad.views.PanelAlpha2 panelAlpha21;
    private com.app.siakad.views.PanelAlpha2 panelAlpha22;
    private com.app.siakad.views.PanelAlpha2 panelAlpha23;
    private com.app.siakad.views.PanelAlpha2 panelAlpha24;
    private javax.swing.JScrollPane q;
    private javax.swing.JTable tblDataKriteria;
    private javax.swing.JTable tblKatPenilaian;
    private javax.swing.JTextField txtBobot;
    private javax.swing.JTextField txtKatPenilaian;
    private javax.swing.JTextField txtKdKriteria;
    // End of variables declaration//GEN-END:variables
}
