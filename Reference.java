package package01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reference {
    // Main components
    JFrame frame;
    JPanel customTitleBar, contentPanel, bottomPanel, backgroundPanel;
    JLabel titleBarLabel, backgroundLabel;
    JTextArea referenceText;
    JScrollPane scrollPane;
    JButton backButton, closeButton, minimizeButton;

    // Fonts
    Font titleBarFont = new Font("Segoe UI", Font.BOLD, 14);
    Font contentFont = new Font("Times New Roman", Font.PLAIN, 16);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 26);

    // Synthwave color palette
    Color synthPink = new Color(255, 20, 147);
    Color synthPurple = new Color(138, 43, 226);
    Color synthCyan = new Color(0, 255, 255);
    Color darkBackground = new Color(25, 25, 35);
    Color textColor = Color.WHITE;

    public Reference() {
        createReference(); // Initialize UI
    }

    private void createReference() {
        // Set up the main frame window
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setUndecorated(true); // Removes default title bar

        createCustomTitleBar(); // Add custom top bar

        // Custom background panel with grid and gradient (synthwave look)
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

                // Gradient background
                GradientPaint gradient = new GradientPaint(
                    0, 0, darkBackground,
                    0, getHeight(), new Color(45, 25, 65)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Light grid lines
                g2d.setColor(new Color(255, 20, 147, 30));
                for (int i = 0; i < getWidth(); i += 50)
                    g2d.drawLine(i, 0, i, getHeight());
                for (int i = 0; i < getHeight(); i += 50)
                    g2d.drawLine(0, i, getWidth(), i);

                // Extra glowing grid overlay
                g2d.setColor(new Color(138, 43, 226, 20));
                for (int i = 25; i < getWidth(); i += 100)
                    g2d.drawLine(i, 0, i, getHeight());
                for (int i = 25; i < getHeight(); i += 100)
                    g2d.drawLine(0, i, getWidth(), i);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        // Main content panel
        contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 20, 40));

        // Title label for the content
        JLabel titleLabel = new JLabel("📚 REFERENCES", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
        titleLabel.setForeground(textColor);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // Reference text area configuration
        referenceText = new JTextArea();
        referenceText.setFont(contentFont);
        referenceText.setEditable(false);
        referenceText.setLineWrap(true);
        referenceText.setWrapStyleWord(true);
        referenceText.setOpaque(false);
        referenceText.setForeground(textColor);
        referenceText.setCaretColor(textColor);

        // Populate the reference text
        referenceText.setText(
            "FOR THE GAME:\n\n" +
            "• Department of Transportation. (2017)...\n\n" +
            "• Department of Transportation (DOTr)...\n\n" +
            "FOR THE CALCULATOR:\n\n" +
            "• Federal Highway Administration. (2019)...\n\n" +
            "• Federal Highway Administration. (n.d.-a)...\n\n" +
            "• Federal Highway Administration. (n.d.-b)...\n\n"
        );

        // Scroll pane for reference text
        scrollPane = new JScrollPane(referenceText);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(synthCyan, 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        scrollPane.setBackground(new Color(0, 0, 0, 100));

        // Custom scrollbar appearance
        scrollPane.getVerticalScrollBar().setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = synthPink;
                this.trackColor = new Color(255, 255, 255, 50);
            }
        });

        contentPanel.add(titleLabel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom panel for the BACK button
        bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 40, 0));

        backButton = new JButton("BACK");
        backButton.setFont(buttonFont);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(138, 43, 226, 180));
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(300, 60));
        backButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(synthPink, 3),
            BorderFactory.createEmptyBorder(15, 25, 15, 25)
        ));

        // Hover effect for BACK button
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

        // BACK button returns to main menu
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu();
            }
        });

        bottomPanel.add(backButton);

        // Add content and bottom panel to background
        backgroundPanel.add(contentPanel, BorderLayout.CENTER);
        backgroundPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add all parts to the frame
        frame.add(customTitleBar, BorderLayout.NORTH);
        frame.add(backgroundPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null); // Center window
        frame.setVisible(true); // Show frame
    }

    private void createCustomTitleBar() {
        // Panel for custom title bar with gradient background
        customTitleBar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

                // Gradient from synthPink to synthPurple
                GradientPaint gradient = new GradientPaint(
                    0, 0, synthPink,
                    getWidth(), 0, synthPurple
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Thin white bottom border
                g2d.setColor(new Color(255, 255, 255, 100));
                g2d.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
            }
        };
        customTitleBar.setLayout(new BorderLayout());
        customTitleBar.setPreferredSize(new Dimension(800, 35));

        // Title area with logo and text
        JPanel titlePanelBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        titlePanelBar.setOpaque(false);

        ImageIcon titleIcon = new ImageIcon("C:\\Users\\Aaron Joshua Abello\\Downloads\\iconpic.png");
        Image scaledTitleIcon = titleIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledTitleIcon));
        titlePanelBar.add(logoLabel);

        titleBarLabel = new JLabel("DRIVEWISE - References");
        titleBarLabel.setForeground(Color.WHITE);
        titleBarLabel.setFont(titleBarFont);
        titleBarLabel.setVerticalAlignment(SwingConstants.CENTER);
        titlePanelBar.add(titleBarLabel);

        // Minimize and close buttons
        JPanel buttonPanelBar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 2, 2));
        buttonPanelBar.setOpaque(false);

        minimizeButton = createTitleBarButton("−");
        minimizeButton.addActionListener(e -> frame.setState(JFrame.ICONIFIED));

        closeButton = createTitleBarButton("×");
        closeButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });

        buttonPanelBar.add(minimizeButton);
        buttonPanelBar.add(closeButton);

        customTitleBar.add(titlePanelBar, BorderLayout.WEST);
        customTitleBar.add(buttonPanelBar, BorderLayout.EAST);

        makeTitleBarDraggable(); // Allow dragging window by the title bar
    }

    private JButton createTitleBarButton(String text) {
        // Create custom buttons for title bar
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(30, 28));
        button.setBackground(new Color(255, 255, 255, 50));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBorder(null);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        // Hover effects for minimize/close
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
        // Allow window dragging by title bar
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

    public Window getFrame() {
        return frame;
    }
}
