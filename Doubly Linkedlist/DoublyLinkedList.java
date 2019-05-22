public class DoublyLinkedList{
    public Linkedlist head;

    public void Addatfront(int data){
        Linkedlist newnode=new Linkedlist(data);
        newnode.prev=null;
        newnode.next=head;
        if(head!=null){
            head.prev=newnode;
        }
        head=newnode;
    }
    public void Addatnode(Linkedlist prev_node,int data){
        Linkedlist newnode=new Linkedlist(data);
        newnode.next=prev_node.next;
        prev_node.next=newnode;
        newnode.prev=prev_node;
        if(prev_node.next!=null){
            newnode.next.prev=newnode;
        }
    }

    public void Addatend(int data){
        Linkedlist newnode=new Linkedlist(data);
        Linkedlist end=head;
        newnode.next=null;
        if(head==null){
           newnode.prev=null;
           head=newnode;
        }
        while(end.next!=null){
            end=end.next;
        }
        end.next=newnode;
        newnode.prev=end;
    }
    public void removeatfront(){
        head=head.next;
        head.prev=null;
    }
    public void removeatend(){
        Linkedlist node=head;

        while(node.next.next!=null){
            node=node.next;
        }
      node.next=null;
    }



    public void print(){
        Linkedlist last=null;
        System.out.println("Printing in the forward direction.....");
        Linkedlist node=head;
        while(node!=null){
            System.out.println(" "+node.val);
            last=node;
            node=node.next;
        }
        System.out.println("Printing in the backward direction.....");
        while(last!=null){
            System.out.println(""+last.val);
            last=last.prev;
        }

    }



}