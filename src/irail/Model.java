package irail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jayadeep
 */
public abstract class Model {
    public static Statement statement=null;
    
    public Model(){
        try {
            Class.forName(GlobalConstants.registerDriver);
            Connection con = DriverManager.getConnection(GlobalConstants.connectionUrl);
            statement = con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    abstract public void fromResultSet(ResultSet res) throws SQLException;
}