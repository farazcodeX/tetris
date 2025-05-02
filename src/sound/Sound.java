package sound;

import java.lang.reflect.Type;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class Sound {
    URL[] url = new URL[5];
    Clip music;

    public Sound() {
        url[0] = getClass().getResource("tetris\\src\\Clip\\delete line.wav");
        url[1] = getClass().getResource("tetris\\src\\Clip\\gameover.wav");
        url[2] = getClass().getResource("tetris\\src\\Clip\\rotation.wav");
        url[3] = getClass().getResource("tetris\\src\\Clip\\touch floor.wav");

    }
    public void play(int index, boolean isMusic) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(url[index]);
            Clip clip = AudioSystem.getClip();
            if(isMusic) {
                music = clip;
            }
            clip.open(ais);
            clip.addLineListener(new LineListener() {

                @Override
                public void update(LineEvent event) {
                    if(event.getType() == javax.sound.sampled.LineEvent.Type.STOP) {
                        clip.close();
                    }
                }
            });
            ais.close();
            clip.start();
        } catch (Exception e) {

        }
    }
    public void loop() {
        music.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void close() {
        music.stop();
        music.close();
    }

}
