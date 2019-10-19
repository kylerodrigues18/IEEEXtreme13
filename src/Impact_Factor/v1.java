package Impact_Factor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class v1 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int numStrings = in.nextInt();
        ArrayList<String> data = new ArrayList<>();
        in.nextLine();
        //Get data and store into data ArrayList
        for(int i = 0; i < numStrings; i++) {
            data.add(in.nextLine());
        }

        //Store the publication data
        addPublications(data.get(0));
    }

    public static ArrayList<Publication> addPublications(String data) {
        ArrayList<Publication> publications = new ArrayList<>();
        data = data.replace("\"publications\": ", "");
        data = data.substring(2, data.length() - 2);
        data = data.replace("\"", "");

        while(data.contains("publicationTitle :")) {
            //Initialize Publication to be added to ArrayList
            Publication publication = new Publication();

            //add Publication Title
            int pubTit1 = data.indexOf("publicationTitle : ");
            int pubTit2 = data.indexOf(",");
            publication.publicationTitle = data.substring(pubTit1 + 19, pubTit2);
            data = data.substring(pubTit2 + 1);

            //add Publication Number
            int pubNum1 = data.indexOf("publicationNumber : ");
            int pubNum2 = data.indexOf(",");
            publication.publicationNumber = data.substring(pubNum1 + 20, pubNum2);
            data = data.substring(pubNum2 + 1);

            //add Publication first year
            int yearOneNum1 = data.indexOf("year : ");
            int yearOneNum2 = data.indexOf(",");
            publication.articleYearFirst = data.substring(yearOneNum1 + 7, yearOneNum2);
            data = data.substring(data.indexOf("},") + 2);

            //add Publication first year
            int yearTwoNum1 = data.indexOf("year : ");
            int yearTwoNum2 = data.indexOf(",");
            publication.articleYearSecond = data.substring(yearTwoNum1 + 7, yearTwoNum2);
            data = data.substring(data.indexOf("},") + 2);
            //add Publication to ArrayList
            publications.add(publication);
            System.out.println(publication.publicationTitle);
            System.out.println(publication.publicationNumber);
            System.out.println(publication.articleYearFirst);
            System.out.println(publication.articleYearSecond);
        }
        return publications;
    }

    private static class Publication {
        String publicationTitle;
        String publicationNumber;
        String articleYearFirst;
        String articleYearSecond;

        Publication() {
            publicationTitle = "";
            publicationNumber = "";
            articleYearFirst = "";
            articleYearSecond = "";
        }

        Publication(String publicationTitle, String publicationNumber, String articleYearFirst, String articleYearSecond) {
            this.publicationTitle = publicationTitle;
            this.publicationNumber = publicationNumber;
            this.articleYearFirst = articleYearFirst;
            this.articleYearSecond = articleYearSecond;
        }
    }
}
