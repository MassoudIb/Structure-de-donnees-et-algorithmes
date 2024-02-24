

public class AVL_Test_Partie2 {

    private AvlTree<Integer> avl;

    /**
     *  Production d'un arbre qui ressemble à la figure 1 du rapport, mais avec 41 éléments.
     */

    public static void main(String[] args) {

        AVL_Test_Partie2 test = new AVL_Test_Partie2();
        test.avl = new AvlTree<>();

        test.avl.add(50);
        test.avl.add(49);
        test.avl.add(48);
        test.avl.add(47);
        test.avl.add(46);
        test.avl.add(45);
        long tempsDebutAjoutMoyen = System.nanoTime(); // cas moyen
        test.avl.add(44);
        long tempsFinAjoutMoyen = System.nanoTime(); // cas moyen
        long tempsPrisAjoutMoyen = tempsFinAjoutMoyen - tempsDebutAjoutMoyen;

        test.avl.add(43);
        long tempsDebutRetraitMoyen = System.nanoTime(); // cas moyen
        test.avl.remove(43);
        long tempsFinRetraitMoyen = System.nanoTime(); // cas moyen
        long tempsPrisRetraitMoyen = tempsFinRetraitMoyen - tempsDebutRetraitMoyen;
        test.avl.add(42);
        test.avl.add(41);
        test.avl.add(40);
        test.avl.add(39);
        test.avl.add(38);
        test.avl.add(37);
        test.avl.add(36);
        test.avl.add(35);
        test.avl.add(34);
        test.avl.add(33);
        test.avl.add(32);
        test.avl.add(31);
        test.avl.add(30);
        test.avl.add(29);
        test.avl.add(28);
        test.avl.add(27);
        test.avl.add(26);
        test.avl.add(25);
        test.avl.add(24);
        test.avl.add(23);
        test.avl.add(22);
        test.avl.add(21);
        test.avl.add(20);
        test.avl.add(19);
        test.avl.add(18);
        test.avl.add(17);
        test.avl.add(16);
        test.avl.add(15);
        test.avl.add(14);
        test.avl.add(13);
        test.avl.add(12);
        test.avl.add(11);
        test.avl.add(10);
        long tempsDebutRetraitPire = System.nanoTime(); // pire des cas
        test.avl.remove(10);
        long tempsFinRetraitPire = System.nanoTime(); // pire des cas
        long tempsPrisRetraitPire = tempsFinRetraitPire - tempsDebutRetraitPire;

        long tempsDebutAjoutPire = System.nanoTime(); // pire des cas
        test.avl.add(5);
        long tempsFinAjoutPire = System.nanoTime(); // pire des cas
        long tempsPrisAjoutPire = tempsFinAjoutPire - tempsDebutAjoutPire;

        System.out.println("Le temps pris pour ajouter un element (scenario cas moyen) : " + tempsPrisAjoutMoyen + " nanosecondes");
        System.out.println("Le temps pris pour ajouter un element (scenario pire cas) : " + tempsPrisAjoutPire + " nanosecondes\n");

        System.out.println("Le temps pris pour retirer un element (scenario cas moyen) : " + tempsPrisRetraitMoyen + " nanosecondes");
        System.out.println("Le temps pris pour retirer un element (scenario pire cas) : " + tempsPrisRetraitPire + " nanosecondes");
    }
}
