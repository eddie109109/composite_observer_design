package assingment2;

import java.util.ArrayList;
import java.util.List;


public class Directory extends Node {

	protected List<Node> children;

	Directory(String n){ 
		this(n, null); 
		children = new ArrayList<Node>();
	}
	
 	Directory(String n, Directory parent){
 		super(n, parent);
 		children = new ArrayList<Node>();
		
 	}
	 	
	 public String getName(){
		 if(parent == null) {
			 return name;
		 }

	     return parent.getName() + "/" + name;
	    
	 }
	 
	 public String getParentName() {
		 if (parent == null) {
			 return null;
		 }
		 return parent.getName();
	 }
	 
	 public void addNode(Node n){
			 children.add(n);		 
	 }
	 
	 public List<String> find(String s){
		 List<String> result = new ArrayList<String>();
		 if (name.indexOf(s) != -1){
			 
		 result.add(this.getName());
		 
		 }
		 for (Node child : children){
			 
		 result.addAll(child.find(s));
		 
		 }
		 return result;
	 }
	 
	
}

