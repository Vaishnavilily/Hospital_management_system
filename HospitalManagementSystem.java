import java.sql.*;

public class HospitalManagementSystem {
    // Database connection details
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/hospital";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try{
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Perform database operations (add, update, delete)

        } catch(Exception e){
            e.printStackTrace();
        } finally{
            try{
                if(stmt != null) stmt.close();
            } catch(SQLException se2) {
            } try{
                if(conn != null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    // Functions for adding, updating, deleting patients, doctors, staff, and appointments
   public void addPatient(String patientName, String patientDetails) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try{
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "INSERT INTO patients (patient_name, patient_details) VALUES (?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, patientName);
        stmt.setString(2, patientDetails);
        stmt.executeUpdate();
        System.out.println("Patient added successfully.");
    } catch(SQLException e) {
        e.printStackTrace();
    } finally{
        try{
            if(stmt != null) stmt.close();
        } catch(SQLException se2) {
        } try{
            if(conn != null) conn.close();
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
}
    
    public void updatePatient(int patientId, String newDetails) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try{
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "UPDATE patients SET patient_details = ? WHERE patient_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, newDetails);
        stmt.setInt(2, patientId);
        int rowsAffected = stmt.executeUpdate();
        
        if(rowsAffected > 0) {
            System.out.println("Patient with ID " + patientId + " updated successfully.");
        } else {
            System.out.println("Patient with ID " + patientId + " not found.");
        }
    } catch(SQLException e) {
        e.printStackTrace();
    } finally{
        try{
            if(stmt != null) stmt.close();
        } catch(SQLException se2) {
        } try{
            if(conn != null) conn.close();
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
}
    
   public void deletePatient(int patientId) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try{
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, patientId);
        int rowsAffected = stmt.executeUpdate();
        
        if(rowsAffected > 0) {
            System.out.println("Patient with ID " + patientId + " deleted successfully.");
        } else {
            System.out.println("Patient with ID " + patientId + " not found.");
        }
    } catch(SQLException e) {
        e.printStackTrace();
    } finally{
        try{
            if(stmt != null) stmt.close();
        } catch(SQLException se2) {
        } try{
            if(conn != null) conn.close();
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
}
    
   public void addDoctor(String doctorName, String specialization) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try{
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "INSERT INTO doctors (doctor_name, specialization) VALUES (?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, doctorName);
        stmt.setString(2, specialization);
        stmt.executeUpdate();
        System.out.println("Doctor added successfully.");
    } catch(SQLException e) {
        e.printStackTrace();
    } finally{
        try{
            if(stmt != null) stmt.close();
        } catch(SQLException se2) {
        } try{
            if(conn != null) conn.close();
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
}
  
    public void updateDoctor(int doctorId, String newSpecialization) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try{
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "UPDATE doctors SET specialization = ? WHERE doctor_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, newSpecialization);
        stmt.setInt(2, doctorId);
        int rowsAffected = stmt.executeUpdate();
        
        if(rowsAffected > 0) {
            System.out.println("Doctor with ID " + doctorId + " updated successfully.");
        } else {
            System.out.println("Doctor with ID " + doctorId + " not found.");
        }
    } catch(SQLException e) {
        e.printStackTrace();
    } finally{
        try{
            if(stmt != null) stmt.close();
        } catch(SQLException se2) {
        } try{
            if(conn != null) conn.close();
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
}
    
    public void deleteDoctor(int doctorId) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try{
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "DELETE FROM doctors WHERE doctor_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, doctorId);
        int rowsAffected = stmt.executeUpdate();
        
        if(rowsAffected > 0) {
            System.out.println("Doctor with ID " + doctorId + " deleted successfully.");
        } else {
            System.out.println("Doctor with ID " + doctorId + " not found.");
        }
    } catch(SQLException e) {
        e.printStackTrace();
    } finally{
        try{
            if(stmt != null) stmt.close();
        } catch(SQLException se2) {
        } try{
            if(conn != null) conn.close();
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
}
    
   public void addStaff(String staffName, String role) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try{
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "INSERT INTO staff (staff_name, role) VALUES (?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, staffName);
        stmt.setString(2, role);
        stmt.executeUpdate();
        System.out.println("Staff member added successfully.");
    } catch(SQLException e) {
        e.printStackTrace();
    } finally{
        try{
            if(stmt != null) stmt.close();
        } catch(SQLException se2) {
        } try{
            if(conn != null) conn.close();
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
}
    public void updateStaff(int staffId, String newRole) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try{
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "UPDATE staff SET role = ? WHERE staff_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, newRole);
        stmt.setInt(2, staffId);
        int rowsAffected = stmt.executeUpdate();
        
        if(rowsAffected > 0) {
            System.out.println("Staff member with ID " + staffId + " updated successfully.");
        } else {
            System.out.println("Staff member with ID " + staffId + " not found.");
        }
    } catch(SQLException e) {
        e.printStackTrace();
    } finally{
        try{
            if(stmt != null) stmt.close();
        } catch(SQLException se2) {
        } try{
            if(conn != null) conn.close();
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
}
    
   public void deleteStaff(int staffId) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try{
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "DELETE FROM staff WHERE staff_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, staffId);
        int rowsAffected = stmt.executeUpdate();
        
        if(rowsAffected > 0) {
            System.out.println("Staff member with ID " + staffId + " deleted successfully.");
        } else {
            System.out.println("Staff member with ID " + staffId + " not found.");
        }
    } catch(SQLException e) {
        e.printStackTrace();
    } finally{
        try{
            if(stmt != null) stmt.close();
        } catch(SQLException se2) {
        } try{
            if(conn != null) conn.close();
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
}
    
   public void scheduleAppointment(int patientId, int doctorId, LocalDateTime appointmentDateTime) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try{
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_datetime) VALUES (?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, patientId);
        stmt.setInt(2, doctorId);
        stmt.setTimestamp(3, Timestamp.valueOf(appointmentDateTime));
        stmt.executeUpdate();
        System.out.println("Appointment scheduled successfully.");
    } catch(SQLException e) {
        e.printStackTrace();
    } finally{
        try{
            if(stmt != null) stmt.close();
        } catch(SQLException se2) {
        } try{
            if(conn != null) conn.close();
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
}
    
    public void rescheduleAppointment(int appointmentId, LocalDateTime newAppointmentDateTime) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "UPDATE appointments SET appointment_datetime = ? WHERE appointment_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setTimestamp(1, Timestamp.valueOf(newAppointmentDateTime));
        stmt.setInt(2, appointmentId);
        int rowsAffected = stmt.executeUpdate();
        
        if(rowsAffected > 0) {
            System.out.println("Appointment with ID " + appointmentId + " rescheduled successfully.");
        } else {
            System.out.println("Appointment with ID " + appointmentId + " not found.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException se2) {
        } try {
            if (conn != null) conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
    
   public void cancelAppointment(int appointmentId) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "DELETE FROM appointments WHERE appointment_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, appointmentId);
        int rowsAffected = stmt.executeUpdate();
        
        if(rowsAffected > 0) {
            System.out.println("Appointment with ID " + appointmentId + " canceled successfully.");
        } else {
            System.out.println("Appointment with ID " + appointmentId + " not found.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException se2) {
        } try {
            if (conn != null) conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
}
