package test.komori;


/**
 * Created by komori on 2016/04/07.
        */
import java.io.*;
import java.nio.charset.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import org.geotools.data.shapefile.*;
import org.geotools.data.simple.*;
import org.geotools.geojson.feature.*;
import org.geotools.swing.data.*;

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

    public static String dateOfFile() throws Exception {

        UIManager.LookAndFeelInfo DummyInfos[] = UIManager.getInstalledLookAndFeels();
        Calendar dummyCalendar = Calendar.getInstance();
        int dummyFile = JFileDataStoreChooser.WIDTH;

        Date date1 = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("'JSON'_yyyyMMdd_HHmmss'.json'");
        String jDate = sdf1.format(date1);
        return jDate;
    }

}