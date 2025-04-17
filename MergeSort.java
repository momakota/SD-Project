import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(ArrayList<String> givenList) {
        if (givenList.size() < 2) {
            return;
        }
        
        int midpoint = givenList.size() / 2;

        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();

        for (int i = 0; i < midpoint; i++) {
            left.add(givenList.get(i));
        }

        for (int i = midpoint; i < givenList.size(); i++) {
            right.add(givenList.get(i));
        }

        mergeSort(left);
        mergeSort(right);

        merge(givenList, left, right);
    }

    public static void merge(ArrayList<String> givenList, ArrayList<String> left, ArrayList<String> right) {
        int i = 0; 
        int j = 0; 
        int k = 0; 
    
        for (int index = 0; index < givenList.size(); index++) {
            if (i < left.size() && j < right.size()) {
                if (left.get(i).compareTo(right.get(j)) <= 0) {
                    givenList.set(k, left.get(i));
                    i++;
                }
            
                else {
                    givenList.set(k, right.get(j));
                    j++;
                }
            
                k++;
            }
        }
    
        for (int index = i; index < left.size(); index++) {
            givenList.set(k, left.get(index));
            k++; 
        }
    
        for (int index = j; index < right.size(); index++) {
            givenList.set(k, right.get(index));
            k++;
        }
    }
}