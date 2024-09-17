package july;

public class LargestBST {

	static int largestBst(Node root)
    {
       
    return help(root).maxSize;
    }
    
    static NodeValue help(Node root){
        if(root== null){
            NodeValue temp =  new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
            return temp;
        }
        NodeValue left = help(root.left);
        NodeValue right = help(root.right);
        if(left.maxVal < root.data && root.data < right.minVal){
           NodeValue temp = new NodeValue(Math.min(root.data,left.minVal),Math.max(root.data,right.maxVal),left.maxSize+right.maxSize +1);
           return temp;
        } 
        
        NodeValue temp = new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize,right.maxSize));
        return temp;
        
    }
    
}
class NodeValue{
    int maxVal,minVal,maxSize;
    public NodeValue(int minVal, int maxVal ,int maxSize ){
        this.minVal= minVal;
        this.maxVal= maxVal;
        this.maxSize = maxSize;
    }
}