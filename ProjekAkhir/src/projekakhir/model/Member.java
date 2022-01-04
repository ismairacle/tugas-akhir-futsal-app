/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekakhir.model;

import projekakhir.utils.Utils;

/**
 *
 * @author Ismail
 */
public class Member {

    //inisialisasi
    public Member() {
    }
    Utils util = new Utils();
    private String idMember, namaMember, alamat, kontak;

    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public String getNamaMember() {
        return namaMember;
    }

    public void setNamaMember(String namaMember) {
        this.namaMember = namaMember;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKontak() {
        return kontak;
    }

    //constructor untuk get data
    public Member(String idMember, String namaMember, String alamat, String kontak) {
        this.idMember = idMember;
        this.namaMember = namaMember;
        this.alamat = alamat;
        this.kontak = kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    //constructor untuk insert
    public Member(String namaMember, String alamat, String kontak) {
        String idMember = util.generateRandomString("M-", 3);

        this.idMember = idMember;
        this.namaMember = namaMember;
        this.alamat = alamat;
        this.kontak = kontak;
    }

}
