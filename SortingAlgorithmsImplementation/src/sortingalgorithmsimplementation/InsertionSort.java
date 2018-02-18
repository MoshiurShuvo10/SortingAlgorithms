
package sortingalgorithmsimplementation;

import java.security.SecureRandom;

public class InsertionSortImplementation {
    
    private static void InsertionSort(int[] list,int low,int high)
    {
        int index,previous_index,key,temp ; 
        
        // always start comparing from list[1] 
        for(index = 1 ; index < list.length ; index++)
        {
            key = list[index] ;
            previous_index = index-1 ; 
            
            while(previous_index >= 0 && key < list[previous_index])
            {
                temp = list[previous_index] ; 
                list[previous_index] = list[previous_index+1] ; 
                list[previous_index+1] = temp ; 
                
                previous_index-- ; 
            }
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
    
    public static void main(String[] args)
    {
          SecureRandom secureRandom = new SecureRandom() ; 
        int[] list = new int[20] ; 
        
        //populate list with random numbers
        for(int i = 0 ; i < list.length ; i++)
            list[i] = secureRandom.nextInt(100) ; 
        
        System.out.print("Before sorting: ") ; 
        printList(list) ; 
        
        
        System.out.print("\n\nAfter sorting: ") ; 
        InsertionSort(list,0,list.length-1) ; 
        printList(list) ; 
    }
    
}
