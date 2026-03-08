package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game 
{
    // Handler for user choices/button clicks
    ChoiceHandler cHandler = new ChoiceHandler();
    
    // UI manager to handle graphical interface
    UI ui = new UI();
    
    // Manages which screens/panels are visible
    VisibilityManager vm = new VisibilityManager(ui);
    
    // Handles the game's story progression and content
    Story story = new Story(this, ui, vm);
    
    // Variables to store the next options in the story branches
    String nextOption1, nextOption2, nextOption3, nextOption4;
    
    // Main constructor - initializes the game
    public Game()
    {
        // Create the user interface with the choice handler
        ui.createUI(cHandler);
        
        // Set up default game state/story
        story.defaultSetup();
        
        // Show the title screen first
        vm.showTitleScreen();
    }
    
    // Inner class to handle user actions/button clicks
    public class ChoiceHandler implements ActionListener
    {
        // Called whenever a button is clicked
        public void actionPerformed(ActionEvent e) 
        {
            // Get which button was clicked
            String yourChoice = e.getActionCommand();
            
            // Handle different button clicks
            switch(yourChoice) 
            {
                // Start button on title screen
                case "start":
                    // Transition from title to main menu
                    vm.titleToMenu();
                    // Load the menu story content
                    story.Menu();
                    break;
                    
                // Instruction button
                case "instruction":
                    // Show instruction screen
                    vm.instruction();
                    // Load instruction content
                    story.instruction();
                    break;
                    
                // Back button (returns to main menu)
                case "back":
                    // Close current game window
                    ui.frame.dispose();
                    // Open new main menu
                    new MainMenu();
                    break;
                    
                // Choice button 1
                case "c1": 
                    // Progress story based on this choice
                    story.selectPosition(nextOption1);
                    break;
                    
                // Choice button 2
                case "c2": 
                    story.selectPosition(nextOption2);
                    break;
                    
                // Choice button 3
                case "c3":
                    story.selectPosition(nextOption3);
                    break;
                    
                // Choice button 4
                case "c4": 
                    story.selectPosition(nextOption4);
                    break;
            }
        }
    }
}