package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONExample 
{
    public static void main(String[] args)
    {
        String API_KEY = "aeb810a46ffabcd067cd61c6ac66c5e1";
        String location = "long beach,ca,usa";
        String units = "imperial";
        
        String urlString = "http://api.openweathermap.org/data/2.5/weather?appid=" + API_KEY + "&q=" + location + "&units=" + units;
        try 
        {
            URL urlObj = new URL(urlString);
            HttpURLConnection urlCon = (HttpURLConnection) urlObj.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
            {
                response.append(inputLine);
            }
            in.close();

            String json = response.toString();
            JSONObject obj = new JSONObject(json);
            int temp = (int)(Math.floor(obj.getJSONObject("main").getDouble("temp")));

            int[] array = new int[temp];
            int min = 0;
            int max = temp;
            int randomInt = 0;

            for (int i = 0; i < array.length; i++)
            {
                randomInt = (int)(Math.random() * (max - min + 1) + min);
                array[i] = randomInt;
            }
            System.out.println(temp + " randomly generated integers:");
            printArray(array);

            System.out.println("\n\nMax Heap Array:");
            buildMaxHeap(array);
            printArray(array);
            System.out.println("\n\nHeight: " + (int)(Math.log(array.length) / Math.log(2)));
        } 
        catch (IOException | JSONException e)
        {
            e.printStackTrace();
        }   
    }

    public static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }

    public static void buildMaxHeap(int[] array)
    {
        int heapSize = array.length;
        for (int i = (heapSize / 2) - 1; i >= 0; i--)
        {
            maxHeapify(array, i);
        }
    }

    public static void maxHeapify(int[] array, int currentIndex)
    {
        int parentIndex; // parent
        int leftIndex = (2 * currentIndex) + 1; // 2 * currentIndex yields an even node index for left child
        int rightIndex = (2 * currentIndex + 1) + 1; // 2 * currentIndex + 1 yields an odd node index right child

        if (leftIndex <= array.length - 1 && array[leftIndex] > array[currentIndex])
        {
            parentIndex = leftIndex;
        }
        else
        {
            parentIndex = currentIndex; 
        }
        if (rightIndex <= array.length - 1 && array[rightIndex] > array[parentIndex])
        {
            parentIndex = rightIndex;
        }
        if (parentIndex != currentIndex)
        {
            int temp = array[currentIndex];
            array[currentIndex] = array[parentIndex];
            array[parentIndex] = temp;

            maxHeapify(array, parentIndex);
        }
    }
}
