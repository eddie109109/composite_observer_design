package assingment2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestFileObservers {

	private static FileObservers fileObserversInstance = null;
	private static List<File> Files = new ArrayList<File>();
	private File toBeAddedFile;
	private File testUpdateFile;
	private Directory dummyParent;
	
	@Test
	public void testGetInstance() {
		fileObserversInstance = FileObservers.getInstance();
		assertNotEquals("Instance has not been instantiated",fileObserversInstance,null);
	}
	
	@Test
	public void testAddObserverFiles() {
		Files.add(toBeAddedFile);
		Files.add(toBeAddedFile);
		Files.add(toBeAddedFile);
		int acutalSizeOfList = Files.size();
		int expectedSizeOfList = 3;
		assertEquals("Number files mismatched", acutalSizeOfList,expectedSizeOfList);
	}
	

	@Test
	public void testUpdate() {
		testUpdateFile = new File("dummy",dummyParent);
		testUpdateFile.write("changeToTrue");
		FileObservers.getInstance().addObserveFiles(testUpdateFile);
		FileObservers.getInstance().update(); // change back to false;
		
		boolean expected = false;
		boolean actual = testUpdateFile.fileModified;
		assertEquals("fileModified attribute has not been changed",expected, actual);
	}
	
	
}
