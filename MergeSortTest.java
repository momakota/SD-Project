import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortTest {
    
    @Test
    public static void test() {
        
        ArrayList<String> input = new ArrayList<>(Arrays.asList("January",
        "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December"));
        
        ArrayList<String> expectedOutput = new ArrayList<>(Arrays.asList("April",
        "August", "December", "February", "January", "July", "June", "March",
        "May", "November", "October", "September"));
        
        MergeSort.mergeSort(input);
        assertEquals(input, expectedOutput);
        
    }
}