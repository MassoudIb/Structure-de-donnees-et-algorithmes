
public class Interview {


    /** Expliquez votre complexité temporelle et spatiale en cas moyen et en pire cas à l'aide de commentaire dans le code
     *  Indiquez les équivalences telles que O(n + 1) => O(n) et O(2n) => O(n)
     *
     *  Dans le meilleur des cas la liste est vide est return null O(1)
     *  La complexité temporelle en pire cas est O(n)
     *  Dans le pire cas, lorsque l'élément unique est le dernier élément du tableau, nous devons parcourir
     *  tout le tableau pour le trouver.
     *  La boucle for itère sur chaque élément du tableau jusqu'à l'avant-dernier élément, en sautant de 2 en 2.
     *  Par conséquent, le nombre d'itérations de la boucle for est n/2, ce qui équivaut à O(n)
     *  La complexité temporelle en cas moyen est également O(n). Comme il n'y a qu'un seul élément unique
     *  dans le tableau, nous devons itérer sur tous les éléments pour le trouver
     *  La complexité spatiale est constante, O(1), car nous n'utilisons qu'un nombre constant de variables
     *  pour stocker les indices et les valeurs.
     *
     *
     ** TODO Time Complexity : Worst Case O(n), explain Worst and Average Case
     ** TODO Space Complexity : Determine and Explain Worst and Average Case in comments
     ** TODO HAS TO BE ITERATIVE, , NOT RECURSIVE
     * @param numbers List of numbers sorted in ascending order containing 1 non-duplicate
     * @return non-duplicate number
     */


    public static Integer findNonDuplicateIterativeLinear(Integer[] numbers) {
        if (numbers.length == 0) {
            return null;
        }

        for (int i = 0; i < numbers.length - 1; i += 2) { //O(n/2) => O(n)
            if (!numbers[i].equals(numbers[i + 1])) {
                return numbers[i];
            }
        }

        return numbers[numbers.length - 1]; // le seul qui n'a pas été vérifié si numbers.length est paire
    }



    /** Expliquez votre complexité temporelle et spatiale à l'aide de commentaire dans le code
     *  Indiquez les équivalences telles que O(n + 1) => O(n) et O(2n) => O(n)
     *
     * Dans le meilleur des cas la liste est vide est return null O(1)
     * La complexité temporelle dans le pire cas est O(log(n))
     * Dans le pire cas, lorsque l'élément unique est à la fin du tableau,
     * à chaque itération de la boucle while, nous divisons l'intervalle de recherche en deux,
     * réduisant ainsi l'espace de recherche de moitié à chaque fois.
     * Par conséquent, le nombre d'itérations nécessaires pour trouver l'élément unique est O(log(n))
     * La complexité temporelle en cas moyen est également O(log(n)). Comme il n'y a qu'un seul
     * élément unique dans le tableau, nous devons effectuer une recherche binaire pour le trouver.
     * La complexité spatiale dans le pire cas est constante, O(1), car nous utilisons un nombre constant
     * de variables pour stocker les indices et les valeurs.
     *
     *
     ** TODO Time Complexity : Worst Case O(log(n)), explain Worst and Average Case
     ** TODO Space Complexity : Determine and Explain Worst and Average Case in comments
     ** TODO HAS TO BE ITERATIVE, NOT RECURSIVE
     * @param numbers List of numbers sorted in ascending order containing 1 duplicate
     * @return non-duplicate number
     */


    public static Integer findNonDuplicateIterative(Integer[] numbers) {

    if (numbers.length == 0) {
        return null;
    }

    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;
        if (mid % 2 == 1) {
            mid--; // Assure que mid est pair pour comparer les éléments en paires
        }

        if (numbers[mid].equals(numbers[mid + 1])) {
            left = mid + 2;
        } else {
            right = mid;
        }
    }
    return numbers[left];
}


    /** Expliquez votre complexité temporelle et spatiale à l'aide de commentaire dans le code
     *  Indiquez les équivalences telles que O(n + 1) => O(n) et O(2n) => O(n)
     *
     * Dans le meilleur des cas la liste est vide est return null O(1)
     * La complexité temporelle dans le pire cas est O(log(n)).
     * Dans le pire cas, lorsque l'élément unique est à l'extrémité opposée du tableau,
     * nous divisons récursivement le tableau en deux à chaque étape.
     * À chaque étape, nous réduisons la taille du tableau à peu près de moitié,
     * ce qui donne une complexité logarithmique.
     * La complexité temporelle en cas moyen est également O(log(n)). Comme il n'y a qu'un seul élément unique
     * dans le tableau, nous divisons récursivement le tableau en deux pour le trouver.
     * La complexité spatiale dans le pire cas est O(log(n))
     * Cela est dû à l'utilisation de la récursion, qui nécessite l'appel de fonctions supplémentaires
     * sur la pile d'appels.
     * La complexité spatiale en cas moyen est également O(log(n)).
     *
     *
     ** TODO Time Complexity : Worst Case O(log(n)), explain Worst and Average Case
     ** TODO Space Complexity : Determine and Explain Worst and Average Case in comments
     ** TODO HAS TO BE RECURSIVE, NOT ITERATIVE
     * @param numbers List of numbers sorted in ascending order containing 1 non-duplicate
     * @return non-duplicate number
     */


    public static Integer findNonDuplicateRecursive(Integer[] numbers) {
        if (numbers.length == 0) {
            return null;
        }
        //utiliser une 2ème fonction pour ne pas vérifier la première condition à chaque fois
        return findNonDuplicate(numbers, 0, numbers.length - 1);
    }
    private static int findNonDuplicate(Integer[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        if (mid % 2 == 1) {
            mid--; // Assure que mid est pair pour comparer les éléments en paires
        }

        if (nums[mid].equals(nums[mid + 1])) {
            return findNonDuplicate(nums, mid + 2, right);
        } else {
            return findNonDuplicate(nums, left, mid);
        }
    }

}



