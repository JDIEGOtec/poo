import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {

        Rockola rockola = new Rockola(1,"10-1");
        rockola.encender();
        rockola.meterDisco("scdsd", "Cancion1", "Cancion2", 1, 'A');
        rockola.pagar("10-1");
        rockola.reproducir(1, 'A',"a");
        System.out.println(rockola.getMsg());
        System.out.println((rockola.tomarCambio()));
        System.out.println(Arrays.toString(rockola.mirarFeria()));
    }
}