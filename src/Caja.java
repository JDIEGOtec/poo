public class Caja {
    private String msg;
    private int precio;
    private int[] cajaDinero = new int[8], cambio = new int[8];
    private int[] monedas = {200, 100, 50, 20, 10, 5, 2, 1};

    public Caja(int precio, String dineroCaja)
    {
        this.precio = precio;
        cajaDinero = convertir(dineroCaja);
    }

    public int[] convertir(String cantidad)
    {
        int[] regreso = new int[8];
        String[] cantidades = cantidad.split(",");
        for (int i = 0; i < monedas.length; i++)
        {
            boolean encontrado = false;
            for (String cant : cantidades)
            {
                int pos = cant.indexOf("-");
                String unidad = cant.substring(0, pos);
                String numero = cant.substring(pos + 1);

                if (monedas[i] == Integer.parseInt(unidad))
                {
                    regreso[i] = Integer.parseInt(numero);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                regreso[i] = 0;
            }
        }
        return regreso;
    }

    public boolean pagar(String cantidad)
    {
        int[] pago = convertir(cantidad);
        int sumaCaja = 0;
        int sumaPago = 0;

        for (int i = 0; i < cajaDinero.length; i++)
        {
            sumaCaja += cajaDinero[i] * monedas[i];
            sumaPago += pago[i] * monedas[i];
        }

        int montoRestante = sumaPago - precio;

        if (cantidad.equals(""))
        {
            msg = "No se ingreso dinero";
            return false;
        }
        if (sumaPago > sumaCaja)
        {
            msg = "No hay cambio suficiente";
            return false;
        }
        if (precio > sumaPago)
        {
            msg = "Saldo insuficiente";
            return false;
        }

        for (int i = 0; i < cajaDinero.length; i++)
        {
            if (pago[i] > 0 && cajaDinero[i] == 0)
            {
                msg = "La caja no tiene suficientes monedas para dar cambio";
                return false;
            }
        }

        for (int i = monedas.length - 1; i >= 0; i--)
        {
            int cantidadCambio = montoRestante / monedas[i];
            if (cajaDinero[i] < cantidadCambio)
            {
                cantidadCambio = cajaDinero[i];
            }
            cambio[i] = cantidadCambio;
            montoRestante -= cantidadCambio * monedas[i];
        }

        for (int i = 0; i < cajaDinero.length; i++)
        {
            cajaDinero[i] -= pago[i] - cambio[i];
        }
        return true;
    }

    public String tomarCambio()
    {
        String regreso = "";
        for (int i = 0; i < cambio.length; i++)
        {
            if (cambio[i] > 0)
            {
                regreso += monedas[i] + "-" + cambio[i] + ",";
            }
        }
        if(regreso.equals(""))
        {
            return "No hay cambio";
        }
        return regreso;
    }

    public String getMsg() {
        return msg;
    }

    public int[] getDineroCajaNum() {
        return cajaDinero;
    }
}