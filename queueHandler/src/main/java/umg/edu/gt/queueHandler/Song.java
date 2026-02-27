package umg.edu.gt.queueHandler;

public class Song {

    private String title;
    private String artist;
    private int duration;   // entre 5 y 30 segundos
    private int priority;   // 1 = alta, 2 = normal

    public Song(String title, String artist, int duration, int priority) {

        if (duration < 5 || duration > 30) {
            throw new IllegalArgumentException("Duration must be between 5 and 30 seconds");
        }

        if (priority != 1 && priority != 2) {
            throw new IllegalArgumentException("Priority must be 1 or 2");
        }

        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.priority = priority;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDuration() { return duration; }
    public int getPriority() { return priority; }
}