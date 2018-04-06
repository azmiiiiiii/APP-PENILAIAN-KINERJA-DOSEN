package com.app.siakad.entities;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.app.siakad.database.KoneksiDB;

public class Mahasiswa extends KoneksiDB{
    
    public String nim;
    public String kd_prodi;
    public int id_ta;
    public String nama_mhs;
    public String tmp_lahir;
    public String tgl_lahir;
    public String jk;
    public String agama;
    public String alamat;
    public String no_teleponhp;
    public String nama_ayah;
    public String nama_ibu;
    public String pkj_ayah;
    public String pkj_ibu;
    public String peng_ayah;
    public String peng_ibu;
    public String sta_mhs;
    public String pass;
    
    public void insert_update(){
        try{
            conn = getConnection();
            if(isUpdate == false){
                query = " insert into tbmahasiswa values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            }else{
                query = " update tbmahasiswa set nim=?, kd_prodi=?, "
                        + " id_ta=?, nama_mhs=?, "
                        + " tmp_lahir=?, tgl_lahir=?, jk=?, agama=?, alamat=?, no_teleponhp=?"
                        + " nama_ayah=?, nama_ibu=?, "
                        + " pkj_ayah=?, pkj_ibu=?, peng_ayah=?, peng_ibu=?, sta_mhs=?, pass=?, "
                        + " where nim='"+id_ta+"' ";
            }
            stat = conn.prepareStatement(query);
            stat.setString(1, nim);
            stat.setString(2, kd_prodi);
            stat.setInt(3, id_ta);
            stat.setString(4, nama_mhs);
            stat.setString(5, tmp_lahir);
            stat.setString(6, tgl_lahir);
            stat.setString(7, jk);
            stat.setString(8, agama);
            stat.setString(9, alamat);
            stat.setString(10, no_teleponhp);
            stat.setString(11, nama_ayah);
            stat.setString(12, nama_ibu);
            stat.setString(13, pkj_ayah);
            stat.setString(14, pkj_ibu);
            stat.setString(15, peng_ayah);
            stat.setString(16, peng_ibu);
            stat.setString(17, sta_mhs);
            stat.setString(18, pass);
            stat.executeUpdate();
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method insert_update() : " + ex);
        }
    }
    
    public void delete(String nim){
        try{
            conn = getConnection();
            query = "delete from tbmahasiswa where nim='"+id_ta+"' ";
            stat = conn.prepareStatement(query);
            stat.executeUpdate();
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void select(){
        tblmahasiswa.setColumnIdentifiers(new Object[]{"NIM", "Nama Mahasiswa", 
            "L/P", "Tempat", "Tgl. Lahir", "Program Studi", "Alamat", "No. Telepon"});
        try{
            conn = getConnection();
            query = " select * from tbmahasiswa a, tbthangkatan b, tbprodi c "
                    + " where a.id_ta=b.id_ta and a.kd_prodi=c.kd_prodi order by a.kd_prodi";
            stat = conn.prepareStatement(query);
            res = stat.executeQuery(query);
            list = new ArrayList<>();
            while(res.next()){
                nim = res.getString("nim");
                nama_mhs = res.getString("nama_mhs");
                jk = res.getString("jk");
                tmp_lahir = res.getString("tmp_lahir");
                tgl_lahir = tglview.format(res.getDate("tgl_lahir"));
                kd_prodi = res.getString("prodi");
                alamat = res.getString("alamat");
                no_teleponhp = res.getString("no_teleponhp");
                
                list.add(new Object[]{nim, nama_mhs, jk, tmp_lahir, 
                    tgl_lahir, kd_prodi, alamat, no_teleponhp});
            }
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method select() : " + ex);
        }
    }
    
    // Membuat NIM otomatis
    public void createNIM(){
        try{
            conn = getConnection();
            query = "select max(right(nim,4)) from tbmahasiswa where Left(nim, 5)='"+nim+"' ";
            stat = conn.prepareStatement(query);
            res = stat.executeQuery(query);
            if(res.first()){
                int noID = res.getInt(1) + 1;
                String no = String.valueOf(noID);
                int noLong = no.length();
                for(int a=0;a<2-noLong;a++){
                    no = "" + no;
                }
                if(noID < 1){
                    nim = nim+"0000" + no;
                }else if(noID < 10){
                    nim = nim+"000" + no;
                }else if(noID < 100){
                    nim = nim+"00" + no;
                }else if(noID < 1000){
                    nim = nim+"0" + no;
                } else{
                    nim = nim+""+ no;
                }
            }else{
                nim = nim+"0001";
            }
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error method createNIM() : " 
                    + ex, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
