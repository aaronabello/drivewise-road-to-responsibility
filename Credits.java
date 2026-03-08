package package01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Credits {
    // Main components
    JFrame frame;
    JPanel titleNamePanel, creditsContentPanel, backButtonPanel, customTitleBar, backgroundPanel;
    JLabel titleNameLabel, titleBarLabel;
    JLabel developedByLabel, developerNameLabel, teamNameLabel;
    JLabel specialThanksLabel, thanks1Label, thanks2Label;
    JButton backButton, closeButton, minimizeButton;

    // Font styles used in the UI
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font headingFont = new Font("Times New Roman", Font.PLAIN, 32);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    Font smallFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font titleBarFont = new Font("Segoe UI", Font.BOLD, 14);

    // Synthwave-inspired colors
    Color synthPink = new Color(255, 20, 147);
    Color synthPurple = new Color(138, 43, 226);
    Color synthCyan = new Color(0, 255, 255);
    Color synthYellow = new Color(255, 255, 0);
    Color synthGreen = new Color(0, 255, 127);
    Color synthOrange = new Color(255, 165, 0);
    Color darkBackground = new Color(25, 25, 35);

    public Credits() {
        // Frame setup
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setUndecorated(true); // Use custom title bar

        createCustomTitleBar(); // Builds the custom top bar

        // Background panel with gradient and gridlines
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

                // Gradient fill
                GradientPaint gradient = new GradientPaint(
                    0, 0, darkBackground,
                    0, getHeight(), new Color(40, 20, 60)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Vertical and horizontal synthwave grid lines
                g2d.setColor(new Color(255, 20, 147, 30));
                for (int i = 0; i < getWidth(); i += 50) g2d.drawLine(i, 0, i, getHeight());
                for (int i = 0; i < getHeight(); i += 50) g2d.drawLine(0, i, getWidth(), i);

                // Additional glowing effect grid lines
                g2d.setColor(new Color(138, 43, 226, 20));
                for (int i = 25; i < getWidth(); i += 100) g2d.drawLine(i, 0, i, getHeight());
                for (int i = 25; i < getHeight(); i += 100) g2d.drawLine(0, i, getWidth(), i);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        // Title panel at the top of the credits screen
        titleNamePanel = new JPanel();
        titleNamePanel.setOpaque(false);
        titleNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
        titleNameLabel = new JLabel("DRIVEWISE");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        // Main content panel with credits text
        creditsContentPanel = new JPanel();
        creditsContentPanel.setOpaque(false);
        creditsContentPanel.setLayout(new BoxLayout(creditsContentPanel, BoxLayout.Y_AXIS));
        creditsContentPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Adding credit sections and individual labels
        developedByLabel = new JLabel("DEVELOPED BY");
        developerNameLabel = new JLabel("Aaron Joshua D. Abello");
        teamNameLabel = new JLabel("BSCpE II - GF");

        specialThanksLabel = new JLabel("Special Thanks To:");
        thanks1Label = new JLabel("Engr. Madonna D. Castro");
        thanks2Label = new JLabel("Course Instructor");

        // Styling and alignment for each label
        JLabel[] labels = {
            developedByLabel, developerNameLabel, teamNameLabel,
            specialThanksLabel, thanks1Label, thanks2Label
        };
        Font[] fonts = {
            headingFont, normalFont, smallFont,
            smallFont, new Font("Times New Roman", Font.PLAIN, 18),
            new Font("Times New Roman", Font.PLAIN, 18)
        };

        for (int i = 0; i < labels.length; i++) {
            labels[i].setForeground(Color.WHITE);
            labels[i].setFont(fonts[i]);
            labels[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            creditsContentPanel.add(labels[i]);
            creditsContentPanel.add(Box.createRigidArea(new Dimension(0, i == labels.length - 1 ? 0 : 15)));
        }

        // Scroll pane for overflowing credits
        JScrollPane scrollPane = new JScrollPane(creditsContentPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Back button section
        backButtonPanel = new JPanel();
        backButtonPanel.setOpaque(false);
        backButtonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));

        // Back button with hover effect
        backButton = new JButton("BACK");
        backButton.setBackground(new Color(138, 43, 226, 180));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(normalFont);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(300, 60));
        backButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(synthPink, 3),
            BorderFactory.createEmptyBorder(15, 25, 15, 25)
        ));

        // Back button hover effects
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

        // Action to return to main menu
        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu(); // Navigates back to main menu
        });

        backButtonPanel.add(backButton);

        // Adding all sections to the background panel
        backgroundPanel.add(titleNamePanel, BorderLayout.NORTH);
        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        backgroundPanel.add(backButtonPanel, BorderLayout.SOUTH);

        // Frame layout assembly
        frame.add(customTitleBar, BorderLayout.NORTH);
        frame.add(backgroundPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }

    // Builds the custom synthwave-styled title bar
    private void createCustomTitleBar() {
        customTitleBar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

                GradientPaint gradient = new GradientPaint(0, 0, synthPink, getWidth(), 0, synthPurple);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                g2d.setColor(new Color(255, 255, 255, 100));
                g2d.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
            }
        };
        customTitleBar.setLayout(new BorderLayout());
        customTitleBar.setPreferredSize(new Dimension(800, 35));

        // App icon and title label
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        titlePanel.setOpaque(false);

        ImageIcon titleIcon = new ImageIcon("C:\\Users\\Aaron Joshua Abello\\Downloads\\iconpic.png");
        Image scaledTitleIcon = titleIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledTitleIcon));
        titlePanel.add(logoLabel);

        titleBarLabel = new JLabel("DRIVEWISE - Credits");
        titleBarLabel.setForeground(Color.WHITE);
        titleBarLabel.setFont(titleBarFont);
        titleBarLabel.setVerticalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleBarLabel);

        // Minimize and close buttons
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

        makeTitleBarDraggable(); // Makes title bar movable
    }

    // Creates styled buttons for the title bar (close and minimize)
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

    // Allows dragging the undecorated window using the title bar
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
