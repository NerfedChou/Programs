public class DataTypes {
   public static void main(String[] args) {
        // Primitive Data Types
        int age = 25; // Integer
        double salary = 50000.50; // Double
        char grade = 'A'; // Character
        boolean isEmployed = true; // Boolean
    
        // Non-Primitive Data Types
        String name = "John Doe"; // String
        int[] numbers = {1, 2, 3, 4, 5}; // Array
        String[] fruits = {"Apple", "Banana", "Cherry"}; // Array of Strings
    
        // Displaying the values
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Grade: " + grade);
        System.out.println("Is Employed: " + isEmployed);
        System.out.println("Name: " + name);
        System.out.print("Numbers: ");
        for (int number : numbers) {
             System.out.print(number + " ");
        }
        System.out.println();
        System.out.print("Fruits: ");
        for (String fruit : fruits) {
             System.out.print(fruit + " ");
        }
   }
}
