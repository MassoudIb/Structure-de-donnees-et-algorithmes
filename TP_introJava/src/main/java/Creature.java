public class Creature {
    private String nom;	    	// Nom de la créature
    private int attaque;		// Puissance d'attaque de la créature
    private int defense;		// Puissance de défense de la créature
    private int pointDeVie;		// Points de vie actuels de la créature
    static final int MAX_VAL=100;
    public Creature(){
        this.nom = "";
        this.attaque = 0;
        this.defense = 0;
        this.pointDeVie = MAX_VAL;
    };
    public Creature(String n, int att, int def){
        nom = n ;
        attaque = att ;
        defense = def ;
        pointDeVie = MAX_VAL;
    };
    public Creature(String n, int att, int def, int pv){
        nom = n ;
        attaque = att ;
        defense = def ;
        pointDeVie = pv ;
    }
    public Creature(Creature autre){
        this.nom = autre.nom;
        this.attaque = autre.attaque;
        this.defense = autre.defense;
        this.pointDeVie = autre.pointDeVie;
    }

    //getter
    public final String getNom(){return nom;};
    public final int getAttaque(){return attaque;};
    public final int getDefense(){return defense;};
    public final int getPointDeVie(){return pointDeVie;};

    //setter
    public void setNom(String nom) {this.nom = nom;}

    public void setAttaque(int attaque) {this.attaque = attaque;}

    public void setDefense(int defense) {this.defense = defense;}

    public void setPointDeVie(int pointDeVie) {
        if(pointDeVie < 0)
            this.pointDeVie = 0;
        else if (pointDeVie > MAX_VAL)
            this.pointDeVie = MAX_VAL;
        else
            this.pointDeVie = pointDeVie;
    }
    public void setPointDeVie(int pointDeVie, boolean estPositive){
        if (estPositive)
            this.pointDeVie += pointDeVie;
        else
            this.pointDeVie -= pointDeVie;

        if (this.pointDeVie > MAX_VAL)
            this.pointDeVie = MAX_VAL;
    }
    private int calculeDommages(int attaque, int defense){
        return attaque-defense;
    }
    public void attaquer(Creature c){
        if (calculeDommages(this.attaque, c.defense)>0)
            c.setPointDeVie(calculeDommages(this.attaque, c.defense), false);
    }
    public void attaquer(Creature c, int attaqueBonus){
        if (calculeDommages(this.attaque, c.defense)>0)
            c.setPointDeVie(calculeDommages(this.attaque + attaqueBonus, c.defense), false);};
    public void defendre(Creature c){
        if (calculeDommages(c.attaque, this.defense)>0)
            this.setPointDeVie(calculeDommages(c.attaque, this.defense), false);
    }
    public void defendre(Creature c, int defenseBonus){c.defense +=defenseBonus; }
    public boolean estAffaibli(){
        return this.pointDeVie == 0;
    }
    public String toString(){
       return ("Nom: " + this.nom + ", Attaque: " + this.attaque +
                ", Défense: " + this.defense + ", Points de Vie: " + this.pointDeVie);
    }
    public boolean equals(Creature c){
        return this.nom == c.nom && this.defense== c.defense &&
                this.attaque == c.attaque && this.pointDeVie == c.pointDeVie;
    }

}