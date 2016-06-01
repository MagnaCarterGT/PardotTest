/**
 * Created by Carter on 5/31/2016.
 */
import java.util.List;
import java.util.ArrayList;

public class secretKeeper {
    public secretKeeper(){}

    public int secret(int n){
        /*magic. this is the most basic definition of a function that takes in an int and returns an int.
            Just replace it with your secret code. Make sure it returns an int!*/
        return n;
    }

    public boolean isSecretAdditive(int n){
        List<Integer> primes = primes(n);

        boolean additive = true;

        for(int foo = 0; foo< primes.size()-1; foo++){
            int x = primes.get(foo);
            for (int bar = foo+1; bar<primes.size(); bar++){
                int y = primes.get(bar);
                int foobar = x+y;
                if(secret(x)+ secret(y) != secret(foobar)) return false;
            }
        }
        return additive;
    }

    public List<Integer> primes(int max){
        List<Integer> primes = new ArrayList<Integer>();

        if (max < 2) return primes; //0 and 1 are not primes
        primes.add(2); //2 is the first prime; we're accepting this as a given
        if (max == 2 ){
            return primes;
        }

        boolean[] generator = new boolean[max+1];
        for(int i = 3; i < max; i++) generator[i] = true;
        //int loops = 0; //tracker for debugging

        for(int i = 3; i<= max; i+=2){
            if (generator[i]){
                primes.add(i);
                for (int j = i*i; j<=max; j+=(i*2)) {
                    //loops++; //for debugging
                    generator[j] = false;}
            }
        } /*this is a modified version of the Sieve of Eratosthenes algorithm for generating primes.
                it's been optimized to skip all even numbers, b/c we know 2 is a prime and the rest have 2 as a factor.
            the result is 70%+ fewer loops*/

        //you can uncomment these if you're curious. remember to uncomment line 43 if you uncomment line 57
        //System.out.println("That was " + loops + " loops");
        //System.out.println("There are " + primes.size() + " primes below " + max);
        return primes;
    }
}