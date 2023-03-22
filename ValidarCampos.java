public class ValidarCampos 
{
    private String[] nombres = {"Ana_r235", "Luisa-987", "Jorge_512", "Maria-104", "Andres_723", "Lucia-812", "Pedro_305", "Marta-619", "David_205", "Laura-832"};
    /* expresion regular para validar los nombres: ^[A-Z][a-z]+[-_][0-9]{3}$ */
    /* expresion regular para validar el email ^[a-zA-Z0-9._%+-]+@(paucasesnovescifp|yahoo|gmail|hotmail)\.(com|es|cat)$ */
    /* expresion regular para validar la contraseña ^[A-Z][a-zA-Z0-9]*[@#_\-][a-zA-Z0-9]*[0-9]{2}$ */
    /* ^(?=.{8,}$)([A-Z][a-zA-Z0-9]*[@#_\-][a-zA-Z0-9]*[0-9]{2})$ */

    public ValidarCampos(String nombre, String email, String password, String codigo, StringBuilder securityCode)
    {
        this.nombres = nombres;

        if ((nombre.matches("^[A-Z][a-z]+[-_][0-9]{3}$")))
        {
            for (String name : nombres)
            {
                if (nombre.equals(name))
                {
                    System.out.println("Este nombre ya existe");
                    System.exit(-1);
                }
            }
            System.out.println("Nombre válido.");
        }
        else
            System.out.println("Nombre de usuario incorrecto");    

        if (email.matches("^[a-zA-Z0-9._%+-]+@(paucasesnovescifp|yahoo|gmail|hotmail)\\.(com|es|cat)$"))
            System.out.println("Correo válido");
        else
        {
            System.out.println("Este correo no es válido");
            System.exit(-1);
        }

        if (password.matches("^(?=.{8,}$)([A-Z][a-zA-Z0-9]*[@#_\\-][a-zA-Z0-9]*[0-9]{2})$"))
            System.out.println("Contraseña válida");
        else
        {
            System.out.println("La contraseña introducida és errónea.");
            System.exit(-1);
        }

        if (codigo.equals(securityCode.toString()))
            System.out.println("Código correcto");
        else
        {
            System.out.println("El código introducido no coincide con el código de seguridad.");
            System.exit(-1);
        }

        System.out.println();
        System.out.println("Estos son los datos introducidos: ");
        System.out.println("*".repeat(20));
        System.out.println(nombre);
        System.out.println(email);
        System.out.println(password);
        System.out.println(codigo);
        System.out.println("El registro se ha realizado con éxito.");
    }
}
