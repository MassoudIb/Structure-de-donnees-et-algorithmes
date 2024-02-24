import java.util.*;

public class Interview {
    protected enum Type{
        MinHeap,
        MaxHeap,
        NotHeap
    };

    public Type part1Interview(BinaryNode<Integer> root) // O(n)+O(n) = O(n)
    {
        if (isMaxHeap(root)) { //O(n)
            return Type.MaxHeap;
        } else if (isMinHeap(root)) { //O(n)
            return Type.MinHeap;
        } else {
            return Type.NotHeap;
        }
    }

    private boolean isMaxHeap(BinaryNode<Integer> root) {
        if (root == null) { //O(1)
            return true;
        }

        if (root.left != null && root.left.getValue() > root.getValue()) { //O(1) pour root.left/right.getValue()
            return false;
        }

        if (root.right != null && root.right.getValue() > root.getValue()) { //O(1) pour root.left/right.getValue()
            return false;
        }

        return isMaxHeap(root.left) && isMaxHeap(root.right); //récursivité sur le nombre de noeuds donc O(n)
    }

    private boolean isMinHeap(BinaryNode<Integer> root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.getValue() < root.getValue()) { //O(1) pour root.left/right.getValue()
            return false;
        }

        if (root.right != null && root.right.getValue() < root.getValue()) { //O(1) pour root.left/right.getValue()
            return false;
        }

        return isMinHeap(root.left) && isMinHeap(root.right); //récursivité sur le nombre de noeuds donc O(n)
    }

    // Partie 3.2
    public Integer part2Interview(Integer[] arr, Integer k) {
        // Calculer la fréquence de chaque nombre
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : arr) { //O(n) on parcours tout le array
            frequency.put(num, frequency.getOrDefault(num, 0) + 1); //la methode put a une complexité de O(1)
        }

        // Trier les nombres en fonction de leur fréquence et de leur valeur
        //dans le meilleur O(1) quand arr n'a qu'un seul element qui se repète sinon O(n) s'ils sont différents
        List<Integer> sortedNumbers = new ArrayList<>(frequency.keySet());
        Collections.sort(sortedNumbers, (a, b) -> {
            int freqComparison = Integer.compare(frequency.get(b), frequency.get(a)); //la methode get a une complexité de O(n) dans le pire cas dans les hashMap
            return freqComparison != 0 ? freqComparison : Integer.compare(b,a); //recursivité avec une complexité de log(n)
        });

        // Retourner le k-ième élément
        if (k <= sortedNumbers.size()) {
            return sortedNumbers.get(k - 1);
        } else {
            return -1;
        }
    }
}

