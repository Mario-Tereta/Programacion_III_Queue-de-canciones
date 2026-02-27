package umg.edu.gt.queueHandler;

import umg.edu.gt.data_structure.queue.manual.QueueLinked;

public class PlaylistManager {

    private QueueLinked<Song> highPriority;
    private QueueLinked<Song> normalPriority;

    private QueueLinked<Song> history;

    private int totalSongsPlayed;
    private int totalTimePlayed;

    public PlaylistManager() {
        highPriority = new QueueLinked<>();
        normalPriority = new QueueLinked<>();
        history = new QueueLinked<>();
        totalSongsPlayed = 0;
        totalTimePlayed = 0;
    }

    public void addSong(Song song) {

        if (song.getPriority() == 1) {
            highPriority.enqueue(song);
        } else {
            normalPriority.enqueue(song);
        }
    }

    public void playAll() throws InterruptedException {

        System.out.println("[LOG] Starting playlist...");

        while (!highPriority.isEmpty() || !normalPriority.isEmpty()) {

            Song current;

            if (!highPriority.isEmpty()) {
                current = highPriority.dequeue();
            } else {
                current = normalPriority.dequeue();
            }

            playSong(current);
        }

        System.out.println("[LOG] Playlist finished.");
        System.out.println("[LOG] Total songs played: " + totalSongsPlayed);
        System.out.println("[LOG] Total time played: " + totalTimePlayed + " seconds");
    }

    private void playSong(Song song) throws InterruptedException {

        System.out.println("[LOG] Now playing: "
                + song.getTitle() + " - "
                + song.getArtist()
                + " (" + song.getDuration() + "s)");

        for (int i = 1; i <= song.getDuration(); i++) {
            Thread.sleep(1000);
            System.out.println("[LOG] Playing: "
                    + song.getTitle()
                    + " | " + i + "s / "
                    + song.getDuration() + "s");
        }

        System.out.println("[LOG] Finished: " + song.getTitle());

        // Guardar en historial
        history.enqueue(song);

        totalSongsPlayed++;
        totalTimePlayed += song.getDuration();
    }
}
