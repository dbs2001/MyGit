import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class txtFileReader {
	public List<String> readFile(String filename)
	{
	  List records = new ArrayList<String>();
	  try
	  {
		//System.out.println("1");
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
	   // System.out.println("2");
	    String line;
	    while ((line = reader.readLine()) != null)
	    {
	     // System.out.println(line);
	      records.add(line);
	    }
	    reader.close();
	    return records;
	  }
	  catch (Exception e)
	  {
	    System.err.format("Exception occurred trying to read '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
	}
}
