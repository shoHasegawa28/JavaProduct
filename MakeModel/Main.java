import java.io.*;

public class Main{
		private static int typeColNum = 2;
		private static int nameColNum = 0;

		public static void main(String[] args){
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.csv")));
				FileWriter filewriter = new FileWriter(new File("Model.txt"));

				String line = "";
				System.out.println(br.readLine());
				while((line = br.readLine()) != null){
					String[] temp = line.split(",",0);
					String type = "String";

					if(temp[typeColNum].indexOf("datetime") != -1){
						continue;
					}

					if(temp[typeColNum].indexOf("tinyint") != -1 || temp[typeColNum].indexOf("int") != -1){
						type = "Int";
					}
					filewriter.write("public " + type + " " + temp[nameColNum] + "{set; get;}\n");
					//System.out.println("public " + type + " " + temp[nameColNum] + "{set; get;}");
				}
				filewriter.close();
				br.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

}
