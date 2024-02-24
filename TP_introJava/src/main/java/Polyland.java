import java.util.ArrayList;
import java.util.Random;

public class Polyland {
    private ArrayList<Dresseur> dresseurs;
    private ArrayList<Creature> creatures;
    public Polyland(){
        dresseurs = new ArrayList<Dresseur>();
        creatures = new ArrayList<Creature>();
    }
    //ajouter
    public boolean ajouterDresseur(Dresseur dresseur){
        if (!this.dresseurs.contains(dresseur)) {
            this.dresseurs.add(dresseur);
            return true;
        }
        else
            return false;
    }
    public boolean ajouterCreature(Creature creature){
        if (!this.creatures.contains(creature)) {
            this.creatures.add(creature);
            return true;
        }
        else
            return false;
    }
    //trouver
    public Dresseur trouverDresseur(String nom){
        for (Dresseur dresseur : dresseurs) {
            if (dresseur.getNom().equals(nom)) {
                return dresseur;
            }
        }
        return null;
    }
    public Creature trouverCreature(String nom){
        for (Creature creature : creatures) {
            if (creature.getNom().equals(nom)) {
                return creature;
            }
        }
        return null;
    }
    //retirer
    public boolean retirerDresseur(String nom){
        for (Dresseur dresseur : dresseurs){
            if (dresseur.getNom().equals(nom)){
                dresseurs.remove(dresseur);
                return true;
            }
        }
        return false;
    }
    public boolean retirerCreature(String nom){
        for (Creature creature : creatures){
            if (creature.getNom().equals(nom)){
                creatures.remove(creature);
                return true;
            }
        }
        return false;
    }
    //choix aleatoire
    public Dresseur choisirDresseurAleatoire(){
        Random random = new Random();
        return this.dresseurs.get(random.nextInt(dresseurs.size()));
    }
    public Creature choisirCreatureAleatoire(){
        Random random = new Random();
        return this.creatures.get(random.nextInt(creatures.size()));
    }
    //affichage
    public String toString(){
        String afficher =  "PolyLand:\n" + "Dresseurs:\n" ;
        for (int i = 0 ; i < this.dresseurs.size() ; i++){
            afficher += this.dresseurs.get(i).toString() + "\n";
        }
        afficher += "Creatures sans dresseur:\n" ;
        for (Creature creature: creatures){
            afficher += creature.toString() + "\n";
        }
        return afficher;
    }

}
