package package01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SafeSpeedCalculator {

    private JFrame frame;
    private JTextField speedField;
    private JComboBox<String> weatherBox, roadBox, visibilityBox;
    private JLabel resultLabel;
    private JPanel customTitleBar, backgroundPanel;
    private JLabel titleBarLabel;
    private JButton closeButton, minimizeButton;

    // Fonts matching Credits style
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 36);
    Font headingFont = new Font("Times New Roman", Font.PLAIN, 18);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 16);
    Font titleBarFont = new Font("Segoe UI", Font.BOLD, 14);

    // Synthwave colors matching Credits
    Color synthPink = new Color(255, 20, 147);
    Color synthPurple = new Color(138, 43, 226);
    Color synthCyan = new Color(0, 255, 255);
    Color synthYellow = new Color(255, 255, 0);
    Color synthGreen = new Color(0, 255, 127);
    Color synthOrange = new Color(255, 165, 0);
    Color darkBackground = new Color(25, 25, 35);

    public SafeSpeedCalculator() {
        frame = new JFrame();
        frame.setSize(700, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        createCustomTitleBar();
        createMainContent();

        frame.setVisible(true);
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
        customTitleBar.setPreferredSize(new Dimension(700, 35));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        titlePanel.setOpaque(false);

        titleBarLabel = new JLabel("DRIVEWISE - Safe Speed Calculator");
        titleBarLabel.setForeground(Color.WHITE);
        titleBarLabel.setFont(titleBarFont);
        titleBarLabel.setVerticalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleBarLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 2, 2));
        buttonPanel.setOpaque(false);

        minimizeButton = createTitleBarButton("−");
        minimizeButton.addActionListener(e -> frame.setState(JFrame.ICONIFIED));

        closeButton = createTitleBarButton("×");
        closeButton.addActionListener(e -> frame.dispose());
        
        buttonPanel.add(minimizeButton);
        buttonPanel.add(closeButton);
        
        customTitleBar.add(titlePanel, BorderLayout.WEST);
        customTitleBar.add(buttonPanel, BorderLayout.EAST);

        makeTitleBarDraggable();
        frame.add(customTitleBar, BorderLayout.NORTH);
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

    private void createMainContent() {
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                // Create gradient background
                GradientPaint gradient = new GradientPaint(
                    0, 0, darkBackground,
                    0, getHeight(), new Color(40, 20, 60)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                
                // Add some synthwave grid lines
                g2d.setColor(new Color(255, 20, 147, 30));
                for (int i = 0; i < getWidth(); i += 50) {
                    g2d.drawLine(i, 0, i, getHeight());
                }
                for (int i = 0; i < getHeight(); i += 50) {
                    g2d.drawLine(0, i, getWidth(), i);
                }
            }
        };
        backgroundPanel.setLayout(null);

        // Title
        JLabel titleLabel = new JLabel("SAFE SPEED CALCULATOR");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(0, 30, 700, 50);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundPanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Calculate safe driving speed based on conditions");
        subtitleLabel.setForeground(synthCyan);
        subtitleLabel.setFont(headingFont);
        subtitleLabel.setBounds(0, 80, 700, 30);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundPanel.add(subtitleLabel);

        // Speed input
        JLabel speedLabel = createStyledLabel("SPEED (MPH):");
        speedLabel.setBounds(100, 140, 200, 30);
        backgroundPanel.add(speedLabel);

        speedField = createStyledTextField();
        speedField.setBounds(350, 140, 200, 35);
        backgroundPanel.add(speedField);

        // Weather condition
        JLabel weatherLabel = createStyledLabel("WEATHER CONDITION:");
        weatherLabel.setBounds(100, 190, 200, 30);
        backgroundPanel.add(weatherLabel);

        String[] weatherOptions = {"Clear", "Light Rain", "Heavy Rain"};
        weatherBox = createStyledComboBox(weatherOptions);
        weatherBox.setBounds(350, 190, 200, 35);
        backgroundPanel.add(weatherBox);

        // Road type
        JLabel roadLabel = createStyledLabel("ROAD TYPE:");
        roadLabel.setBounds(100, 240, 200, 30);
        backgroundPanel.add(roadLabel);

        String[] roadOptions = {"Highway", "Urban streets", "Gravel roads"};
        roadBox = createStyledComboBox(roadOptions);
        roadBox.setBounds(350, 240, 200, 35);
        backgroundPanel.add(roadBox);

        // Visibility
        JLabel visibilityLabel = createStyledLabel("VISIBILITY:");
        visibilityLabel.setBounds(100, 290, 200, 30);
        backgroundPanel.add(visibilityLabel);

        String[] visibilityOptions = {"Good", "Reduced", "Poor"};
        visibilityBox = createStyledComboBox(visibilityOptions);
        visibilityBox.setBounds(350, 290, 200, 35);
        backgroundPanel.add(visibilityBox);

        // Buttons
        JButton calculateButton = createStyledButton("CALCULATE");
        calculateButton.setBounds(100, 360, 140, 50);
        calculateButton.addActionListener(e -> calculateSafeSpeed());
        backgroundPanel.add(calculateButton);

        JButton recalculateButton = createStyledButton("RESET");
        recalculateButton.setBounds(260, 360, 140, 50);
        recalculateButton.addActionListener(e -> clearFields());
        backgroundPanel.add(recalculateButton);

        JButton backButton = createStyledButton("BACK TO MENU");
        backButton.setBounds(420, 360, 160, 50);
        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });
        backgroundPanel.add(backButton);

        // Result label
        resultLabel = new JLabel("SAFE SPEED = ");
        resultLabel.setForeground(synthGreen);
        resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        resultLabel.setBounds(0, 450, 700, 50);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundPanel.add(resultLabel);

        frame.add(backgroundPanel, BorderLayout.CENTER);
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(normalFont);
        return label;
    }

    private JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setBackground(new Color(50, 50, 70));
        field.setForeground(Color.WHITE);
        field.setFont(normalFont);
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(synthPink, 2),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        field.setCaretColor(synthCyan);
        return field;
    }

    private JComboBox<String> createStyledComboBox(String[] options) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBackground(new Color(50, 50, 70));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(normalFont);
        comboBox.setBorder(BorderFactory.createLineBorder(synthPink, 2));
        
        // Style the dropdown arrow
        comboBox.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setBackground(synthPurple);
                button.setBorder(BorderFactory.createEmptyBorder());
                return button;
            }
        });
        
        return comboBox;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(138, 43, 226, 180));
        button.setForeground(Color.WHITE);
        button.setFont(normalFont);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(synthPink, 2),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(synthPink);
                button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.WHITE, 2),
                    BorderFactory.createEmptyBorder(10, 15, 10, 15)
                ));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(138, 43, 226, 180));
                button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(synthPink, 2),
                    BorderFactory.createEmptyBorder(10, 15, 10, 15)
                ));
            }
        });
        
        return button;
    }

    private void calculateSafeSpeed() {
        String speedText = speedField.getText().trim();
        if (speedText.isEmpty()) {
            resultLabel.setText("SAFE SPEED = Please enter speed");
            resultLabel.setForeground(synthOrange);
            return;
        }

        try {
            double speed = Double.parseDouble(speedText);

            double afw = 1.0;
            if (weatherBox.getSelectedIndex() == 1) afw = 0.8;
            else if (weatherBox.getSelectedIndex() == 2) afw = 0.6;

            double afr = 1.0;
            if (roadBox.getSelectedIndex() == 1) afr = 0.8;
            else if (roadBox.getSelectedIndex() == 2) afr = 0.6;

            double afv = 1.0;
            if (visibilityBox.getSelectedIndex() == 1) afv = 0.7;
            else if (visibilityBox.getSelectedIndex() == 2) afv = 0.5;

            double safeSpeed = speed * afw * afr * afv;
            resultLabel.setText(String.format("SAFE SPEED = %.1f MPH", safeSpeed));
            resultLabel.setForeground(synthGreen);
        } catch (NumberFormatException e) {
            resultLabel.setText("SAFE SPEED = Invalid speed value");
            resultLabel.setForeground(synthOrange);
        }
    }

    private void clearFields() {
        speedField.setText("");
        weatherBox.setSelectedIndex(0);
        roadBox.setSelectedIndex(0);
        visibilityBox.setSelectedIndex(0);
        resultLabel.setText("SAFE SPEED = ");
        resultLabel.setForeground(synthGreen);
    }
}