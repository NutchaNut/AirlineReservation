public class FlightFileReader extends TextFileReader{

    public Flight readFlight()
    {
        Flight flight = null;
        String line = getNextLine();

        String flightId , airline;
        int totalSeat , price;

        if(line != null)
        {
            String fields[] = line.split(" "); // split each field by space

            flightId = fields[0];
            airline = fields[1];
            totalSeat = Integer.parseInt(fields[2]);
            price = Integer.parseInt(fields[3]);

            flight = new Flight(flightId, airline, totalSeat, price);
        }

        return flight;
    }

   
    
}