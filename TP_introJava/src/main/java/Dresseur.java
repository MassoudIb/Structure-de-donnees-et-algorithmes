import java.util.ArrayList;
import java.util.Objects;
public class Dresseur {
    protected String nom;
    protected ArrayList<Creature> creatures;
    //constructeur
    public Dresseur(String nom){
        this.nom=nom;
        this.creatures=new ArrayList<Creature>();
    }
    //constructeur de copie
    public Dresseur(Dresseur autre){
        this.nom = autre.nom;
        this.creatures = new ArrayList<Creature>();
        for (int i = 0; i < autre.getNombreCreatures(); i++ ){
            this.ajouterCreature(new Creature(autre.creatures.get(i)));
        }
    }
    //setter
    public void setNom(String nom){this.nom = nom;}
    public void setCreatures(ArrayList<Creature> creatures)
    {this.creatures = creatures;}
    //getter
    public final String getNom() {
        return this.nom;
    }
    public final int getNombreCreatures(){
        return creatures.size();
    }
    public final ArrayList<Creature> getCreatures(){return creatures;}
    public boolean attraperCreature(Creature creature) {
        if(creature.estAffaibli()){
            return this.ajouterCreature(creature);
        }
        return false;
    }
    public boolean ajouterCreature(Creature creature) {
        if (!this.creatures.contains(creature)){
            creatures.add(creature);
            return true;
        }
        return false;
    }
    public boolean supprimerCreature(String nom){
        if (creatures.contains(getCreature(nom))){
            creatures.remove(getCreature(nom));
            return true;}
        return false;
    }
    public final Creature getCreature(String nom){
        for (Creature creature : creatures) {
            if (creature.getNom().equals(nom)) {
                return creature;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        Dresseur autre = (Dresseur) o;
        return nom.equals(autre.nom) && creatures.equals(autre.creatures);
    }

    public int hashCode(){
        return Objects.hash(nom, creatures);
    }

    public String toString(){
        String afficher =  "[" + this.nom + "]\n";
        for (int i = 0 ; i < this.getNombreCreatures() ; i++){
            afficher += "\t" + this.creatures.get(i).toString() + "\n";
        }
        return afficher;
    }
}