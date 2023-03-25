import java.util.Scanner;
import java.util.Random;

public class RegistroUsuario 
{
    private String nombreUsuario;
    private String email;
    private String password;
    private String codigo;
    private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+";

    public RegistroUsuario()
    {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.codigo = codigo;
        this.characters = characters;

        StringBuilder securityCode = scanner();

        new ValidarCampos(nombreUsuario, email, password, codigo, securityCode);
    }

    private StringBuilder scanner() {
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
        setNombreUsuario(sc.nextLine());
        System.out.println("Introduce correo de registro: ");
        setEmail(sc.nextLine());
        System.out.println("Introduce la contraseña: ");
        setPassword(sc.nextLine());
        System.out.println("Introduce el siguiente código de seguridad: " + securityCode.toString());
        setCodigo(sc.nextLine());
        sc.close();
        return securityCode;
    }

    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public String getEmail(){
       return email;
    }

    public String getPassword(){
        return password;
    }

    public String getCodigo(){
        return codigo;
    }


    public static void main(String[] args) 
    {
        new RegistroUsuario();    
    }


}
