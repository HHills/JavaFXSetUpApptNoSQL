package application;

public class Appointments 
{
	private String apptName;
	private String date;
	private String startTime;
	private String endTime;
	private String duration;
	
	
	public Appointments(String apptName, String date, String startTime, String endTime, String duration)
	{
		this.apptName = apptName;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
	}


	public String getApptName() 
	{
		return apptName;
	}


	public void setApptName(String apptName)
	{
		this.apptName = apptName;
	}


	public String getDate() 
	{
		return date;
	}


	public void setDate(String date)
	{
		this.date = date;
	}


	public String getStartTime() 
	{
		return startTime;
	}


	public void setStartTime(String startTime) 
	{
		this.startTime = startTime;
	}


	public String getEndTime() 
	{
		return endTime;
	}


	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}


	public String getDuration()
	{
		return duration;
	}


	public void setDuration(String duration)
	{
		this.duration = duration;
	}
	
	public String toCSV() 
	{
        return apptName + "," + date + "," + startTime + "," + endTime + "," + duration;
    }
	
	public static Appointments fromCSV(String csvLine) 
	{
	      String[] parts = csvLine.split(",");
	      return new Appointments(parts[0], parts[1], parts[2], parts[3], parts[4]);
	}
	
}
