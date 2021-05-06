
public class Driver {
	public static void main(String[] args) throws Exception{

		Parse parser = new Parse();

		parser.createCSV("giving2018.txt");
		parser.createCSVNoPercent("2017", "giving2017.txt");
		parser.createCSVNoPercent("2016", "giving2016.txt");
		parser.createCSVNoPercent("2015", "giving2015.txt");

	}
}