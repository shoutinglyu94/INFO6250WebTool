/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lvsho
 */
import java.util.Vector;

public class Prime {

    public static void main(String[] args) {
        Vector<Long> primes = new Vector<>(100, 10);      
        primes.add(2L);                   // Seed the first prime
        primes.add(3L);                    // and the second
        int count = 2;                     
        long number = 5L;  
        
        outer:
        for (; count < primes.capacity() + 10; number += 2L) {
            // The maximum divisor we need to try is square root of number
            long limit = (long) Math.ceil(Math.sqrt((double) number));
            // Divide by all the primes we have up to limit
            for (int i = 1; i < count && primes.get(i) <= limit; ++i) {
                if (number % primes.get(i) == 0L) {   
                    continue outer;              
                }
            }
            primes.add(count++, number);
            System.out.println("The " + count + "th prime number we found: " + number);
            if (count >= 10000) {
                break;
            }
        }

    }
}
