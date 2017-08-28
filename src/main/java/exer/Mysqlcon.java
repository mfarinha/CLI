package exer;

import java.sql.*;

public class Mysqlcon {


    static Connection con;
    private PreparedStatement stmt;
    static boolean logged;
    private String username;
    private String password;


    public void connection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DevDB","root","root");

    }


    public void validateUsernameAndPassowrd(String user, String pass) throws SQLException, ClassNotFoundException {
        this.connection();

        String query = "SELECT userName FROM User WHERE userName = ?";
        String query2 = "INSERT INTO User (userName, contrasenha) VALUES (?, ?)";
        stmt = con.prepareStatement(query);
        stmt.setString(1,user);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        if ( rs.next() == true){

            System.out.println("User already in use!");
        }else
        {
            stmt = con.prepareStatement(query2);
            stmt.setString(1,user);
            stmt.setString(2,pass);
            stmt.execute();
        }
        con.close();
    }


    public void login (String user, String pass) throws SQLException, ClassNotFoundException {
        this.connection();

        String query = "SELECT userName, contrasenha FROM User WHERE userName = ? AND contrasenha = ?";
        stmt = con.prepareStatement(query);
        stmt.setString(1, user);
        stmt.setString(2, pass);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        if (rs.getString(1).equalsIgnoreCase(user) && rs.getString(2).equalsIgnoreCase(pass))
        {
            logged = true;
            System.out.println("Welcome! " + user);
        }else{
            System.out.println("Incorrect user or password!");
        }
        con.close();
    }

/*
    private void setUsername(ResultSet rs) throws SQLException {
        this.username = rs.getString("userName");
    }

    private void setPassword(ResultSet rs) throws SQLException {
        this.password = rs.getString("contrasenha");
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void print()
    {
        System.out.println("Username "+ this.username +" Password "+ this.password);
    }
*/



}
