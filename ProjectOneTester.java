public class ProjectOneTester {
    /*
            A general problem people have is remembering the different types of problems in different mathematical situations, such as calculus, vectors, and statistics.
        In this project, the goal is to help students in these situations by providing differentiation math problems and detailed solutions after giving them a chance to answer. 
        The project will include a Problem class that provides randomized, relevant problems for each category. 
        There will also be an enum called Types that defines the different types of expressions, which will allow for a specific type of problem to be selected too. 
        There will also be a Solution class that takes a problem and provides the correct solution with details (like steps and explanations). 
        A Display class will be needed to provide the interface for the student to input (into the terminal) what categories they want to learn and provide solutions for. 
        This will be done through a sentinel while loop in the constructor, allowing for the student to keep going as long as they want. 
        There must finally be a caller class that calls the Display class for the program to run.

            There are also technical classes that allow for problems of different types to be created. 
        This includes a general Function class that allows for simple actions between functions if there is no designated action in the subclasses. 
        The Polynomial class is a kind of Function and allows for many different actions like addition and multiplication. 
        The Expression class can create a polynomial or rational expression based on the given type and allows for edits to its constituent polynomial functions. 
        The equation class consolidates two expressions into one with an equal sign between, making it easier to display. 
        Finally, the Rule interface is a skeleton for all the different derivative rules, like the PowerRule, ProductRule, and QuotientRule, 
        which can only apply to an expression of its designated type.
    */
    public static void main(String[] args) {
        new Display();
    }
}
