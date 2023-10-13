public class Rivista extends Biblioteca {
    public String periodicita;



    public Rivista(String ISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public String getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(String periodicità) {
        this.periodicita = periodicita;
    }

}
