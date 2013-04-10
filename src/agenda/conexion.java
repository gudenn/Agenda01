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
private Connection conexion = null;
public conexion()
{
}
public void estableceConexion()
{
        if (conexion != null)
            return;
        String url = "jdbc:postgresql://127.0.0.1:5432/agenda";
        try
        {
           Class.forName("org.postgresql.Driver");
          
           conexion = DriverManager.getConnection(url,"postgres","postgres");
           if (conexion !=null){
               System.out.println("Conexión a base de datos ... Ok");
           }
        } catch (Exception e) {
            System.out.println("Problema al establecer la Conexión a la base de datos 1 ");
        }
}
      
public void insertarDatos(String nombEven,String fecha,String hrsIni,String hrsFin)
{
   /*conexion con = new conexion();
   con.Function("insert into evento (nombre_evento,fecha,horaini,horafin) values ('"+nombEven+"','"+fecha+"','"+hrsIni+"','"+hrsFin+"')");
   */
    estableceConexion();
    Statement s = null;
        try
        {
                s = conexion.createStatement();
                int n=s.executeUpdate("insert into evento (nombre_evento,fecha,horaini,horafin) values ('"+nombEven+"','"+fecha+"','"+hrsIni+"','"+hrsFin+"')");
        }catch (Exception e)
        {
            System.out.println("Problema al consultar la base de datos insertar datos ");
        }
     cierraConexion();
        
}

public void cierraConexion()
{
        try
        {
            conexion.close();
        }catch(Exception e)
        {
            System.out.println("Problema para cerrar la Conexión a la base de datos ");
        }
}            


/*private  void listar(ResultSet rs)throws SQLException{
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
	
  */
}
