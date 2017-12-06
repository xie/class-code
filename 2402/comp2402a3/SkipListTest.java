import java.util.Scanner;

class SkipNode {
  int element;
  SkipNode right;
  SkipNode down;

  public SkipNode(int x) {
    this(x, null, null);
  }

  public SkipNode(int x, SkipNode rt, SkipNode dt) {
    element = x;
    right = rt;
    down = dt;
  }
}

class SkipList {
  private SkipNode header;
  private int infinity;
  private SkipNode bottom = null;
  private SkipNode tail = null;

  public SkipList(int inf) {
    infinity = inf;
    bottom = new SkipNode(0);
    bottom.right = bottom.down = bottom;
    tail = new SkipNode(infinity);
    tail.right = tail;
    header = new SkipNode(infinity, tail, bottom);
  }

  public void insert(int x) {
    SkipNode current = header;
    bottom.element = x;
    while (current != bottom)
    {
        while (current.element < x) {
          current = current.right;
        }
        if (current.down.right.right.element < current.element)
        {
            current.right = new SkipNode(current.element, current.right, current.down.right.right);
            current.element = current.down.right.element;
        } else {
            current = current.down;
        }
    }

    if (header.right != tail) {
      header = new SkipNode(infinity, tail, header);
    }
  }

  public void makeEmpty() {
    header.right = tail;
    header.down = bottom;
  }

  public boolean isEmpty() {
    return header.right == tail && header.down == bottom;
  }

  private int element(SkipNode t) {
    return t == bottom ? 0 : t.element;
  }

  public void printList() {
    System.out.print("\nSkiplist = ");
    SkipNode current = header;
    while( current.down != bottom ) {
      current = current.down;
    }
    while (current.right != tail ) {
      System.out.print(current.element +" ");
      current = current.right;
    }
    System.out.println();
  }
}

public class SkipListTest {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
        SkipList list = new SkipList(10000);
        for (int i = 0; i < 10000; i++) {
          list.insert(i);
        }
        list.printList();
  }
}
