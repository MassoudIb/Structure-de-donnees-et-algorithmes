public class CreatureMagique extends Creature{
    private int forceMagique;
    private boolean aPotionMagique;
    private boolean estMagique;
    static final int PERTE_MAGIQUE = 5;

    public CreatureMagique(){
        super();
        forceMagique = 0;
        aPotionMagique = false;
        estMagique = false;
    };
    public CreatureMagique(String n, int att, int def, int pv, int fm, boolean pm, boolean em){
        super(n, att, def, pv);
        forceMagique = fm;
        aPotionMagique = pm;
        estMagique = em;
    };

    public CreatureMagique(Creature c, int fm,boolean pm, boolean em){
        super(c);
        forceMagique = fm;
        aPotionMagique = pm;
        estMagique = em;
    };

    public CreatureMagique(CreatureMagique cm){
        super(cm);
        forceMagique = cm.forceMagique;
        aPotionMagique = cm.aPotionMagique;
        estMagique = cm.estMagique;
    };



    public final int getForceMagique(){return forceMagique;};
    public final boolean getAPotionMagique() {return aPotionMagique;};
    public final boolean getEstMagique() {return estMagique;};

    public void setForceMagique(int fm) {
        if(fm > MAX_VAL)
            this.forceMagique = MAX_VAL;
        else if(fm < 0)
            this.forceMagique = 0;
        else
            this.forceMagique = fm;
    }
    public void setForceMagique(int fm, boolean estPositive) {
        if (estPositive) {
            this.forceMagique += fm;

            if (this.forceMagique > MAX_VAL){
                this.forceMagique = MAX_VAL;
            }

        } else {
            this.forceMagique -= fm;
        }
    }


    @Override
    public void attaquer(Creature c) {
        if(this.estMagique)
            this.attaquer(c, this.forceMagique);
        else
            super.attaquer(c);
    }

    public void attaquer(Creature c, int fm) {
        int bonus =(int) (this.getAttaque() * fm / 100.0);
        this.setAttaque(this.getAttaque() + bonus);
        c.setPointDeVie(this.getAttaque() - c.getDefense(), false);
        this.forceMagique -= PERTE_MAGIQUE;
    }

    @Override
    public void defendre(Creature c){
        if(this.estMagique){
            int dommage = ( c.getAttaque() - (this.forceMagique) );
            this.setPointDeVie(dommage, false);
            c.attaquer(c);
        } else {
            int dommage = ( c.getAttaque() - (this.getDefense()) );
            setPointDeVie(dommage, false);
        }

    }

    public void utiliserPotionMagique(){
        if(this.aPotionMagique){
            if(this.getPointDeVie() != MAX_VAL){
                setPointDeVie(MAX_VAL);
                this.estMagique = true;
                this.aPotionMagique = false;
            }
        }
    }

    public void afficher(){
        System.out.print("[Creature Magique] -> " + "Nom: " + this.getNom() + ", Attaque: " + this.getAttaque() +
                ", Défense: " + this.getDefense() + ", Points de Vie: " + this.getPointDeVie() + ", Force Magique: " + this.forceMagique);
    }

    public String toString(){
        return ("[Creature Magique] -> " + "Nom: " + this.getNom() + ", Attaque: " + this.getAttaque() +
                ", Défense: " + this.getDefense() + ", Points de Vie: " + this.getPointDeVie() + ", Force Magique: " + this.forceMagique);
    }

}