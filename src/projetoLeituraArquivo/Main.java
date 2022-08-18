package projetoLeituraArquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
			
			LocalDate startTime = LocalDate.now();
		
			String fileName = "c://Users//F8223718//eclipse-workspace//projetoLeituraArquivo//movies1.csv";
			String fileName2 = "c://Users//F8223718//eclipse-workspace//projetoLeituraArquivo//movies2.csv";
			String fileName3 = "c://Users//F8223718//eclipse-workspace//projetoLeituraArquivo//movies3.csv";

			List<Movie> listMovies = new ArrayList<>();
			
			//read file into stream, try-with-resources
			try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

				stream.forEach(line -> listMovies.add(new Movie(line)));

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//read file into stream, try-with-resources
			try (Stream<String> stream = Files.lines(Paths.get(fileName2))) {
				
				stream.forEach(line -> listMovies.add(new Movie(line)));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//read file into stream, try-with-resources
			try (Stream<String> stream = Files.lines(Paths.get(fileName3))) {
				
				stream.forEach(line -> listMovies.add(new Movie(line)));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(listMovies.get(1).getGenre());
			
			LocalDate endTime = LocalDate.now();
			Duration totalProcessingTime = Duration.between(endTime, startTime); 
			

		

	}

}
