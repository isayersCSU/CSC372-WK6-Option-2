import java.util.Comparator;

public class MergeSort {
    public static void mergeSort(Student[] array, int low, int high, Comparator<Student> comparator) {
        if (low < high) {
            int mid = (low + high) / 2;

            // Sort by Student ID first
            mergeSort(array, low, mid, new StudentIdComparator());
            mergeSort(array, mid + 1, high, new StudentIdComparator());

            // Then sort by Student Name (assuming IDs are the same)
            mergeSort(array, low, mid, new StudentNameComparator());
            mergeSort(array, mid + 1, high, new StudentNameComparator());

            // Merge the sorted sub-arrays
            merge(array, low, mid, high, new StudentNameComparator());
        }
    }

    private static void merge(Student[] array, int low, int mid, int high, Comparator<Student> comparator) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[low + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            if (comparator.compare(leftArray[i], rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}