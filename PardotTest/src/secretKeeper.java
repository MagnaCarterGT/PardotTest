/**
 * Created by Carter on 5/31/2016.
 */
import java.util.List;
import java.util.ArrayList;

public class secretKeeper {

    public int secret(int n){
        return n;
        /*magic. this is the most basic definition of a function
            that takes in an int and returns an int. Just replace it with your secret code. */
    }

    public boolean isSecretAdditive(int n){
        List<Integer> primes = primes(n);

        boolean additive = true;

        for(int foo = 0; foo< primes.size(); foo++){
            for (int bar = foo+1; bar<primes.size(); bar++){
                int foobar = primes.get(foo) + primes.get(bar);
                if(secret(foo)+ secret(bar) != secret(foobar)) return false;
            }
        }
        return additive;
    }

    public List<Integer> primes(int max){
        List<Integer> primes = new ArrayList<Integer>();

        if (max < 2) return primes;
        if (max == 2 ){
            primes.add(2);
            return primes;
        }

        boolean[] generator = new boolean[max];
        generator[0] = false;
        generator[1] = false;
        for(int i = 2; i <  max; i++) generator[i] = true;

        for(int i = 2; i< Math.sqrt(max); i++){
      /*for(int i = 3; i< Math.sqrt(max); i+=2) is a cheat I resisted using. it would speed things way up.
           it's a given that 2 is the lowest prime and thus every even number is not.*/
            if (generator[i]){
                primes.add(i);
                for (int j = i*i; j<max; j+=i) generator[j] = false;
            }
        } //this is known as the Sieve of Eratosthenes algorithm for generating primes
        return primes;
    }
}