import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        Usb roja=new Usb(8,"exFAT");
        roja.grabar("prueba",".pdf",30,"mb");
        roja.grabar("prueba2",".pdf",30,"mb");
        roja.grabar("prueba3",".pdf",30,"mb");
        roja.grabar("prueba4",".pdf",30,"mb");
        roja.grabar("prueba5",".pdf",30,"mb");
        roja.grabar("prueba6",".pdf",30,"mb");
        roja.grabar("prueba7",".pdf",30,"mb");
        roja.grabar("prueba8",".pdf",30,"mb");
        roja.grabar("prueba9",".pdf",30,"mb");
        roja.grabar("prueba10",".pdf",30,"gb");
        roja.grabar("prueba11",".pdf",30,"mb");
        System.out.println(roja.getMsg());

        System.out.println(roja.mostrarTodos());
        System.out.println(roja.mostrar("prueba2",".pdf"));

        roja.borrar("prueba3",".pdf");
        System.out.println(roja.getMsg());
        System.out.println(roja.mostrarTodos());
    }
}