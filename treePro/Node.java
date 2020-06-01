public class Node{
  private int data;
  private Node left;
  private Node right;

  public Node(int n){
    this.data = n;
    this.left = null;
    this.right = null;
  }

  public int getNodeData(){
    return this.data;
  }

  public void setLeftNode(Node l){
    this.left = l;
  }

  public void setRightNode(Node r){
    this.right = r;
  }

  public Node getRightNode(){
    if(this.right != null){
      return this.right;
    }
    return null;
  }

  public Node getLeftNode(){
    if(this.left != null){
      return this.left;
    }
    return null;
  }
}
