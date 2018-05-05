package solution;

import java.util.*;
import jigsaw.Jigsaw;
import jigsaw.JigsawNode;
import sun.misc.Queue;


/**
 * 在此类中填充算法，完成重拼图游戏（N-数码问题）
 */
public class Solution extends Jigsaw {
	private Deque<JigsawNode> open;
	private Set<JigsawNode> close;
    /**
     * 拼图构造函数
     */
    public Solution() {
    }

    /**
     * 拼图构造函数
     * @param bNode - 初始状态节点
     * @param eNode - 目标状态节点
     */
    public Solution(JigsawNode bNode, JigsawNode eNode) {
        super(bNode, eNode);
    }
    
    /**
     * 遍历JigSaw是否已经在close中存在
     * @param node
     * @return 如果存在返回true，如果不存在返回false
     */

    /**
     *（实验一）广度优先搜索算法，求指定5*5拼图（24-数码问题）的最优解
     * 填充此函数，可在Solution类中添加其他函数，属性
     * @param bNode - 初始状态节点
     * @param eNode - 目标状态节点
     * @return 搜索成功时为true,失败为false
     */
    
    public boolean BFSearch(JigsawNode bNode, JigsawNode eNode) {
        open = new LinkedList<JigsawNode>();
        close = new HashSet<JigsawNode>();
        this.currentJNode = new JigsawNode(bNode);
        this.setBeginJNode(bNode);
        this.setEndJNode(eNode);
        //放入第一个节点
        open.push(this.currentJNode);
        close.add(this.currentJNode);
        //开始循环
        int time = 0;
        while(!open.isEmpty()) {
        	time ++;
        	this.currentJNode = open.peek();
        	if(open.peek().equals(eNode)) {
        		// 输出到控制台
        		System.out.println("Jigsaw AStar Search Result:");
                System.out.println("Begin state:" + this.getBeginJNode().toString());
                System.out.println("End state:" + this.getEndJNode().toString());
                System.out.println("Solution Path: ");
                this.getPath();
                System.out.println(this.getSolutionPath());
                System.out.println("Total number of searched nodes:" + time);
                System.out.println("Depth of the current node is:" + this.getCurrentJNode().getNodeDepth());
        		return true;
        	}
        	//将临界节点添加到队列中去
        	if(open.peek().canMoveEmptyDown()) {    //下
        		JigsawNode tmp = new JigsawNode(open.peek());
        		tmp.moveEmptyDown();
        		if(!close.contains(tmp)) {
        			open.addLast(tmp);
        			close.add(tmp);
        		}
        	}
        	if(open.peek().canMoveEmptyUp()) {    //上
        		JigsawNode tmp = new JigsawNode(open.peek());
        		tmp.moveEmptyUp();
        		if(!close.contains(tmp)) {
        			open.addLast(tmp);
        			close.add(tmp);
        		}
        	}
        	if(open.peek().canMoveEmptyLeft()) {    //左
        		JigsawNode tmp = new JigsawNode(open.peek());
        		tmp.moveEmptyLeft();
        		if(!close.contains(tmp)) {
        			open.addLast(tmp);
        			close.add(tmp);
        		}
        	}
        	if(open.peek().canMoveEmptyRight()) {      //右
        		JigsawNode tmp = new JigsawNode(open.peek());
        		tmp.moveEmptyRight();
        		if(!close.contains(tmp)) {
        			open.addLast(tmp);
        			close.add(tmp);
        		}
        	}
        	//从open列表中删除节点v，放入close列表中
        	open.pop();
        }
        return false;
    }
    

    /**
     *（Demo+实验二）计算并修改状态节点jNode的代价估计值:f(n)
     * 如 f(n) = s(n). s(n)代表后续节点不正确的数码个数
     * 此函数会改变该节点的estimatedValue属性值
     * 修改此函数，可在Solution类中添加其他函数，属性
     * @param jNode - 要计算代价估计值的节点
     */
    public void estimateValue(JigsawNode jNode) {
        int a = 0; // 后续节点不正确的数码个数
        int dimension = JigsawNode.getDimension();
        for (int index = 1; index < dimension * dimension; index++) {
            if (jNode.getNodesState()[index] + 1 != jNode.getNodesState()[index + 1]) {
                a++;
            }
        }
		int b = 0;
		for (int i = 1; i < dimension * dimension; i++) {
			if (jNode.getNodesState()[i] != i) {
				b++;
			}
		}
		
		int c = 0;
		for (int i = 1; i <= dimension * dimension; i++) {
			int num = jNode.getNodesState()[i];
			if (num != i && num != 0) {
				double x1 = (num - 1) % dimension;
				double y1 = (num - 1) / dimension;
				double x2 = (i - 1) % dimension;
				double y2 = (i - 1) / dimension;
				c += (int)Math.sqrt(Math.abs(x1 - x2) + Math.abs(y1 - y2));
			}
}
        jNode.setEstimatedValue(a+c*c);
    }
}
