public class Document {
    protected String titre;
    protected String reference;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference){
        this.reference = reference;
    }
    public Document() {
        this.titre = "";
        this.reference = "";
    }

    public Document(String titre, String reference) {
        this.titre = titre;
        this.reference = reference;
    }
    public String toString() {
        return "Document{" +
                "titre='" + titre + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }

    public static Document lireDocument(){
        System.out.println("--------------------------------Entrer les informations du document--------------------------------");
        String titre;
        String reference;

        System.out.println( "Entrer le titre d'un document: " );
        titre = Main.clavier.nextLine().trim();
        while(titre.isEmpty()) {
            System.out.println("Le titre d'un document ne peut pas etre vide");
            System.out.println( "Entrer le titre d'un document: " );
            titre = Main.clavier.nextLine().trim();
        }

        System.out.println( "Entrer la reference d'un document: " );
        reference = Main.clavier.nextLine().trim();
        while(reference.isEmpty()) {
            System.out.println("La reference d'un document ne peut pas etre vide");
            System.out.println( "Entrer la reference d'un document: " );
            reference = Main.clavier.nextLine().trim();
        }
        System.out.println("titre: " + titre + " reference: " + reference + "");
        return new Document(titre, reference);
    }

    public String toStringInline() {
        return String.format("%-18s | %-18s", this.reference, this.titre);
    }


}
