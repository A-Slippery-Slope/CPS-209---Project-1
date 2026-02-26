public class Display {
    public Display() {
        String input = "";
        
        System.out.println("\nWelcome to the Derivative Practice Tool!");
        System.out.println("Enter 'quit' to stop the program at any time.\n");

        while (!input.toLowerCase().equals("quit")) {
            System.out.println("Enter the type of problem you want to practice (Types: MULTIPLICATION, QUOTIENT, POLYNOMIAL, RANDOM):\n");
            input = System.console().readLine();

            Problem problem = null;

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

            Solution solution = new Solution(problem);

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