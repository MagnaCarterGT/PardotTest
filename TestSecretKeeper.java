import java.util.Random;
/**
 * Created by Carter on 6/1/2016.
 */
public class TestSecretKeeper {
    public static void main(String[] args){
        //long start = System.currentTimeMillis(); //for debugging
        secretKeeper sk = new secretKeeper();
        int input = 0;

        System.out.println("We have a secret function.\nDoes secret(x+y) = secret(x)+ secret(y)?\n");

        if (args.length >0){ //user supplied a value
            try{
                input = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException n){ // if user tries to pass in anything other than an int
                System.out.println("Whoa, buddy. Give us an integer.");
                System.exit(0);
            }

            if (input < 2){ //again, 2 is the first prime. anything lower and we've got nothin'.
                System.out.println("Hey, come on, man. Give us at least 2 or we don't have anything to work with.");
                System.exit(0);
            }
            System.out.println("You provided " + input + " as an input. Thanks!");
        }
        else { //if user didn't supply a value in the command line, pick a random number
            Random r = new Random();
            input = r.nextInt(1000)+2; //feel free to make the max as large as you'd like
            System.out.println("Hey, you didn't provide a number! Let's just use " + input + ".");
        }

        if(sk.isSecretAdditive(input)) System.out.println("Yep! This secret is additive!");
        else System.out.println("Nope! This secret is NOT additive!");
        //System.out.println("That took " + (System.currentTimeMillis() - start) + " milliseconds"); //for debugging
    }
}