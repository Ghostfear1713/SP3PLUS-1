public abstract class Amedia implements Media {
    private String name;
    private String year;
    private String genre;
    private String rating;

    public Amedia(String name, String year, String genre, String rating) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public Amedia() {
        name = "";
        year = "";
        genre = "";
        rating = "";

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Name:" + " " + this.name + "| " + "Year:" + this.year + "|" + "Genre:" + " " + this.genre + "|" + "Rating:" + " " + this.rating;
    }


}
