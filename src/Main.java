public class Main {
    public static void main(String[] args)
    {

        Rockola rockola = new Rockola();
        rockola.encender();
        rockola.meterDisco("scdsd", "Cancion1", "Cancion2", 1, 'A');
        rockola.pagar(10);
        rockola.reproducir(1, 'A',"a");
        System.out.println(rockola.getMsg());
    }
}