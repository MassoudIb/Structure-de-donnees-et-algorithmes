import java.util.Collection;

public class CompletTree {
    // Partie 1

    public boolean isCompleteTree(Integer[] arr){
        // TODO

        for (Integer valeur : arr) {
            if (valeur == null)
                return false;
        }

        return true;
    }

    public boolean isCompleteTree(BinaryNode<Integer> root){
        // TODO
        if(root.left == null && root.right == null)
            return true;

        if((root.left!= null) && (root.right != null))
            return(isCompleteTree(root.left) && isCompleteTree(root.right));

        return false;
    }


}
