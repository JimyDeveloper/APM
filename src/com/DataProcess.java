package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataProcess {

    public static String selectPassword(String name) {
        String pass = "";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT password FROM Users where name = '" + name + "'");
            ResultSet rst = stm.executeQuery();
            while (rst.next()) {
                pass = rst.getString(1);
            }
            conn.close();

        } catch (SQLException ex) {
            System.out.println("I am in SQLException");
        } catch (ClassNotFoundException ex) {
            System.out.println("I am in ClassNotFoundException");
        }
        return pass;
    }

    public static ObservableList<Registration> selectDataFromRegistration() {

        ObservableList<Registration> list = FXCollections.observableArrayList();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT department,"
                    + " station, object, leftDays, detail,"
                    + " lastCheck, nextCheck, location, registrationID FROM"
                    + " Registration");
            ResultSet rst = stm.executeQuery();

            while (rst.next()) {

                String department = rst.getString(1);
                String station = rst.getString(2);
                String object = rst.getString(3);
                int leftDays = Integer.valueOf(rst.getString(4));
                String detail = rst.getString(5);
                Date lastCheck = rst.getDate(6);
                Date nextCheck = rst.getDate(7);
                int location = Integer.valueOf(rst.getString(8));
                int registrationID = Integer.valueOf(rst.getString(9));
                Registration r = new Registration(department, station, object, leftDays, detail,
                        lastCheck, nextCheck, location, registrationID);
                list.add(r);
            }

            conn.close();

        } catch (SQLException ex) {
            System.out.println("I am in SQLException");
        } catch (ClassNotFoundException ex) {
            System.out.println("I am in ClassNotFoundException");
        }
        return list;
    }

    public static ObservableList<Registration> selectDataFromRegistration(int day) {

        ObservableList<Registration> list = FXCollections.observableArrayList();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT department,"
                    + " station, object, leftDays, detail,"
                    + " lastCheck, nextCheck, location, registrationID FROM"
                    + " Registration where leftDays = " + day);
            ResultSet rst = stm.executeQuery();

            while (rst.next()) {

                String department = rst.getString(1);
                String station = rst.getString(2);
                String object = rst.getString(3);
                int leftDays = Integer.valueOf(rst.getString(4));
                String detail = rst.getString(5);
                Date lastCheck = rst.getDate(6);
                Date nextCheck = rst.getDate(7);
                int location = Integer.valueOf(rst.getString(8));
                int registrationID = Integer.valueOf(rst.getString(9));
                Registration r = new Registration(department, station, object, leftDays, detail,
                        lastCheck, nextCheck, location, registrationID);
                list.add(r);
            }

            conn.close();

        } catch (SQLException ex) {
            System.out.println("I am in SQLException");
        } catch (ClassNotFoundException ex) {
            System.out.println("I am in ClassNotFoundException");
        }
        return list;
    }

    public static ArrayList selectLeftDays() {
        ArrayList<Integer> leftDaysList = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("select leftDays from Registration");
            ResultSet rst = stm.executeQuery();
            while (rst.next()) {
                leftDaysList.add(Integer.valueOf(rst.getString(1)));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in selectLeftDays");
        }

        return leftDaysList;
    }

    public static ObservableList<Registration> selectDepartment() {

        ObservableList<Registration> departmentList = FXCollections.observableArrayList();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("select depName from Department");
            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                departmentList.add(new Registration(rst.getString(1)));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in selectDepartment");
        }
        return departmentList;
    }

    public static ObservableList<Registration> selectDetail() {

        ObservableList<Registration> detailList = FXCollections.observableArrayList();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("select detailName, yearWarranty from Detail");
            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                detailList.add(new Registration(rst.getString(1), Integer.valueOf(rst.getString(2))));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in selectDetail");
        }
        return detailList;
    }

    public static int selectDetailWarranty(String detail) {
        int warranty = 0;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("select yearWarranty "
                    + "from Detail where detailName = '" + detail + "'");
            ResultSet rst = stm.executeQuery();
            while (rst.next()) {
                warranty = rst.getInt(1);
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in selectDetailWarranty");
        }
        return warranty;
    }

    public static ObservableList<Registration> selectObject() {

        ObservableList<Registration> departmentList = FXCollections.observableArrayList();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("select objectName from Object");
            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                departmentList.add(new Registration(rst.getString(1)));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in selectObject");
        }
        return departmentList;
    }

    public static ObservableList<Registration> selectStation() {

        ObservableList<Registration> departmentList = FXCollections.observableArrayList();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("select stationName from Station");
            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                departmentList.add(new Registration(rst.getString(1)));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in selectStation");
        }
        return departmentList;
    }

    public void insertRegistration(Registration reg) {

        try {
            try (Connection conn = DBConnection.getConnection()) {
                PreparedStatement stm = conn.prepareStatement("Insert into Registration("
                        + " department, station, object, leftDays, detail, lastCheck,"
                        + " nextCheck, location) values(?,?,?,?,?,?,?,?)");
                stm.setString(1, reg.getDepartment());
                stm.setString(2, reg.getStation());
                stm.setString(3, reg.getObject());
                stm.setInt(4, reg.getLeftDays());
                stm.setString(5, reg.getDetail());
                stm.setDate(6, reg.getLastCheck());
                stm.setDate(7, reg.getNextCheck());
                stm.setInt(8, reg.getLocation());
                stm.execute();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in insertRegistration");
        }
    }

    public void insertDepartment(Registration department) throws SQLException {

        try {
            try (Connection conn = DBConnection.getConnection()) {
                PreparedStatement stm = conn.prepareStatement("insert into "
                        + "Department(depName) values (?)");
                stm.setString(1, department.getName());
                stm.execute();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in insertDepartment");
        }
    }

    public void insertDetail(Registration department) throws SQLException {

        try {
            try (Connection conn = DBConnection.getConnection()) {
                PreparedStatement stm = conn.prepareStatement("insert into "
                        + "Detail(detailName, yearWarranty) values (?,?)");
                stm.setString(1, department.getName());
                stm.setInt(2, department.getWarranty());
                stm.execute();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in insertDetail");
        }
    }

    public void insertObject(Registration department) throws SQLException {

        try {
            try (Connection conn = DBConnection.getConnection()) {
                PreparedStatement stm = conn.prepareStatement("insert into "
                        + "Object(objectName) values (?)");
                stm.setString(1, department.getName());
                stm.execute();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in insertObject");
        }
    }

    public void insertStation(Registration department) throws SQLException {

        try {
            try (Connection conn = DBConnection.getConnection()) {
                PreparedStatement stm = conn.prepareStatement("insert into "
                        + "Station(stationName) values (?)");
                stm.setString(1, department.getName());
                stm.execute();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in insertStation");
        }
    }

    public static ObservableList<String> selectDepartmentForCBox() {

        ObservableList<String> departmentList = FXCollections.observableArrayList();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("select depName from Department");
            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                departmentList.add(rst.getString(1));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in selectDepartmentForCBox");
        }
        return departmentList;
    }

    public static ObservableList<String> selectDetailForCBox() {

        ObservableList<String> detailList = FXCollections.observableArrayList();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("select detailName from Detail");
            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                detailList.add(rst.getString(1));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in selectDetailForCBox");
        }
        return detailList;
    }

    public static ObservableList<String> selectObjectForCBox() {

        ObservableList<String> departmentList = FXCollections.observableArrayList();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("select objectName from Object");
            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                departmentList.add(rst.getString(1));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in selectObjectForCBox");
        }
        return departmentList;
    }

    public static ObservableList<String> selectStationForCBox() {

        ObservableList<String> departmentList = FXCollections.observableArrayList();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("select stationName from Station");
            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                departmentList.add(rst.getString(1));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in selectStationForCBox");
        }
        return departmentList;
    }

    public static void updateLeftDays() {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement("UPDATE Registration"
                    + " SET leftDays = (SELECT DATEDIFF(NOW(), nextCheck))");
            stm.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in updateLeftDays");
        }
    }

    public static void updateDate(int id, Date newDate, Date nextDate) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm1 = conn.prepareStatement("UPDATE Registration"
                    + " SET lastCheck = '" + newDate
                    + "' , nextCheck = '" + nextDate
                    + "' where registrationID = " + id);
            System.out.println("i am updateDate");
            stm1.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in updateDate");
        }
    }

    public static void deleteRegistraion(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm1 = conn.prepareStatement("DELETE FROM `Registration` WHERE registrationID = '" + id + "'");
            System.out.println("i am deleteRegistraion");
            stm1.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in deleteRegistraion");
        }
    }

    public static void deleteStation(String id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm1 = conn.prepareStatement("DELETE FROM `Station` WHERE stationName = '" + id + "'");
            System.out.println("i am deleteStation");
            stm1.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in deleteStation");
        }
    }

    public static void deleteObject(String id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm1 = conn.prepareStatement("DELETE FROM `Object` WHERE objectName = '" + id + "'");
            System.out.println("i am deleteObject");
            stm1.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in deleteObject");
        }
    }

    public static void deleteDetail(String id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm1 = conn.prepareStatement("DELETE FROM `Detail` WHERE detailName = '" + id + "'");
            System.out.println("i am deleteDetail");
            stm1.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in deleteDetail");
        }
    }

    public static void deleteDepartment(String id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stm1 = conn.prepareStatement("DELETE FROM `Department` WHERE depName = '" + id + "'");
            System.out.println("i am deleteDepartment");
            stm1.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("I am in deleteDepartment");
        }
    }

}
