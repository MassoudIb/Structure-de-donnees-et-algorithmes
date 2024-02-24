public class CreatureExperience extends Creature implements Experience {

    @Override
    public void afficher() {

    }

    @Override
    public int obtenirExperience() {
        return 0;
    }

    private int forceExperience;


    public CreatureExperience(){
        super();
        forceExperience = 0;
    };
    public CreatureExperience(String n, int att, int def, int pv, int fe){
        super(n, att, def, pv);
        forceExperience = fe;
    };

    public CreatureExperience(Creature autre, int fe){
        super(autre);
        forceExperience = fe;
    };

    public CreatureExperience(CreatureExperience ce){
        super(ce);
        forceExperience = ce.forceExperience;
    };

    public final int getExperience(){return forceExperience;};
    public void setExperience(int exp) {
        if(exp > MAX_VAL)
            this.forceExperience = MAX_VAL;
        else if(exp < 0)
            this.forceExperience = 0;
        else
            this.forceExperience = exp;
    }
    public void setExperience(int exp, boolean estPositive) {
        if (estPositive) {
            this.forceExperience += exp;

            if (this.forceExperience > MAX_VAL){
                this.forceExperience = MAX_VAL;
            }

        } else {
            this.forceExperience -= exp;
        }
    }

    @Override
    public void attaquer(Creature c){
        this.setAttaque((int)(this.getAttaque() *(double)(this.forceExperience) / MAX_VAL));
        c.setPointDeVie(this.getAttaque(), false);
    }

    public void attaquer(Creature c, int expBonus){
        this.setAttaque((int)(this.getAttaque() *((double)(this.forceExperience + expBonus)) / MAX_VAL));
        c.setPointDeVie(this.getAttaque(), false);
        }
    @Override
    public void defendre(Creature c){
        int defenseBonus = (int) (this.getDefense() * (this.forceExperience / 100.0));
        int dommage = ( c.getAttaque() - (this.getDefense() + defenseBonus) );
        this.setPointDeVie(dommage, false);
    }
    public void defendre(Creature c, int expBonus){
        int defenseBonus = (int) (this.getDefense() * ((this.forceExperience + expBonus)/ 100.0));
        int dommage = ( c.getAttaque() - (this.getDefense() + defenseBonus) );
        this.setPointDeVie(dommage, false);
        this.setExperience(expBonus, false);
    }
    public String toString(){
        return ("[Creature Experience] -> " + "Nom: " + this.getNom() + ", Attaque: " + this.getAttaque() +
                ", Défense: " + this.getDefense() + ", Points de Vie: " + this.getPointDeVie() + ", Force Experience: " + this.forceExperience);
    }

}