package assingment2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestDirectory{
	
	private Directory testDirectory;
	private File toBeAddedFile;
	private File toBeAddedFile2;
	private Directory toBeAddedDirectory;
	private String name;
	private String name1;
	private String name2;
	
	@Before
	public void initialize(){
		name = "bar222";
		name1 = "wwwbarwww";
		name2 = "xxxxxxxxx";
		testDirectory = new Directory("");
		toBeAddedDirectory = new Directory(name);
		toBeAddedFile = new File(name1,testDirectory);
		toBeAddedFile2 = new File(name2,testDirectory);
    }

	
	
	@Test
	public void testAddNode() {
		testDirectory = new Directory(name);
		toBeAddedFile = new File(name1,testDirectory);
		testDirectory.addNode(toBeAddedFile);
		
		int expected = 1;
		int actual = testDirectory.children.size();
		assertEquals("size of nodes is not increased to 1",expected, actual);
	}
	
	
	@Test
	public void testFind() {
		testDirectory.addNode(toBeAddedDirectory);
		testDirectory.addNode(toBeAddedFile);
		testDirectory.addNode(toBeAddedFile2);
		List<String> resultArrayList = testDirectory.find("bar");
		
		String[] actualArray = {"dummy1","dummy2","dummy3"};
		String[] expectedArray = {"bar222","/wwwbarwww","dummy3"};
		for (int i = 0; i < resultArrayList.size(); i++) {
			actualArray[i] = resultArrayList.get(i);
		}
		
		assertArrayEquals("the two arrays are not equal", actualArray, expectedArray);
		
	}
	
	

}
