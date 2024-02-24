import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SPLAY_Test_Partie2 {

    private SplayTree splay;

    /**
     *  Production d'un arbre qui ressemble à la figure 1 du rapport, mais avec 41 éléments.
     */

public static void main(String[] args) {

    SPLAY_Test_Partie2 test = new SPLAY_Test_Partie2();
    test.splay = new SplayTree();
    test.splay.insert(50);
    test.splay.insert(49);
    test.splay.insert(48);
    test.splay.insert(47);
    test.splay.insert(46);
    test.splay.insert(45);
    test.splay.insert(44);
    test.splay.insert(43);
    test.splay.remove(43);
    test.splay.insert(42);
    test.splay.insert(41);
    test.splay.insert(40);
    test.splay.insert(39);
    test.splay.insert(38);
    test.splay.insert(37);
    test.splay.insert(36);
    test.splay.insert(35);
    test.splay.insert(34);
    test.splay.insert(33);
    test.splay.insert(32);
    test.splay.insert(31);
    test.splay.insert(30);
    test.splay.insert(29);
    test.splay.insert(28);
    test.splay.insert(27);
    test.splay.insert(26);
    test.splay.insert(25);
    test.splay.insert(24);
    test.splay.insert(23);
    test.splay.insert(22);
    test.splay.insert(21);
    test.splay.insert(20);
    test.splay.insert(19);
    test.splay.insert(18);
    test.splay.insert(17);
    test.splay.insert(16);
    test.splay.insert(15);
    long tempsDebutRetraitPire = System.nanoTime(); // pire cas de retrait
    test.splay.remove(43);
    long tempsFinRetraitPire = System.nanoTime(); // pire cas de retrait
    long tempsPrisRetraitPire = tempsFinRetraitPire - tempsDebutRetraitPire;

    long tempsDebutAjoutPire = System.nanoTime(); // pire cas de retrait
    test.splay.insert(51);
    long tempsFinAjoutPire = System.nanoTime(); // pire cas de retrait
    long tempsPrisAjoutPire = tempsFinAjoutPire - tempsDebutAjoutPire;

    test.splay.insert(14);
    test.splay.insert(13);
    test.splay.insert(12);
    test.splay.insert(11);
    test.splay.insert(10);
    long tempsDebutRetraitMoyen = System.nanoTime(); // cas moyen de retrait
    test.splay.remove(12);
    long tempsFinRetraitMoyen = System.nanoTime(); // cas moyen de retrait
    long tempsPrisRetraitMoyen = tempsFinRetraitMoyen - tempsDebutRetraitMoyen;

    long tempsDebutAjoutMoyen = System.nanoTime(); // cas moyen d'ajout
    test.splay.insert(5);
    long tempsFinAjoutMoyen = System.nanoTime(); // cas moyen d'ajout
    long tempsPrisAjoutMoyen = tempsFinAjoutMoyen - tempsDebutAjoutMoyen;

    System.out.println("Le temps pris pour ajouter un element (scenario cas moyen) : " + tempsPrisAjoutMoyen + " nanosecondes");
    System.out.println("Le temps pris pour ajouter un element (scenario pire cas) : " + tempsPrisAjoutPire + " nanosecondes\n");

    System.out.println("Le temps pris pour retirer un element (scenario cas moyen) : " + tempsPrisRetraitMoyen + " nanosecondes");
    System.out.println("Le temps pris pour retirer un element (scenario pire cas) : " + tempsPrisRetraitPire + " nanosecondes");
}
}
