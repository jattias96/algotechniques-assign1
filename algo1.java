public class algo1
{
    public static int linearSearch(int array[], int searchFor)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == searchFor)
            {
                found++;
            }
        }
        return found;
    }
}