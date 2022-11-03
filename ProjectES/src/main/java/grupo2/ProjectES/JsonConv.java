package grupo2.ProjectES;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JsonConv {


	
	
public static void main(String[] args) throws IOException {
	String user="";
	File text = new File("src\\main\\java\\Files\\file.txt");
	
	File converted = new File("src\\main\\java\\Files\\converted.json");
	
	BufferedWriter wr = new BufferedWriter(new FileWriter(converted));
	
	Scanner sc = new Scanner(text);
	int i=0;   //para caso seja o primeiro evento, n colocar a fechar (se tivesse feito de outra maneira, o ultimo punharia uma virgula
	
			while(sc.hasNextLine()) {
				
				
				String stringatual=sc.nextLine();
				
				
				if(stringatual.contains("X-WR-CALNAME:")) {
					 user = stringatual.split("@")[0].split(":")[1];
					 
					 
					 String inicial= "{\r\n"
					 		+ "  \"vcalendar\": [\r\n"
					 		+ "    {\r\n"
					 		+ "      \"prodid\": \"-//ISCTE-IUL//fenix//EN\",\r\n"
					 		+ "      \"version\": \"2.0\",\r\n"
					 		+ "      \"calscale\": \"GREGORIAN\",\r\n"
					 		+ "      \"user\": "+"\""+user+"\",\r\n"
					 		+ "      \"vevent\": [\r\n";
			//		 		+ "        {";
					 wr.write(inicial);	 
				}
				if(stringatual.contains("BEGIN:VEVENT")) {
					i++;
					String data_atual = sc.nextLine().split(":")[1];
					String data_inicio = sc.nextLine().split(":")[1];
					String data_fim = sc.nextLine().split(":")[1];
					
					if(i==1) {
						String a="        {\r\n";
						wr.write(a);
					}else {
						String b="        }, \r\n"
								+"        {\r\n";
						wr.write(b);
					}
					String add="         \"data_atual\": "+"\""+data_atual+"\", \r\n"
							+ "          \"data_inicio\": "+"\""+data_inicio+"\", \r\n"
							+ "          \"data_fim\": "+"\""+data_fim+"\" \r\n";
					wr.write(add);
				
				}
			}
			
			
			
			String sfinal = "        }\r\n"
					+ "      ]\r\n"
					+ "    }\r\n"
					+ "  ]\r\n"
					+ "}";
		
			wr.write(sfinal);
	
	sc.close();
	wr.close();
	
	
}
}

