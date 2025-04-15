
package persistence;

import domain.College;
import java.sql.SQLException;
import java.util.List;


public interface ICollegePersistence {

    boolean save(College college) throws SQLException;

    List<College> getAll() throws SQLException;
}
