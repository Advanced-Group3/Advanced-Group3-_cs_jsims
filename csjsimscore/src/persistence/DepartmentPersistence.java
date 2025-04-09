
package persistence;

import domain.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DepartmentPersistence implements IDepartmentPersistence {

    @Override
    public boolean save(Department department) throws SQLException {
        int affectedRow;
        String query = "Insert into department (name, collegeid) Values(?,?)";
        try (Connection conn = DbConnection.getConnection()) {
            try (PreparedStatement prepare = conn.prepareStatement(query)) {
                prepare.setString(1, department.getName());
                prepare.setInt(2, department.getCollegeId());
                affectedRow = prepare.executeUpdate();
            }
        }
        return affectedRow > 0;
    }

}
