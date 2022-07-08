package verificar.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Oracle {

    private String sid;
    private String host;
    private String puerto;
    private String usuario;
    private String password;

    public Oracle() {
        this.sid      = "BDHSIC";
        this.host     = "192.168.18.169";
        this.puerto   = "1521";
        this.usuario  = "LLE";
        this.password = "YVL";
    }

    public Connection conexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection  conexion = DriverManager.getConnection("jdbc:oracle:thin:@"+this.host+":"+this.puerto+":"+this.sid,this.usuario,this.password);
            return conexion;
        } catch (SQLException | ClassNotFoundException ex) {
        	JOptionPane.showMessageDialog(null, "Error en la conexión de la base de datos. "+ex);
            System.out.println("Error en la conexión de la base de datos");
        }
        return null;
    }
    
    public void test() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection  conexion = DriverManager.getConnection("jdbc:oracle:thin:@"+this.host+":"+this.puerto+":"+this.sid,this.usuario,this.password);
            if(conexion != null) {
            	conexion.close();
            	JOptionPane.showMessageDialog(null, "Conexión Exitosa !!");
            }else {
            	JOptionPane.showMessageDialog(null, "Sin conexión");
            }
        } catch (SQLException | ClassNotFoundException ex) {
        	JOptionPane.showMessageDialog(null, "Error en la conexión de la base de datos. "+ex);
            System.out.println("Error en la conexión de la base de datos");
        }
    }

	
    public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}  
    
}
