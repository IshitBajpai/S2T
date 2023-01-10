package p1;

import java.awt.Desktop;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
//import java.awt.Desktop;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print(40+10);
//		String url = "C:\\Users\\admin\\eclipse-workspace\\Demo\\src\\p1\\hhh.html";
//		File file = new File(url);
//		Desktop.getDesktop().browse(file.toURI());
//		
//		Scanner scn= new Scanner(System.in);
//		for(int i=0;i<4;i++) {
//			int x = scn.nextInt();
//			int y = scn.nextInt();
//		}
		
		String x  = "\"50\"";
		String y =  "\"50\"";
		
		String rec_code = "    <svg width=\"400\" height=\"180\"> <rect x=" + x + " y="+y+" width= "+"\"150\""+" height="+"\"150\" "+"style=\"fill:blue;stroke:pink;stroke-width:5;fill-opacity:0.1;stroke-opacity:0.9\" /></svg>";
//		System.out.print(rec_code);
		
		
		
		File file = new File("C:\\Users\\admin\\eclipse-workspace\\Demo\\hello.html");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write("<html><head><title>New Page</title></head><body><p>This is Body</p>"+ rec_code  +"</body></html>");
		bw.close();
		
		
		String url = "C:\\Users\\admin\\eclipse-workspace\\Demo\\hello.html";
		File f = new File(url);
		Desktop.getDesktop().browse(f.toURI());
		
		
		
		
		
		
		  // Assigning the content of the file
//        String text
//        // Defining the file name of the file
//        Path fileName = Path.of(
//        		"C:\\Users\\admin\\eclipse-workspace\\Demo\\src\\p1\\hi.txt");
//        // Writing into the file
//        Files.writeString(fileName, text);
//        // Reading the content of the file
//        String file_content = Files.readString(fileName);
//
//        // Printing the content inside the file
//        System.out.println(file_content);
//		
//		
//		
		
	}

}
