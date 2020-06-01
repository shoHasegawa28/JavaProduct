public class TreeMgr{
  private Node head;
  private int max;
  private int point;

  public TreeMgr(int s,int p){
    head = new Node(s);
    point = p;
    max = 0;
  }

  public void allTreeData(){
    addTreeData();
    //showData(head);
    System.out.println(max);
  }

  private void showData(Node t){
    if(t == null){
      return ;
    }
    System.out.println(t.getNodeData());
    showData(t.getLeftNode());
    showData(t.getRightNode());

    return ;
  }

  public void addTreeData(){
    subAddTreeData(head,3);
  }

  public Node subAddTreeData(Node t,int p){
    if(max < t.getNodeData()){
      max = t.getNodeData();
    }

    if(p == 0){
      return t;
    }
    t.setLeftNode(subAddTreeData(new Node(t.getNodeData() * (100 + 1)/100),p-1));
    if(p != 1){
      t.setRightNode(subAddTreeData(new Node(t.getNodeData() * (100 + p)/100),0));
    }

    return t;
  }
}
