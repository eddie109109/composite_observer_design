package assingment2;

import static org.junit.Assert.*;

//import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestFile {

	private File testFile;
	private String name;
	private Directory p;
	
	@Before
    public void initialize(){
		name = "myName";
        testFile = new File(name, p);
    }

	
	
	@Test
	public void testConstructorAttribute() {
		boolean actual = testFile.fileModified;
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetName() {
		String expected = "myName";
		String actual = testFile.getName();
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testWriteAttribute() {
		String s = "dummyString";
		testFile.write(s);
		boolean actual = testFile.fileModified;
		boolean expected = true;
		assertEquals("attribute is not modififed when write is called",expected, actual);
	}
	
	@Test
	public void testFind() {	
		name = "myNameAndmore";
		testFile = new File(name, p);
		List<String> resultArrayList = testFile.find("myName"); 
		String expected = resultArrayList.get(0);
		String actual = "myNameAndmore";
		assertEquals("can't find the corret node",expected, actual);
	
	}
	
	
	
}
