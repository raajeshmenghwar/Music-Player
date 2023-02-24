import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;

public class Java_MusicPlayer {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{



        JFrame frame = new JFrame();
        frame.setTitle("Music Player");
        frame.setSize(500,200);
        frame.setLayout(null);
        frame.setVisible(true);

        //adding buttons
        JButton play = new JButton("Play");
        play.setBounds(25,50,75,30);
        play.setFont(new Font("Verdana", Font.PLAIN, 12 ));
        play.setForeground(Color.BLACK);
        frame.add(play);

        JButton reset = new JButton("Pause");
        reset.setBounds(125,50,75,30);
        reset.setFont(new Font("Verdana", Font.PLAIN, 12 ));
        reset.setForeground(Color.BLACK);
        frame.add(reset);

        JButton stop = new JButton("Stop");
        stop.setBounds(225,50,75,30);
        stop.setFont(new Font("Verdana", Font.PLAIN, 12 ));
        stop.setForeground(Color.BLACK);
        frame.add(stop);

        JButton quit = new JButton("Quit");
        quit.setBounds(325,50,75,30);
        quit.setFont(new Font("Verdana", Font.PLAIN, 12 ));
        quit.setForeground(Color.BLACK);
        frame.add(quit);

        //Java Audio Code
        File file = new File("Little Fish - Quincas Moreira (1).wav");
        // file = new File("Level_Up.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        play.addActionListener(e -> {
            clip.start();
        });
        reset.addActionListener(e -> {
            clip.setMicrosecondPosition(0);
        });

        stop.addActionListener(e -> {
            clip.stop();
        });

        quit.addActionListener(e ->{
            clip.close();
            frame.dispose();
        });

    }
}
