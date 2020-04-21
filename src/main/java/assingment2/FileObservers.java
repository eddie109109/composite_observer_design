package assingment2;

import java.util.ArrayList;
import java.util.List;

public class FileObservers {
	
	private static FileObservers fileObserversInstance = null; 
	private static List<File> Files = new ArrayList<File>();
	
	
	public static FileObservers getInstance() 
    { 
        if (fileObserversInstance == null) 
        	fileObserversInstance = new FileObservers(); 
  
        return fileObserversInstance; 
    } 
	
	public void addObserveFiles(File fileTobeObservered) {
		Files.add(fileTobeObservered);
	}
	
	public void update() {
		for (int i = 0; i < Files.size(); i++) {
			if (Files.get(i).fileModified) {
				System.out.println("File /" + Files.get(i).name + " has been modified!!!");
				Files.get(i).fileModified = false; 
			}
		}
	}
	
	
	

}
