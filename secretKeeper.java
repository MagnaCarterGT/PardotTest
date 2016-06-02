/**
 * Created by Carter on 5/31/2016.
 */
import java.util.List;
import java.util.ArrayList;

public class secretKeeper {

    public int secret(int m){
        /*magic. This is a stub that just takes in an int and returns it.
            Just replace it with your secret code. Make sure it returns an int!*/
        return m;
    }

    public boolean isSecretAdditive(int n){
        List<Integer> primes = primes(n);

        for(int foo = 0; foo< primes.size(); foo++){
            int x = primes.get(foo);
            for (int bar = foo; bar<primes.size(); bar++){
                int y = primes.get(bar);
                int foobar = x+y;
                if(secret(x)+ secret(y) != secret(foobar)) return false;
            }
        }
        return true;
    }

    public List<Integer> primes(int max){
        List<Integer> primes = new ArrayList<Integer>();

        primes.add(2); //2 is the first prime; we're accepting this as a given
        if (max == 2 ) return primes;

        boolean[] generator = new boolean[max+1];
        for(int i = 3; i <= max; i++) generator[i] = true;
        //int loops = 0; //tracker for debugging

        for(int i = 3; i<= max; i+=2){
            if (generator[i]){
                //loops++;
                primes.add(i);
                if (i< Math.sqrt(max)) {
                    for (int j = i * i; j <= max; j += (i * 2)) {
                        //loops++; //for debugging
                        generator[j] = false;
                    }
                }
            }
        } /*this is a modified version of the Sieve of Eratosthenes algorithm for generating primes.
                it's been optimized to skip all even numbers, b/c we know 2 is a prime and the rest have 2 as a factor.
            the result is 70%+ fewer loop iterations*/

        //you can uncomment these if you're curious. uncomment 37, 41, 45, and 55 to track all the loop iterations
        //System.out.println("That was " + loops + " loop iterations");
        //System.out.println("There are " + primes.size() + " primes below " + max);
        return primes;
    }
}