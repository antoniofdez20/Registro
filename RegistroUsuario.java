import java.util.Scanner;
import java.util.Random;

public class RegistroUsuario 
{
    private String nombre;
    private String email;
    private String password;
    private String codigo;
    private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+";

    public RegistroUsuario()
    {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.codigo = codigo;
        this.characters = characters;

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        StringBuilder securityCode = new StringBuilder();
        for (int i = 0; i < 8; i++) 
        {
            int index = random.nextInt(characters.length());
            char character = characters.charAt(index);
            securityCode.append(character);
        }

        System.out.println("Introduce tu nombre de usuario: ");
        nombre = sc.nextLine();
        System.out.println("Introduce correo de registro: ");
        email = sc.nextLine();
        System.out.println("Introduce la contraseña: ");
        password = sc.nextLine();
        System.out.println("Introduce el siguiente código de seguridad: " + securityCode.toString());
        codigo = sc.nextLine();
        sc.close();

        new ValidarCampos(nombre, email, password, codigo, securityCode);
    }

    public static void main(String[] args) 
    {
        new RegistroUsuario();    
    }
}
