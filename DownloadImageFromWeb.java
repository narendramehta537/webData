package webData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadImageFromWeb {

	public DownloadImageFromWeb() {
		downloadImage();
	}

	private void downloadImage() {
		try{
			File file=new File("src/webData/ImageList.txt");
			BufferedReader buffer=new BufferedReader(new FileReader(file));
			URL imageUrl=null;
			InputStream in;
			String str;
			int i=0;
			while((str=buffer.readLine())!=null){
				if(!str.contains("http://")){
					imageUrl=new URL("https:"+str);
					System.out.println("https:"+str);
				}
				else imageUrl=new URL("https:"+str);
			in=imageUrl.openStream();
			i++;
			Files.copy(in,Paths.get("Data/image"+i+".jpg"));
			}
		}catch (Exception e) {
		}
	}

}
