package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler 
{	
	
	public void saveData(List<Appointments> appts, String fileName)
	{
		try (FileWriter writer = new FileWriter(fileName)) 
		{
	        for (Appointments a : appts) 
	        {
	            writer.write(a.toCSV() + "\n");
	        }
	    } 
		catch (IOException e) 
		{
	        e.printStackTrace();
	    }
	}
	
	
	public List<Appointments> loadData(String fileName) 
	{
	    List<Appointments> appts = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) 
	    {
	        String line;
	        while ((line = reader.readLine()) != null)
	        {
	            appts.add(Appointments.fromCSV(line));
	        }
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	    return appts;
	}
}
