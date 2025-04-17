// MSO2700 - Project (by M00959722)

// We are uploading these classes from java.util package because they will be used in the methods since we 
// are working not only on  normal arrays but also resizable ones.
import java.util.ArrayList;
import java.util.Arrays;

// The following is the class that implements the merge sort algorithm for an array list of strings
// (words or characters). The algorithm works by splitting the list into two recursively, sorting each
// sublist then merging them to form a final list sorted into alphabetical (or ascending) order.
public class ProjectMergeSort {

    public static void mergeSort(ArrayList<String> givenList) {
        
        // If the list only has one item, then it is alredy sorted.
        if (givenList.size() < 2) {
            return;
        }
        
        // This divides or splits the list into two (not necesarrily equal parts).
        int midpoint = givenList.size() / 2;
        
        // Here, we store the two parts into left and right ArrayList portions.
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        
        // Fills in the left portion with items from start to midpoint of the list.
        for (int i = 0; i < midpoint; i++) {
            left.add(givenList.get(i));
        }
        
        // Fills in the right portion with items after midpoint to end of the list.
        for (int i = midpoint; i < givenList.size(); i++) {
            right.add(givenList.get(i));
        }
        
        // Sorts the left and right portions of the list recursively.
        mergeSort(left);
        mergeSort(right);

        // Calls on the method that merges the two sorted portions back into one list.
        merge(givenList, left, right);
    }

    // This is the method that merges the two lists back into the ArrayList, given that the two lists
    // are already sorted.
    public static void merge(ArrayList<String> givenList, ArrayList<String> left, ArrayList<String> right) {
        
        // We will use the following indices for the loops:
        int i = 0;    // i for the left portion
        int j = 0;    // j for the right portion
        int k = 0;    // k for the merged list

        // Here we compare the items from both portions. The algorith will pick the lower item first, 
        // according to alphabetical order and place it in the merged list first.
        for (int index = 0; index < givenList.size(); index++) {

            // The algorithm only makes comparison if there are there still items in both portions.
            if (i < left.size() && j < right.size()) {
                
                // If the item coming from the left portion is smaller, then it will get picked.               
                if (left.get(i).compareTo(right.get(j)) <= 0) {
                    givenList.set(k, left.get(i));
                    i++;
                }
            
                // Otherwise, the item from the right side gets picked.
                else {
                    givenList.set(k, right.get(j));
                    j++;
                }
            
                k++;
            }
        }
                // Then the algorithm will move unto the next item in the portion.
                
        // This loop is for any items that are left in the left portion.
        for (int index = i; index < left.size(); index++) {
            givenList.set(k, left.get(index));
            k++; 
        }
  
        // This loop is for the remaining items in the right portion.  
        for (int index = j; index < right.size(); index++) {
            givenList.set(k, right.get(index));
            k++;
        }
    }

    // Here is the main method that demonstrates the merge sort algorithm.
    public static void main(String[] args) {

        // Creates the ArrayList of items or strings to be sorted.   
        ArrayList<String> words = new ArrayList<>(Arrays.asList(
        "January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December"
        ));

        // Displays the unsorted list first.
        System.out.println("Before sorting: " + words);
    
        // Sorts the given list using the method outlined above.
        mergeSort(words);
        
        // Displays the list after it has been sorted alphabetically.
        System.out.println("After sorting: " + words);
    }
}



