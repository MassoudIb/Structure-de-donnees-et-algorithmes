


public class BST_Test_Partie2 {

    private BinarySearchTree<Integer> bst;

    /**
     *  Production d'un arbre qui ressemble à la figure 1 du rapport, mais avec 41 éléments.
     */

    public static void main(String[] args) {

        BST_Test_Partie2 test = new BST_Test_Partie2();
        test.bst = new BinarySearchTree<>();

        test.bst.add(50);
        test.bst.add(49);
        test.bst.add(48);
        test.bst.add(47);
        test.bst.add(46);
        test.bst.add(45);
        long tempsDebutAjoutMoyen = System.nanoTime(); // cas moyen
        test.bst.add(44);
        long tempsFinAjoutMoyen = System.nanoTime(); // cas moyen
        long tempsPrisAjoutMoyen = tempsFinAjoutMoyen - tempsDebutAjoutMoyen;

        test.bst.add(43);
        long tempsDebutRetraitMoyen = System.nanoTime(); // cas moyen
        test.bst.remove(43);
        long tempsFinRetraitMoyen = System.nanoTime(); // cas moyen
        long tempsPrisRetraitMoyen = tempsFinRetraitMoyen - tempsDebutRetraitMoyen;
        test.bst.add(42);

        long tempsDebutContainsMoyen = System.nanoTime(); // cas moyen
        test.bst.contains(42);
        long tempsFinContainsMoyen = System.nanoTime(); // cas moyen
        long tempsPrisContainsMoyen = tempsFinContainsMoyen - tempsDebutContainsMoyen;

        test.bst.add(41);
        test.bst.add(40);
        test.bst.add(39);
        test.bst.add(38);
        test.bst.add(37);
        test.bst.add(36);
        test.bst.add(35);
        test.bst.add(34);
        test.bst.add(33);
        test.bst.add(32);
        test.bst.add(31);
        test.bst.add(30);
        test.bst.add(29);
        test.bst.add(28);
        test.bst.add(27);
        test.bst.add(26);
        test.bst.add(25);
        test.bst.add(24);
        test.bst.add(23);
        test.bst.add(22);
        test.bst.add(21);
        test.bst.add(20);
        test.bst.add(19);
        test.bst.add(18);
        test.bst.add(17);
        test.bst.add(16);
        test.bst.add(15);
        test.bst.add(14);
        test.bst.add(13);
        test.bst.add(12);
        test.bst.add(11);
        test.bst.add(10);
        long tempsDebutRetraitPire = System.nanoTime(); // pire des cas
        test.bst.remove(10);
        long tempsFinRetraitPire = System.nanoTime(); // pire des cas
        long tempsPrisRetraitPire = tempsFinRetraitPire - tempsDebutRetraitPire;

        long tempsDebutAjoutPire = System.nanoTime(); // pire des cas
        test.bst.add(5);
        long tempsFinAjoutPire = System.nanoTime(); // pire des cas
        long tempsPrisAjoutPire = tempsFinAjoutPire - tempsDebutAjoutPire;

        long tempsDebutContainsPire = System.nanoTime(); // pire des cas
        test.bst.contains(10);
        long tempsFinContainsPire = System.nanoTime(); // pire des cas
        long tempsPrisContainsPire = tempsFinContainsPire - tempsDebutContainsPire;

        System.out.println("Le temps pris pour ajouter un element (scenario cas moyen) : " + tempsPrisAjoutMoyen + " nanosecondes");
        System.out.println("Le temps pris pour ajouter un element (scenario pire cas) : " + tempsPrisAjoutPire + " nanosecondes\n");

        System.out.println("Le temps pris pour retirer un element (scenario cas moyen) : " + tempsPrisRetraitMoyen + " nanosecondes");
        System.out.println("Le temps pris pour retirer un element (scenario pire cas) : " + tempsPrisRetraitPire + " nanosecondes\n");

        System.out.println("Le temps pris pour rechercher un element (scenario cas moyen) : " + tempsPrisContainsMoyen + " nanosecondes");
        System.out.println("Le temps pris pour rechercher un element (scenario pire cas) : " + tempsPrisContainsPire + " nanosecondes");

    }
}
