import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.stream.Collectors;
import java.io.*;
import java.lang.Math;
import java.time.*;



public class HW1{
    static AtomicInteger counter = new AtomicInteger(1);
    
    public static void main(String[] args) throws IOException {
        int i = 0;
        // Limit is 10^8, and it is the maximum value that our boss has requested
        int limit = 100000000;

        List<Integer> lst = new ArrayList<>();
    
        long sum = 0;
        int totalPrimes = 0;
    
        long start = System.currentTimeMillis();

        while (i < limit)
        {
            i = counter.getAndIncrement();
            if (isPrime(i))
            {
                lst.add(i);
                sum = sum + i;
                totalPrimes = totalPrimes + 1;
            }
        }
        long end = System.currentTimeMillis();
        List<Integer> lst1 = lst.stream().sorted(Comparator.reverseOrder()).limit(10).collect(Collectors.toList()); 
        Collections.reverse(lst1);
        long totalTime = end - start;
        
        File file = new File("primes.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);
        System.out.println("Total Time: " + totalTime +" ms.");
        System.out.println("Total Primes Found: " + totalPrimes);
        System.out.println("Sum of Primes: " + sum);
        System.out.println("Top 10 primes: " + lst1);
    }

    // Method to check whether the incoming number is a prime or not. 
    // Returns False if num is not a prime, returns True if num is a prime. 
    public static boolean isPrime(int num)
    {
        if (num <= 1)
        {
            return false;
        }

        int sqNum = (int) Math.sqrt(num);

        for (int i = 2; i <= sqNum; i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}