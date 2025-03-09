public class Dictionnaire extends Document{
    private int nbreMotsDefinis;

    public int getNbreMotsDefinis() {
        return nbreMotsDefinis;
    }
    public void setNbreMotsDefinis(int nbreMotsDefinis) {
        this.nbreMotsDefinis = nbreMotsDefinis;
    }
    public Dictionnaire() {
        this.nbreMotsDefinis = 0;
    }
    public Dictionnaire(int nbreMotsDefinis) {
        this.nbreMotsDefinis = nbreMotsDefinis;
    }

    public Dictionnaire(String titre, String reference, int nbreMotsDefinis) {
        super(titre, reference);
        this.nbreMotsDefinis = nbreMotsDefinis;
    }

    @Override
    public String toString() {
        return "Dictionnaire{" +
                "nbreMotsDefinis=" + nbreMotsDefinis +
                ", reference='" + reference + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }

    public String toStringInline() {
        return String.format("%-18s | %-18s | %-6d", this.reference, this.titre, this.nbreMotsDefinis);
    }
    public String getInfo(){
        return "Le dictionnaire " + this.titre + " a " + this.nbreMotsDefinis + " mots definis.";
    }

    public static Dictionnaire lireDictionnaire(){
        System.out.println("Entrer les informations du dictionnaire: ");
        String titre;
        String reference;
        int nbreMotsDefinis;

        System.out.println( "Entrer le titre du dictionnaire: " );
        titre = Main.clavier.nextLine().trim();

        while(titre.isEmpty()) {
            System.out.println("Le titre du dictionnaire ne peut pas etre vide");
            System.out.println( "Entrer le titre du dictionnaire: " );
            titre = Main.clavier.nextLine().trim();
        }

        System.out.println( "Entrer la reference du dictionnaire: " );
        reference = Main.clavier.nextLine().trim();

        while(reference.isEmpty()) {
            System.out.println("Le titre du dictionnaire ne peut pas etre vide");
            System.out.println( "Entrer le titre du dictionnaire: " );
            reference = Main.clavier.nextLine().trim();
        }

        while (true) {
            try {
                System.out.println( "Entrer le nombre de mots definis: " );
                if (Main.clavier.hasNextInt() ) {
                    nbreMotsDefinis = Main.clavier.nextInt();
                    Main.clavier.nextLine();
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Erreur de saisie du nombre de mots definis");
            }
        }
        System.out.println("titre: " + titre + " reference: " + reference + " nbreMotsDefinis: " + nbreMotsDefinis + "");
        return new Dictionnaire(titre, reference, nbreMotsDefinis);
    }

    public static Dictionnaire ajouter(){
        System.out.println("Ajout d'un dictionnaire");
        /*String titre = Main.clavier.lireChaine("Titre: ");
        String reference = Saisie.lireChaine("Reference: ");
        int nbreMotsDefinis = Saisie.lireEntier("Nombre de mots definis: ");
        return new Dictionnaire(titre, reference, nbreMotsDefinis);*/
        return null;
    }

}
