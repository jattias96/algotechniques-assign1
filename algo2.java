public class algo2
{
    public static int binarySearch(int[] list, int x)
    {
        return binarySearch(list, 0, list.length-1, x);
    }
    
    public static int binarySearch(int list[], int first, int last, int x)
    {
         int found_index;
        
        if(first > last)
        {
            return 0;
        }
        else
        {
            int mid = (first + last) / 2;
            if(list[mid] == x)
            {
                found_index = mid;
                return found_index;
            }
            else
            {
                if(x < list[mid])
                {
                    found_index = binarySearch(list, first, mid-1, x);
                }
                else
                {
                    found_index = binarySearch(list, mid + 1, last, x);
                }
            }
        }
        return found_index;
    }
    
    public static int searchBinary(int[] list, int searchFor, int foundInd)
    {
        int count = foundInd;
        while(count >= 0 && list[count] == searchFor)
        {
            found++;
            count--;
        }
        count = foundInd + 1;
        while(count < list.length && list[count] == searchFor)
        {
            found++;
            count++;
            if(count >= list.length)
            {
                break;
            }
        }
        return found;
    }
}
    