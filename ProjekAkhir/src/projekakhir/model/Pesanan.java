/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekakhir.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import projekakhir.utils.Constants;
import projekakhir.utils.Utils;

/**
 *
 * @author Ismail
 */
public class Pesanan {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM HH:mm");
    Utils util = new Utils();
    private String namaTeam, status, kodePesanan, kodeMember;

    public String getKodeMember() {
        return kodeMember;
    }
    private Timestamp jamMulai, jamSelesai;
    private int dp, sisaBayar;

    public int getSisaBayar() {
        return sisaBayar;
    }

    public void setSisaBayar(int sisaBayar) {
        this.sisaBayar = sisaBayar;
    }
    
    //untuk update pesanan
    public Pesanan(String kodeMember, String namaTeam, String status, String kodePesanan, Timestamp jamMulai, Timestamp jamSelesai, int dp) {
        this.namaTeam = namaTeam;
        this.status = status;
        this.kodePesanan = kodePesanan;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.dp = dp;
        this.kodeMember = kodeMember;
    }
    
        public Pesanan(String kodeMember, String namaTeam, String status, String kodePesanan, Timestamp jamMulai, Timestamp jamSelesai, int dp, int sisaBayar) {
        this.namaTeam = namaTeam;
        this.status = status;
        this.kodePesanan = kodePesanan;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.dp = dp;
        this.kodeMember = kodeMember;
        this.sisaBayar = sisaBayar;
    }
    
    //untuk insert pesanan baru
    public Pesanan(String kodeMember, String namaTeam, Timestamp jamMulai, Timestamp jamSelesai, int dp) {
        
        String kodePesanan1 = util.generateRandomString("IFH",5);
        this.kodeMember = kodeMember;
        this.namaTeam = namaTeam;
        this.status = Constants.DIPROSES;
        this.kodePesanan = kodePesanan1;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.dp = dp;
    }
    
    


    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pesanan() {
    }

    public String getKodePesanan() {
        return kodePesanan;
    }

    public void setKodePesanan(String kodePesanan) {
        this.kodePesanan = kodePesanan;
    }





    public String getNamaTeam() {
        return namaTeam;
    }

    public void setNamaTeam(String namaTeam) {
        this.namaTeam = namaTeam;
    }

    public Timestamp getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(Timestamp jamMulai) {
        this.jamMulai = jamMulai;
    }

    public Timestamp getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(Timestamp jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }
    


    
    
}
