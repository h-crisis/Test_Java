package test.komori;

/**
 * Created by komori on 2016/04/07.
 */
import java.io.File;
import java.io.FilenameFilter;


public class GetFileName {
    public static String gFName() {
        File dir = new File("/Users/komori/Desktop/N03-20150101_11_GML/");
        String[] files = dir.list(new MyFilter());
        String nameOf = files[0].toString();
        return nameOf;
    }
}

class MyFilter implements FilenameFilter{
    public boolean accept(File dir, String name) {
        int index = name.lastIndexOf(".");//拡張子の"."を探す

        //"."以下の文字列を取り出して全て小文字に
        String ext = name.substring(index+1).toLowerCase();

        //拡張子が"txt"と一致すれば取り出す
        if(ext.equals("shp") == true) {return true;}

        //それ以外のファイルはリストアップしない
        return false;
    }
}