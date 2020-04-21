package assingment2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestFileSystem {
	
	private FileSystem fileSystem;
	
	@Before
	public void initialize(){
		fileSystem = new FileSystem();
	}
	
	@Test
	public void testReturnHeadDirectory() {
		Directory head = fileSystem.returnHeadDirectory();
		assertNotNull(head);
	}
	
	
	@Test
	public void testImportDifferentString1() {
		fileSystem.Import("src/main/resources/importFile.txt");
		List<String> list = fileSystem.returnHeadDirectory().find("dir3");
		String actual = list.get(0);
		String expected = "root/dir2/dir3";
		assertEquals(actual,expected);
	}
	
	@Test
	public void testImportDifferentString2() {
		fileSystem.Import("src/main/resources/importFile.txt");
		List<String> list = fileSystem.returnHeadDirectory().find("file1");
		String actual = list.get(0);
		String expected = "root/file1.txt";
		assertEquals(actual,expected);
	}
	
	@Test
	public void testImportDifferentString3() {
		fileSystem.Import("src/main/resources/importFile.txt");
		List<String> list = fileSystem.returnHeadDirectory().find("file2");
		String actual = list.get(0);
		String expected = "root/dir1/file2.pdf";
		assertEquals(actual,expected);
	}

}
