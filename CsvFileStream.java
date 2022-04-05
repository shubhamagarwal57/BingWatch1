package CSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

///Users/shubhamagarwal57/IdeaProjects/BingWatchAssignment1/src/netflix_titles.csv
//show_id,type,title,director,cast,country,date_added,release_year,rating,duration,listed_in,description
public class CsvFileStream {
    public static void main(String[] args) throws IOException {
        int records;
        Scanner sc=new Scanner(System.in);
        Path path=Path.of("/Users/shubhamagarwal57/IdeaProjects/BingWatchAssignment1/src/netflix_titles.csv");
        List<Show> show_list=Files.lines(path)
                .skip(1)
                .map(line ->{
                    String[] fields=line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                    return new Show(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10],fields[11]);
                }).collect(Collectors.toList());


        System.out.println("Enter the no. of records to be fetched for Type=TV show");
        records=sc.nextInt();
        show_list.stream().
                filter(e->e.type.equalsIgnoreCase("TV Show"))
                .limit(records).forEach(n->System.out.println(n));

        System.out.println("Enter the no. of records to be fetched for Listed_in=Horror Movies");
        records= sc.nextInt();
        show_list.stream().
                filter(r->r.listed_in.contains("Horror Movies")).
                limit(records).forEach(n->System.out.println(n));

        System.out.println("Enter the no. of records to be fetched type=movie and country=india");
        records=sc.nextInt();
        show_list.stream()
                .filter(r->r.type.equalsIgnoreCase("Movie") && r.country.equalsIgnoreCase("India"))
                .limit(10).forEach(n->System.out.println(n));



    }
}
