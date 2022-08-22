package projetoLeituraArquivo;

public class Movie {
	private String rank;				//0
	private String title;
	private String genre;
	private String description;
	private String director;
	private String actors;			//5
	private String year;
	private String runtime;
	private String rating;
	private String votes;
	private String revenue;			//10
	private String metascore;
	private String rawData;
	
	public Movie(String rawData) {
		super();
		this.rawData = rawData;
		String[] rawDataSplit = this.rawData.split("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)"); //commas except commas inside quotation marks
//		String[] rawDataSplit = this.rawData.split(",(?![^\"]*\"{1,20}\\,)"); //commas except commas inside quotation marks
		this.rank = rawDataSplit[0];
		this.title = rawDataSplit[1];
		this.genre = rawDataSplit[2];
		this.description = rawDataSplit[3];
		this.director= rawDataSplit[4];
		this.actors = rawDataSplit[5];
		this.year = rawDataSplit[6];
		this.runtime = rawDataSplit[7];
		this.rating = rawDataSplit[8];
		
	
		
	}

	public String getRank() {
		return rank;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public String getDescription() {
		return description;
	}

	public String getDirector() {
		return director;
	}

	public String getActors() {
		return actors;
	}

	public String getYear() {
		return year;
	}

	public String getRuntime() {
		return runtime;
	}

	public String getRating() {
		return rating;
	}

	public String getVotes() {
		return votes;
	}

	public String getRevenue() {
		return revenue;
	}

	public String getMetascore() {
		return metascore;
	}

	public String getRawData() {
		return rawData;
	}


	
	
	
}
