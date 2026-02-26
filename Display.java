public class Display {
    // Creates a display for the derivative practice tool, 
    // which allows the user to select a type of problem to practice and 
    // enter their answer until they get it correct or choose to see the solution.
    public Display() {
        String input = "";
        
        System.out.println("\nWelcome to the Derivative Practice Tool!");
        System.out.println("Enter 'quit' to stop the program at any time.\n");

        // Sentinel loop to keep the program running until the user chooses to quit.
        while (!input.toLowerCase().equals("quit")) {
            System.out.println("Enter the type of problem you want to practice (Types: MULTIPLICATION, QUOTIENT, POLYNOMIAL, RANDOM):\n");
            input = System.console().readLine();

            Problem problem = null;

            // Creates a problem based on the user's input, or shows an error message if the input is invalid.
            switch (input.toUpperCase()) {
                case "MULTIPLICATION" -> problem = new Problem(Types.MULTIPLICATION);
                case "QUOTIENT" -> problem = new Problem(Types.QUOTIENT);
                case "POLYNOMIAL" -> problem = new Problem(Types.POLYNOMIAL);
                case "RANDOM" -> problem = new Problem();
                case "QUIT" -> {
                    System.out.println("\nThank you for using the Derivative Practice Tool!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("\nInvalid input. Please try again.\n");
                    continue;
                }
            }

            Solution solution = new Solution(problem); // Creates the solution for the problem.

            // Loop to allow the user to keep trying to answer the problem until they get it correct or choose to see the solution.
            while (!input.toLowerCase().equals("quit") && !input.toLowerCase().equals("solution")) {
                System.out.println("\n" + problem.toString() + " Make sure to simplify your answer (Enter SOLUTION to see the solution).\n");

                input = System.console().readLine();

                switch (input.toUpperCase()) {
                    case "SOLUTION" -> {
                        System.out.println("\n" + solution + "\n");
                        input = "solution";
                    }
                    case "QUIT" -> {
                        System.out.println("\nThank you for using the Derivative Practice Tool!");
                        System.exit(0);
                    }
                    default -> {
                        if (solution.isCorrect(input)) {
                            System.out.println("\nCorrect! Great job.\n");
                            input = "solution";
                        } 
                        else System.out.println("\nIncorrect. Please try again.\n");
                    }
                    
                }
            }
        }
    }
}