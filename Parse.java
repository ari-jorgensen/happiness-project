import java.io.*;
import java.util.Scanner;

class Parse {

	public String filename;
	
	public Parse(String filename) throws IOException {
		this.filename = filename;
	}

	public void createCSV() throws Exception {
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		PrintWriter writer = new PrintWriter(new File("giving.csv"));
		StringBuilder sb;
		String line;
		while (scan.hasNextLine()) {
			sb = new StringBuilder();
			line = scan.nextLine();
			String[] chars = line.split(" ");
			String name = getName(chars);
			sb.append(name);
			for (int i = 0; i < chars.length; i++) {
				if (chars[i].matches(".*\\d.*")) {
					if (!chars[i].contains("%")) {
						sb.append(", ");
						sb.append(chars[i]);
					}
				}
			}
			sb.append("\n");
			writer.write(sb.toString());
		}
		writer.close();
		scan.close();
	}

	private String getName(String[] chars) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i].matches(".*\\d.*")) {
				break;
			} else {
				sb.append(chars[i]);
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}