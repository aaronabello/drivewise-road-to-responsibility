package package01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class MainMenu {
    // UI Components
    JFrame frame;
    JPanel titleNamePanel, buttonPanel, customTitleBar;
    JLabel titleNameLabel, backgroundLabel, titleBarLabel, logoLabel;
    JButton startButton, instructionsButton, creditsButton, exitButton;
    JButton closeButton, minimizeButton;

    // Font and Color settings - Updated for FinQuest theme
    Font buttonFont = new Font("Segoe UI", Font.BOLD, 28);
    Font titleFont = new Font("Segoe UI", Font.BOLD, 52);
    Font subtitleFont = new Font("Segoe UI", Font.PLAIN, 18);
    Font titleBarFont = new Font("Segoe UI", Font.BOLD, 14);
    
    // FinQuest Color Palette
    Color finTeal = new Color(25, 55, 85);           // Dark blue-teal for buttons
    Color finGold = new Color(212, 175, 55);         // Gold border
    Color buttonGradientStart = new Color(30, 60, 90, 220);
    Color buttonGradientEnd = new Color(0, 85, 95, 220);

    public MainMenu() {
        createMainMenu();
    }

    private void createMainMenu() {
        frame = new JFrame();
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setUndecorated(true); 

        createCustomTitleBar();

        // BACKGROUND PANEL WITH GRADIENT
        GradientBackgroundPanel backgroundPanel = new GradientBackgroundPanel();
        backgroundPanel.setLayout(null); // Absolute positioning for precise control
        
        // LOGO AND TITLE SECTION
        titleNamePanel = new JPanel();
        titleNamePanel.setOpaque(false);
        titleNamePanel.setLayout(new BoxLayout(titleNamePanel, BoxLayout.Y_AXIS));
        titleNamePanel.setBounds(262, 30, 500, 240);

        // LOGO IMAGE PLACEHOLDER
        // Replace with your actual logo: new ImageIcon("path/to/your/finquest_logo.png")
        logoLabel = new JLabel(createLogoPlaceholder());
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // TITLE LABEL - "FinQuest"
        titleNameLabel = new JLabel("FinQuest");
        titleNameLabel.setFont(titleFont);
        titleNameLabel.setForeground(finTeal);
        titleNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // SUBTITLE LABEL - "Your Money, Your Moves."
        JLabel subtitleLabel = new JLabel("Your Money, Your Moves.");
        subtitleLabel.setFont(subtitleFont);
        subtitleLabel.setForeground(finTeal);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        titleNamePanel.add(logoLabel);
        titleNamePanel.add(Box.createRigidArea(new Dimension(0, 15)));
        titleNamePanel.add(titleNameLabel);
        titleNamePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        titleNamePanel.add(subtitleLabel);
        
        // BUTTON PANEL
        buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(327, 300, 370, 370);
        
        // Create buttons with icons
        startButton = createRoundedButton("Start", "▶", 0);
        instructionsButton = createRoundedButton("Instructions", "?", 90);
        creditsButton = createRoundedButton("Credits", "🏆", 180);
        exitButton = createRoundedButton("Exit", "✕", 270);

        // Add action listeners
        startButton.addActionListener(e -> onStartClicked());
        instructionsButton.addActionListener(e -> onInstructionsClicked());
        creditsButton.addActionListener(e -> onCreditsClicked());
        exitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(startButton);
        buttonPanel.add(instructionsButton);
        buttonPanel.add(creditsButton);
        buttonPanel.add(exitButton);
        
        backgroundPanel.add(titleNamePanel);
        backgroundPanel.add(buttonPanel);
        
        frame.add(customTitleBar, BorderLayout.NORTH);
        frame.add(backgroundPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private JButton createRoundedButton(String text, String icon, int yPosition) {
        RoundedButton button = new RoundedButton(text, icon);
        button.setBounds(0, yPosition, 370, 70);
        return button;
    }
    
    // Custom rounded button class
    class RoundedButton extends JButton {
        private String iconText;
        private boolean isHovered = false;
        
        public RoundedButton(String text, String icon) {
            super(text);
            this.iconText = icon;
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setForeground(Color.WHITE);
            setFont(buttonFont);
            
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    isHovered = true;
                    repaint();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    isHovered = false;
                    repaint();
                }
            });
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            int width = getWidth();
            int height = getHeight();
            int arc = 20;
            
            // Create rounded rectangle shape
            RoundRectangle2D roundedRect = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, arc, arc);
            
            // Fill with gradient
            GradientPaint gradient;
            if (isHovered) {
                gradient = new GradientPaint(0, 0, new Color(40, 80, 110, 230), 
                                            width, height, new Color(10, 105, 115, 230));
            } else {
                gradient = new GradientPaint(0, 0, buttonGradientStart, 
                                            width, height, buttonGradientEnd);
            }
            g2.setPaint(gradient);
            g2.fill(roundedRect);
            
            // Draw gold border
            g2.setColor(finGold);
            g2.setStroke(new BasicStroke(3));
            g2.draw(roundedRect);
            
            // Draw icon on the left
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Segoe UI", Font.BOLD, 32));
            FontMetrics iconMetrics = g2.getFontMetrics();
            int iconWidth = iconMetrics.stringWidth(iconText);
            g2.drawString(iconText, 40, (height + iconMetrics.getAscent() - iconMetrics.getDescent()) / 2);
            
            // Draw text
            g2.setFont(getFont());
            FontMetrics fm = g2.getFontMetrics();
            int textX = (width - fm.stringWidth(getText())) / 2 + 20; // Slight offset to right
            int textY = (height + fm.getAscent() - fm.getDescent()) / 2;
            g2.drawString(getText(), textX, textY);
            
            g2.dispose();
        }
    }
    
    // Gradient background panel
    class GradientBackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Create gradient from blue-teal to green-teal
            GradientPaint gradient = new GradientPaint(
                0, 0, new Color(30, 65, 95),           // Dark blue-teal (left)
                getWidth(), getHeight(), new Color(40, 110, 90)  // Teal-green (right)
            );
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            
            // Add subtle pattern overlay (optional)
            drawPattern(g2d);
        }
        
        private void drawPattern(Graphics2D g2d) {
            g2d.setColor(new Color(255, 255, 255, 15));
            // Draw some circles as decoration
            for (int i = 0; i < 5; i++) {
                int x = (int)(Math.random() * getWidth());
                int y = (int)(Math.random() * getHeight());
                int size = 100 + (int)(Math.random() * 200);
                g2d.drawOval(x, y, size, size);
            }
        }
    }
    
    // Create logo placeholder
    private ImageIcon createLogoPlaceholder() {
        int size = 120;
        java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(
            size, size, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Draw circle with gradient (gold)
        GradientPaint gp = new GradientPaint(0, 0, new Color(255, 215, 100), 
                                              size, size, new Color(212, 175, 55));
        g2.setPaint(gp);
        g2.fillOval(10, 10, size - 20, size - 20);
        
        // Draw brain/finance icon outline
        g2.setColor(finTeal);
        g2.setStroke(new BasicStroke(4));
        // Simple magnifying glass representation
        g2.drawOval(45, 45, 35, 35);
        g2.drawLine(72, 72, 90, 90);
        
        g2.dispose();
        
        // Replace this with: new ImageIcon("path/to/your/finquest_logo.png")
        return new ImageIcon(image);
    }
    
    private void createCustomTitleBar() {
        customTitleBar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(25, 55, 85), 
                                                          getWidth(), 0, new Color(0, 40, 45));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        customTitleBar.setLayout(new BorderLayout());
        customTitleBar.setPreferredSize(new Dimension(1024, 35));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        titlePanel.setOpaque(false);

        titleBarLabel = new JLabel("FINQUEST - Your Money, Your Moves");
        titleBarLabel.setForeground(finGold);
        titleBarLabel.setFont(titleBarFont);
        titlePanel.add(titleBarLabel);

        JPanel buttonPanelBar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 2, 2));
        buttonPanelBar.setOpaque(false);

        minimizeButton = createTitleBarButton("−");
        minimizeButton.addActionListener(e -> frame.setState(JFrame.ICONIFIED));

        closeButton = createTitleBarButton("×");
        closeButton.addActionListener(e -> System.exit(0));
        
        buttonPanelBar.add(minimizeButton);
        buttonPanelBar.add(closeButton);
        
        customTitleBar.add(titlePanel, BorderLayout.WEST);
        customTitleBar.add(buttonPanelBar, BorderLayout.EAST);

        makeTitleBarDraggable();
    }
    
    private JButton createTitleBarButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(30, 28));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBorder(null);
        button.setContentAreaFilled(false);
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(finGold);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(Color.WHITE);
            }
        });
        
        return button;
    }
    
    private void makeTitleBarDraggable() {
        final Point[] mouseDownCompCoords = {null};
        customTitleBar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) { 
                mouseDownCompCoords[0] = e.getPoint(); 
            }
            public void mouseReleased(MouseEvent e) { 
                mouseDownCompCoords[0] = null; 
            }
        });
        customTitleBar.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                frame.setLocation(currCoords.x - mouseDownCompCoords[0].x, 
                                currCoords.y - mouseDownCompCoords[0].y);
            }
        });
    }
    
    // Button action methods
    private void onStartClicked() {
        System.out.println("Start button clicked");
        // Add your start game logic here
    }
    
    private void onInstructionsClicked() {
        System.out.println("Instructions button clicked");
        // Add your instructions display logic here
    }
    
    private void onCreditsClicked() {
        System.out.println("Credits button clicked");
        // Add your credits display logic here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu());
    }
}