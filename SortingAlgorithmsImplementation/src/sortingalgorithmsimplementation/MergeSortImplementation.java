
package sortingalgorithmsimplementation;

import java.security.SecureRandom;

public class MergeSortImplementation {
    
    private static void merge(int[] list,int low,int middle,int high)
    {
        int lengthOfLeftSubarray = middle-low+1 ; 
        int lengthOfRightSubarray = high-middle ; 
        
        int[] leftSubarray = new int[lengthOfLeftSubarray] ; 
        int[] rightSubarray = new int[lengthOfRightSubarray] ; 
        
        for(int i = 0 ; i < lengthOfLeftSubarray ; i++)
            leftSubarray[i] = list[i+low] ; 
        
        for(int i = 0 ; i < lengthOfRightSubarray ; i++)
            rightSubarray[i] = list[i+middle+1] ;
        
        int indexOfLeftSubarray = 0 ; 
        int indexOfRightSubarray = 0 ; 
        int indexOfSortedArray = low ; 
        
        while(indexOfLeftSubarray < lengthOfLeftSubarray && 
              indexOfRightSubarray < lengthOfRightSubarray)
        {
            if(leftSubarray[indexOfLeftSubarray] <= rightSubarray[indexOfRightSubarray])
            {
                list[indexOfSortedArray] = leftSubarray[indexOfLeftSubarray] ; 
                indexOfLeftSubarray++ ; 
            }
            else
            {
                list[indexOfSortedArray] = rightSubarray[indexOfRightSubarray] ; 
                indexOfRightSubarray++ ; 
            }
            indexOfSortedArray++ ; 
        }
        
        while(indexOfLeftSubarray < lengthOfLeftSubarray)
        {
            list[indexOfSortedArray] = leftSubarray[indexOfLeftSubarray] ; 
            indexOfSortedArray++ ; 
            indexOfLeftSubarray++ ; 
        }
        
        while(indexOfRightSubarray < lengthOfRightSubarray)
        {
            list[indexOfSortedArray] = rightSubarray[indexOfRightSubarray] ; 
            indexOfSortedArray++ ; 
            indexOfRightSubarray++ ; 
        }
        
        
    }
    
    private static void MergeSort(int[] list,int low,int high)
    {
       if(low < high)
       {
           int middle = (low+high)/2 ; 
           
           MergeSort(list,low,middle) ; 
           MergeSort(list,middle+1,high) ; 
           
           merge(list,low,middle,high) ; 
       }
        
    }
    
    private static void printList(int[] list)
    {
        for(int i = 0 ; i < list.length ; i++)
        {
            if(i == list.length-1)
                System.out.println(list[i]) ; 
            else 
                System.out.print(list[i]+"-") ; 
        }
    }

    public static void main(String[] args) {
        
        SecureRandom secureRandom = new SecureRandom() ; 
        int[] list = new int[20] ; 
        
        //populate list with random numbers
        for(int i = 0 ; i < list.length ; i++)
            list[i] = secureRandom.nextInt(100) ; 
        
        System.out.print("Before sorting: ") ; 
        printList(list) ; 
        
        System.out.print("\n\nAfter sorting: ") ; 
        MergeSort(list,0,list.length-1) ; 
        printList(list) ; 
        
        
    }
    
}
