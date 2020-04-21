package assingment2;

import java.util.List;

abstract class Node {
	 protected String name;
	 protected Directory parent;
	 
	 
	 Node(String name, Directory parent) {
		 this.name = name;
		 this.parent = parent;
		 
	 }
	 
	 public String getName() {
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
	 
	 
	 public abstract List<String> find(String s);
	 
}
