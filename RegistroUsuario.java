/**
 * Programa Java que se encarga de pedir un nombre de usuario, un email, una contraseña y
 * un codigo. Donde el mismo programa comprueva que los valores introducidos sean correctos
 * 
 * Nombre --> No esta en la base de datos, empieza por mayuscula, el resto minusculas, tiene un guion medio o
 * y acaba con 3 digitos
 * 
 * Email --> Contiene un @, acaba en .com, .es o .cat y los dominios permitidos son paucasesnovescifp, yahoo, gmail y hotmail.
 * 
 * Contraseña --> Empieza por mayusculas, contiene un caràcter especial, acaba en dos numeros y debe tener 8 caracteres
 * 
 * Codigo --> Se generara un codigo aleartorio de 8 caracteres que se tiene que copiar exactamente igual
 */

import java.util.Scanner;
import java.util.Random;

public class RegistroUsuario 
{

    //Declaracion de las variables necesarias
    private String nombreUsuario;
    private String email;
    private String password;
    private String codigo;
    private StringBuilder securityCode;
    private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+";
    private boolean datosCorrectos = false;
    
    /**
     * Constructor para realizar el registro de usuario con todas sus variables necesarias
     */
    public RegistroUsuario()
    {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.codigo = codigo;
        this.characters = characters;
        this.datosCorrectos = datosCorrectos;
    }//Cierre constructor

    /**
     * Metodo encargado de la comprovacion de los datos.
     * @param vu El parametro vu es el objeto que hace referencia a la classe Validar usuarios encargado de comprovar todos los datos introducidos 
     * @param sc El prametro sc el el parametro utilizado por el scanner para que el usuario pueda escrivir los datos
     */

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

    /**
     * Metodo encargado de pedir el Nombre de Usuario
     * @param sc El parametro sc es el usado por el Scanner encargado de permitir que el usuario pueda escribir los datos
     */
    public void pedirNombreUsuario(Scanner sc)
    {
        System.out.println("Introduce tu nombre de usuario: ");
        setNombreUsuario(sc.nextLine());
    }//Cierre del metodo

    /**
     * Metodo encargado de pedir el email al usuario
     * @param sc El parametro sc es el usado por el Scanner encargado de permitir que el usuario pueda escribir los datos
     */   
    public void pedirEmail(Scanner sc)
    {
        System.out.println("Introduce correo de registro: ");
        setEmail(sc.nextLine());
    }

    /**
     * Metodo encargado de pedir la contraseña al usuario
     * @param sc
     */
    public void pedirPassword(Scanner sc)
    {
        System.out.println("Introduce la contraseña: ");
        setPassword(sc.nextLine());
    }

    /**
     * Metodo encargado de la generacion de los codigos de seguridad
     * @param sc El parametro sc es el usado por el Scanner encargado de permitir que el usuario pueda escribir los datos
     * @return Devuelve el securityCode generado 
     */
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

    /**
     * Setter del nombre de usuario
     * @param nombreUsuario Valor del nombre de Usuaior intorducido por el usuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Setter del email
     * @param email Valor del email introducido por el usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter de la password
     * @param password Valor de la passwrod introducido por el usario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setter del codigo
     * @param codigo Valor del codigo introducido por el usuario
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Setter de datosCorerctos
     * @param datosCorrectos Valor falso o verdadero dependiendo del resultado de la comrovacion de datos
     */
    public void setDatosCorrectos(boolean datosCorrectos) {
        this.datosCorrectos = datosCorrectos;
    }

    /**
     * Getter del Nombre de Usuario 
     * @return Valor de la variable nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Getter del email
     * @return Valor de la variable email
     */
    public String getEmail() {
       return email;
    }

    /**
     * Getter de la contraseña
     * @return Valor de la varible password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter del codigo
     * @return Valor de la variable codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Getter Datos Correctos
     * @return Devuelve el valor falso o verdadero de la variable detosCorrectos
     */
    public boolean getDatosCorrectos() {
        return datosCorrectos;
    }


    /**
     * Metodo main encargado de la ejecucion del programa
     */
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