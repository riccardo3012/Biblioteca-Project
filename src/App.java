import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        Scanner scanner = new Scanner(System.in);

        boolean continua = true;

        while (continua) {
            System.out.println("Scegli un'operazione:");
            System.out.println("1. Aggiungi Libro");
            System.out.println("2. Aggiungi Rivista");
            System.out.println("3. Elimina Elemento per ISBN");
            System.out.println("0. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il carattere di nuova riga

            switch (scelta) {
                case 1:
                    aggiungiLibro(catalogo, scanner);
                    break;
                case 2:
                    aggiungiRivista(catalogo, scanner);
                    break;
                case 3:
                    eliminaElementoPerISBN(catalogo, scanner);
                    break;
                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();

        // Stampa l'archivio del catalogo
        catalogo.stampaCatalogo();
    }

    private static void aggiungiLibro(Catalogo catalogo, Scanner scanner) {
        System.out.println("Inserisci i dettagli del libro:");
        String ISBN = leggiStringaDaInput(scanner, "ISBN:");
        String titolo = leggiStringaDaInput(scanner, "Titolo:");
        int annoPubblicazione = leggiInteroDaInput(scanner, "Anno di pubblicazione:");
        int numeroPagine = leggiInteroDaInput(scanner, "Numero di pagine:");
        String autore = leggiStringaDaInput(scanner, "Autore:");

        Libri libro = new Libri(ISBN, titolo, annoPubblicazione, numeroPagine, autore);
        catalogo.aggiungiElemento(libro);
    }

    private static void aggiungiRivista(Catalogo catalogo, Scanner scanner) {
        System.out.println("Inserisci i dettagli della rivista:");
        String ISBN = leggiStringaDaInput(scanner, "ISBN:");
        String titolo = leggiStringaDaInput(scanner, "Titolo:");
        int annoPubblicazione = leggiInteroDaInput(scanner, "Anno di pubblicazione:");
        int numeroPagine = leggiInteroDaInput(scanner, "Numero di pagine:");
        String periodicita = leggiStringaDaInput(scanner, "Periodicità (SETTIMANALE, MENSILE o SEMESTRALE):");

        Rivista rivista = new Rivista(ISBN, titolo, annoPubblicazione, numeroPagine);
        try {
            rivista.setPeriodicita(String.valueOf(Periodicita.valueOf(periodicita)));
            catalogo.aggiungiElemento(rivista);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: Periodicità non valida.");
        }
    }

    private static void eliminaElementoPerISBN(Catalogo catalogo, Scanner scanner) {
        String isbnDaEliminare = leggiStringaDaInput(scanner, "Inserisci l'ISBN dell'elemento da eliminare:");
        catalogo.eliminaElementoPerISBN(isbnDaEliminare);
    }

    private static String leggiStringaDaInput(Scanner scanner, String messaggio) {
        System.out.print(messaggio + " ");
        return scanner.nextLine();
    }

    private static int leggiInteroDaInput(Scanner scanner, String messaggio) {
        int valore = 0;
        boolean inputValido = false;
        while (!inputValido) {
            System.out.print(messaggio + " ");
            try {
                valore = Integer.parseInt(scanner.nextLine());
                inputValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserisci un valore numerico valido.");
            }
        }
        return valore;
    }
}
