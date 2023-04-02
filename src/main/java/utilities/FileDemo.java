package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {

		// create a empty file
//		
//		File myFile = new File("data1.txt");
//		try {
//			if(myFile.createNewFile()) {
//				System.out.println("File created successfully.");
//			}else {
//				System.out.println("File creation error.");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// write data to file
		String data = "This is file demo";
		try {
			FileWriter output = new FileWriter("data2.txt");
			output.write(data);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// use bufferedWriter
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			writer.write(data);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// read data

		char[] data2 = new char[100];
		try {
			FileReader input = new FileReader("data1.txt");
			input.read(data2);
			System.out.println(data2);
			input.close();
		} catch (IOException e) {
			System.out.println("File read error");
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
			String line;
			while((line=reader.readLine())!=null)
			System.out.println(reader.readLine());
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String data3 = "This data is appended...";
		try {
			FileWriter output1 = new FileWriter("data1.txt", true);
			output1.write(data3);
			System.out.println("Data appended successfully.");
			output1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		File myDeleteFile = new File("data2.txt");
		if (myDeleteFile.delete()) {
			System.out.println("File deleted successfully" + myDeleteFile.getName());
		} else {
			System.out.println("Failed to delete a file");
		}

	}

}
