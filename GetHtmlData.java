package webData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetHtmlData {

	public GetHtmlData() {
		getHtmlData();
	}

	private void getHtmlData() {
		URL url;
		File file=new File("src/webData/WebHtmlData.html");
		try{
			FileWriter out=new FileWriter(file);
			url=new URL("http://konachan.net/post");
			URLConnection conn= url.openConnection();
			
			BufferedReader buffer=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str;
			while((str=buffer.readLine())!=null){
				out.write(str+"\n");
			}
		}catch (Exception e) {
		}
	}
}
