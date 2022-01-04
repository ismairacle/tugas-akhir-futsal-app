/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekakhir.utils;

import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import projekakhir.model.Pesanan;
import java.sql.*;

/**
 *
 * @author Ismail
 */
public class Utils {

    private static Connection conn;

    public Calendar getDateAndHour(JDateChooser dateChooser, int jam) {

        Calendar calendar = new GregorianCalendar();
        Date date = dateChooser.getDate();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, jam);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar;

    }

    public Timestamp getTimestamp(JDateChooser dateChooser, int jam) {

        Calendar calendar = new GregorianCalendar();
        Date date = dateChooser.getDate();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, jam);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Timestamp ts = new Timestamp(calendar.getTime().getTime());

        return ts;

    }

    public Date timeStampToDate(Timestamp timestamp) {

        java.sql.Date date = new java.sql.Date(timestamp.getTime());
        return date;

    }

    public String generateRandomString(String head, int length) {
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        String alphaNumeric = upperAlphabet + numbers;
        StringBuilder sb = new StringBuilder();
        sb.append(head);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphaNumeric.length());
            char randomChar = alphaNumeric.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
    }
    
    public int getLamaMain(Pesanan pesanan) {
        
        Timestamp mulai = pesanan.getJamMulai();
        Timestamp selesai = pesanan.getJamSelesai();
        java.sql.Date dateMulai = new java.sql.Date(mulai.getTime());
        java.sql.Date dateSelesai = new java.sql.Date(selesai.getTime());
        Calendar calMulai = Calendar.getInstance();
        Calendar calSelesai = Calendar.getInstance();
        calMulai.setTime(dateMulai);
        calSelesai.setTime(dateSelesai);
        
        int result = calSelesai.get(Calendar.HOUR_OF_DAY) - calMulai.get(Calendar.HOUR_OF_DAY);
        return result;
    }

}
