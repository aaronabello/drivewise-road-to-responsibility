package package01;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import package01.Game.ChoiceHandler;

public class UI 
{
    JFrame frame;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, customTitleBar, backgroundPanel;
    JLabel titleNameLabel, xpLabel, xpNumberLabel, badgeLabel, badgeNameLabel, titleBarLabel;
    JButton instructionButton, startButton, backButton, choice1, choice2, choice3, choice4, closeButton, minimizeButton;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);
    
    Color synthPink = new Color(255, 20, 147);
    Color synthPurple = new Color(138, 43, 226);
    Color synthCyan = new Color(0, 255, 255);
    Color darkBackground = new Color(25, 25, 35);
    Color textColor = Color.WHITE;

    Font titleBarFont = new Font("Segoe UI", Font.BOLD, 14);
    
    Font instructionFont = new Font("Segoe UI", Font.BOLD, 15);
    
    public void createUI(ChoiceHandler cHandler) 
    {
        // WINDOW
    	frame = new JFrame();
    	frame.setSize(800, 600);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLayout(new BorderLayout());
    	frame.setResizable(false);
    	frame.setUndecorated(true);
    	
    	createCustomTitleBar();
    	
    	backgroundPanel = new JPanel() {
    	    @Override
    	    protected void paintComponent(Graphics g) {
    	        super.paintComponent(g);
    	        Graphics2D g2d = (Graphics2D) g;
    	        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    	        
    	        // Create gradient background
    	        GradientPaint gradient = new GradientPaint(
    	            0, 0, darkBackground,
    	            0, getHeight(), new Color(45, 25, 65)
    	        );
    	        g2d.setPaint(gradient);
    	        g2d.fillRect(0, 0, getWidth(), getHeight());
    	        
    	        // Add synthwave grid lines
    	        g2d.setColor(new Color(255, 20, 147, 30));
    	        for (int i = 0; i < getWidth(); i += 50) {
    	            g2d.drawLine(i, 0, i, getHeight());
    	        }
    	        for (int i = 0; i < getHeight(); i += 50) {
    	            g2d.drawLine(0, i, getWidth(), i);
    	        }
    	        
    	        // Add some glowing effect lines
    	        g2d.setColor(new Color(138, 43, 226, 20));
    	        for (int i = 25; i < getWidth(); i += 100) {
    	            g2d.drawLine(i, 0, i, getHeight());
    	        }
    	        for (int i = 25; i < getHeight(); i += 100) {
    	            g2d.drawLine(0, i, getWidth(), i);
    	        }
    	    }
    	};
    	backgroundPanel.setLayout(null);
    	
    	titleNamePanel = new JPanel();
    	titleNamePanel.setBounds(100, 100, 600, 100);
    	titleNamePanel.setOpaque(false);
    	titleNameLabel = new JLabel("DRIVEWISE");
    	titleNameLabel.setForeground(synthCyan);
    	titleNameLabel.setFont(titleFont);
    	
    	titleNameLabel.setBorder(BorderFactory.createCompoundBorder(
    		    BorderFactory.createLineBorder(synthPink, 2),
    		    BorderFactory.createEmptyBorder(10, 10, 10, 10)
    		));
    		titleNamePanel.add(titleNameLabel);
    		
    		startButtonPanel = new JPanel();
    		startButtonPanel.setBounds(300, 220, 200, 250);
    		startButtonPanel.setOpaque(false);
    		
    		instructionButton = new JButton("INSTRUCTION");
    		instructionButton.setBackground(new Color(138, 43, 226, 180));
    		instructionButton.setForeground(Color.WHITE);
    		instructionButton.setFont(normalFont);
    		instructionButton.setFocusPainted(false);
    		instructionButton.setBorder(BorderFactory.createCompoundBorder(
    		    BorderFactory.createLineBorder(synthPink, 3),
    		    BorderFactory.createEmptyBorder(15, 25, 15, 25)
    		));
    		
    		instructionButton.addMouseListener(new MouseAdapter() {
    		    @Override
    		    public void mouseEntered(MouseEvent e) {
    		    	instructionButton.setBackground(synthPink);
    		        instructionButton.setBorder(BorderFactory.createCompoundBorder(
    		            BorderFactory.createLineBorder(Color.WHITE, 3),
    		            BorderFactory.createEmptyBorder(15, 25, 15, 25)
    		        ));
    		    }

    		    @Override
    		    public void mouseExited(MouseEvent e) {
    		    	instructionButton.setBackground(new Color(138, 43, 226, 180));
    		        instructionButton.setBorder(BorderFactory.createCompoundBorder(
    		            BorderFactory.createLineBorder(synthPink, 3),
    		            BorderFactory.createEmptyBorder(15, 25, 15, 25)
    		        ));
    		    }
    		});

    		instructionButton.addActionListener(cHandler);
    		instructionButton.setActionCommand("instruction");
    		startButtonPanel.add(instructionButton);
    		
    		startButton = new JButton("    START    ");
    		startButton.setBackground(new Color(138, 43, 226, 180));
    		startButton.setForeground(Color.WHITE);
    		startButton.setFont(normalFont);
    		startButton.setFocusPainted(false);
    		startButton.setBorder(BorderFactory.createCompoundBorder(
    		    BorderFactory.createLineBorder(synthPink, 3),
    		    BorderFactory.createEmptyBorder(15, 25, 15, 25)
    		));
    		
    		startButton.addMouseListener(new MouseAdapter() {
    		    @Override
    		    public void mouseEntered(MouseEvent e) {
    		        startButton.setBackground(synthPink);
    		        startButton.setBorder(BorderFactory.createCompoundBorder(
    		            BorderFactory.createLineBorder(Color.WHITE, 3),
    		            BorderFactory.createEmptyBorder(15, 25, 15, 25)
    		        ));
    		    }

    		    @Override
    		    public void mouseExited(MouseEvent e) {
    		        startButton.setBackground(new Color(138, 43, 226, 180));
    		        startButton.setBorder(BorderFactory.createCompoundBorder(
    		            BorderFactory.createLineBorder(synthPink, 3),
    		            BorderFactory.createEmptyBorder(15, 25, 15, 25)
    		        ));
    		    }
    		});

    		startButton.addActionListener(cHandler);
    		startButton.setActionCommand("start");
    		startButtonPanel.add(startButton);
    		
    		backButton = new JButton("     BACK     ");
    		backButton.setBackground(new Color(138, 43, 226, 180));
    		backButton.setForeground(Color.WHITE);
    		backButton.setFont(normalFont);
    		backButton.setFocusPainted(false);
    		backButton.setBorder(BorderFactory.createCompoundBorder(
    		    BorderFactory.createLineBorder(synthPink, 3),
    		    BorderFactory.createEmptyBorder(15, 25, 15, 25)
    		));
    		
    		backButton.addMouseListener(new MouseAdapter() {
    		    @Override
    		    public void mouseEntered(MouseEvent e) {
    		    	backButton.setBackground(synthPink);
    		    	backButton.setBorder(BorderFactory.createCompoundBorder(
    		            BorderFactory.createLineBorder(Color.WHITE, 3),
    		            BorderFactory.createEmptyBorder(15, 25, 15, 25)
    		        ));
    		    }

    		    @Override
    		    public void mouseExited(MouseEvent e) {
    		        backButton.setBackground(new Color(138, 43, 226, 180));
    		        backButton.setBorder(BorderFactory.createCompoundBorder(
    		            BorderFactory.createLineBorder(synthPink, 3),
    		            BorderFactory.createEmptyBorder(15, 25, 15, 25)
    		        ));
    		    }
    		});

    		backButton.addActionListener(cHandler);
    		backButton.setActionCommand("back");
    		startButtonPanel.add(backButton);

    		// GAME SCREEN with synthwave styling
    		mainTextPanel = new JPanel();
    		mainTextPanel.setBounds(100, 100, 600, 200);
    		mainTextPanel.setOpaque(false);
    		mainTextPanel.setBorder(BorderFactory.createCompoundBorder(
    		    BorderFactory.createLineBorder(synthCyan, 2),
    		    BorderFactory.createEmptyBorder(5, 5, 5, 5)
    		));

    		mainTextArea = new JTextArea("This is the main text area");
    		mainTextArea.setBounds(100,100,600,200);
    		mainTextArea.setOpaque(false);
    		mainTextArea.setForeground(Color.WHITE);
    		mainTextArea.setFont(instructionFont);
    		mainTextArea.setLineWrap(true);
    		mainTextArea.setWrapStyleWord(true);
    		mainTextArea.setEditable(false);
    		mainTextArea.setCaretColor(Color.WHITE);
    		mainTextPanel.add(mainTextArea);

    		// Choice buttons with synthwave styling
    		choiceButtonPanel = new JPanel();
    		choiceButtonPanel.setBounds(150, 360, 500, 180);
    		choiceButtonPanel.setOpaque(false);
    		choiceButtonPanel.setLayout(new GridLayout(4, 1, 0, 10));

    		// Style all choice buttons
    		choice1 = createStyledChoiceButton("choice1");
    		choice1.addActionListener(cHandler);
            choice1.setActionCommand("c1");
            
    		choice2 = createStyledChoiceButton("choice2");
    		choice2.addActionListener(cHandler);
            choice2.setActionCommand("c2");
            
    		choice3 = createStyledChoiceButton("choice3");
    		choice3.addActionListener(cHandler);
    	    choice3.setActionCommand("c3");
    	        
    		choice4 = createStyledChoiceButton("choice4");
    		choice4.setBackground(synthPink);
    		choice4.addActionListener(cHandler);
    	    choice4.setActionCommand("c4");

    		choiceButtonPanel.add(choice1);
    		choiceButtonPanel.add(choice2);
    		choiceButtonPanel.add(choice3);
    		choiceButtonPanel.add(choice4);

    		// Player panel with synthwave styling
    		playerPanel = new JPanel();
    		playerPanel.setBounds(100, 15, 600, 50);
    		playerPanel.setOpaque(false);
    		playerPanel.setLayout(new GridLayout(1, 4));
    		playerPanel.setBorder(BorderFactory.createCompoundBorder(
    		    BorderFactory.createLineBorder(synthPink, 2),
    		    BorderFactory.createEmptyBorder(8, 8, 8, 8)
    		));

    		xpLabel = new JLabel("XP: ");
    		xpLabel.setFont(normalFont);
    		xpLabel.setForeground(synthCyan);
    		playerPanel.add(xpLabel);

    		xpNumberLabel = new JLabel();
    		xpNumberLabel.setForeground(Color.WHITE);
    		xpNumberLabel.setFont(normalFont);
    		playerPanel.add(xpNumberLabel);

    		badgeLabel = new JLabel("Current Badge: ");
    		badgeLabel.setForeground(synthCyan);
    		badgeLabel.setFont(normalFont);
    		playerPanel.add(badgeLabel);

    		badgeNameLabel = new JLabel();
    		badgeNameLabel.setForeground(Color.WHITE);
    		badgeNameLabel.setFont(normalFont);
    		playerPanel.add(badgeNameLabel);

    		// Add all components to background panel
    		backgroundPanel.add(titleNamePanel);
    		backgroundPanel.add(startButtonPanel);
    		backgroundPanel.add(mainTextPanel);
    		backgroundPanel.add(choiceButtonPanel);
    		backgroundPanel.add(playerPanel);

    		// Add to frame
    		frame.add(customTitleBar, BorderLayout.NORTH);
    		frame.add(backgroundPanel, BorderLayout.CENTER);

    		frame.setLocationRelativeTo(null);
    		frame.setVisible(true);
    }     
    
    private JButton createStyledChoiceButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(138, 43, 226, 120));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(synthCyan, 2),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(synthCyan);
                button.setForeground(Color.BLACK);
                button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.WHITE, 2),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(138, 43, 226, 120));
                button.setForeground(Color.WHITE);
                button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(synthCyan, 2),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
        });
        return button;
    }

    private void createCustomTitleBar() {
        customTitleBar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                GradientPaint gradient = new GradientPaint(
                    0, 0, synthPink,
                    getWidth(), 0, synthPurple
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                
                g2d.setColor(new Color(255, 255, 255, 100));
                g2d.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
            }
        };
        customTitleBar.setLayout(new BorderLayout());
        customTitleBar.setPreferredSize(new Dimension(800, 35));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        titlePanel.setOpaque(false);

        // Add icon if you have one
        titleBarLabel = new JLabel("DRIVEWISE - Game");
        titleBarLabel.setForeground(Color.WHITE);
        titleBarLabel.setFont(titleBarFont);
        titleBarLabel.setVerticalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleBarLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 2, 2));
        buttonPanel.setOpaque(false);

        minimizeButton = createTitleBarButton("−");
        minimizeButton.addActionListener(e -> frame.setState(JFrame.ICONIFIED));

        closeButton = createTitleBarButton("×");
        closeButton.addActionListener(e -> System.exit(0));
        
        buttonPanel.add(minimizeButton);
        buttonPanel.add(closeButton);
        
        customTitleBar.add(titlePanel, BorderLayout.WEST);
        customTitleBar.add(buttonPanel, BorderLayout.EAST);

        makeTitleBarDraggable();
    }

    private JButton createTitleBarButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(30, 28));
        button.setBackground(new Color(255, 255, 255, 50));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBorder(null);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (text.equals("×")) {
                    button.setBackground(new Color(255, 0, 0, 150));
                } else {
                    button.setBackground(new Color(255, 255, 255, 100));
                }
                button.setContentAreaFilled(true);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setContentAreaFilled(false);
            }
        });
        
        return button;
    }

    private void makeTitleBarDraggable() {
        final Point[] mouseDownCompCoords = {null};
        
        customTitleBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords[0] = e.getPoint();
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords[0] = null;
            }
        });
        
        customTitleBar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                if (mouseDownCompCoords[0] != null) {
                    frame.setLocation(
                        currCoords.x - mouseDownCompCoords[0].x,
                        currCoords.y - mouseDownCompCoords[0].y
                    );
                }
            }
        });
    }
}