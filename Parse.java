import java.io.*;
import java.util.*;

class Parse {

	public void createCSV(String filename) throws Exception {
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		PrintWriter writer = new PrintWriter(new File("giving2018.csv"));
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

	public void createCSVNoPercent(String year, String filename) throws Exception {
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		StringBuilder titleBuilder = new StringBuilder();
		titleBuilder.append("giving");
		titleBuilder.append(year);
		titleBuilder.append(".csv");
		PrintWriter writer = new PrintWriter(new File(titleBuilder.toString()));
		StringBuilder sb;
		String line;
		while (scan.hasNextLine()) {
			sb = new StringBuilder();
			line = scan.nextLine();
			String[] chars = line.split(" ");
			String name = getName(chars);
			sb.append(name);
			List<String> vals = new ArrayList<>();
			for (int i = 0; i < chars.length; i++) {
				if (chars[i].matches(".*\\d.*")) {
					vals.add(chars[i]);
				}
			}
			for (int i = 0; i < vals.size(); i++) {
				if (i % 2 == 0) {
					sb.append(", ");
					sb.append(vals.get(i));
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