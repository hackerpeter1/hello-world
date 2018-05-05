package solution;
import java.util.*;

import jigsaw.JigsawNode;

public class debug {
	public static void main(String[] args) {
		Deque<JigsawNode> open = new LinkedList<JigsawNode>();
		
		open.addLast(new JigsawNode(new int[]{9,1,2,3,4,5,6,7,8,0}) );
		open.addLast(new JigsawNode(new int[]{9,2,1,3,4,5,6,7,8,0}) );
		open.pop();
		System.out.println(open);
	}
}
