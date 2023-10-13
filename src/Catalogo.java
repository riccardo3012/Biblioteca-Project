import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Biblioteca> archivio;

    public Catalogo() {
        archivio = new ArrayList<>();
    }

    public void aggiungiElemento(Biblioteca elemento) {
        archivio.add(elemento);
    }

    public void eliminaElementoPerISBN(String isbnDaEliminare) {
        archivio.removeIf(elemento -> elemento.getISBN().equals(isbnDaEliminare));
    }

    public void stampaCatalogo() {
        for (Biblioteca elemento : archivio) {
            if (elemento instanceof Libri) {
                Libri libro = (Libri) elemento;
                System.out.println("Libro: " + libro.getTitolo() + ", Autore: " + libro.getAutore());
            } else if (elemento instanceof Rivista) {
                Rivista rivista = (Rivista) elemento;
                System.out.println("Rivista: " + rivista.getTitolo() + ", Periodicità: " + rivista.getPeriodicita());
            }
        }
    }

    public List<Biblioteca> getArchivio() {
        return archivio;
    }
}
