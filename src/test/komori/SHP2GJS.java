package test.komori;

/**
 * Created by komori on 2016/04/07.
 */
import java.io.File;

public class SHP2GJS{

    public static void main(String[] args) throws Exception  {

        String namea = GetFileName.gFName();
        File jsonfile = new File("/Users/komori/Desktop/N03-20150101_11_GML/" + namea);
        String jsonString = Shape2GeoJSON.getJSON(jsonfile,"Shift_JIS");
        String jsonDate = Shape2GeoJSON.dateOfFile();
        Shape2GeoJSON.getGeoJSON(jsonString,"/Users/komori/Desktop/N03-20150101_11_GML/" + jsonDate, "utf-8");
    }

}