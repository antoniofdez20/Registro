import java.util.Scanner;
import java.util.Random;

public class RegistroUsuario 
{
    private String nombreUsuario;
    private String email;
    private String password;
    private String codigo;
    private StringBuilder securityCode;
    private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+";
    private boolean datosCorrectos = false;

    public RegistroUsuario()
    {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.codigo = codigo;
        this.characters = characters;
        this.datosCorrectos = datosCorrectos;
    }

    public void init(ValidaUsuario vu, Scanner sc)
    {   
        while (!datosCorrectos)
        {
            try {
                vu.compruebaNombre(nombreUsuario, vu.getUsuarios());
                vu.compruebaEmail(email);
                vu.compruebaPassword(password);
                vu.compruebaCodigo(codigo, securityCode);

                sc.close();
                datosCorrectos = true;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, rellene de nuevo los campos");
                sc.nextLine();
                pedirNombreUsuario(sc);
                pedirEmail(sc);
                pedirPassword(sc);
                scanner(sc);

                datosCorrectos = false;
            }
        }
        
        if (datosCorrectos)
            vu.mostrarRegistro(nombreUsuario, email, password, codigo);
    }

    public void pedirNombreUsuario(Scanner sc)
    {
        System.out.println("Introduce tu nombre de usuario: ");
        setNombreUsuario(sc.nextLine());
    }

    public void pedirEmail(Scanner sc)
    {
        System.out.println("Introduce correo de registro: ");
        setEmail(sc.nextLine());
    }

    public void pedirPassword(Scanner sc)
    {
        System.out.println("Introduce la contraseña: ");
        setPassword(sc.nextLine());
    }

    private StringBuilder scanner(Scanner sc) 
    {
        Random random = new Random();
        securityCode = new StringBuilder();

        for (int i = 0; i < 8; i++) 
        {
            int index = random.nextInt(characters.length());
            char character = characters.charAt(index);
            securityCode.append(character);
        }

        System.out.println("Introduce el siguiente código de seguridad: " + securityCode.toString());
        setCodigo(sc.nextLine());
        return securityCode;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDatosCorrectos(boolean datosCorrectos) {
        this.datosCorrectos = datosCorrectos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
       return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean getDatosCorrectos() {
        return datosCorrectos;
    }

    public static void main(String[] args) 
    {
        RegistroUsuario rg = new RegistroUsuario();
        Scanner sc = new Scanner(System.in);
        rg.pedirNombreUsuario(sc);
        rg.pedirEmail(sc);
        rg.pedirPassword(sc);
        rg.scanner(sc);
        ValidaUsuario vu = new ValidaUsuario(rg.nombreUsuario, rg.email, rg.password, rg.codigo, rg.securityCode);
        rg.init(vu, sc);    
    }
}