Jacob Betts
01/28/22

Primes
This program will run from 1 to a desired value, in this case 10^8, and test each value to see whether it 
is a prime number. At the programs end, the total execution time, total number of primes found, and 
the sum of all primes found will be output to the file "primes.txt". Following this, a list of the top 10 
highest numerically valued prime numbers within our given range will also be output to the file. The range is adjusted within the 
program by changing the "limit" variable.  

How we guarantee it will work with multithreading

This program is based on a loop that runs through our desired range of numbers. This is accomplished 
by use of a shared Atomic variable, and the atomic operation "getAndIncrement()". This use of atomic 
variables and operations ensures that the shared variable will never be updated by more than one 
thread at a time. We have formed a sort of queue, where each resource (thread) in our machine must 
wait in line to grab the next number it that it will check. This also ensures that each thread is doing as 
close to an equal amount of work as possible. If a thread quickly moves through its current number, 
then it moves to the back of the que to grab another number and begin work again. Rather than trying 
to guess what the workload is and split it evenly between our threads based on our limit value, we have 
each thread request more of the total workload whenever it is available. 

How to use it

Download either this entire directory, or the file HW1.java on its own. Then, in your command line 
navigate to the location where you have saved this file. 
Enter the following command to compile the program:
javac HW1.java
To run the program after compiling, enter the following command:
java HW1

This program will run for several minutes, approximately 4 minutes in our testing on my machine, and 
output to a newly created file called "primes.txt", which should appear in the same directory as 
HW1.java. This output will be in the following format:

Total Time: (in milliseconds)
Total Number of Primes Found: 
Sum of All Primes Found:
Top 10 Primes: [smallest - largest]


Correct Output can be verified with following information:

According to this ( https://primes.utm.edu/howmany.html ) resource on prime numbers from the University of Tenessee, the total number of prime values between 1 and 10000000 should be 5761455. In our testing, this is the number of primes that we have output. Adjusting the value of limit results in the correct number of prime values being found. This can be verified by running the program on your machine, and comparing the "Total Number of Primes Found" value agains the expected number of primes for the given range. 
 



