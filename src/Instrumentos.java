import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Instrumentos {
    int id;
    String nombre;
    String tipo;
    double precio;
    String caracteristicas;
    String foto;

    public Instrumentos(int id, String nombre, String tipo, double precio, String caracteristicas, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.caracteristicas = caracteristicas;
        this.foto=foto;
    }

    public Instrumentos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void insertarItemBDD(String nombre, String tipo, double precio, String caracteristicas, String foto){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectos", "root", "")) {
            // Crear la consulta de inserción con parámetros

            String sql = "INSERT INTO instrumentos (nombre,  tipo,  precio,  caracteristicas,  foto) VALUES (?,?, ?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Establecer los valores de los parámetros
                //preparedStatement.setInt(1, id);
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, tipo);
                preparedStatement.setDouble(3, precio);
                preparedStatement.setString(4, caracteristicas);
                preparedStatement.setString(5, foto);

                // Ejecutar la consulta de inserción
                int filasAfectadas = preparedStatement.executeUpdate();

                // Verificar si la inserción fue exitosa
                if (filasAfectadas > 0) {
                    System.out.println("Datos insertados correctamente.");
                } else {
                    System.out.println("Error al insertar datos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
