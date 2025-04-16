/*
Welcome to JDoodle!

You can execute code here in 88 languages. Right now you’re in the Java IDE.

  1. Click the orange Execute button ▶ to execute the sample code below and see how it works.

  2. Want help writing or debugging code? Type a query into JDroid on the right hand side ---------------->

  3.Try the menu buttons on the left. Save your file, share code with friends and open saved projects.

Want to change languages? Try the search bar up the top.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class ProjectMergeSort {

    public static void mergeSort(ArrayList<String> givenList) {
        if (givenList.size() < 2) {
            return;
        }

        int mid = givenList.size() / 2;

        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            left.add(givenList.get(i));
        }

        for (int i = mid; i < givenList.size(); i++) {
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

    public static void main(String[] args) {
    
        ArrayList<String> words = new ArrayList<>(Arrays.asList(
        "January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December"
        ));

        System.out.println("Before sorting: " + words);
    
    
        for (int i = 0; i < words.size(); i++) {
      
            words.set(i, words.get(i));
        }

        mergeSort(words);
        System.out.println("After sorting: " + words);
    }
}



