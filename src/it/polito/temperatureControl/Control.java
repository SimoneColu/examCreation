package it.polito.temperatureControl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Control {


	/**
	 * Creates a new building
	 * @param name name of the new building
	 */
	public Control(String name) {
		
    }

	/**
	 * Retrieves the name of the building
	 * @return name
	 */
	public String getName() { 
		return null;
	}
    
    /**
     * retrieves the category of a given lift type code
     * @param typeCode lift type code
     * @return the category of the type
     * @throws InvalidLiftException if the code has not been defined
     */
    public Building createBuilding(String code, String name, String description) throws InvalidException {
		return null;
    }

    /**
     * retrieves the capacity of a given lift type code
     * @param typeCode lift type code
     * @return the capacity of the type
     * @throws InvalidLiftException if the code has not been defined
     */
    public Collection<Building> getBuildings() throws InvalidException {
		return null;
    }


	public void updateBuilding(String buildingCode) {
		
	}

	public void deleteBuilding(String buildingCode) {

	}







    /**
     * retrieves the list of lift types
     * @return the list of codes
     */
	public Collection<String> types() {
		return null;
	}
	
	/**
	 * Creates new lift with given name and type
	 * 
	 * @param name		name of the new lift
	 * @param typeCode	type of the lift
	 * @throws InvalidLiftException in case the lift type is not defined
	 */
    public void createLift(String name, String typeCode) throws InvalidLiftException{

    }
    
	/**
	 * Retrieves the type of the given lift
	 * @param lift 	name of the lift
	 * @return type of the lift
	 */
	public String getType(String lift) {
		return null;
	}

	/**
	 * retrieves the list of lifts defined in the ski area
	 * @return the list of names sorted alphabetically
	 */
	public List<String> getLifts(){
		
		return null;
    }	

	/**
	 * create a new slope with a given name, difficulty and a starting lift
	 * @param name			name of the slope
	 * @param difficulty	difficulty
	 * @param lift			the starting lift for the slope
	 * @throws InvalidLiftException in case the lift has not been defined
	 */
    public void createSlope(String name, String difficulty, String lift) throws InvalidLiftException {
		Area s;
		if(!liftMap.containsKey(lift)){
			throw new InvalidLiftException();
		}

		else{
			s = new Area(name, difficulty, lift);
			slopesMap.put(name,s);
		}
			
    }
    
    /**
     * retrieves the name of the slope
     * @param slopeName name of the slope
     * @return difficulty
     */
	public String getDifficulty(String slopeName) {
		return slopesMap.get(slopeName).getDifficulty();
	}

	/**
	 * retrieves the start lift
	 * @param slopeName name of the slope
	 * @return starting lift
	 */
	public String getStartLift(String slopeName) {
		return slopesMap.get(slopeName).getName();
	}

	/**
	 * retrieves the list of defined slopes
	 * 
	 * @return list of slopes
	 */
    public Collection<String> getSlopes(){
		return slopesMap.keySet();
    }

    /**
     * Retrieves the list of slopes starting from a given lift
     * 
     * @param lift the starting lift
     * @return the list of slopes
     */
    public Collection<String> getSlopesFrom(String lift){
		return slopesMap.entrySet().stream()
			.filter(e->e.getValue().getStartingLiftName().compareTo(lift)==0)
			.map(e->e.getKey())
			.toList();
    }

    /**
     * Create a new parking with a given number of slots
     * @param name 	new parking name
     * @param slots	slots available in the parking
     */
    public void createParking(String name, int slots){
		Parking p = new Parking(name, slots);
		parkingMap.put(name,p);
    }

    /**
     * Retrieves the number of parking slots available in a given parking
     * @param parking	parking name
     * @return number of slots
     */
	public int getParkingSlots(String parking) {
		return parkingMap.get(parking).getParkingSlots();
	}

	/**
	 * Define a lift as served by a given parking
	 * @param lift		lift name
	 * @param parking	parking name
	 */
	public void liftServedByParking(String lift, String parking) {
		List<String> l = new LinkedList<>();
		/* prova.put(lift,parking);
		parkPerLift.put(parking,liftMap.get(lift).getType().getCapacity()); */
		if(liftServedByParking.containsKey(parking)){
			liftServedByParking.get(parking).add(lift);
			//l.add(lift);
			/* liftServedByParking.remove(parking);
			liftServedByParking.put(parking,l);  */
		}
		else{
			l.add(lift);
			liftServedByParking.put(parking,l);
		}
		
	}

	
	/**
	 * Retrieves the list of lifts served by a parking.
	 * @param parking	parking name
	 * @return the list of lifts
	 */
	public Collection<String> servedLifts(String parking) {

		/* return prova.entrySet().stream()
			.filter(e->e.getValue().compareTo(parking)==0)
			.map(Map.Entry::getKey)
			.collect(Collectors.toList()); */

		return liftServedByParking.get(parking);
	}

	/**
	 * Checks whether the parking is proportional to the capacity of the lift it is serving.
	 * A parking is considered proportionate if its size divided by the sum of the capacity of the lifts 
	 * served by the parking is less than 30.
	 * 
	 * @param parkingName name of the parking to check
	 * @return true if the parking is proportionate
	 */
	public boolean isParkingProportionate(String parkingName) {
		/* int parkingSize = parkingMap.get(parkingName).getParkingSlots();
		if(parkingSize/parkPerLift.get(parkingName)<30){
			return true;
		}
		return false; */

		//Map<String,Integer> m = prova.entrySet().stream()
			//.filter(e->e.getValue().compareTo(parkingName)==0)
			
		
		int m = liftServedByParking.get(parkingName).stream()
			.mapToInt(e->liftMap.get(e).getType().getCapacity())
			.sum();
		
		if(parkingMap.get(parkingName).getParkingSlots()/m < 30){
			return true;
		}
		else {
			return false;
		}
		


		/* Map<String,Integer> m = liftServedByParking.entrySet().stream()
			.collect(Collectors.toMap(
				e->e.getKey(),
				e->e.getValue().entrySet().stream()
					.map(p->liftTypeMap.get(liftMap.get(p).getSetType()).getCapacity())
					)
			)
 */	
	}

	/**
	 * reads the description of lift types and lift descriptions from a text file. 
	 * The contains a description per line. 
	 * Each line starts with a letter indicating the kind of information: "T" stands for Lift Type, 
	 * while "L" stands for Lift.
	 * A lift type is described by code, category and seat number. 
	 * A lift is described by the name and the lift type.
	 * Different data on a line are separated by ";" and possible spaces surrounding the separator are ignored.
	 * If a line contains the wrong number of information it should be skipped and
	 * the method should continue reading the following lines. 
	 * 
	 * @param path 	the path of the file
	 * @throws IOException	in case IO error
	 * @throws InvalidLiftException in case of duplicate type or non-existent lift type
	 */
    public void readLifts(String path) throws IOException, InvalidLiftException {
		List<String> lines;
		String[] riga;
		try(
			BufferedReader br = new BufferedReader(new FileReader(path));
		){
			lines = br.lines().collect(Collectors.toList());
		}
		catch(IOException ioe){
			System.out.println(ioe);
			return;
		}
		
		for(int i=0;i<lines.size();i++){
			riga = lines.get(i).trim().split(";");
			if(riga.length == 4 && (riga[0].compareTo("T")==0)){
				liftType(riga[1], riga[2], Integer.parseInt(riga[3]));
			}
			else if(riga.length == 3 && (riga[0].compareTo("L")==0)){
				createLift(riga[1],riga[2]);
			}
		}
		
			
		
    }

}
