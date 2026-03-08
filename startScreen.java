package package01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * startScreen creates the first screen of the Drivewise application.
 * It includes a custom title bar, a background, a stylized "START" button, and UI setup.
 */
public class startScreen {
    
    // Core GUI components
    JFrame frame;
    JPanel titleNamePanel, startButtonPanel, customTitleBar;
    JLabel titleNameLabel, backgroundLabel, titleBarLabel;
    JButton startButton, closeButton, minimizeButton;

    // Fonts and colors used for visual theme
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    Font titleBarFont = new Font("Segoe UI", Font.BOLD, 14);

    Color synthPink = new Color(255, 20, 147);
    Color synthPurple = new Color(138, 43, 226);
    Color darkBackground = new Color(25, 25, 35);

    // Constructor - initializes and sets up the GUI screen
    public startScreen() {
        // Set up the main frame
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setUndecorated(true); // Custom title bar disables default decorations

        createCustomTitleBar(); // Build the custom title bar

        // Set animated GIF background
        backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\Aaron Joshua Abello\\Downloads\\backgroundpic.gif"));
        backgroundLabel.setLayout(new BorderLayout());

        // Title panel with game name
        titleNamePanel = new JPanel();
        titleNamePanel.setOpaque(false);
        titleNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));

        titleNameLabel = new JLabel("DRIVEWISE");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        // Start button panel and button configuration
        startButtonPanel = new JPanel();
        startButtonPanel.setOpaque(false);
        startButtonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 80, 0)); // Padding

        startButton = new JButton("START");
        startButton.setBackground(new Color(138, 43, 226, 180)); // Semi-transparent purple
        startButton.setForeground(Color.WHITE);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.setPreferredSize(new Dimension(250, 60));
        startButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(synthPink, 3), // Pink border
            BorderFactory.createEmptyBorder(15, 25, 15, 25)
        ));

        // Hover effect for start button
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

        startButtonPanel.add(startButton);

        // Add panels to background
        backgroundLabel.add(titleNamePanel, BorderLayout.CENTER);
        backgroundLabel.add(startButtonPanel, BorderLayout.SOUTH);

        // Add components to frame
        frame.add(customTitleBar, BorderLayout.NORTH);
        frame.add(backgroundLabel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);            // Show window
    }

    // Custom title bar with minimize and close buttons
    private void createCustomTitleBar() {
        customTitleBar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

                // Gradient background for title bar
                GradientPaint gradient = new GradientPaint(0, 0, synthPink, getWidth(), 0, synthPurple);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // White border line below title bar
                g2d.setColor(new Color(255, 255, 255, 100));
                g2d.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
            }
        };
        customTitleBar.setLayout(new BorderLayout());
        customTitleBar.setPreferredSize(new Dimension(800, 35));

        // App icon and label
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        titlePanel.setOpaque(false);

        ImageIcon titleIcon = new ImageIcon("C:\\Users\\Aaron Joshua Abello\\Downloads\\iconpic.png");
        Image scaledTitleIcon = titleIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledTitleIcon));
        titlePanel.add(logoLabel);

        titleBarLabel = new JLabel("DRIVEWISE");
        titleBarLabel.setForeground(Color.WHITE);
        titleBarLabel.setFont(titleBarFont);
        titlePanel.add(titleBarLabel);

        // Minimize and Close buttons
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

        makeTitleBarDraggable(); // Make custom title bar draggable
    }

    // Creates a stylized button used in the custom title bar
    private JButton createTitleBarButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(30, 28));
        button.setBackground(new Color(255, 255, 255, 50));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBorder(null);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        // Hover effect for title bar buttons
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (text.equals("×")) {
                    button.setBackground(new Color(255, 0, 0, 150)); // Red for close
                } else {
                    button.setBackground(new Color(255, 255, 255, 100)); // Light for minimize
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

    // Enables dragging the undecorated frame using the custom title bar
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

    // Exposes method to set external action handlers (like main menu navigation)
    public void setChoiceHandler(ActionListener handler) {
        startButton.setActionCommand("start");
        startButton.addActionListener(handler);
    }

    // Allows external access to the main window
    public Window getFrame() {
        return frame;
    }
}
