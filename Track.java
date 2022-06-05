public class Track implements Comparable<Track>{
    private String id;
    private String artist;
    private String songName;
    private int popularity;


    public Track(String id, String songName, String artist, int popularity) {
        this.artist = artist;
        this.songName = songName;
        this.popularity = popularity;
        this.id = id;
    }

    public Track(String songName) { this.songName = songName; }

    public void setArtist(String artist) { this.artist = artist; }
    public void setSongName(String songName) { this.songName = songName; }
    public void setPopularity(int popularity) { this.popularity = popularity; }
    public void setId(String id) { this.id = id; }
    public void setKey(String name) { this.songName = songName; }

    public String getArtist() { return this.artist; }
    public String getSongName() { return this.songName; }
    public int getPopularity() { return this.popularity; }
    public String getId() { return this.id; }


    // auxiliar
    public void print() { System.out.println(getId() + " " + getArtist() + " " + getSongName() + " " + getPopularity()); }

    @Override
    public int compareTo(Track o) {
        String a = this.songName;
        String b = o.getSongName();

        if(a.compareTo(b) < 0){ return -1; }
        else if (a.compareTo(b) > 0){ return 1; }
        else { return 0; }
    }
}
