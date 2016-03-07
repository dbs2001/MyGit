
import java.io.*;     // for File
import java.util.*;   // for Scanner

public class FileCrawler {
	public static HashMap<String,String> hm=new HashMap<String,String>();  
	
	public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Directory to crawl? ");
        String directoryName = console.nextLine();
        
        System.out.println("Indexing ... ");
        File f = new File(directoryName);
        crawl(f, directoryName);
        System.out.println("");
        for (String key : hm.keySet()) {
            System.out.println(key + " " + hm.get(key));
        }
        
        System.out.println("\nEnter the key word you want to search for");
        String Name = console.nextLine();
    }
    
    // Prints the given file/directory and any files/directories inside it,
    // starting with zero indentation.
    // Precondition: f != null and f exists
    public static void crawl(File f, String dName) {
    	crawl(f, "", dName);
    }
    
    // This recursive "helper" method prints the given file/directory and any
    // files/directories inside it at the given level of indentation.
    // Precondition: f != null and f exists
    public static void crawl(File f, String indent, String DirectoryName) {
    	//System.out.println(indent + f.getName());
    	hm.put(f.getName(), f.getPath());
    	String buffer = f.getName();
    	//System.out.println(buffer.length());
    	int l = buffer.length();
    	if(buffer.charAt(l-1)== 't' &&buffer.charAt(l-2) == 'x' && buffer.charAt(l-3) == 't'){
    		txtFileReader tFR = new txtFileReader();
    		List records = new ArrayList<String>();
    		records = tFR.readFile(f.getPath());
    		for (int i = 0; i < records.size(); i++) {
    		    String value = (String) records.get(i);
    		    String[] tokens = value.split(" ");
    		    
    		    for(int j = 0 ; i < tokens.length ; i++){
    		    	//System.out.println(tokens[j]);
    		    }
    		}
    	}
    	if (f.isDirectory()) {
        	// recursive case: directory
        	// print everything in the directory
    		
        	File[] subFiles = f.listFiles();
    		indent += "    ";
        	for (int i = 0; i < subFiles.length; i++) {
              	crawl(subFiles[i], indent, DirectoryName);
        	}
        }
    	//else
    		//System.out.println("//Not found");
    }
}
