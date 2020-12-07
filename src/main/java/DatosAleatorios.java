import com.github.javafaker.Faker;

public class DatosAleatorios {
    public String generarCorreo() {
        Faker fk = new Faker();
        String nombre = fk.name().firstName();
        String lowerNombre = nombre.toLowerCase();

        int numeroAleatorio = 0;

        numeroAleatorio = (int) (Math.random() * (20 - 1));

        String correo = lowerNombre + numeroAleatorio + "@gmail.com";

        return correo;
    }

    public int randomSalary() {
        int salario = (int) (Math.random() * (1000 - 10));
        return salario;
    }
}

