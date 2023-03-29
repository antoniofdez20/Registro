public class ValidaUsuario 
{
    private String[] usuarios = {"Ana_r235", "Luisa-987", "Jorge_512", "Maria-104", "Andres_723", "Lucia-812", "Pedro_305", "Marta-619", "David_205", "Laura-832"};

    public ValidaUsuario(String nombre, String email, String password, String codigo, StringBuilder securityCode)
    {
        this.usuarios = usuarios;    
    }

    public void compruebaNombre(String nombreUsuario, String[] usuarios) throws Exception
    {
        if ((nombreUsuario.matches("^[A-Z][a-z]+[-_][0-9]{3}$")))
        {
            for (String name : usuarios)
            {
                if (nombreUsuario.equals(name))
                    throw new Exception("Nombre de usuario ya existe");
            }
            System.out.println();
            System.out.println("Nombre válido.");
        }
        else
            throw new Exception("Nombre incorrecto");
    }

    public void compruebaEmail(String email) throws Exception
    {
        if (email.matches("^[a-zA-Z0-9._%+-]+@(paucasesnovescifp|yahoo|gmail|hotmail)\\.(com|es|cat)$"))
            System.out.println("Correo válido");
        else
            throw new Exception("Este correo no es válido");
        
    }

    public void compruebaPassword(String password) throws Exception
    {
        if (password.matches("^(?=.{8,}$)([A-Z][a-zA-Z0-9]*[@#_\\-][a-zA-Z0-9]*[0-9]{2})$"))
            System.out.println("Contraseña válida");
        else
            throw new Exception("Contraseña incorrecta");
    }

    public void compruebaCodigo(String codigo, StringBuilder securityCode) throws Exception
    {
        if (codigo.equals(securityCode.toString()))
            System.out.println("Código correcto");
        else
            throw new Exception("El código introducido no coincide con el de seguridad");
    }

    public void mostrarRegistro(String nombreUsuario, String email, String password, String codigo)
    {
        System.out.println();
        System.out.println("Estos son los datos introducidos: ");
        System.out.println("*".repeat(20));
        System.out.println(nombreUsuario);
        System.out.println(email);
        System.out.println(password);
        System.out.println(codigo);
        System.out.println("El registro se ha realizado con éxito.");
    }

    public void setUsuarios(String[] usuarios) {
        this.usuarios = usuarios;
    }

    public String[] getUsuarios() {
        return usuarios;
    }
}
