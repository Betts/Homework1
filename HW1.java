import java.util.*;
import java.io.*;
import java.lang.Math;



public class HW1{
    public static void main(String[] args) {
        long i = 0;
        long limit = (long) Math.pow(10, 8);
        // test



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
            return true;
        }
    }
}