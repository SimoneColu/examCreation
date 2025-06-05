package it.polito.temperatureControl;

import java.io.IOException;
import java.util.*;

/**
 * University Sensors Control System
 * Manages buildings, blocks, rooms, sensors, and environmental measurements.
 */
public class Control {


    /**
     * Creates the control system for a university.
     * 
     * @param universityName name of the university
     */
    public Control(String universityName) {
    }

    /**
     * Returns the name of the university.
     * 
     * @return university name
     */
    public String getName() {
        return null;
    }

    // ======================
    // R1: Building Management
    // ======================

    /**
     * Adds a new building to the system.
     * 
     * @param code        unique building code
     * @param name        building name
     * @param description building description
     * @throws InvalidControlException if building code already exists
     */
    public void createBuilding(String code, String name, String description) throws InvalidControlException {
    }

    /**
     * Returns the list of all building codes.
     * 
     * @return list of building codes
     */
    public List<String> getBuildings() {
        return null;
    }

    /**
     * Updates the name and description of a building.
     * 
     * @param code         building code
     * @param newName      new name
     * @param newDesc      new description
     * @throws InvalidControlException if building not found
     */
    public void updateBuilding(String code, String newName, String newDesc) throws InvalidControlException {
    }

    /**
     * Deletes the building with the given code.
     * 
     * @param code building code
     * @throws InvalidControlException if building not found
     */
    public void deleteBuilding(String code) throws InvalidControlException {
    }

    // =================
    // R2: Block 
    // =================

    /**
     * Creates a block inside a building.
     * 
     * @param buildingCode building code
     * @param blockCode    unique block code
     * @param roomNames    list of room names in the block
     * @param description  description of the block
     * @throws InvalidControlException if building is not found or block already exists
     */
    public void createBlock(String buildingCode, String blockCode, List<String> roomNames, String description)
            throws InvalidControlException {
    }

    /**
     * Returns the list of blocks in the given building.
     * 
     * @param buildingCode building code
     * @return list of block names
     * @throws InvalidControlException if building not found
     */
    public List<String> getBlocks(String buildingCode) throws InvalidControlException {
        return null;
    }

    /**
     * Updates the area block details.
     * 
     * @param blockCode    block code
     * @param newRooms     new list of room names
     * @param newDesc      updated description
     * @throws InvalidControlException if block not found
     */
    public void updateBlock(String blockCode, List<String> newRooms, String newDesc) throws InvalidControlException {
    }

    /**
     * Deletes a block by its code.
     * 
     * @param blockCode block code
     * @throws InvalidControlException if block not found
     */
    public void deleteBlock(String blockCode) throws InvalidControlException {
    }

    // ===================
    // R3: Sensor to Room
    // ===================

    /**
     * Installs a sensor in a classroom.
     * 
     * @param sensorId         unique sensor ID
     * @param roomName         room name
     * @param installationDate date in YYYY-MM-DD format
     * @param capabilities     sensor capabilities (e.g., TEMPERATURE, HUMIDITY)
     * @throws InvalidControlException if sensorId already exists or room is unknown
     */
    public void addSensorToRoom(String sensorId, String roomName, String installationDate,
            Set<SensorCapability> capabilities) throws InvalidControlException {
    }

    /**
     * Checks if a room has a sensor.
     * 
     * @param roomName room name
     * @return true if sensor installed
     */
    public boolean hasSensor(String roomName) {
        return false;
    }

    /**
     * Gets sensor info for a room.
     * 
     * @param roomName room name
     * @return sensorId and installation date
     * @throws InvalidControlException if room not found
     */
    public String getSensorInfo(String roomName) throws InvalidControlException {
        return null;
    }

    /**
     * Returns all room names with sensors.
     * 
     * @return collection of room names
     */
    public Collection<String> getAllSensorRooms() {
        return null;
    }

    /**
     * Returns rooms with sensors in a building.
     * 
     * @param buildingName name of the building
     * @return list of room names
     * @throws InvalidControlException if building unknown
     */
    public List<String> getSensorRoomsInBuilding(String buildingName) throws InvalidControlException {
        return null;
    }

    // ================
    // R4: File Reading
    // ================

    /**
     * Reads sensor definitions from a file and installs them in rooms.
     * (Additional helper method for reading sensor metadata before measurements)
     * 
     * @param sensorInfoFile file path with sensor metadata
     * @throws IOException
     * @throws InvalidControlException
     */
    public void readSensorInfos(String sensorInfoFile) throws IOException, InvalidControlException {
    }

    /**
     * Reads sensor readings from a text file.
     * Each line format: sensorId ; timestamp ; humidity? ; temperature?
     *
     * @param sensorReadingFile path to the file
     * @throws IOException
     * @throws InvalidControlException if format or sensor capabilities are violated
     */
    public void readSensorReadings(String sensorReadingFile) throws IOException, InvalidControlException {
    }

    // ============================
    // R5: Measurements & Analysis
    // ============================

    /**
     * Returns average temperature and humidity in a block.
     *
     * @param areaName name of the block
     * @return map with keys "temperature" and/or "humidity" and their values
     * @throws InvalidControlException if block not found
     */
    public Map<String, String> getBlockStats(String areaName) throws InvalidControlException {
        return null;
    }

    /**
     * Returns rooms in a block with high humidity over 2 hours (mean > 20 g/m³).
     *
     * @param areaName name of the area
     * @return list of too humid rooms
     * @throws InvalidControlException if block not found
     */
    public List<String> getTooHumidRooms(String areaName) throws InvalidControlException {
        return null;
    }

    /**
     * Returns rooms in a block with temperature > 30°C over 4 hours.
     *
     * @param areaName name of the area
     * @return list of too hot rooms
     * @throws InvalidControlException if block not found
     */
    public List<String> getTooColdRooms(String areaName) throws InvalidControlException {
        return null;
    }

    /**
     * Returns all rooms with at least one temperature reading today below a threshold.
     *
     * @param threshold temperature threshold (°C)
     * @return list of room names
     */
    public List<String> getFreezingRooms(double threshold) {
        return null;
    }

    /**
     * Returns number of broken sensors (those without measurements matching capabilities).
     *
     * @return number of broken sensors
     */
    public int getBrokenSensorsNumber() {
        return 0;
    }
}