import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Partie2Test {
    // Partie 2
    // TODO
    public static void main(String[] args)
    {
        int[] tailleDonnees = {5000, 10000, 17000};
        List<Integer>[] nombresCasMoyenArrays = new List[3];

        for(int i = 0;  i < nombresCasMoyenArrays.length; i++)
        {
            nombresCasMoyenArrays[i] = new ArrayList<>();
            creerListe(nombresCasMoyenArrays[i], tailleDonnees[i]);
        }

        int casMoyen = 0; int pireCas = 1;
        int ajout = 0; int getMin = 1; int retrait = 2;


        System.out.print("\n --------------------- Résultats pour Binary Tree ici ----------------------\n");
        for(int j = 0; j < 2; j++) // pour le 0 : cas moyen et 1 : le pire cas
        {
            for(int taille : tailleDonnees) // For pour le cas moyen et le pire cas.
            {
                // Création de l'arbre binaire
                BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

                for(int k = 0; k < 3; k++) // pour les 3 différents tests (0 : ajout, 1 : getMin et 2 : retrait)
                {
                    long tempsDebut = System.nanoTime();

                    if (j == casMoyen) {
                        int index = getIndex(taille,tailleDonnees);
                        for (int valeur : nombresCasMoyenArrays[index]) {
                            if (k == ajout)
                                binarySearchTree.add(valeur);
                            else if(k == retrait)
                                binarySearchTree.remove(valeur);
                        }
                    }
                    else {
                        for (int i = 0; i < taille; i++) { // le pire cas
                            if (k == ajout)
                                binarySearchTree.add(i); // ajout en ordre (pour le pire cas)

                            else if(k == retrait)
                                binarySearchTree.remove(taille - i); // car on veut passer les valeurs du bas vers le haut

                            else {
                                //binarySearchTree.findMin(binarySearchTree.root); // devrait être rapide, car c'est ordre croissant (haut de l'arbre)
                                binarySearchTree.findMax(binarySearchTree.root);
                            }
                        }
                    }

                    long tempsFin = System.nanoTime();
                    long tempsMis = tempsFin - tempsDebut;

                    if (k == ajout)
                        System.out.print("\nPour le test d'insertion:\n----------------------------");
                    else if (k == getMin)
                        System.out.print("\nPour le test de GetMin()/GetMax():\n------------------------------------");
                    else
                        System.out.print("\nPour le test de suppression (delete):\n-------------------------------------");

                    if (j == casMoyen)
                        System.out.print("\nDans le cas moyen:\n");
                    else
                        System.out.print("\nDans le pire cas:\n");

                    System.out.print("Pour une taille de " + taille + " données: ");

                    if(k == ajout || k == retrait)
                        System.out.print("le temps est de: " + tempsMis/1000000 + " ms.\n");
                    else
                        System.out.print("le temps est de: " + tempsMis + " ns.\n");
                }
            }
        }




        System.out.print("\n---------------------Résultats pour Heap ici---------------------\n");
        for(int j = 0; j < 2; j++) // pour le 0 : cas moyen et 1 : le pire cas
        {
            for(int taille : tailleDonnees) // For pour le cas moyen et le pire cas.
            {
                // Pour Heap
                PriorityQueue<Integer> heap = new PriorityQueue<>();
                for(int k = 0; k < 3; k++) // pour les 3 différents tests (0 : ajout, 1 : getMin et 2 : retrait)
                {
                    long tempsDebut = System.nanoTime();

                    if (j == pireCas) {
                        int index = getIndex(taille,tailleDonnees);
                        for (int valeur : nombresCasMoyenArrays[index]) {
                            if (k == ajout)
                                heap.add(valeur);
                            else if (k == retrait)
                                heap.poll();
                            else
                                heap.peek();
                        }
                    }
                    else
                        for(int i = 0; i < taille; i++)
                        {
                            if (k == ajout)
                                heap.add(i);
                            else if(k == getMin)
                                heap.peek();
                            else
                                heap.poll();
                        }

                    long tempsFin = System.nanoTime();
                    long tempsMis = tempsFin - tempsDebut;
                    if (k == ajout)
                        System.out.print("\nPour le test d'insertion:\n----------------------------");
                    else if (k == getMin)
                        System.out.print("\nPour le test de GetMin()/GetMax():\n------------------------------------");
                    else
                        System.out.print("\nPour le test de suppression (delete):\n-------------------------------------");

                    if (j == casMoyen)
                        System.out.print("\nDans le cas moyen:\n");
                    else
                        System.out.print("\nDans le pire cas:\n");

                    System.out.print("Pour une taille de " + taille + " données: ");

                    if(k == ajout || k == retrait)
                        System.out.print("le temps est de: " + tempsMis + " ns.\n");
                    else
                        System.out.print("le temps est de: " + tempsMis + " ns.\n");
                }
            }
        }
    }

    private static void creerListe(List<Integer> list, int taille) {
        for (int i = 0; i < taille; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
    }

    private static int getIndex(int taille, int[] tailleDonnees) {
        for (int i = 0; i < tailleDonnees.length; i++)
            if (taille == tailleDonnees[i])
                return i;
        return 0;
    }
}