package util;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Christian
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class Javaconnect {
    Connection conn;
    
public static Connection ConnecrDb(){
    try{
       Class.forName("org.sqlite.JDBC"); 
       Connection conn = DriverManager.getConnection("jdbc:sqlite:L:\\Tugas Kampus\\Semester 3\\OOP\\LibraryManagement\\LibraryDB.sqlite");
       return conn;
    }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
}   
}
