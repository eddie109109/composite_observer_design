package assingment2;

import java.util.ArrayList;
import java.util.List;

public class File extends Node{
	
	protected boolean fileModified;

	 File(String n, Directory p){
			 super(n,p);			 
			 fileModified = false;
	 }
	 
	 
	 public List<String> find(String s){
	  List<String> result = new ArrayList<String>();
	 
	  if (name.indexOf(s) != -1){
		  
		  result.add(this.getName());
	  
	  }
	 
	  return result;
	 }
	 
	 
	 public void write(String s) {
		  fileModified = true;
		  System.out.println("written '" + s + "' to the file: /" + name);
		  FileObservers.getInstance().update();
	  }
}
