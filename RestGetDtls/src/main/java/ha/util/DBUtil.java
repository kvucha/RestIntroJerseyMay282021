package ha.util;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
  private static DBUtil thisInstance = null;  

  public static DBUtil getInstance() {
    if (thisInstance == null)
        thisInstance = new DBUtil();
    return thisInstance;
  }

  public Connection getDBConnection(){
	Connection DBConnection = null;
    try {     
	  Context initContext = new InitialContext();
	  URL propFile = getClass().getResource("/surround.properties");   
	  Properties properties = new Properties();  
	  properties.load(propFile.openStream());   
		   
			   
	    DataSource ds;
		ds = (DataSource) initContext.lookup(properties.getProperty("JNDI_DB"));
		DBConnection = ds.getConnection();
    }
    catch (NullPointerException e2) {
    	System.out.println("Null pointer exceptoin " + e2);
    }
    catch (NamingException ex) {
    	System.out.println("Exception in naming EXCEPTION " + ex);
      }
    catch (SQLException e1) {
    	System.out.println("Exception in SQL EXCEPTION " + e1);
    }
    catch (Exception e) {
      System.out.println("Error in Exception " + e);
    	
      e.printStackTrace();
    }

	return DBConnection;
  }


}
	   
	   

	   
	   

	   
