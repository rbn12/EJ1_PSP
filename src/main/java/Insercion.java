import java.sql.*;

public class Insercion extends Thread{
    int principio;
    int fin;

    public Insercion(int principio, int fin) {
        this.principio = principio;
        this.fin = fin;
    }

    public void  añadirRegistro(){
        Connection cn ;
        try {
            DatosAleatorios da = new DatosAleatorios();
            cn = DriverManager.getConnection("jdbc:mysql://localhost/bbdd_psp_1", "DAM2020_PSP", "DAM2020_PSP");
            for (int i = principio; i < fin; i++) {
                int ingresos = da.randomSalary();
                String correo = String.valueOf(da.generarCorreo());
                Statement registro = cn.createStatement();
                int query = registro.executeUpdate("insert into empleados(email,ingresos) values ('" + correo + "'," + ingresos + ")");

            }
            System.out.println("Registros añadidos");
            cn.close();


        } catch (SQLException e) {
            e.printStackTrace(); }
    }

    @Override
    public void run() {

        super.run();
        añadirRegistro();
    }

}
