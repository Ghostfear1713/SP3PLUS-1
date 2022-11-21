public class Series extends Amedia {

    String seasonAndEpisode;

    public Series(String name, String yearOfReleaseMedia, String genreMedia, String rating, String seasonAndEpisode) {
        super(name, yearOfReleaseMedia, genreMedia, rating);
        this.seasonAndEpisode = seasonAndEpisode;
    }

    public Series() {

    }

    public String getSeasonAndEpisode() {
        return seasonAndEpisode;
    }

    public void setSeasonAndEpisode(String seasonAndEpisode) {
        this.seasonAndEpisode = seasonAndEpisode;
    }

    @Override
    public String toString() {
        return super.toString() + " Season and Episode" + " " + this.seasonAndEpisode;
    }
}

