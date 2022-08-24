package projetoLeituraArquivo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

public class Main {

	Comparator<Integer> reverseComparator = new Comparator<Integer>() {
		@Override
		public int compare(Integer i1, Integer i2) {
		  return i2.compareTo(i1);
		}
	  }; 
	public static void main(String[] args) {
			
			LocalDateTime startTime = LocalDateTime.now();
		
//			String fileName = "c://Users//F6855063//Let'sCode//desafios//projeto3-pedro//movies1.csv";
//			String fileName2 ="c://Users//F6855063//Let'sCode//desafios//projeto3-pedro//movies2.csv";
//			String fileName3 = "c://Users//F6855063//Let'sCode//desafios//projeto3-pedro//movies3.csv";

			String fileName = "movies1.csv";
			String fileName2 = "movies2.csv";
			String fileName3 = "movies3.csv";

			List<Movie> listMovies = new ArrayList<>();
			List<Movie> listHorror = new ArrayList<>();
			Set<String> setYear = new HashSet<>();
			
			//read file into stream, try-with-resources
			try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

				stream.forEach(line -> {
					Movie temp = new Movie(line);
					listMovies.add(temp);
					setYear.add(temp.getYear());
					if (temp.getYear().contains("4531")){
						System.out.println(line);
					}
				});

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//read file into stream, try-with-resources
			try (Stream<String> stream = Files.lines(Paths.get(fileName2))) {

				stream.forEach(line -> {
					Movie temp = new Movie(line);
					listMovies.add(temp);
					setYear.add(temp.getYear());
					if (temp.getYear().contains("4531")){
						System.out.println(line);
					}
				});
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//read file into stream, try-with-resources
			try (Stream<String> stream = Files.lines(Paths.get(fileName3))) {

				stream.forEach(line -> {
					Movie temp = new Movie(line);
					listMovies.add(temp);
					setYear.add(temp.getYear());
					if (temp.getYear().contains("4531")){
						System.out.println(line);
					}
				});

				System.out.println(listHorror.size());

			} catch (IOException e) {
				e.printStackTrace();
			}

			//int i = 0;

			listMovies.stream().sorted(Comparator.comparing(Movie::getRating))
				.forEach(y -> {
					if(y.getGenre().contains("Horror")){
						System.out.println(y.getGenre())
						;listHorror.add(y);
					}
				});


			try{
				PrintWriter writer = new PrintWriter("HorrorMovies", "UTF-8");
				Collections.reverse(listHorror);
				listHorror.subList(0, 20).stream().forEach(y -> {
					writer.println(y.getTitle()+" "+y.getRating());
				});
				writer.close();
			} catch (IOException e){
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

		setYear.stream().filter(s -> {
					try {
						Integer.parseInt(s);
						return true;
					} catch (final NumberFormatException e) {
						return false;
					}
				})
				.filter(s -> Integer.parseInt(s)>1500 & Integer.parseInt(s)<2050).forEach(s -> {
			try {
				PrintWriter writer = new PrintWriter(s, "UTF-8");
				listMovies.stream()
						.filter(movie -> movie.getYear().contains(s))
						.sorted(Comparator.comparing(Movie::getRating).reversed())
						.limit(50)
						.forEach(y -> {
							writer.println(y.getTitle()+" "+y.getRating());
						});
				writer.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		});


		LocalDateTime endTime = LocalDateTime.now();
			double totalProcessingTime = ChronoUnit.MILLIS.between(startTime, endTime);
			System.out.println(totalProcessingTime);
			
			try{
				PrintWriter writer = new PrintWriter("ProcessingReport", "UTF-8");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.A");
				writer.println("Processamento iniciado em: "+startTime.format(formatter));
				writer.println("Processamento finalizado em: "+endTime.format(formatter));
				writer.println("Processamento levou: "+totalProcessingTime/1000+" segundos");
				writer.println("Processamento levou: "+totalProcessingTime+" milisegundos");
				writer.close();
			} catch (IOException e){
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
	}

}

//Tratamento de exceção pro construtor do objeto Movie - omiti os últimos atributos 
//		porque estava dando outOfBoundsException por conta de alguns registros incorretos. 
//Filtro por gênero "Horror", ordenar por campo "Rating", filtrar apenas o top 20          //
//		e mandar para um arquivo
//Filtro por gênero "Year", ordenar por campo "Rating", filtrar apenas o top 50 e mandar 
//		para um arquivo, um para cada ano
//Gerar um arquivo com as informações de tempo de processamento

