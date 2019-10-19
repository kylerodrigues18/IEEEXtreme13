package Impact_Factor;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
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
        ArrayList<Publication> publications = addPublications(data.get(0));

        for(int i = 1; i < numStrings; i++) {
            publications = getCitationCount(data.get(i), publications);
        }
        for(Publication publication: publications) {
            String title = publication.publicationTitle;
            double c = publication.citationCount;
            double p = publication.publicationCount;
            double inferedFactor = c/p;
            inferedFactor = (double)Math.round(inferedFactor * 100d) / 100d;
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(publication.publicationTitle + ": " + df.format(inferedFactor));
        }
    }

    public static ArrayList<Publication> addPublications(String data) {
        ArrayList<Publication> publications = new ArrayList<>();
        data = data.replace("\"", "");

        while(data.contains("publicationTitle :")) {
            data = data.substring(data.indexOf("publicationTitle : "));
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
            int publicationCountYear1 = data.indexOf("articleCount : ");
            int endPubCountIndex = data.indexOf("}");
            publication.publicationCount += Integer.parseInt(data.substring(publicationCountYear1 + 15, endPubCountIndex));
            data = data.substring(data.indexOf("},") + 2);

            //add Publication first year
            int yearTwoNum1 = data.indexOf("year : ");
            int yearTwoNum2 = data.indexOf(",");
            publication.articleYearSecond = data.substring(yearTwoNum1 + 7, yearTwoNum2);
            int publicationCountYear2 = data.indexOf("articleCount : ");
            int endPub2CountIndex = data.indexOf("}");
            publication.publicationCount += Integer.parseInt(data.substring(publicationCountYear2 + 15, endPub2CountIndex));
            data = data.substring(data.indexOf("},") + 2);

            //add Publication to ArrayList
            publications.add(publication);
        }
        return publications;
    }

    public static ArrayList<Publication> getCitationCount(String data, ArrayList<Publication> publications) {
        data = data.replace("\"", "");
        data = data.substring(data.indexOf("publicationNumber :"));
        while(data.contains("publicationNumber")) {
            data = data.substring(data.indexOf("publicationNumber"));
            int firstPos = data.indexOf("publicationNumber :");
            int secondPos = data.indexOf(",");
            int pubNum = Integer.parseInt(data.substring(firstPos + 20, secondPos));
            for (Publication p: publications) {
                if(Integer.parseInt(p.publicationNumber) == pubNum) {
                    int year = Integer.parseInt(data.substring(data.indexOf("year : ") + 7, data.indexOf("year : ") + 11));
                    if(Integer.parseInt(p.articleYearFirst) == year || Integer.parseInt(p.articleYearSecond) == year) {
                        p.citationCount++;
                    }
                }
            }
            data= data.substring(secondPos);
        }
        return publications;
    }

    private static class Publication {
        String publicationTitle;
        String publicationNumber;
        String articleYearFirst;
        String articleYearSecond;
        //found through parsing through all data
        int citationCount;
        //Found in header
        int publicationCount;

        Publication() {
            publicationTitle = "";
            publicationNumber = "";
            articleYearFirst = "";
            articleYearSecond = "";
            citationCount = 0;
            publicationCount = 0;
        }

        Publication(String publicationTitle, String publicationNumber, String articleYearFirst, String articleYearSecond) {
            this.publicationTitle = publicationTitle;
            this.publicationNumber = publicationNumber;
            this.articleYearFirst = articleYearFirst;
            this.articleYearSecond = articleYearSecond;
        }
    }
}
