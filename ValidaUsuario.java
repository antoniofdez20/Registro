/**
 * Este código Java define una clase llamada ValidaUsuario,
 * que se utiliza para validar los datos de registro de un usuario.
 */

/**
 * El constructor de la clase ValidaUsuario recibe como parámetros el nombre,
 * el correo electrónico, la contraseña, el código de seguridad
 * y una instancia de StringBuilder para el código de seguridad.
 */
public class ValidaUsuario {
    private String[] usuarios = { "Ana_r235", "Luisa-987", "Jorge_512", "Maria-104", "Andres_723", "Lucia-812",
            "Pedro_305", "Marta-619", "David_205", "Laura-832" };

    public ValidaUsuario(String nombre, String email, String password, String codigo, StringBuilder securityCode) {
        this.usuarios = usuarios;
    }

    /**
     * Comprueba si el nombre de usuario es válido y no existe en la lista de
     * usuarios existentes.
     *
     * @param nombreUsuario el nombre de usuario a comprobar.
     * @param usuarios      un arreglo de nombres de usuario ya existentes.
     * @throws Exception si el nombre de usuario es incorrecto o ya existe en la
     *                   lista de usuarios existentes.
     */
    public void compruebaNombre(String nombreUsuario, String[] usuarios) throws Exception {
        if ((nombreUsuario.matches("^[A-Z][a-z]+[-_][0-9]{3}$"))) {
            for (String name : usuarios) {
                if (nombreUsuario.equals(name))
                    throw new Exception("Nombre de usuario ya existe");
            }
            System.out.println();
            System.out.println("Nombre válido.");
        } else
            throw new Exception("Nombre incorrecto");
    }

    /**
     * Comprueba si una dirección de correo electrónico tiene el formato correcto.
     *
     * @param email la dirección de correo electrónico a comprobar.
     * @throws Exception si la dirección de correo electrónico no tiene el formato
     *                   esperado.
     */
    public void compruebaEmail(String email) throws Exception {
        if (email.matches("^[a-zA-Z0-9._%+-]+@(paucasesnovescifp|yahoo|gmail|hotmail)\\.(com|es|cat)$"))
            System.out.println("Correo válido");
        else
            throw new Exception("Este correo no es válido");

    }

    /**
     * Verifica si una contraseña cumple con ciertos requisitos de complejidad.
     *
     * @param password La contraseña a verificar.
     * @throws Exception Se lanza una excepción si la contraseña no cumple los
     *                   requisitos de complejidad.
     */
    public void compruebaPassword(String password) throws Exception {
        if (password.matches("^(?=.{8,}$)([A-Z][a-zA-Z0-9]*[@#_\\-][a-zA-Z0-9]*[0-9]{2})$"))
            System.out.println("Contraseña válida");
        else
            throw new Exception("Contraseña incorrecta");
    }

    /**
     * Comprueba si el código introducido por el usuario coincide con el código de
     * seguridad.
     * 
     * @param codigo       el código introducido por el usuario
     * @param securityCode el código de seguridad generado previamente
     * @throws Exception si el código introducido por el usuario no coincide con el
     *                   código de seguridad generado previamente
     */
    public void compruebaCodigo(String codigo, StringBuilder securityCode) throws Exception {
        if (codigo.equals(securityCode.toString()))
            System.out.println("Código correcto");
        else
            throw new Exception("El código introducido no coincide con el de seguridad");
    }

    /**
     * Muestra los datos introducidos y un mensaje de éxito para indicar que el
     * registro se ha realizado con éxito.
     * 
     * @param nombreUsuario El nombre de usuario introducido
     * @param email         El correo electrónico introducido
     * @param password      La contraseña introducida
     * @param codigo        El código de seguridad introducido
     */
    public void mostrarRegistro(String nombreUsuario, String email, String password, String codigo) {
        System.out.println();
        System.out.println("Estos son los datos introducidos: ");
        System.out.println("*".repeat(20));
        System.out.println(nombreUsuario);
        System.out.println(email);
        System.out.println(password);
        System.out.println(codigo);
        System.out.println("El registro se ha realizado con éxito.");
    }

    /**
     * Establece un nuevo array de usuarios.
     * 
     * @param usuarios el nuevo array de usuarios a establecer
     */
    public void setUsuarios(String[] usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Este método se utiliza para obtener el arreglo de cadenas "usuarios" que es
     * una variable de instancia de la clase.
     * 
     * @return El arreglo de cadenas "usuarios".
     */
    public String[] getUsuarios() {
        return usuarios;
    }
}
