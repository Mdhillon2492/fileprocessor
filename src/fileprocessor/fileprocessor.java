package fileprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileprocessor {

	public static void main(String[] args) {
		
		//Get the filename from user input.
		System.out.println("Provide the path to the input file: ");
		Scanner sc= new Scanner(System.in); 
		String fileName= sc.nextLine();
		//Comma delimiter to be used to split our units
		final String delimiter = ",";
		
		//Try and catch to help prevent file input error
		try {
			//Declaration of the input file
		      File file = new File(fileName);
		      
		      // Show user error if file is empty and end the program
		      if (file.length() == 0) {
		          System.out.println("File is empty ...");
		          return;
		      }
		      
		      // Declaring necessary variables to be used to process the input file
		      FileReader fr = new FileReader(file);
		      BufferedReader br = new BufferedReader(fr);
		      String line = " ";
		      String[] lineRow;
		      
		      // A two dimension array list to store the teams in each unit
		      ArrayList<ArrayList<String> > teams = new ArrayList<ArrayList<String> >();
		      teams.add(new ArrayList<String>());
		      
		      // Looping through our file
		      while ((line = br.readLine()) != null) {
		    	  lineRow = line.split(delimiter);
		    	  
		    	  // Each line is expected to have two teams separated by a comma. If not notify user and end program
		    	  if (lineRow.length < 2) {
			          System.out.println("File is not fully comma separated ...");
			          return;
			      }
		    	  
		    	  //Loop through our array list and store the teams in each matching unit
		    	  for(int i =0; i<teams.size()+1; i++)
			    	  if(lineRow[lineRow.length -1].equals("SAT"+String.valueOf(i))) {
			    		  teams.add(new ArrayList<String>());
			    			  for (int j = 0; j<lineRow.length; j++) {
			    				  for(int k =0; k<=teams.get(i-1).size(); k++) {

			    					  if(teams.get(i-1).contains(lineRow[j])) {
			    						  
			    						  
			    					  }else {
			    						  
			    						  teams.get(i-1).add(lineRow[j]);
			    					  }
			    				  }
						        	
			    			  }
			    			 
			    	  }
		        
		        
		      }
		      br.close();
		      
		      int maxLength = 0;
		      
		      // Store the largest array list size in the maxlength variable. This value 
		      // minus 1 will be the maximum number of units. 
		      // Minus one is to factor out the SAT names which are initially stored yet
		      // they don't represent members of the teams but the satellites.
		      for(int i =0; i<teams.size(); i++) {
		    	  
		    	  if(maxLength < teams.get(i).size()) {
		    		  
		    		  maxLength = teams.get(i).size() -1;
		    	  }
		    	  
		      }
		      
		      //Print the maximum number of units.
		      System.out.print("The maximum number of units is: "+maxLength);
		    }
		    catch(IOException ioe) {
		      ioe.printStackTrace();
		    }
	  }
	

	

}
