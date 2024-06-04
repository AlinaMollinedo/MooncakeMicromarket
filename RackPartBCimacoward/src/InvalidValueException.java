import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

class InvalidValueException extends Exception {
    public InvalidValueException(Connection conn, String tableName, String fieldName, int id, String message) {
        super("Error en la tabla " + tableName + ", campo " + fieldName + ": " + message);
        try {
            String countQuery = "SELECT COUNT(*) AS total FROM " + tableName;
            PreparedStatement countStmt = conn.prepareStatement(countQuery);
            ResultSet rs = countStmt.executeQuery();
            int total = 0;
            if (rs.next()) {
                total = rs.getInt("total");
            }
            countStmt.close();
            if (id > total + 1) {
                JOptionPane.showMessageDialog(null, "Error en la tabla " + tableName + ", campo " + fieldName + ": " + message, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
