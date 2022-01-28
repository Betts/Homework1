import java.util.*;
import java.util.concurrent.atomic.*;
import java.io.*;
import java.lang.Math;
import java.time.*;



public class HW1{
    static AtomicInteger counter = new AtomicInteger(1);
    
    public static void main(String[] args) {
        int i = 0;
        // Limit is 10^8, and it is the maximum value that our boss has requested
        int limit = 100000000;
        // test
        int[] primes = new int[limit + 1];
    
        long start = System.currentTimeMillis();
        while (i < limit)
        {
            i = counter.getAndIncrement();
            if (isPrime(i))
            {

                System.out.println(i);
            }
        }
        long end = System.currentTimeMillis();




    }

    // Method to check whether the incoming number is a prime or not. 
    // Returns False if num is not a prime, returns True if num is a prime. 
    public static boolean isPrime(int num)
    {
        if (num <= 1)
        {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}