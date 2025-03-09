import java.util.Scanner;

public class Main {
    static Scanner clavier = new Scanner(System.in);
    static Bibliotheque Biblio = new Bibliotheque();
    public static void main(String[] args) {

        Application();
        /*
        System.out.println("Lire un document");
        Document document = Document.lireDocument();
        System.out.println(document);


        System.out.println("Lire un livre");
        Livre livre = Livre.lireLivre();
        System.out.println(livre.toStringInline());

        System.out.println("Lire un auteur");
        Auteur auteur = new Auteur();
        auteur = Auteur.lireAuteur();
        System.out.println(auteur.toStringInline());

        System.out.println("Lire un dictionnaire");
        Dictionnaire dictionnaire = Dictionnaire.lireDictionnaire();
        System.out.println(dictionnaire.toStringInline());

        Biblio.ajouterDocument(dictionnaire);
        Biblio.ajouterDocument(livre);
        Biblio.ajouterDocument(document);

        Biblio.afficherToutDocuments();
        */


    }

    public static int Menu(){
        int choix;

        do{
            System.out.println("==================Menu==============");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Calculer le nombre de livres");
            System.out.println("3. Afficher que les dictionnaires");
            System.out.println("4. Afficher tous les documents");
            System.out.println("0. Quitter");
            System.out.println("================================");
            System.out.print("Veuillez choisir une option : ");
            while ( !clavier.hasNextInt()){
                System.out.print("Veuillez choisir une option : ");
                clavier.next();
            }
            choix = clavier.nextInt();
            if ( choix < 0 || choix > 4){
                System.out.println("Choix incorrect");
                clavier.next();
            }
        }while(choix < 0 || choix > 4);

        return choix;
    }

    public static void Application() {
        int choix = Menu();
        Main.clavier.nextLine();
        switch (choix){
            case 1:
                System.out.println("Ajouter un document");
                Biblio.ajouterDocument();
                break;
            case 2:
                System.out.println("Calculer le nombre de livres");
                System.out.println("Le nombre de livres est: " + Biblio.getNombreDeLivres());
                break;
            case 3:
                System.out.println("Afficher que les dictionnaires");
                Biblio.afficherDictionnaires();
                break;
            case 4:
                System.out.println("Afficher tous les documents");
                Biblio.afficherToutDocuments();
                break;
            case 0:
                System.out.println("Fin de l'application");
                System.exit(0);
                break;
            default:
                System.out.println("Choix incorrect");
                break;
        }

        char choix2;
        do {
            System.out.println("Voulez-vous continuer ? (O/N)");

            if (clavier.hasNext()) {
                choix2 = Character.toUpperCase(clavier.next().charAt(0));// Convertir en majuscule
            } else {
                choix2 = ' '; // Valeur par défaut pour éviter une boucle infinie
                clavier.next(); // Ignorer l’entrée invalide
            }

            if (choix2 != 'O' && choix2 != 'N') {
                System.out.println("Erreur ! Veuillez entrer 'O' pour Oui ou 'N' pour Non.");
            }

        } while (choix2 != 'O' && choix2 != 'N');

        if (choix2 == 'N'){
            System.out.println("Au revoir !");
            System.exit(0);
        }
        else{
            Application();
        }
    }
}
/*
* - Ajouter un document (livre ou dictionnaire) ;
- Calculer le nombre de livres ;
- Afficher que les dictionnaires ;
* */