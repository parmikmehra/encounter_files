import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Encounter_File {
	public static void main(String[] args) {
		String file1Name = "";
		String file2Name = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file 1 name: ");
		file1Name = scan.nextLine();
		System.out.println("Enter the file 2 name: ");
		file2Name = scan.nextLine();
		scan.close();
		String lineFile1 = "";
		String lineFile2 = "";
		ArrayList<Character> line1 = new ArrayList<Character>();
		ArrayList<Character> line2 = new ArrayList<Character>();
		int indexstart1 = 0;
		int indexstop1 = 0;
		int indexstart2 = 0;
		int indexstop2 = 0;
		ArrayList<Character> temp1 = new ArrayList<Character>();
		ArrayList<Character> temp2 = new ArrayList<Character>();
		String rep1 = "";
		String rep2 = "";
		try {
			FileReader fileReader = new FileReader(file1Name);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileReader fr2 = new FileReader(file2Name);
			BufferedReader br2 = new BufferedReader(fr2);
			PrintWriter writer = new PrintWriter("compareFiles.txt");
            
            while(lineFile1 != null) {
            	lineFile1 = bufferedReader.readLine();
            	lineFile2 = br2.readLine();
            	if (lineFile1 == null) {

            	} else {
           			for (char c : lineFile1.toCharArray()) {
  					line1.add(c);
					}
					for (char c : lineFile2.toCharArray()) {
  					line2.add(c);
					}
            		if(lineFile1.equals(lineFile2)) {
            		
            		} else {
            			writer.println(lineFile1);
            		}
            	}
            }


            for (int i = 0; i < line1.size() - 1; i++) {
            	if (line1.get(i) == '*') {
            		indexstart1 = line1.indexOf('*');
            		line1.remove(i);
            		indexstop1 = line1.indexOf('*');
            		indexstart2 = line2.indexOf('*');
            		line2.remove(i);
            		indexstop2 = line2.indexOf('*');
            		for (int j = indexstart1; j < indexstop1; j++) {
            			temp1.add(line1.get(j));
            		}
            		for (int x = indexstart2; x < indexstop2; x++) {
            			temp2.add(line2.get(x));
            		}
            		if(line1.get(i+1) != line2.get(i+1)) {
            			//System.out.println(line1.get(i+1));
            		}
            	}
            	rep1 = getStringRepresentation(temp1);
            	rep2 = getStringRepresentation(temp2);
            	temp1.clear();
            	temp2.clear();
            	if (rep1.equals(rep2)) {

            	} else {
            		System.out.println(rep1 + "                    " + rep2);
            	}
            }
            bufferedReader.close();
            br2.close();
            writer.close();
		} catch (IOException ex) {
			System.out.println("Error reading file");
		}
	}


	public static String getStringRepresentation(ArrayList<Character> list) {    
    	StringBuilder builder = new StringBuilder(list.size());
    	for(Character ch: list){
        	builder.append(ch);
    	}
    	return builder.toString();
	}
}