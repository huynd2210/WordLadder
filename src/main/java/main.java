import solver.WordJumpSolver;

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String origin, destination;
        System.out.println("Input '-1' to exit or press enter to start ");
        while(!sc.nextLine().equalsIgnoreCase("-1")){
            System.out.println("Input origin");
            origin = sc.nextLine();
            System.out.println("Input destination");
            destination = sc.nextLine();
            System.out.println("Solution: ");
            WordJumpSolver.jumpToWord(origin, destination);
            System.out.println("Press Enter to continue");
        }



    }
}
