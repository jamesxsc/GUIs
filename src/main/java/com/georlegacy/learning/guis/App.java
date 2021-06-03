package com.georlegacy.learning.guis;

import com.georlegacy.learning.guis.util.ImageUtil;
import com.jidesoft.swing.MultilineLabel;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class App extends JFrame {
    private ImageUtil imgutil;
    private NumberSplashes splashes;

    private MultilineLabel label;
    private JProgressBar bar;
    private int clicks = 0;

    public App() {
        imgutil = new ImageUtil();
        init();
    }

    public static void main(String[] args) {
        new App();
    }

    private void updateLabel(String nt) {
        this.label.setText(nt);
    }

    private void updateBar(int v) {
        this.bar.setValue(v);
    }

    private void init() {
        this.splashes = new NumberSplashes();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.bar = new JProgressBar();
        this.label = new MultilineLabel();
        final JButton button = new JButton();
        button.setPreferredSize(new Dimension(250, 130));
        button.setFocusPainted(false);
        button.setForeground(new Color(0,0,0));
        button.setBackground(new Color(0, 0, 0));
        button.setMargin(new Insets(0,0, 0, 0));
        button.setOpaque(true);
        button.setIcon(imgutil.createImageIcon("images/clickbutton/main.png"));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(imgutil.createImageIcon("images/clickbutton/rollover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setIcon(imgutil.createImageIcon("images/clickbutton/main.png"));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                button.setPreferredSize(new Dimension(375,195));
                button.setIcon(imgutil.createImageIcon("images/clickbutton/click.png"));
                try {
                    AudioInputStream click = AudioSystem.getAudioInputStream(App.class.getClassLoader().getResource("audio/button-click.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(click);
                    clip.start();
                } catch (UnsupportedAudioFileException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (LineUnavailableException e1) {
                    System.err.println("The audio output line was unavailable.");
                }
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        button.setPreferredSize(new Dimension(250, 130));
                        button.setIcon(imgutil.createImageIcon("images/clickbutton/rollover.png"));
                    }
                }, 20);
            }
        });
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clicks++;
                updateLabel(splashes.getOrDefault(clicks));
                updateBar(clicks);
            }
        });

        bar.setMinimum(0);
        bar.setMaximum(1000);
        bar.setOrientation(1);
        bar.setPreferredSize(new Dimension(40, 300));
        bar.setForeground(new Color(59, 181, 255));
        bar.setBackground(new Color(246, 246, 246));
        bar.setValue(0);

        label.setForeground(Color.white);
        label.setFont(button.getFont().deriveFont(20.0F));
        label.setPreferredSize(new Dimension(200, 300));
        label.setText("You haven't yet clicked the button; Why not give it a try?");

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20,20,20,20);

        JPanel barpanel = new JPanel(new GridBagLayout());
        barpanel.add(bar, c);
        barpanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        barpanel.setBackground(Color.BLACK);

        JPanel labelpanel = new JPanel(new GridBagLayout());
        labelpanel.add(label, c);
        labelpanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        labelpanel.setBackground(Color.BLACK);

        JPanel buttonpanel = new JPanel(new GridBagLayout());
        buttonpanel.add(button, c);
        buttonpanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        buttonpanel.setBackground(Color.BLACK);

        this.setSize(new Dimension(800, 400));
        this.setResizable(false);
        this.add(barpanel, BorderLayout.EAST);
        this.add(labelpanel, BorderLayout.WEST);
        this.add(buttonpanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

}
