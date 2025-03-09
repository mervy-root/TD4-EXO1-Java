public class Livre extends Document{
    private Auteur auteur;
    private int nbrePages;
/*
    public Livre(Auteur auteur, int nbrePages) {
        this.auteur = auteur;
        this.nbrePages = nbrePages;
    }*/

    public Livre(String titre, String reference, Auteur auteur, int nbrePages) {
        super(titre, reference);
        this.auteur = auteur;
        this.nbrePages = nbrePages;
    }

    public int getNbrePages() {
        return nbrePages;
    }

    public void setNbrePages(int nbrePages) {
        this.nbrePages = nbrePages;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }



    @Override
    public String toString() {
        return "Livre{" +
                "auteur=" + auteur.toStringInline() +
                ", nbrePages=" + nbrePages +
                '}';
    }

    public String getInfo(){
        return "Le livre " + this.titre + " a " + this.nbrePages + " pages.";
    }

    public String toStringInline() {
        return String.format("%-18s | %-18s | %-6d", this.reference, this.titre, this.nbrePages);
    }

    public static Livre lireLivre(){
        System.out.println("--------------------------------Entrer les informations du livre--------------------------------");
        String titre;
        String reference;
        Auteur auteur = new Auteur();
        int nbrePages;

        //le titre du livre
        System.out.println( "Entrer le titre du livre: " );
        titre = Main.clavier.nextLine().trim();
        while(titre.isEmpty()) {
            System.out.println("Le titre du livre ne peut pas etre vide");
            System.out.println( "Entrer le titre du livre: " );
            titre = Main.clavier.nextLine().trim();
        }

        //la reference du livre
        System.out.println( "Entrer la reference du livre: " );
        reference = Main.clavier.nextLine().trim();
        while(reference.isEmpty()) {
            System.out.println("Le titre du livre ne peut pas etre vide");
            System.out.println( "Entrer le titre du livre: " );
            reference = Main.clavier.nextLine().trim();
        }

        //le nombre de page du livre
        while (true) {
            try {
                System.out.println( "Entrer le nombre de page du livre: " );
                if (Main.clavier.hasNextInt() ) {
                    nbrePages = Main.clavier.nextInt();
                    Main.clavier.nextLine();
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Erreur de saisie du nombre de page du livre");
            }
        }

        System.out.println("titre: " + titre + " reference: " + reference + " nbrePages: " + nbrePages + "");

        //l'auteur du livre
        //auteur.lireAuteur();
        return new Livre(titre, reference, auteur, nbrePages);
    }
}


