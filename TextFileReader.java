import java.io.*;

/**
 * TextFlieReader
 *  	
 * 		This class is for read the text flie into the system.
 * 		
 * 		Modified by Preyapach Tanathipchaicharoen (JJ) ID 59070501089
 * 		,18 April 2019
 */
public class TextFileReader
{
    /** Reader object to access the file */
    private BufferedReader reader = null;

    /**
    * Open a text file, if possible. It will be closed
    * when we open a new file, or get to the end of the old one.
    * @param filename   File to open
    * @return true if successfully opened, false if not found.
    */
    public boolean open(String filename)
    {
	boolean bOk = true;
	try
	{
	    if (reader != null)
		reader.close();
	}
	catch (IOException io)
	{
	    reader = null;
	}
	try
	{
	    reader = new BufferedReader(new FileReader(filename));
	}
	catch (FileNotFoundException fnf)
	{
	    bOk = false;
	    reader = null;
	}
	return bOk;
    }    

    /** 
    * Try to read a line from the open file.
    * @return Line as a string, or null if an error occurred.
    */   
    public String getNextLine()
    {
	String lineRead = null;
	try
	{
	    if (reader != null)  /* if reader is null, file is not open */
	    {
		lineRead = reader.readLine();
		if (lineRead == null)  /* end of the file */
		{
		    reader.close();
		}
	    } /* end if reader not null */
	}
	catch (IOException ioe)
	{
	    lineRead = null;
	}
	return lineRead;
    }

    /** 
     * Explicitly close the reader to free resources 
     */
    public void close()
    {
	try
	{
	    reader.close();
	}
	catch (IOException ioe)
	{
	}
    }
}    

