public class Libri extends Biblioteca {
    public String autore;
    public String genere;
    public Libri(String ISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        setAutore(autore);
        setGenere(genere);
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
