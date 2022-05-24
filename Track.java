public class Track {
    private String id;
    private String artist;
    private String songName;
    private String popularity;


    public Track(String id, String songName, String artist, String popularity) {
        this.artist = artist;
        this.songName = songName;
        this.popularity = popularity;
        this.id = id;
    }

    public void setArtist(String artist) { this.artist = artist; }
    public void setSongName(String songName) { this.songName = songName; }
    public void setPopularity(String popularity) { this.popularity = popularity; }
    public void setId(String id) { this.id = id; }

    public String getArtist() { return this.artist; }
    public String getSongName() { return this.songName; }
    public String getPopularity() { return this.popularity; }
    public String getId() { return this.id; }

    // auxiliares
    public void print() { System.out.println(getId() + " " + getArtist() + " " + getSongName() + " " + getPopularity()); }
}
