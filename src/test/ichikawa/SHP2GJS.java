package test.ichikawa;

/**
 * Created by komori on 2016/04/07.
 */

import test.komori.GetFileName;

import java.io.File;

public class SHP2GJS{

    public static void main(String[] args) throws Exception  {
        File jsonfile = new File("/Users/manabu/Dropbox/IntelliJ IDEA/HCRISIS_TestJava/files/A002005212010DDSWC11229/h22ka11229.shp");
        String jsonString = Shape2GeoJSON.getJSON(jsonfile,"Shift_JIS");
        String jsonDate = Shape2GeoJSON.dateOfFile();
        Shape2GeoJSON.getGeoJSON(jsonString,"/Users/manabu/Dropbox/IntelliJ IDEA/HCRISIS_TestJava/files/A002005212010DDSWC11229/h22ka11229.geojson", "utf-8");
    }

}