package ShopInventory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//import java.util.StringTokenizer;

public class Main {
	
	public static List<String> finalStockList = new LinkedList<String>();
	public static int finalDays = 0;
	
	public static List<String> readInStock(File stockFile) throws IOException {

        //line in
        String line = null;
        List<String> inputStockList = new LinkedList<String>();

        try {
            FileReader reader = new FileReader(stockFile);

            BufferedReader buffer = new BufferedReader(reader);
            line = buffer.readLine();
            while (line != null) {
                //System.out.println(line);
                inputStockList.add(line);
                line = buffer.readLine();

            }
            buffer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file " + stockFile + "\n");
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return inputStockList;

    }

	
	public static void Main() throws IOException {
		
		File file1 = null;
		//int futureDays = 0;
		
        Scanner keyboard = new Scanner(System.in);
        //ask client for info
        System.out.println("Please enter a file containing stock to read.");
        file1 = new File(keyboard.nextLine());
        System.out.println("Please enter the number of days in the future:");
        finalDays = Integer.parseInt(keyboard.nextLine());
        System.out.println("Calculating stock value "+ finalDays + " days in the future.");
        
        keyboard.close();
        
        List<String> inputStock = new LinkedList<String>();
        
        //read in the file

        inputStock = readInStock(file1);
        
        //add to public stockList
        
        for (String tokens : inputStock) { //for all tokens from inputStock
            finalStockList.add(tokens); //transfer all tokens to public var finalStockList
            System.out.println(tokens);
        }
        
        
        
        
        
		
	}

}
