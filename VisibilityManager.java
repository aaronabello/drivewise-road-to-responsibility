package package01;

// Manages the visibility of different UI panels in the application
public class VisibilityManager 
{
	UI ui;

	// Constructor that receives the UI object to control its components
	public VisibilityManager(UI userInterface) 
	{
		ui = userInterface;
	}
	
	// Shows the title screen panels and hides the main game interface
	public void showTitleScreen() 
	{
		ui.titleNamePanel.setVisible(true);      // Show title
		ui.startButtonPanel.setVisible(true);    // Show start button panel
		
		ui.mainTextPanel.setVisible(false);      // Hide main text area
		ui.choiceButtonPanel.setVisible(false);  // Hide choice buttons
		ui.playerPanel.setVisible(false);        // Hide player info panel
	}
	
	// Transitions from title screen to main menu/game interface
	public void titleToMenu() 
	{
		ui.titleNamePanel.setVisible(false);     // Hide title
		ui.startButtonPanel.setVisible(false);   // Hide start button panel
		
		ui.mainTextPanel.setVisible(true);       // Show main text area
		ui.choiceButtonPanel.setVisible(true);   // Show choice buttons
		ui.playerPanel.setVisible(true);         // Show player info panel
	}
	
	// Shows the instruction screen: main text and choices, but no player info
	public void instruction() 
	{
		ui.titleNamePanel.setVisible(false);     // Hide title
		ui.startButtonPanel.setVisible(false);   // Hide start button panel
		
		ui.mainTextPanel.setVisible(true);       // Show instructions in main text
		ui.choiceButtonPanel.setVisible(true);   // Show navigation/next choices
		ui.playerPanel.setVisible(false);        // Hide player info
	}
}
