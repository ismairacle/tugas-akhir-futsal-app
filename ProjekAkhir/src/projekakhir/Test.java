/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekakhir;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import projekakhir.dao.MemberDatabaseOperation;
import projekakhir.dao.PesananDatabaseOperation;
import projekakhir.model.Member;
import projekakhir.model.Pesanan;
import projekakhir.utils.Constants;
import projekakhir.utils.Utils;

/**
 *
 * @author Ismail
 */
public class Test {

    public static void main(String[] args) throws SQLException {

        PesananDatabaseOperation dao = new PesananDatabaseOperation();
        MemberDatabaseOperation daoMember = new MemberDatabaseOperation();
        Utils utils = new Utils();
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM");

//        Pesanan pesanan = new Pesanan("M-001", "Garuda", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 90000);
//        int lamaMain = dao.cariLamaMain("IFH8UK69");
//        System.out.println(String.valueOf(lamaMain));
//dao.insertPesanan(pesanan);
//        Scanner input = new Scanner(System.in);
//
//        List<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();
//
//        boolean ulang = false;
//
//        do {
//
//            for (int i = 0; i < 5; i++) {
//                System.out.println("Nama : ");
//                String nama = input.next();
//                System.out.println("Kelas : ");
//                String kelas = input.next();
//                mahasiswa.add(new Mahasiswa(nama, kelas));
//            }
//
//            
//            for (Mahasiswa obj : mahasiswa) {
//                System.out.println("Nama    :   "+obj.nama);
//                System.out.println("Kelas   :   "+obj.kelas);
//            }
//
//        } while (ulang);
//        int result = daoMember.cekMember("");
//        System.out.println(String.valueOf(result));
//        
//        Pesanan pesanan2 = dao.getPesananByKodePesanan("IFHMZ8SY");
//        System.out.println(pesanan2.getNamaTeam());
//        Pesanan pesanan = dao.getPesananByKodePesanan("IFH-1423D");
//        System.out.println(pesanan.getJamMulai());
//
//        Timestamp tanggal = pesanan.getJamMulai();
//        Date date = new Date(tanggal.getTime());
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//        
//        int lamaMain = utils.getLamaMain(pesanan);
//        System.out.println(lamaMain);


//        int result = dao.getTotalLamaSewa();
//        System.out.println(result);
//        
//        List<Pesanan> pesanan = dao.searchPesanan("Diproses", "A");
//        for (Pesanan pesanan1 : pesanan) {
//            System.out.println(pesanan1);
//        }
        
        Member member = daoMember.getMemberByIdMember("M-8BN");
        
        System.out.println(member.getNamaMember());
        member.setNamaMember("Ayus");
        System.out.println(member.getNamaMember());
        

    }
}

class Mahasiswa {

    public Mahasiswa(String nama, String kelas) {
        this.nama = nama;
        this.kelas = kelas;
    }

    String nama, kelas;
}
