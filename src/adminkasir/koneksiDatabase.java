/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminkasir;

import java.sql.*;

/**
 *
 * @author User
 */
public class koneksiDatabase {
    private static koneksiDatabase instance;
    private Connection koneksi;
   
    private koneksiDatabase(){
        String url= "jdbc:mysql://localhost:3306/databasekasir";
        String username = "root";
        String password = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.koneksi = DriverManager.getConnection(url, username, password);
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
         }
    }
    
    public static koneksiDatabase getInstance(){
        if(instance == null){
            instance = new koneksiDatabase();
        }
        return instance;
    }
    
    public Connection getConnection(){
        try {
            if (koneksi == null || koneksi.isClosed()) {
                // Reconnect if connection is null or closed
                instance = new koneksiDatabase();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return instance.koneksi;
    }
}
