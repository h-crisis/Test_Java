package test.ichikawa;

/**
 * http://qiita.com/t-mat/items/562d71e62102cc906152
 * 上記に出ていたサンプルプログラム
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.geojson.feature.FeatureJSON;

public class Shape2GeoJSON {

    public static String getJSON(File f,String encoding)throws Exception{
        f.setReadOnly();
        ShapefileDataStore store = new ShapefileDataStore(f.toURI().toURL());
        Charset cs=Charset.forName(encoding);
        store.setCharset(cs);
        SimpleFeatureSource source = store.getFeatureSource();
        SimpleFeatureCollection featureCollection = source.getFeatures();
        String geoJson=null;
        FeatureJSON fj = new FeatureJSON();
        StringWriter writer = new StringWriter();
        fj.writeFeatureCollection(featureCollection, writer);
        geoJson = writer.toString();
        return geoJson;
    }

    public static File getGeoJSON(String json,String path,String encoding) throws Exception{
        File out=new File(path);
        PrintWriter pw=null;
        try{
            FileOutputStream fos = new FileOutputStream(out);
            OutputStreamWriter osw = new OutputStreamWriter(fos,encoding);
            pw = new PrintWriter(osw);
            pw.write(json);
            pw.close();
            pw=null;
            return out;
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(pw!=null){
                pw.close();
            }
        }
        return null;
    }

}