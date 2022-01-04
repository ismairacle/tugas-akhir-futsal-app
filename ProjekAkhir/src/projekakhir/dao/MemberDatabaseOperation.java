/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekakhir.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import projekakhir.DatabaseConnection;
import projekakhir.model.Member;
import projekakhir.model.Pesanan;

/**
 *
 * @author Ismail
 */
public class MemberDatabaseOperation {

    private static Connection conn;
    private Member member = new Member();

    public int cekMember(String kodeMember) {

        int result = 0;
        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT EXISTS (SELECT 1 FROM member WHERE id_member ='" + kodeMember + "' LIMIT 1) AS 'cek_member'";
            ResultSet resultSet = st.executeQuery(sql);
            resultSet.next();
            result = resultSet.getInt("cek_member");
            conn.close();
        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan : " + e.toString());

        }
        return result;

    }

    public void insertMember(Member member) {

        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();

            String kodeMember = member.getIdMember();
            String namaTeam = member.getNamaMember();
            String kontak = member.getKontak();
            String alamat = member.getAlamat();

            String query = "INSERT INTO member (id_member, nama_member, alamat, kontak) VALUES ('%s', '%s', '%s', '%s')";
            String sql = String.format(query, kodeMember, namaTeam, kontak, alamat);

            st.execute(sql);

            conn.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan (insertMember) : " + e.toString());

        }

    }

    public void updateMember(Member member, String kodeMember) {

        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();

            String namaTeam = member.getNamaMember();
            String kontak = member.getKontak();
            String alamat = member.getAlamat();

            String query = "UPDATE member SET nama_member = '%s', alamat = '%s', kontak = '%s' WHERE id_member = '%s'";
            String sql = String.format(query, namaTeam, kontak, alamat, kodeMember);

            st.execute(sql);

            conn.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan (insertMember) : " + e.toString());

        }

    }

    public List<Member> getAllMember() {

        List<Member> result = new ArrayList<>();
        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();

            String sql = "SELECT * FROM member";

            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                String idMember = resultSet.getString("id_member");
                String namaMember = resultSet.getString("nama_member");
                String alamat = resultSet.getString("alamat");
                String kontak = resultSet.getString("kontak");

                member = new Member(idMember, namaMember, alamat, kontak);
                result.add(member);

            }
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan (getAllMember) : " + ex.toString());
        }

        return result;

    }

    public Member getMemberByIdMember(String idMember) {
        Member result = new Member();
        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();

            String sql = "SELECT * FROM member WHERE id_member = '" + idMember + "'";

            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                String idMember1 = resultSet.getString("id_member");
                String namaMember = resultSet.getString("nama_member");
                String alamat = resultSet.getString("alamat");
                String kontak = resultSet.getString("kontak");

                result = new Member(idMember1, namaMember, alamat, kontak);

            }
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan (getMemberByIdMember) : " + ex.toString());
        }

        return result;
    }

    public void deleteMemberByKodeMember(String kodeMember) {

        try {
            conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            String query = "DELETE FROM member WHERE id_member = '" + kodeMember + "'";
            st.execute(query);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalahan (deleteMemberyByKodeMember) : " + ex.toString());
        }

    }
}
