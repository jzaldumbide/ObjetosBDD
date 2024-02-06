import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectarDB {
    String servidor;
    String usuario;
    String password;
    String mensaje;


    public conectarDB(String servidor, String usuario, String password) {
        this.servidor = servidor;
        this.usuario = usuario;
        this.password = password;
    }

    public conectarDB() {
    }

    public void conexionlocal(String servidor, String usuario, String password){
        try(Connection connection=DriverManager.getConnection(servidor,usuario,password)){
            if(connection!=null){
                mensaje="Conexión correcta";
                System.out.println(mensaje);


            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
