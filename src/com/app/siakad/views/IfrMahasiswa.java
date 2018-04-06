
package com.app.siakad.views;

import com.app.siakad.database.AutoFitTableColumns;
import com.app.siakad.entities.Mahasiswa;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class IfrMahasiswa extends javax.swing.JInternalFrame {
    
    Mahasiswa ma = new Mahasiswa();

    public IfrMahasiswa() {
        initComponents();
        
        
    }
    
    private void clearInput(){
        txtNim.setText("");
        txtKdProdi.setText("");
        txtIdTA.setText("");
        txtNamaMhs.setText("");
        txtTmpLahir.setText("");
        dtTglLahir.setDate(new Date());
        rdLaki.setSelected(false);
        rdPerempuan.setSelected(false);
        cmbAgama.setSelectedIndex(0);
        pnAlamat.setText("");
        txtNoTelepon.setText("");
        txtNamaAyah.setText("");
        txtNamaIbu.setText("");
        txtPekerjaanAyah.setText("");
        txtPekerjaanIbu.setText("");
        txtPenghasilanAyah.setText("");
        txtPenghasilanIbu.setText("");
        cmbStaMhs.setSelectedIndex(0);
        txtPassword.setText("");
        btntambah.setText("Tambah");
        btnSimpan.setText("Simpan");
        btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.app.siakad.icons/icons8_Add_List_20px.png")));
    }
    
    private void disableInput(){
        txtNim.setEnabled(false);
        txtKdProdi.setEnabled(false);
        txtIdTA.setEnabled(false);
        txtNamaMhs.setEnabled(false);
        txtTmpLahir.setEnabled(false);
        dtTglLahir.setEnabled(false);
        rdLaki.setEnabled(false);
        rdPerempuan.setEnabled(false);
        cmbAgama.setEnabled(false);
        pnAlamat.setEnabled(false);
        txtNoTelepon.setEnabled(false);
        txtNamaAyah.setEnabled(false);
        txtNamaIbu.setEnabled(false);
        txtPekerjaanAyah.setEnabled(false);
        txtPekerjaanIbu.setEnabled(false);
        txtPenghasilanAyah.setEnabled(false);
        txtPenghasilanIbu.setEnabled(false);
        cmbStaMhs.setEnabled(false);
        txtPassword.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(false);
    } 
    
    private void enableInput(){
        txtNim.setEnabled(true);
        txtKdProdi.setEnabled(true);
        txtIdTA.setEnabled(true);
        txtNamaMhs.setEnabled(true);
        txtTmpLahir.setEnabled(true);
        dtTglLahir.setEnabled(true);
        rdLaki.setEnabled(true);
        rdPerempuan.setEnabled(true);
        cmbAgama.setEnabled(true);
        pnAlamat.setEnabled(true);
        txtNoTelepon.setEnabled(true);
        txtNamaAyah.setEnabled(true);
        txtNamaIbu.setEnabled(true);
        txtPekerjaanAyah.setEnabled(true);
        txtPekerjaanIbu.setEnabled(true);
        txtPenghasilanAyah.setEnabled(true);
        txtPenghasilanIbu.setEnabled(true);
        cmbStaMhs.setEnabled(true);
        txtPassword.setEnabled(true);
        btnSimpan.setEnabled(true);
    }
    
    private void clearDataMahasiswa(){
        
    }
    
    private void showDataMahasiswa(){
        tblDataMhs.setModel(ma.tblmahasiswa);
        int row = ma.tblthangkatan.getRowCount();
        for(int i=0; i<row; i++){
            ma.tblmahasiswa.removeRow(0);
        }
        ma.select();
        for(Object obj: ma.list){
            ma.tblmahasiswa.addRow((Object[]) obj);
        }
        tblDataMhs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        AutoFitTableColumns tca = new AutoFitTableColumns(tblDataMhs);
        tca.adjustColumns();
        lblRecord.setText("Record : "+ tblDataMhs.getRowCount());
    }
    
    private void aksiSimpan(){
        if(txtNim.getText().equals("") || txtKdProdi.getText().equals("") || txtIdTA.getText().equals("") || txtNamaMhs.getText().equals("") || txtTmpLahir.getText().equals("") || pnAlamat.getText().equals("") || txtNoTelepon.getText().equals("") || txtNamaAyah.getText().equals("") || txtNamaIbu.getText().equals("") || txtPekerjaanAyah.getText().equals("") || txtPekerjaanIbu.getText().equals("") || txtPenghasilanAyah.getText().equals("") || txtPenghasilanIbu.getText().equals("") || txtPassword.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Mohon lengkapi data", 
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else if(cmbAgama.getSelectedIndex()<=0){
            JOptionPane.showMessageDialog(this, "Agama belum dipilih",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else if(cmbStaMhs.getSelectedIndex()<=0){
            JOptionPane.showMessageDialog(this, "Status Mahasiswa belum diisi",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else {
            ma.isUpdate = !btnSimpan.getText().equals("Simpan");
            ma.nim = ("");
            ma.id_ta = Integer.parseInt(txtIdTA.getText());
            ma.kd_prodi = ("");
            ma.nama_mhs =("");
            ma.tmp_lahir =("");
            ma.tgl_lahir =("");
            ma.jk =("");
            ma.agama=("");
            ma.alamat=("");
            ma.no_teleponhp=("");
            ma.nama_ayah=("");
            ma.nama_ibu=("");
            ma.pkj_ayah=("");
            ma.pkj_ibu=("");
            ma.peng_ayah=("");
            ma.peng_ibu=("");
            ma.sta_mhs=("");
            ma.pass=("");
            ma.insert_update();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            clearInput(); disableInput(); showDataMahasiswa();
    }
}
    
        
    private void aksiHapus(){
        if(txtNim.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Informasi",
                    "Anda belum memilih data yang akan dihapus", JOptionPane.INFORMATION_MESSAGE);
        }else {
            int jawab = JOptionPane.showConfirmDialog(this, "Apakah anda akan menghapus data ini? Kode : "+ma.nim,
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(jawab == JOptionPane.YES_OPTION){
                ma.delete(ma.nim); 
                JOptionPane.showMessageDialog(this, "Data Berhasil dihapus",
                        "Informasi", JOptionPane.INFORMATION_MESSAGE);
                clearInput(); disableInput(); showDataMahasiswa();
            }
            
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelAlpha21 = new com.app.siakad.views.PanelAlpha2();
        txtNim = new javax.swing.JTextField();
        txtIdTA = new javax.swing.JTextField();
        txtNamaMhs = new javax.swing.JTextField();
        txtTmpLahir = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        pnAlamat = new javax.swing.JEditorPane();
        jPanel3 = new javax.swing.JPanel();
        rdLaki = new javax.swing.JRadioButton();
        rdPerempuan = new javax.swing.JRadioButton();
        txtNamaAyah = new javax.swing.JTextField();
        txtNamaIbu = new javax.swing.JTextField();
        txtPenghasilanIbu = new javax.swing.JTextField();
        cmbStaMhs = new javax.swing.JComboBox<>();
        txtPassword = new javax.swing.JTextField();
        txtPekerjaanIbu = new javax.swing.JTextField();
        txtNoTelepon = new javax.swing.JTextField();
        txtPekerjaanAyah = new javax.swing.JTextField();
        txtPenghasilanAyah = new javax.swing.JTextField();
        dtTglLahir = new com.toedter.calendar.JDateChooser();
        cmbAgama = new javax.swing.JComboBox<>();
        txtKdProdi = new javax.swing.JTextField();
        panelAlpha22 = new com.app.siakad.views.PanelAlpha2();
        btntambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        panelAlpha23 = new com.app.siakad.views.PanelAlpha2();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDataMhs = new javax.swing.JTable();
        lblRecord = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setClosable(true);
        setTitle("Apekido v1.0");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/desktop_22651 (1).png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setToolTipText("");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/logo-medium.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("APLIKASI PENILAIAN KINERJA DOSEN");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AKADEMI KOMUNITAS NEGERI KAJEN");

        panelAlpha21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Form Mahasiswa :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        txtNim.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "NIM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNim.setOpaque(false);

        txtIdTA.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "ID. TA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtIdTA.setOpaque(false);

        txtNamaMhs.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Nama Mahasiswa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNamaMhs.setOpaque(false);

        txtTmpLahir.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Tempat Lahir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtTmpLahir.setOpaque(false);
        txtTmpLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTmpLahirActionPerformed(evt);
            }
        });

        pnAlamat.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Alamat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        pnAlamat.setOpaque(false);
        jScrollPane4.setViewportView(pnAlamat);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Jenis Kelamin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setOpaque(false);

        rdLaki.setForeground(new java.awt.Color(255, 255, 255));
        rdLaki.setText("Laki - laki");
        rdLaki.setOpaque(false);

        rdPerempuan.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        rdPerempuan.setForeground(new java.awt.Color(255, 255, 255));
        rdPerempuan.setText("Perempuan");
        rdPerempuan.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdLaki)
                    .addComponent(rdPerempuan))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(rdLaki, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtNamaAyah.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Nama Ayah", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNamaAyah.setOpaque(false);

        txtNamaIbu.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Nama Ibu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNamaIbu.setOpaque(false);

        txtPenghasilanIbu.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        txtPenghasilanIbu.setForeground(new java.awt.Color(255, 255, 255));
        txtPenghasilanIbu.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Penghasilan Ibu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPenghasilanIbu.setOpaque(false);

        cmbStaMhs.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        cmbStaMhs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "1", "2" }));
        cmbStaMhs.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Status Mahasiswa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11))); // NOI18N

        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPassword.setOpaque(false);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        txtPekerjaanIbu.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Pekerjaan Ibu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPekerjaanIbu.setOpaque(false);

        txtNoTelepon.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "No. Telepon ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNoTelepon.setOpaque(false);

        txtPekerjaanAyah.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Pekerjaan Ayah", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPekerjaanAyah.setOpaque(false);

        txtPenghasilanAyah.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Penghasilan Ayah", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPenghasilanAyah.setOpaque(false);

        dtTglLahir.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Tanggal Lahir"));
        dtTglLahir.setOpaque(false);

        cmbAgama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "Islam ", "Katholik", "Kriten", "Hindu ", "Budha" }));
        cmbAgama.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Agama"));

        txtKdProdi.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Kode Prodi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtKdProdi.setOpaque(false);
        txtKdProdi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKdProdiKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelAlpha21Layout = new javax.swing.GroupLayout(panelAlpha21);
        panelAlpha21.setLayout(panelAlpha21Layout);
        panelAlpha21Layout.setHorizontalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKdProdi))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPenghasilanAyah))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPenghasilanIbu, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaIbu, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(cmbAgama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addComponent(txtIdTA, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmbStaMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addComponent(txtTmpLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtTglLahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addComponent(txtNoTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaAyah, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addComponent(txtPekerjaanAyah, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPekerjaanIbu)))
                .addContainerGap())
        );
        panelAlpha21Layout.setVerticalGroup(
            panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha21Layout.createSequentialGroup()
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlpha21Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlpha21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtKdProdi)
                            .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNim)
                                .addComponent(txtIdTA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNamaMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTmpLahir)))
                        .addGap(13, 13, 13)))
                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNoTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaAyah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAlpha21Layout.createSequentialGroup()
                                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelAlpha21Layout.createSequentialGroup()
                                        .addComponent(cmbAgama, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtNamaIbu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPekerjaanAyah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPekerjaanIbu)))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelAlpha21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPenghasilanIbu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbStaMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPenghasilanAyah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panelAlpha22.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Navigasi : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        btntambah.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Add_List_20px.png"))); // NOI18N
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnSimpan.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Save_as_20px.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/siakad/icons/icons8_Delete_File_20px.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAlpha22Layout = new javax.swing.GroupLayout(panelAlpha22);
        panelAlpha22.setLayout(panelAlpha22Layout);
        panelAlpha22Layout.setHorizontalGroup(
            panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btntambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAlpha22Layout.setVerticalGroup(
            panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Tabel Mahasiswa : Klik 2x pada tabel untuk mengubah / menghapus data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jScrollPane1.setOpaque(false);
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tblDataMhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "KD. Prodi", "ID. TA", "Nm Mhs", "Tmp Lahir", "Tgl Lahir", "Alamat", "Jns Kel", "Agama", "No. Telp", "Nama Ayah", "Nama Ibu", "Pek. Ayah", "Pek. Ibu", "Penghasilan Ayah", "Penghasilan Ibu", "Sta Mhs", "Password"
            }
        ));
        tblDataMhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMhsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDataMhs);

        jScrollPane1.setViewportView(jScrollPane3);

        lblRecord.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lblRecord.setForeground(new java.awt.Color(255, 255, 255));
        lblRecord.setText("Record : 0");

        javax.swing.GroupLayout panelAlpha23Layout = new javax.swing.GroupLayout(panelAlpha23);
        panelAlpha23.setLayout(panelAlpha23Layout);
        panelAlpha23Layout.setHorizontalGroup(
            panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecord)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAlpha23Layout.setVerticalGroup(
            panelAlpha23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlpha23Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecord)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelAlpha22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlpha23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlpha21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAlpha21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(panelAlpha22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAlpha23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void txtTmpLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTmpLahirActionPerformed
    
    }//GEN-LAST:event_txtTmpLahirActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        aksiSimpan();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
       if(btntambah.getText().equals("Tambah")){
           clearInput();
           enableInput();
           btntambah.setText("Batal");
           ma.createNIM();
           txtNim.setText("");
           txtIdTA.requestFocus(true);
           txtNamaMhs.requestFocus(true);
           txtTmpLahir.requestFocus(true);
           dtTglLahir.requestFocus(true);
           pnAlamat.requestFocus(true);
           txtNoTelepon.requestFocus(true);
           txtNamaAyah.requestFocus(true);
           txtNamaIbu.requestFocus(true);
           txtPekerjaanAyah.requestFocus(true);
           txtPekerjaanIbu.requestFocus(true);
           txtPenghasilanAyah.requestFocus(true);
           txtPenghasilanIbu.requestFocus(true);
           txtIdTA.requestFocus(true);
           txtPassword.requestFocus(true);
           btntambah.setIcon(new javax.swing.ImageIcon(getClass().
                   getResource("/com.app.siakad.icons/icons_Add_List_20px.png")));
       }else if(btntambah.getText().equals("Batal")){
           clearInput();
           disableInput();
           btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.app.siakad.icons/icons_Add_List_20px.png")));
           
       }
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
       aksiSimpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        aksiHapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblDataMhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMhsMouseClicked
       if(evt.getClickCount() == 2){
           int row = tblDataMhs.getSelectedRow();
           ma.nim = ("");
           ma.kd_prodi =("");
           ma.id_ta = Integer.parseInt(tblDataMhs.getValueAt(row, 0).toString());
           ma.nama_mhs=("");
           ma.tmp_lahir=("");
           ma.tgl_lahir=("");
           ma.jk=("");
           ma.agama=("");
           ma.alamat=("");
           ma.no_teleponhp=("");
           ma.nama_ayah=("");
           ma.nama_ibu=("");
           ma.pkj_ayah=("");
           ma.pkj_ibu=("");
           ma.peng_ayah=("");
           ma.peng_ibu=("");
           ma.sta_mhs=("");
           ma.pass=("");
           
           txtNim.setText("");
           txtKdProdi.setText("");
           txtIdTA.setText(Integer.toString(ma.id_ta));
           txtNamaMhs.setText("");
           txtTmpLahir.setText("");
           
           
           
           enableInput();
           txtIdTA.setEnabled(false);
           btnHapus.setEnabled(true);
           btnSimpan.setText("Ubah");
       }
    }//GEN-LAST:event_tblDataMhsMouseClicked

    private void txtKdProdiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKdProdiKeyTyped
        if(txtKdProdi.getText().length()==4){
            evt.consume();
        }
    }//GEN-LAST:event_txtKdProdiKeyTyped

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cmbAgama;
    private javax.swing.JComboBox<String> cmbStaMhs;
    private com.toedter.calendar.JDateChooser dtTglLahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblRecord;
    private com.app.siakad.views.PanelAlpha2 panelAlpha21;
    private com.app.siakad.views.PanelAlpha2 panelAlpha22;
    private com.app.siakad.views.PanelAlpha2 panelAlpha23;
    private javax.swing.JEditorPane pnAlamat;
    private javax.swing.JRadioButton rdLaki;
    private javax.swing.JRadioButton rdPerempuan;
    private javax.swing.JTable tblDataMhs;
    private javax.swing.JTextField txtIdTA;
    private javax.swing.JTextField txtKdProdi;
    private javax.swing.JTextField txtNamaAyah;
    private javax.swing.JTextField txtNamaIbu;
    private javax.swing.JTextField txtNamaMhs;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtNoTelepon;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPekerjaanAyah;
    private javax.swing.JTextField txtPekerjaanIbu;
    private javax.swing.JTextField txtPenghasilanAyah;
    private javax.swing.JTextField txtPenghasilanIbu;
    private javax.swing.JTextField txtTmpLahir;
    // End of variables declaration//GEN-END:variables
}
