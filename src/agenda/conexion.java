/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author SONY
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;
	/**
	 *
	 * @author beastieux
12	 */
public class conexion
{
 
	public conexion()
	{
		
		
	}
 public void Function(String sql)
  {
           try
           {
                   Class.forName("org.postgresql.Driver");
 
                    String url = "jdbc:postgresql://127.0.0.1:5432/agenda";
                    Connection con = DriverManager.getConnection(url, "postgres","postgres");
	                    Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	                                                      ResultSet.CONCUR_READ_ONLY);
	 
                    ResultSet rs= s.executeQuery(sql);
                     
	   listar(rs);
	                    CachedRowSet crs = new CachedRowSetImpl();
	                    crs.populate(rs);
	 
	                    rs.close();
	                    s.close();
	                    con.close();
	 
                   /// return crs;
 
            }
            catch(Exception e)
            {
                   System.out.println(e.getMessage()+"Erroor");
            }
 
          
    }
	private static void listar(ResultSet rs)throws SQLException{
		System.out.println("");
		ResultSetMetaData meta = rs.getMetaData();
		int n = meta.getColumnCount();
		
		for(int i = 1; i<=n; i++){
			System.out.println(meta.getColumnName(i)+"\t");
			
		}
		System.err.println("\t");
		
		while(rs.next()){
			System.out.println(rs.getString(1)+"\t");
			System.out.println(rs.getString(2)+"\t");
			System.out.println("\n");
		}
		
	}   
	public static void main(String org[])
	{
                conexion co=new conexion();
                co.Function("Select * from evento");
               // co.insertarDatos("'cumple fernando'", "'27-08-2013'", "'8:00'", "'10:00'");
	}
        
        public static void insertarDatos(String nombEven,String fecha,String hrsIni,String hrsFin)
        {
            conexion con = new conexion();
            con.Function("insert into evento (nombre_evento,fecha,horaini,horafin) values ('"+nombEven+"','"+fecha+"','"+hrsIni+"','"+hrsFin+"')");
            
        }
            
            
}