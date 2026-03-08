package package01;

// Main class containing the entry point of the program
public class mainClass {

    public static void main(String[] args) 
    {
        // Create an instance of mainClass to access the inner class ChoiceHandler
        mainClass main = new mainClass();
        
        // Create the start screen GUI
        startScreen screen = new startScreen();
        
        // Create an instance of ChoiceHandler, passing the screen to it
        ChoiceHandler handler = main.new ChoiceHandler(screen);
        
        // Attach the handler to the screen so it can respond to user actions
        screen.setChoiceHandler(handler);  // Pass handler to button
    }

    // Inner class to handle user choices or button clicks
    public class ChoiceHandler implements java.awt.event.ActionListener 
    {
        private startScreen screen;

        // Constructor that initializes the handler with the start screen
        public ChoiceHandler(startScreen screen) 
        {
            this.screen = screen;
        }

        // Method that handles actions performed (e.g., button clicks)
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            // Get the action command (i.e., which button was clicked)
            String yourChoice = e.getActionCommand();

            // Switch case to handle specific button actions
            switch (yourChoice) {
                case "start":
                    // If "start" is clicked, close the start screen
                    screen.getFrame().dispose();  
                    
                    // Open the main menu of the application
                    new MainMenu();             
                    break;
            }
        }
    }
}
