public class Display {
    public Display() {
        String input = "";
        
        System.out.println("Welcome to the Derivative Practice Tool!");
        System.out.println("Enter 'quit' to stop the program at any time.\n");

        while (!input.toLowerCase().equals("quit")) {
            System.out.println("Enter the type of problem you want to practice (Types: MULTIPLICATION, QUOTIENT, DEPENDANT, POLYNOMIAL, RANDOM): ");
            input = System.console().readLine();

            Problem problem = null;

            switch (input.toUpperCase()) {
                case "MULTIPLICATION" -> problem = new Problem(Types.MULTIPLICATION);
                case "QUOTIENT" -> problem = new Problem(Types.QUOTIENT);
                case "DEPENDANT" -> problem = new Problem(Types.DEPENDANT);
                case "POLYNOMIAL" -> problem = new Problem(Types.POLYNOMIAL);
                case "RANDOM" -> problem = new Problem();
                case "QUIT" -> {
                    System.out.println("Thank you for using the Derivative Practice Tool!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid input. Please try again.\n");
                    continue;
                }
            }

            System.out.println("\n" + problem.toString() + "\n");

            input = System.console().readLine();
        }
    }
}