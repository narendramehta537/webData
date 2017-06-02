package webData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadHtmlPageImage {
	
	private BufferedWriter bufferImage;
	private BufferedReader buffer;
	public ReadHtmlPageImage() throws Exception {
		readHtml();
	}
	private void readHtml() throws Exception{
		try{
			File file=new File("src/webData/WebHtmlData.html");
		
		File imagFile=new File("src/webData/ImageList.txt");
		
		FileWriter out=new FileWriter(imagFile);
		buffer = new BufferedReader(new FileReader(file));
		bufferImage = new BufferedWriter(out);
		Pattern pattern =Pattern.compile("<img src=\"((\\S*)(.jpg|.png|.gif|.bmp))");	
		Matcher matcher;
		String str="";
		String strImg;
		while((str=buffer.readLine())!=null){
			matcher=pattern.matcher(str);
			while(matcher.find()){
				strImg=matcher.group(1);
				System.out.println(strImg);
				bufferImage.write(strImg+"\n");
			}
		}
		}catch (Exception e) {
		}finally {
			bufferImage.close();
		}
		
	}
}
