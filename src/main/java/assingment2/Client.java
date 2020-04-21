
package assingment2;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		
		
		// below is the manual test for assignment 2: 
		// the tree structure I am creating is:
		//          root
		//        /        \
		//    core        usr 
		//             /  | | \    \
		//         adm  foo |  xbar2 yybarzz3
		//              /   |
		//           xbar3 bar1
		//            /
		//          yyybarxxx
		                    
		 Directory root = new Directory("");
		 Directory usr = new Directory("usr", root);
		 File core = new File("core", root);
		 File adm = new File("adm", usr);
		 Directory foo = new Directory("foo", usr);
		 File bar1 = new File("bar1", usr);
		 File xbar2 = new File("xbar2", usr);
		 Directory xbar3 = new Directory("xbar3",foo);
		 Directory yybarzz3 = new Directory("yybarzz3", usr);
		 File yyybarxxx = new File("yyybarxxx",xbar3);
		 
		 root.addNode(core);
		 root.addNode(usr);
		 usr.addNode(adm);
		 usr.addNode(foo);
		 usr.addNode(xbar2);
		 usr.addNode(yybarzz3);
		 usr.addNode(bar1);
		 foo.addNode(xbar3);
		 xbar3.addNode(yyybarxxx);
		 
		 String target = "bar";
		 System.out.println("All the file paths that contain the string name '" + target + "' are:");
		 System.out.println(root.find(target));
		 System.out.println(""); 
	
		 
		 
		 FileObservers.getInstance().addObserveFiles(bar1);
		 FileObservers.getInstance().addObserveFiles(xbar2);
		 bar1.write("How are you?");
		 xbar2.write("How are you doing?");
		 System.out.println("");
		 
		 // FileObserver has not added these files, therefore no warning is sent for these two modified files
		 adm.write("How are you all doing?");
		 core.write("How are you doing my friend?");
		 System.out.println("");
		 
		 
		 
		 // below is the manual test for assignment 3: file system
		 // the tree structure I am creating is like the following:
		 //           root1/
		 //       /      |       \
		 //   dir1/     dir2/   file1.txt
		 //    |        |
		 // file2.pdf   dir3/
		 //             |
		 //             file3.png
		 

		 
		 // after calling import, all the file paths should be established
		 FileSystem fileSystem = new FileSystem();
		 fileSystem.Import("src/main/resources/importFile.txt");
		 
		 String target1 = "fil";
		 System.out.println("All the file paths that contain the string name '" + target1 + "' are:");
		 System.out.println(fileSystem.returnHeadDirectory().find(target1));

	}

}
