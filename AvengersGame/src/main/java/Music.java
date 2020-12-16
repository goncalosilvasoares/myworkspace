
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

public class Music {
    private Clip clip;
    private URL soundURL;

    public Music(String path) {
        this.initClip(path);
    }

    public void play(boolean fromStart) {
        if (fromStart) {
            this.clip.setFramePosition(0);
        }

        this.clip.start();
    }

    public void stop() {
        this.clip.stop();
    }

    public void close() {
        this.clip.close();
    }

    public void setLoop(int times) {
        this.clip.loop(times);
    }

    public void reOpen() {
        AudioInputStream inputStream = null;

        try {
            inputStream = AudioSystem.getAudioInputStream(this.soundURL);
            this.clip.open(inputStream);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException var3) {
            System.out.println(var3.getMessage());
        }

    }

    private void initClip(String path) {
        this.soundURL = Music.class.getResource(path);
        AudioInputStream inputStream = null;

        try {
            if (this.soundURL == null) {
                path = path.substring(1);
                File file = new File(path);
                this.soundURL = file.toURI().toURL();
            }

            inputStream = AudioSystem.getAudioInputStream(this.soundURL);
            this.clip = AudioSystem.getClip();
            this.clip.open(inputStream);

            FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            floatControl.setValue(-20.00f);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException var4) {
            System.out.println(var4.getMessage());
        }

    }
}
