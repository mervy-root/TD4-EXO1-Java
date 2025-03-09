public class Auteur{
    private int id;
    private String nom;
    private String prenom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Auteur() {
        this.id = 0;
        this.nom = "";
        this.prenom = "";
    }
    public Auteur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Auteur(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    public String getInfo(){
        return "L'auteur " + this.nom + " " + this.prenom + " a l'id " + this.id;
    }

    public String toStringInline() {
        return String.format("%-8d | %-18s | %-18s", this.id, this.nom, this.prenom);
    }

    public static Auteur lireAuteur(){
        System.out.println("Entrer les informations de l'auteur: ");
        int id;
        String nom;
        String prenom;
        while (true) {
            try {
                System.out.println( "Entrer l'id de l'auteur: " );
                id = Main.clavier.nextInt();
                Main.clavier.nextLine();
                break;
            }
            catch (Exception e) {
                System.out.println("Erreur de saisie de l'id de l'auteur");
            }
        }

        while (true) {
            try {
                System.out.println( "Entrer le nom de l'auteur: " );
                nom = Main.clavier.nextLine().trim();
                if (nom.isEmpty()) {
                    System.out.println("Le nom de l'auteur ne peut pas etre vide");
                }
                break;
            }
            catch (Exception e) {
                System.out.println("Erreur de saisie du nom de l'auteur");
                continue;
            }
        }

        while (true){
            try {
                System.out.println( "Entrer le prenom de l'auteur: " );
                prenom = Main.clavier.nextLine().trim();
                if (prenom.isEmpty()) {
                    System.out.println("Le prenom de l'auteur ne peut pas etre vide");
                }
                break;
            }
            catch (Exception e) {
                System.out.println("Erreur de saisie du prenom de l'auteur");
            }
        }
        System.out.println("id: " + id + " nom: " + nom + " prenom: " + prenom + "");

        Auteur auteur = new Auteur(id, nom, prenom);

        return auteur;
    }
}
