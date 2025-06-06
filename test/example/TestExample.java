package example;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import it.polito.temperatureControl.InvalidControlException;
import it.polito.temperatureControl.Control;
import it.polito.temperatureControl.SensorCapability;


public class TestExample {

  
  @Test
    public void testBuildingAndBlocks() throws InvalidControlException {
        Control ctrl = new Control("Politecnico di Torino");

        assertEquals("Politecnico di Torino", ctrl.getName());

        // Create building
        ctrl.createBuilding("B01", "Sede Centrale", "Sede centrale measurements");
        ctrl.createBuilding("B02", "Cittadella", "Cittadella measurements");

        List<String> buildings = ctrl.getBuildings();
        assertEquals(2, buildings.size());
        assertTrue(buildings.contains("B01"));
        assertTrue(buildings.contains("B02"));

        // Update building
        ctrl.updateBuilding("B01", "Valentino", "Measurements sede del Valentino");

        // Delete building
        ctrl.deleteBuilding("B02");

        buildings = ctrl.getBuildings();
        assertEquals(1, buildings.size());
        assertTrue(buildings.contains("B01"));
    }

    @Test
    public void testBlocksAndRooms() throws InvalidControlException {
        Control ctrl = new Control("UniTest");

        ctrl.createBuilding("B01", "Test Building", "A test building");

        List<String> roomNames = Arrays.asList("R1", "R2", "R3");
        ctrl.createBlock("B01", "R", roomNames, "Block R classrooms");

        List<String> blocks = ctrl.getBlocks("B01");
        assertEquals(1, blocks.size());
        assertTrue(blocks.contains("R"));
    }

    @Test
    public void testSensorInstallation() throws InvalidControlException {
        Control ctrl = new Control("Sensor Uni");

        ctrl.createBuilding("B01", "Building 1", "B1 Desc");
        List<String> rooms = Arrays.asList("RoomA", "RoomB");
        ctrl.createBlock("B1", "Block1", rooms, "Block with rooms");

        Set<SensorCapability> caps = new HashSet<>();
        caps.add(SensorCapability.TEMPERATURE);
        ctrl.addSensorToRoom("S1", "RoomA", "2023-06-01", caps);

        assertTrue(ctrl.hasSensor("RoomA"));
        assertFalse(ctrl.hasSensor("RoomB"));

        String info = ctrl.getSensorInfo("RoomA");
        assertNotNull(info);
        assertTrue(info.contains("S1"));

        Collection<String> sensorRooms = ctrl.getAllSensorRooms();
        assertEquals(1, sensorRooms.size());
        assertTrue(sensorRooms.contains("RoomA"));

        List<String> sensorRoomsInBuilding = ctrl.getSensorRoomsInBuilding("Building 1");
        assertEquals(1, sensorRoomsInBuilding.size());
        assertTrue(sensorRoomsInBuilding.contains("RoomA"));
    }

    /**
     * Create a new temporary file and write the content
     * @param content content of the file
     * @return the path of the new file.
     * @throws IOException in case of file writing error
     */
    private static String writeFile(String content) throws IOException {          
            File f = File.createTempFile("off","txt");
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(content.getBytes());
            fos.close();
            return f.getAbsolutePath();
    }
}
