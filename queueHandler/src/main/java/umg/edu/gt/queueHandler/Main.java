package umg.edu.gt.queueHandler;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        PlaylistManager manager = new PlaylistManager();

        manager.addSong(new Song("C4", "Artist A", 8, 1));
        manager.addSong(new Song("C6", "Artist B", 10, 1));
        manager.addSong(new Song("C8", "Artist C", 6, 1));

        manager.addSong(new Song("C5", "Artist D", 7, 2));
        manager.addSong(new Song("C7", "Artist E", 9, 2));

        manager.playAll();
    }
}