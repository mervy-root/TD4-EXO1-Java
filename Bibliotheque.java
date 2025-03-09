import java.util.List;
import java.util.ArrayList;

public class Bibliotheque {
    private List<Document> listeDocuments;

    public List<Document> getlisteDocuments() {
        return listeDocuments;
    }
    public void setlisteDocuments(List<Document> listeDocuments) {
        this.listeDocuments = listeDocuments;
    }
    public Bibliotheque() {
        this.listeDocuments = new java.util.ArrayList<>();
    }
    public Bibliotheque(List<Document> listeDocuments) {
        this.listeDocuments = listeDocuments;
    }
    public String toString() {
        return "Bibliotheque{" +
                "listeDocuments=" + listeDocuments +
                '}';
    }

    //1. Ajouter un document
    public void ajouterDocument(Document document) {
        if (document == null) {
            System.out.println("Le document ne peut pas etre null");
            return;
        }

        this.listeDocuments.add(document);
    }

    public void ajouterDocument() {
        System.out.println( "Entrer le type de document: (LIVRE / DICTIONNAIRE / DOCUMENT)" );
        String typeDocument = Main.clavier.nextLine().trim();
        typeDocument = typeDocument.toUpperCase();
        while (typeDocument.isEmpty()) {
            System.out.println("Le type de document ne peut pas etre vide");
        }

        switch (typeDocument) {
            case "LIVRE":
                Livre livre;
                livre = Livre.lireLivre();
                ajouterDocument(livre);
                livre = null;
                break;
            case "DICTIONNAIRE":
                Dictionnaire dictionnaire;
                dictionnaire = Dictionnaire.lireDictionnaire();
                ajouterDocument(dictionnaire);
                dictionnaire = null;
                break;
            case "DOCUMENT":
                Document document;
                document = Document.lireDocument();
                ajouterDocument(document);
                document = null;
                break;
            default:
                System.out.println("Le type de document n'existe pas");
                break;
        }
    }

    //2. Calculer le nombre de livres
    public int getNombreDeLivres() {
        int nombreDeLivres = 0;
        for (Document document : listeDocuments) {
            if (document instanceof Livre) {
                nombreDeLivres++;
            }
        }
        return nombreDeLivres;
    }

    //3. Afficher que les dictionnaires
    public List<Dictionnaire> getDictionnaires() {
        List<Dictionnaire> dictionnaires = new java.util.ArrayList<>();
        for (Document document : listeDocuments) {
            if (document instanceof Dictionnaire) {
                dictionnaires.add((Dictionnaire) document);
            }
        }
        return dictionnaires;
    }

    public void afficherDictionnaires() {
        System.out.println("==========================LISTE DES DICTIONNAIRES============================");
        System.out.println(String.format("%-18s | %-18s | %-6s", "TITRE", "REFERENCE", "NBRE DE MOTS"));

        for (Dictionnaire dictionnaire : getDictionnaires()) {
            System.out.println(dictionnaire.toStringInline());
        }
    }

    //4. Afficher tous les documents
    public void afficherToutDocuments() {
        List<Document> documents = new ArrayList<>();
        List<Livre> livres = new ArrayList<>();
        List<Dictionnaire> dictionnaires = new ArrayList<>();

        for (Document document : this.listeDocuments) {
            if (document instanceof Dictionnaire) {
                dictionnaires.add((Dictionnaire) document);
            } else if (document instanceof Livre) {
                livres.add((Livre) document);
            } else if (document != null) {
                documents.add(document);
            }
        }

        System.out.println("\n==========================LISTE DES DOCUMENTS============================");
        System.out.println(String.format("%-18s | %-18s", "REFERENCE", "TITRE"));
        while (!documents.isEmpty()) {
            System.out.println(documents.getFirst().toStringInline());
            documents.removeFirst(); // Supprime le premier élément en toute sécurité
        }

        System.out.println("\n==========================LISTE DES LIVRES============================");
        System.out.println(String.format("%-18s | %-18s | %-6s", "TITRE", "REFERENCE", "NBRE DE PAGES"));
        while (!livres.isEmpty()){
            System.out.println(livres.getFirst().toStringInline());
            livres.removeFirst();
        }

        System.out.println("\n==========================LISTE DES DICTIONNAIRES============================");
        System.out.println(String.format("%-18s | %-18s | %-6s", "TITRE", "REFERENCE", "NBRE DE MOTS"));
        while (!dictionnaires.isEmpty()){
            System.out.println(dictionnaires.getFirst().toStringInline());
            dictionnaires.removeFirst();
        }

    }

}
