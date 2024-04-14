/**
 * Created by tomasz_taw
 * Date: 13.04.2024
 * Time: 15:26
 * Project Name: java-exercises
 * Description:
 */
package pl.taw.graphicEditor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GraphicEditor extends JFrame {

    private Color currentColor = Color.BLACK;
    private int strokSize = 5;
    private BufferedImage canvasImage;
    private Point lineStart = null;

    public GraphicEditor() {
        super("Simple app for drawing");

        canvasImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        fillCanvas(Color.WHITE);
        DrawingPanel drawingPanel = new DrawingPanel();
        getContentPane().add(drawingPanel, BorderLayout.CENTER);

        createToolbar();

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createToolbar() {
        JToolBar toolBar = new JToolBar();

        JButton openButton = new JButton("Open");
        openButton.addActionListener(e -> openImage());
        toolBar.add(openButton);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveImage());
        toolBar.add(saveButton);

        JButton colorButton = new JButton("Color");
        colorButton.addActionListener(e -> {
            Color chosenColor = JColorChooser.showDialog(this, "Choose color", currentColor);
            if (chosenColor != null) {
                currentColor = chosenColor;
            }
        });
        toolBar.add(colorButton);

        JButton strokeButton = new JButton("Thickness");
        strokeButton.addActionListener(e -> {
            String size = JOptionPane.showInputDialog(this, "Enter the line thickness", strokSize);
            try {
                strokSize = Integer.parseInt(size);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Wrong value", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        toolBar.add(strokeButton);

        getContentPane().add(toolBar, BorderLayout.NORTH);
    }

    private void fillCanvas(Color color) {
        Graphics2D g2d = canvasImage.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, canvasImage.getWidth(), canvasImage.getHeight());
        g2d.dispose();
    }

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                canvasImage = ImageIO.read(fileChooser.getSelectedFile());
                repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(canvasImage, "PNG", fileChooser.getSelectedFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class DrawingPanel extends JPanel {
        public DrawingPanel() {
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    lineStart = e.getPoint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    lineStart = null;
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
               @Override
               public void mouseDragged(MouseEvent e) {
                   if (lineStart != null) {
                       drawLine(e.getPoint());
                       lineStart = e.getPoint();
                   }
               }
           });
        }

        private void drawLine(Point endPoint) {
            Graphics2D g2d = canvasImage.createGraphics();
            g2d.setColor(currentColor);
            g2d.setStroke(new BasicStroke(strokSize));
            g2d.drawLine(lineStart.x, lineStart.y, endPoint.x, endPoint.y);
            g2d.dispose();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(canvasImage, 0, 0, this);
        }
    }

}
