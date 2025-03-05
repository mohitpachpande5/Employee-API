package jdbcExamples;

import java.sql.*;
import java.util.*;

public class JDBC_Util {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/testDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    public static void main(String[] args) {
        Collection<Data> dataCollection = new ArrayList<>();
        dataCollection.add(new Data(1, "Anirudha", 40, 200000));
        dataCollection.add(new Data(2, "Amisha", 35, 100000));
        dataCollection.add(new Data(3, "Vaibhav", 25, 80000));

        try {
            // Insert new data
            insertTblRow("users", dataCollection);

            // Fetch and display data
            List<Data> users = readAllRows("users");
            System.out.println("\n📌 Data before Update:");
            users.forEach(System.out::println);

            // Update data using Collection
            Collection<Data> updatedUsers = new ArrayList<>();
            updatedUsers.add(new Data(1, "Ani", 41, 250000));  // Update record with id=1
            updatedUsers.add(new Data(2, "Ami", 36, 120000));  // Update record with id=2
            updateRows("users", updatedUsers);

            // Fetch and display updated data
            users = readAllRows("users");
            System.out.println("\n📌 Data after Update:");
            users.forEach(System.out::println);

            // Delete data using Collection
            Collection<Integer> deleteIds = Arrays.asList(2, 3); // Delete records with ID 2 and 3
            deleteRows("users", deleteIds);

            // Fetch and display final data
            users = readAllRows("users");
            System.out.println("\n📌 Data after Deletion:");
            users.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Establishes and returns a database connection.
     */
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Inserts multiple rows into the table using batch processing.
     */
    public static void insertTblRow(String tableName, Collection<Data> dataCollection) throws SQLException {
        String query = "INSERT INTO " + tableName + " VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            for (Data d : dataCollection) {
                pstmt.setInt(1, d.getId());
                pstmt.setString(2, d.getName());
                pstmt.setInt(3, d.getAge());
                pstmt.setFloat(4, d.getSalary());
                pstmt.addBatch();
            }

            int[] rowsInserted = pstmt.executeBatch();
            System.out.println("✅ " + rowsInserted.length + " rows inserted successfully into " + tableName);
        }
    }

    /**
     * Reads and returns all rows from the table as a List<Data>.
     */
    public static List<Data> readAllRows(String tableName) throws SQLException {
        List<Data> dataList = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Data data = new Data(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getFloat("salary")
                );
                dataList.add(data);
            }
        }
        return dataList;
    }

    /**
     * Updates multiple rows using a Collection<Data>.
     */
    public static void updateRows(String tableName, Collection<Data> dataCollection) throws SQLException {
        String query = "UPDATE " + tableName + " SET name=?, age=?, salary=? WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            for (Data d : dataCollection) {
                pstmt.setString(1, d.getName());
                pstmt.setInt(2, d.getAge());
                pstmt.setFloat(3, d.getSalary());
                pstmt.setInt(4, d.getId());
                pstmt.addBatch();
            }

            int[] rowsUpdated = pstmt.executeBatch();
            System.out.println("✅ " + rowsUpdated.length + " rows updated successfully in " + tableName);
        }
    }

    /**
     * Deletes multiple rows using a Collection<Integer> of IDs.
     */
    public static void deleteRows(String tableName, Collection<Integer> ids) throws SQLException {
        String query = "DELETE FROM " + tableName + " WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            for (int id : ids) {
                pstmt.setInt(1, id);
                pstmt.addBatch();
            }

            int[] rowsDeleted = pstmt.executeBatch();
            System.out.println("✅ " + rowsDeleted.length + " rows deleted successfully from " + tableName);
        }
    }
}

/**
 * Represents a Data object with ID, Name, Age, and Salary fields.
 */
class Data {
    private int id;
    private String name;
    private int age;
    private float salary;

    public Data(int id, String name, int age, float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public float getSalary() { return salary; }
    public void setSalary(float salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Data{id=" + id + ", name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}
