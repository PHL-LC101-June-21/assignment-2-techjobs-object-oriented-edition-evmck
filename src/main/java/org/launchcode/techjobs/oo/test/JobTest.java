package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job testJobOne = new Job();
        Job testJobTwo = new Job();
        assertNotEquals(testJobOne, testJobTwo);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
    Job testerJob =
        new Job("Product tester", new Employer("ACME"),
        new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testerJob.getName() instanceof String);
        assertEquals("Product tester", testerJob.getName());

        assertTrue(testerJob.getEmployer() instanceof Employer);
        assertEquals("ACME", testerJob.getEmployer().getValue());

        assertTrue(testerJob.getLocation() instanceof Location);
        assertEquals("Desert", testerJob.getLocation().getValue());

        assertTrue(testerJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testerJob.getPositionType().getValue());

        assertTrue(testerJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testerJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job eqlJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job eqlJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(eqlJobOne.equals(eqlJobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job newLineJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String stringified = newLineJob.toString();
        char startC = stringified.charAt(0);
        char endsC = stringified.charAt(stringified.length() - 1);
        assertEquals(startC, '\n');
        assertEquals(endsC, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job dummy = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(dummy.toString(), "\n" + "ID: " + dummy.getId()
                + "\n" + "Name: " + "Product tester"
                + "\n" + "Employer: " + "ACME"
                + "\n" + "Location: " + "Desert"
                + "\n" + "Position Type: " +"Quality control"
                + "\n" + "Core Competency: " + "Persistence"
                + "\n");
    }
    public void testToStringHandlesEmptyField(){
        Job unqualified = new Job("Thing Doer", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String stringfied = unqualified.toString();
        String idealOutput =  "\n" + "ID: " + unqualified.getId()
                + "\n" + "Name: Thing Doer"
                + "\n" + "Employer: Data not available"
                + "\n" + "Location: Data not available"
                + "\n" + "Position Type: Data not available"
                + "\n" + "Core Competency: Data not available"
                + "\n";
        assertEquals(stringfied,idealOutput);
    }


}