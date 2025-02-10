import java.util.Scanner;

/**
 Abel Lagonell
 U000001730
 Jan 23, 2025
 <p>
 Sum two numbers and print it out to the console.
 */
public class Lab01 {
    /**
     Main Function
     <p>
     Gets two numbers and returns the sum function's output
     */
    public static void main (String[] args) {
        int a = 0;
        int b = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        a = input.nextInt();
        do {
            System.out.print("Enter second number greater than the first: ");
            b = input.nextInt();
        } while (b < a);


        System.out.println("This is the sum we found: " + sum(a, b));
    }

    /**
     Sum the product of two randoms with two inputs

     @param num   first number
     @param limit second number
     @return num * rand1 + limit * rand2
     */
    static int sum (int num, int limit) {
        int rand1 = 3 + (int) (Math.random() * (8 - 3 + 1));
        int rand2 = 3 + (int) (Math.random() * (8 - 3 + 1));

        return num * rand1 + limit * rand2;

    }
}
