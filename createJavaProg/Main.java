import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.charset.*;

public class Main{
	private static List<String> lines;

	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("�t�@�C�������w�肵�Ă�������");
			System.exit(-1);
		}

		String FileName = args[0];

		if(isName(FileName)){
			System.out.println("���̃t�@�C�����͖����ł�");
			System.exit(1);
		}

		if(FileRead(FileName)){
			System.out.println("�t�@�C�����J���܂���");
		}

		if(FileWrite(FileName)){
			System.out.println("�t�@�C�����������߂܂���");
		}
	

	}

	public static boolean FileRead(String name){
		try{
			lines = Files.readAllLines(new File("temple.txt").toPath(),StandardCharsets.UTF_8);
			lines.set(0,lines.get(0).replace("_",name));
		}catch(IOException e){
			e.printStackTrace();
			return true;
		}
		return false;
	}

	public static boolean FileWrite(String name){
		try{
			File newfile = new File("output/"+name+".java");
			FileWriter fw = new FileWriter(newfile);

			for(String s: lines){
				fw.write(s + "\r\n");
			}

			fw.close();
		}catch(IOException e){
			e.printStackTrace();
			return true;
		}
		return false;
	}

	public static boolean isName(String Name){
		File file = new File("output");
		File files[] = file.listFiles();

		for(File f: files){
			if(f.getName().matches(Name + ".java")){
				System.out.println("�����t�@�C�������݂��܂�");
				return true;
			}
		}
		return false;
	}
}
