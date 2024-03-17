public class Rockola
{
    Disco[][] discos =new Disco[20][10];
    private boolean encendido;
    private String msg;
    Caja caja;
    public Rockola(int precio ,String feriaCaja)
    {
        encendido=false;
        caja=new Caja(precio,feriaCaja);
    }

    public boolean meterDisco(String artista,String cancionA,String cancionB, int fila, char columna)
    {
        int numColumna =  columna-65;
        int numFila = fila-1;
        if (!encendido)
        {
            msg="La rockola esta apagada";
            return false;
        }
        else if (numFila<0 || numFila>19 || numColumna<0 || numColumna>9)
        {
            msg="Position invalida";
            return false;
        }
        else if (discos[numFila][numColumna]!=null)
        {
            msg="Ya hay un disco en esa position";
            return false;
        }
        else
        {
            discos[numFila][numColumna]=new Disco(artista,cancionA,cancionB);
            msg="Disco metido";
            return true;
        }
    }
    public boolean pagar(String cantidad)
    {
        caja.pagar(cantidad);
        return true;
    }
    public int[] mirarFeria()
    {
        return caja.getDineroCajaNum();
    }
    public String tomarCambio()
    {
        return caja.tomarCambio();
    }

    public boolean reproducir(int fila,char columna,String lado)
    {
        int numColumna =  columna-65;
        int numFila = fila-1;
        if (!encendido)
        {
            msg="La rockola esta apagada";
            return false;
        }

        if (numFila<0 || numFila>19 || numColumna<0 || numColumna>9)
        {
            msg="Position invalida";
            return false;
        }
        else if (discos[numFila][numColumna]==null)
        {
            msg="No hay disco en esa position";
            return false;
        }
        else
        {
            if (lado.equals("A") || lado.equals("a"))
            {
                msg="Reproduciendo "+discos[numFila][numColumna].getArtista()+" / "+discos[numFila][numColumna].getCancionA();
                return true;
            }
            else if (lado.equals("B")||lado.equals("b"))
            {
                msg="Reproduciendo "+discos[numFila][numColumna].getArtista()+" / "+discos[numFila][numColumna].getCancionB();
                return true;
            }
            else
            {
                msg="canción invalida";
                return false;
            }
        }
    }

    public boolean encender()
    {
        if (encendido)
        {
            msg="La rockola ya esta encendida";
            return false;
        }

        encendido=true;
        return true;
    }
    public boolean apagar()
    {
        if (!encendido)
        {
            msg="La rockola ya esta apagada";
            return false;
        }
        encendido=false;
        return true;
    }
    public String getMsg()
    {
        return msg;
    }
    public String cajamsg()
    {
        return caja.getMsg();
    }
}
