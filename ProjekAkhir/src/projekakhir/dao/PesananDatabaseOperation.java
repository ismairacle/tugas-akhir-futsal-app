/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekakhir.dao;

import java.awt.Component;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projekakhir.DatabaseConnection;
import projekakhir.model.Pesanan;
import projekakhir.utils.Constants;
import projekakhir.utils.Utils;

/**
 *
 * @author Ismail
 */
public class PesananDatabaseOperation {

    private static Pesanan pesanan = new Pesanan();
    private static MemberDatabaseOperation memberDao = new MemberDatabaseOperation();
    private static Connection conn;
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM HH:mm");

    public List<Pesanan> getListPesananByStatus(String inputStatus) {

        List<Pesanan> result = new ArrayList<>();
        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            String sql = "";
            if (inputStatus.equals("Semua")) {
                sql = "SELECT * FROM pesanan";
            } else {
                sql = "SELECT * FROM pesanan WHERE status = '" + inputStatus + "'";
            }

            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                String namaTeam = resultSet.getString("nama_team");
                Timestamp jamMulai = resultSet.getTimestamp("jam_mulai");
                Timestamp jamSelesai = resultSet.getTimestamp("jam_selesai");
                int dp = resultSet.getInt("dp");
                int sisaBayar = resultSet.getInt("sisa_bayar");

                String status = resultSet.getString("status");
                String kodePesanan = resultSet.getString("kode_pesanan");
                String kodeMember = resultSet.getString("id_member");

                pesanan = new Pesanan(kodeMember, namaTeam, status, kodePesanan, jamMulai, jamSelesai, dp, sisaBayar);
                result.add(pesanan);

            }
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan (getListPesanan) : " + ex);
        }

        return result;
    }



    public Pesanan getPesananByKodePesanan(String kodePesanan) {

        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            String query = "SELECT * FROM pesanan WHERE kode_pesanan = '" + kodePesanan + "'";
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                String namaTeam = resultSet.getString("nama_team");
                Timestamp jamMulai = resultSet.getTimestamp("jam_mulai");
                Timestamp jamSelesai = resultSet.getTimestamp("jam_selesai");
                int dp = resultSet.getInt("dp");
                int sisaBayar = resultSet.getInt("sisa_bayar");
                String status = resultSet.getString("status");
                String kodePesanan1 = resultSet.getString("kode_pesanan");
                String kodeMember = resultSet.getString("id_member");

                pesanan = new Pesanan(kodeMember, namaTeam, status, kodePesanan1, jamMulai, jamSelesai, dp, sisaBayar);

            }
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan (getPesananByKodePesanan) : " + ex);
        }
        return pesanan;

    }

    public List<Pesanan> searchPesanan(String statusParam, String key) {

        List<Pesanan> result = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            String sql;
            if (statusParam.equals("Semua")) {
                sql = "SELECT * FROM pesanan WHERE nama_team LIKE '%" + key + "%'";
            } else {
                sql = "SELECT * FROM pesanan WHERE status = '" + statusParam + "' AND nama_team LIKE '%" + key + "%'";
            }

            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                String namaTeam = resultSet.getString("nama_team");
                Timestamp jamMulai = resultSet.getTimestamp("jam_mulai");
                Timestamp jamSelesai = resultSet.getTimestamp("jam_selesai");
                int dp = resultSet.getInt("dp");
                int sisaBayar = resultSet.getInt("sisa_bayar");
                String status = resultSet.getString("status");
                String kodePesanan = resultSet.getString("kode_pesanan");
                String kodeMember = resultSet.getString("id_member");

                pesanan = new Pesanan(kodeMember, namaTeam, status, kodePesanan, jamMulai, jamSelesai, dp, sisaBayar);
                result.add(pesanan);

            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan : " + e.toString());

        }
        return result;

    }

    public void insertPesanan(Pesanan pesanan) {

        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();

            String kodeMember = pesanan.getKodeMember();
            String namaTeam = pesanan.getNamaTeam();
            Timestamp jamMulai = pesanan.getJamMulai();
            Timestamp jamSelesai = pesanan.getJamSelesai();
            int dp = pesanan.getDp();
            String status = pesanan.getStatus();
            String kodePesanan = pesanan.getKodePesanan();

            String query = "INSERT INTO pesanan (nama_team, jam_mulai, jam_selesai, dp, status, kode_pesanan, id_member) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')";
            String sql = String.format(query, namaTeam, jamMulai, jamSelesai, dp, status, kodePesanan, kodeMember);
            st.execute(sql);

            conn.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan (insertPesanan) : " + e.toString());

        }

    }

    public void deletePesananByKodePesanan(String kodePesanan) {

        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            String query = "DELETE FROM pesanan WHERE kode_pesanan = '" + kodePesanan + "'";
            st.execute(query);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalahan (deletePesanananById) : " + ex.toString());
        }

    }

    public void updatePesananByKodePesanan(Pesanan pesanan, String kodePesanan) {

        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            String namaTeam = pesanan.getNamaTeam();
            Timestamp jamMulai = pesanan.getJamMulai();
            Timestamp jamSelesai = pesanan.getJamSelesai();
            int dp = pesanan.getDp();
            String status = pesanan.getStatus();
            String kodeMember = pesanan.getKodeMember();

            String query = "UPDATE pesanan SET nama_team = '%s', jam_mulai = '%s', jam_selesai = '%s', dp = '%s', status = '%s', id_member = '%s' WHERE kode_pesanan = '%s'";
            String sql = String.format(query, namaTeam, jamMulai, jamSelesai, dp, status, kodeMember, kodePesanan);
            st.execute(sql);

            conn.close();

        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalahan (updatePesanan) : " + ex.toString());
        }

    }

    public void setStatus(String kodePesanan, String status) {

        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();

            String query = "UPDATE `pesanan` SET status = '%s' WHERE `kode_pesanan`= '%s'";
            String sql = String.format(query, status, kodePesanan);
            st.execute(sql);
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan (setStatus) : " + ex.toString());
        }

    }

    public int cariSisaBayar(String kodePesanan, String kodeMember) {

        int result = 0;
        try {

            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            String query = "SELECT TIMESTAMPDIFF(HOUR, jam_mulai,jam_selesai) as lama_main, dp FROM `pesanan` WHERE `kode_pesanan`= '%s'";
            String sql = String.format(query, kodePesanan);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int lamaMain = rs.getInt("lama_main");
            int dp = rs.getInt("dp");

            int member = memberDao.cekMember(kodeMember);
            int totalBayar = 0;
            if (member == 1) {
                int x = lamaMain * Constants.TARIF;
                int diskon = x / 100 * 10;
                totalBayar = x - diskon;

            } else {
                totalBayar = lamaMain * Constants.TARIF;

            }
            result = totalBayar - dp;
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan (cariSisaBayar) : " + ex.toString());
        }
        return result;
    }

    public void insertSisaBayar(int sisaBayar, String kodePesanan) {

        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();

            String query = "UPDATE pesanan SET sisa_bayar = '%s' WHERE kode_pesanan = '%s'";
            String sql = String.format(query, sisaBayar, kodePesanan);
            st.execute(sql);

            conn.close();

        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalahan (updateSisaBayar) : " + ex.toString());
        }
    }

    public int getTotalPendapatan() {

        int result = 0;

        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT dp + sisa_bayar AS total_bayar FROM pesanan";
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                int totalBayar = resultSet.getInt("total_bayar");
                result += totalBayar;

            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan : " + e.toString());

        }
        return result;

    }

    public int getTotalLamaSewa() {

        int result = 0;

        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT SUM(TIMESTAMPDIFF(HOUR, jam_mulai,jam_selesai)) as lama_main FROM pesanan";
            ResultSet resultSet = st.executeQuery(sql);
            resultSet.next();
            result = resultSet.getInt("lama_main");

            conn.close();
        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan : " + e.toString());

        }
        return result;

    }

    public List<Pesanan> getListPesanan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
