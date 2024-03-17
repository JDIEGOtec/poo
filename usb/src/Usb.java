public class Usb {
    private int capacidad , limiteArchivos,tamaño, archivosTotales,tamañoByte;
    private String formato,unidadByte,msg="";
    Archivo[] archivos;

    public Usb()
    {
     this(16,"FAT32");
    }
    public Usb(int capacidad,String formato)
    {
        this.capacidad=capacidad*107374182;
        this.formato=formato;

        if (formato.equals("FAT32"))
            limiteArchivos =100;

        if (formato.equals("NTFS"))
            limiteArchivos =50;

        if (formato.equals("exFAT"))
            limiteArchivos =10;

        archivos =new Archivo[limiteArchivos];
        for (int a=1;a<archivos.length;a++)
    {
        archivos[a] = null;
    }
    }

    public int convertirByte(int tamaño,String unidadByte)
    {
        if (unidadByte.equals("kb"))
            tamaño=(tamaño*1024);

        if (unidadByte.equals("mb"))
            tamaño=(tamaño*1048576);

        if (unidadByte.equals("gb"))
            tamaño=(tamaño*1073741824);

        return tamaño;
    }
    public boolean grabar(String nomArchivo,String extension, int tamaño,String unidadByte)
    {
        tamañoByte=convertirByte(tamaño,unidadByte);
        int contador=0;

        if (capacidad<tamañoByte)
        {
            msg="la capacidad de almacenamiento es insuficiente";
            return false;
        }
        if ((tamañoByte+capacidad)< capacidad)
        {
            msg="la capacidad de almacenamiento es insuficiente";
            return false;
        }
        if (archivosTotales >=limiteArchivos)
        {
            msg="La usb ya no puede contener mas archivos";
            return false;
        }

        for (int i=0;i<archivos.length;i++)
        {
            if (archivosTotales <= limiteArchivos)
                {
                    if (archivos[i] == null)
                    {
                        archivos[i] = new Archivo(nomArchivo, extension, tamaño, unidadByte);
                        continue;
                    }
                }

        }
        for (int i=0;i<archivos.length;i++)
        {
            if (archivos[i].getNomArchivo().equals(nomArchivo) )
                if (archivos[i].getExtension().equals(extension))
                {
                    contador+=1;
                    if (contador>1)
                    {
                        archivos[i] = null;
                    }
                }
        }

        capacidad=capacidad-tamañoByte;
        archivosTotales =archivosTotales+1;
        return true;
    }
    public boolean borrar(String nombre,String extension)
    {
        for (int a=0;a<archivos.length;a++)
        {
            if (archivos[a] != null)
            {
                if(archivos[a].getNomArchivo().equals(nombre))
                {
                    if (archivos[a].getExtension().equals(extension))
                    {
                        archivos[a] = null;
                        return true;
                    }
                    else
                    {
                    msg = "Ningún archivo tiene ese nombre y extension";
                    return false;
                    }
                }

            }
        }
        return false;
    }
    public String mostrar(String nombre,String extension)
    {
        String resultado="";
        for (int a=0;a<archivos.length;a++)
        {
            if (archivos[a] != null)
            {
                if (archivos[a].getNomArchivo().equals(nombre))
                {
                    if (archivos[a].getExtension().equals(extension))
                        resultado = archivos[a].getNomArchivo() + archivos[a].getExtension() + " " + archivos[a].getTamaño() + archivos[a].getUnidadByte() + " " + archivos[a].getFecha();
                    else
                        resultado = "Ningún archivo tiene ese nombre y extension";
                }

            }
        }
        return resultado;
    }
    public String mostrarTodos()
    {
        String resultado="";
        for(int a=0;a<archivos.length;a++)
        {
            if (archivos[a] != null)
            {
                resultado = resultado + archivos[a].getNomArchivo()+archivos[a].getExtension()+" "+archivos[a].getTamaño()+archivos[a].getUnidadByte()+" "+archivos[a].getFecha()+"\n";
            }
        }
        return resultado;
    }
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getLimiteArchivos() {
        return limiteArchivos;
    }

    public void setLimiteArchivos(int limiteArchivos) {
        this.limiteArchivos = limiteArchivos;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getUnidadByte() {
        return unidadByte;
    }

    public void setUnidadByte(String unidadByte) {
        this.unidadByte = unidadByte;
    }
    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }


    public Archivo[] getArchivos() {
        return archivos;
    }

    public void setArchivos(Archivo[] archivos) {
        this.archivos = archivos;
    }

    public int getArchivosTotales() {
        return archivosTotales;
    }

    public void setArchivosTotales(int archivosTotales) {
        this.archivosTotales = archivosTotales;
    }
}