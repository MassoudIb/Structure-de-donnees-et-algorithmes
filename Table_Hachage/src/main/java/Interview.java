import java.util.*;
import java.util.HashMap;

public final class Interview {

    /** Expliquez votre complexité temporelle et spatiale à l'aide de commentaire dans le code
     *  n représente le nombre de charactère de `phrase` et m le nombre de charactère de `stopwords`
     *  Indiquez les équivalences telles que O(n + 1 + m + 1) => O(n+m) et O(2n+3m) => O(n+m) lorsque possible
     *
     ** TODO Justify Time Complexity  : Average Case O(n+m)
     ** TODO Justify Space Complexity : Worst Case O(n+m)
     * Notre première étape dans l'algorhitme est de diviser la phrase en la délimitant par les espaces blancs.
     * Ceci donne une compléxité temporelle et spatiale de (n+m) étant donné qu'il faut passer par toutes les
     * caractères des mots valides et des stopwords.
     *
     * Par la suite, la création d'une Map avec la HashMap est d'une complexité spatiale O(n) puisqu'il faut
     * avoir assez d'espace de mémoire pour contenir tous les caractères des mots valides.
     * C'est d'une compléxité temporelle O(1) puisque c'est une opération qui se fait 1 fois.
     *
     * Ensuite, pour la création du Set qui va contenir les mots invalides (stopwords), la compléxité spatiale
     * est de O(m) étant donné que m est le nombre de charactère de `stopwords`.
     * La compléxité temporelle est de O(m) puisque la fonction 'rendreMinuscule" lui donne cette compléxité
     * en rendant tous les caractères des mots "stopwords" minuscules.
     *
     * La fonction faireCompte utilise plusieurs méthodes de la HashMap tels que : contains et put
     * qui eux ont une complexité O(1). Au total la complexité de cette fonction et O(n+m) en moyenne
     *
     * La fonction trouverMotValide est d'une complexité temporelle O(n) et d'une complexité spatiale O(1)
     * puisque les fonctions getValue() et getKey() pour la HashMap sont d'une complexité O(1).
     *
     * Finalement, si on considère toute les complexité de la fonction findMostCommonValidWord,
     * au total nous aurons ceci:
     * Complexité temporelle: O(3n + 3m + 1) => O(n+m) en moyenne.
     * Complexité spatiale:   O(3n + 3m + 1) => O(n+m) en pire cas.
     *
     * @param phrase String containing a sequence of words separated by a space
     * @param stopwords String array containing all the stop words
     * @return Pair containing two elements, first being the most common word not in the stop words,
     * second being the number of occurences of this word
     */


    public static Pair findMostCommonValidWord(String phrase, String[] stopwords) {
        // Complexité temporelle et spatiale O(n+m) de la fonction split pour la string.
        String [] motsDansPhrase = phrase.split(" ");

        // Complexité temporelle O(1), Complexité spatiale O(n)
        Map<String, Integer> motsValides = new HashMap<>();

        // Complexité temporelle O(m + 1) => O(m), Complexité spatiale O(m + 1) => O(m)
        Set<String> motsInvalides        = new HashSet<>(Arrays.asList(rendreMinuscule(stopwords)));

        // Complexité temporelle O(2m + n + 3) => O(m+n), Complexité spatiale O(2n + 2m) => O(m+n)
        faireCompte(motsDansPhrase, motsValides, motsInvalides);

        // Complexité temporelle O(2n) => O(n), Complexité spatiale O(2) => O(1)
        return trouverMotValide(motsValides);
    }

    public static String[] rendreMinuscule(String[] stopwords) {
        for (int i = 0; i < stopwords.length; i++)   //Complexité temporelle O(m) puisqu'on passe par tous les stopwords.
            stopwords[i] = stopwords[i].toLowerCase(); // Complexité temporelle et spatiale O(1).
        return stopwords;                              // Total: Complexité temporelle O(m)
    }                                                  //        Complexité spatiale O(1)
    public static void faireCompte(String [] motsDansPhrase, Map <String, Integer> motsValides, Set<String> motsInvalides){
        rendreMinuscule(motsDansPhrase);          // Complexité temporelle O(m) et Complexité spatiale O(1).
        for (String s : motsDansPhrase) {         // Complexité temporelle O(n+m) puisque on passe tous les mots.
            if (!motInvalid(s, motsInvalides)) {  // Complexité temporelle et spatiale O(1).
                int count = motsValides.containsKey(s) ? motsValides.get(s) : 0; //Complexité temporelle O(1) pour  la fonction containsKey du HashMap.
                motsValides.put(s, count + 1); // Complexité temporelle et spatiale O(1) pour  la fonction put du HashMap
            }                                     // Total: Complexité temporelle O(2m + n + 3) => O(m+n)
        }                                         //        Complexité spatiale O(2n + 2m) => O(m+n)
    }

    public static boolean motInvalid(String mot, Set<String> motsInvalides){
        return motsInvalides.contains(mot); // Complexité temporelle et spatiale O(1) pour la fonction contains du HashSet.
    }

    public static Pair trouverMotValide(Map <String, Integer> motsValides)
    {
        int compteurMaximal = 0;     // Complexité temporelle et spatiale O(1).
        String motPopulaire = null;  // Complexité temporelle et spatiale O(1).

        for(Map.Entry<String, Integer> valeur : motsValides.entrySet()){ // Complexité temporelle O(n) et compléxité spatiale O(1) puisqu'on passe par tous les mots valides.
            if(valeur.getValue() > compteurMaximal){
                compteurMaximal = valeur.getValue();     // Complexité temporelle O(1) et compléxité spatiale O(1).
                motPopulaire = valeur.getKey();          // Complexité temporelle O(1) et compléxité spatiale O(1).
            }                                            // Total: Complexité temporelle O(2n) => O(n)
        }                                                //        Complexité spatiale O(2) => O(1)

        if(motPopulaire == null || motPopulaire.isEmpty())
            return new Pair(null, null);
        else
            return new Pair(motPopulaire, compteurMaximal);
    }
}