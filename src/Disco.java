public class Disco
{
    private String artista,cancionA,cancionB;
    public Disco(String artista, String cancionA, String cancionB)
    {
        this.artista=artista;
        this.cancionA=cancionA;
        this.cancionB=cancionB;
    }

    public String getCancionB() {
        return cancionB;
    }

    public void setCancionB(String cancionB) {
        this.cancionB = cancionB;
    }

    public String getCancionA() {
        return cancionA;
    }

    public void setCancionA(String cancionA) {
        this.cancionA = cancionA;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
