import java.util.Random;

/**
 * Created by ctemplet on 6/1/2016.
 */
public class TestSecretKeeper {
    public static void main(String[] args){
        //long start = System.currentTimeMillis(); //for debugging
        secretKeeper sk = new secretKeeper();
        Random r = new Random();
        int testRandom;
        boolean additive;

        System.out.println("We have a secret function.\nDoes secret(x+y) = secret(x)+ secret(y)?");

        if (args.length >0){
            testRandom = Integer.parseInt(args[0]);
            System.out.println("You provided " + testRandom + " as an input. Thanks!");
            additive = sk.isSecretAdditive(Integer.parseInt(args[0]));
        }
        else { //if a number wasn't provided in the command line, pick a random number
            testRandom = r.nextInt(1000)+2; //feel free to make the max as large as you'd like
            System.out.println("Hey, you didn't provide a number! Let's just use " + testRandom + ".");
            additive = sk.isSecretAdditive(testRandom);
        }
        if(additive) System.out.println("Yep! This secret is additive!");
        else System.out.println("Nope! This secret is NOT additive!");
        //System.out.println("That took " + (System.currentTimeMillis() - start) + " milliseconds"); //for debugging
    }
}