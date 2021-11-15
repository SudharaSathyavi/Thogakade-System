package lk.ijse.POS.controller;


import lk.ijse.POS.db.DataBaseConnection;
import lk.ijse.POS.model.Customer;
import lk.ijse.POS.utils.CrudUtil;

import java.sql.*;
import java.util.ArrayList;

public class CustomerController {

    public boolean saveCustomer(Customer c) throws ClassNotFoundException, SQLException {
        //LOAD DRIVER
        /*Class.forName("com.mysql.cj.jdbc.Driver");
        //CREATE CONNECTION  (import java.sql.Connection)
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Thogakade", "root", "9999");*/
        //CREATE SQL
        //String query = "INSERT INTO Customer VALUES ('"+c.getId()+"','"+c.getName()+"','"+c.getAddress()+"','"+c.getSalary()+"')";
        //CREATE STATEMENT
        //Statement stm = con.createStatement();
        /*PreparedStatement stm = DataBaseConnection.getInstance().getConnection().prepareStatement(  "INSERT INTO Customer VALUES (?,?,?,?)");
        stm.setObject(1, c.getId());
        stm.setObject(2, c.getName());
        stm.setObject(3, c.getAddress());
        stm.setObject(4, c.getSalary());
        //CREATE EXECUTE  (INSERT,DELETE,UPDATE [executeUpdate])   (SELECT[executeQueary])
        return stm.executeUpdate() > 0;
        /*return isSaved>0;*/
        /*if (isSaved>0){
            return true;
        }
        return false;*/
        return CrudUtil.execute("INSERT INTO Customer VALUES (?,?,?,?)",c.getId(),c.getName(),c.getAddress(),c.getSalary());
    }

    public Customer searchCustomer(String id) throws ClassNotFoundException, SQLException {
        /*Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Thogakade", "root", "9999");*/
        //PreparedStatement stm = DataBaseConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Customer WHERE id=?");
        //stm.setObject(1, id);
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer WHERE id=?",id);
        if (rst.next()) {
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble("salary")
            );
        }

        return null;
    }


    public boolean updateCustomer(Customer c) throws SQLException, ClassNotFoundException {
        /*Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakade", "root", "9999");*/
        //PreparedStatement stm = DataBaseConnection.getInstance().getConnection().prepareStatement("UPDATE Customer SET name=?, address=?, salary=? WHERE id=?");
        /*stm.setObject(1, c.getName());
        stm.setObject(2, c.getAddress());
        stm.setObject(3, c.getSalary());
        stm.setObject(4, c.getId());*/
        return CrudUtil.execute("UPDATE Customer SET name=?, address=?, salary=? WHERE id=?",c.getName(),c.getAddress(),c.getSalary(),c.getId());
    }

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        /*Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakade", "root", "9999");*/
        /*PreparedStatement stm = DataBaseConnection.getInstance().getConnection().prepareStatement("DELETE FROM Customer WHERE id=?");
        stm.setObject(1, id);*/
        return CrudUtil.execute("DELETE FROM Customer WHERE id=?",id) ;
    }


    public ArrayList<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        /*Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakade", "root", "9999");*/
        /*PreparedStatement stm = DataBaseConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Customer");*/
        ArrayList<Customer> customerArray = new ArrayList();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer");
        while (rst.next()) {
            customerArray.add(
                    new Customer(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getDouble("salary")

                    )
            );

        }
        return customerArray;
    }

    public ArrayList<String>getAllCustomerIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> ids = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT id FROM Customer");
        while (rst.next()){
            ids.add(rst.getString(1));
        }
        return ids;
    }

}