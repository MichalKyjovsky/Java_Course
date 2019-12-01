import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		StringBuilder buffer = new StringBuilder();
		int length = 0;
		//Field, articles and logical separation and processing
		NumCheck numCheck = new NumCheck();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String firstLine = reader.readLine();
			if (numCheck.isInt(firstLine) != 0) {
				length = Integer.parseInt(firstLine);
				int entered = 0;
				String line;
				String last = "";

				while ((line = reader.readLine()) != null){

					if(line.equals("")) {
						if (line.equals("") && !last.equals("")) {
							while (line.equals("") && !last.equals("")) {
								line = reader.readLine();
							}
							buffer.append("\n");
						}
						try {
							while (line.equals("")) {
								line = reader.readLine();
							}
						}catch (Exception e){
							System.out.println();
							System.exit(0);
						}
						buffer.append("\n");
						entered = 0;
						}


					String[] wordOnLine = line.split(" ");

					for (int i = 0; i < wordOnLine.length;i++){

						if(wordOnLine[i].length() > length){
							if(!buffer.toString().endsWith("\n"))
								buffer.append("\n").append(wordOnLine[i]);
							else
								buffer.append(wordOnLine[i]).append("\n");
							continue;
						}

						if(entered + wordOnLine[i].length() <= length) {
							buffer.append(wordOnLine[i]).append(" ");
							entered += wordOnLine[i].length() + 1;
						}
						else{
							buffer.append("\n");
							entered = 0;
							i--;
						}
					}
					last = line;
				}
			if(line == null && buffer.length() == 0){
				System.exit(0);
			}
			} else {
				System.out.println("Error");
				System.exit(0);
			}
		} catch (IOException e) {
			System.out.println("Error");
		}

		String[] lines = buffer.toString().split("\n");
		StringBuilder output = new StringBuilder();

		for(int i = 0; i < lines.length; i++){
			for(int j = lines[i].length() - 1; j >= 0; j--){
				if(lines[i].equals(""))
					break;

				if(!lines[i].endsWith(" "))
					break;

				if(lines[i].charAt(j) == ' '){
					lines[i] = lines[i].substring(0,lines[i].length() - 1);
					if(lines[i].charAt(j-1) != ' ')
						break;
				}
			}
		}

		for (int i = 0; i < lines.length; i++){
			int whiteSpaceCount = 0;

			for (char item:lines[i].toCharArray()) {
				if(Character.isWhitespace(item))
					whiteSpaceCount++;
			}

			if(whiteSpaceCount == 0) {
				output.append(lines[i]).append("\n");
				continue;
			}

			if(lines[(i+1)%lines.length].equals("") || i == lines.length - 1){
				output.append(lines[i]).append("\n");
				continue;
			}


			int diff = length - lines[i].length();
			int positionCounter = 0;
			int checkCounter = 0;
			int division = diff / whiteSpaceCount;
			int reminder = diff % whiteSpaceCount;

			for (char item:lines[i].toCharArray()) {
				output.append(item);
				if (Character.isWhitespace(item) && lines[i].length() + checkCounter < length) {
					if (positionCounter < whiteSpaceCount) {
						for (int j = 0; j < division; j++) {
							output.append(" ");
						}
						if (positionCounter < reminder)
							output.append(" ");
						positionCounter++;
					} else {
						output.append(" ");
					}
					checkCounter++;
				}
			}
			output.append("\n");
		}

		System.out.print(output);
	}
}

