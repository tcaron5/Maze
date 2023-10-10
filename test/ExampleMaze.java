import tester.Tester;

import java.util.*;

import org.junit.Assert;

import org.junit.Test;


/**
 * Tests for the maze.
 */
public class ExampleMaze {

  Maze mSmall = new Maze(20, 20);

  Maze m = new Maze(60, 60);

  Maze mLarge = new Maze(80, 80);


  @Test
  public void testGetWalls() {
    Assert.assertEquals(m.makeOutOfBounds(m.mazeVertex, m.allEdges), m.walls);
    Assert.assertEquals(mSmall.makeOutOfBounds(mSmall.mazeVertex, mSmall.allEdges), mSmall.walls);
    Assert.assertEquals(mLarge.makeOutOfBounds(mLarge.mazeVertex, mLarge.allEdges), mLarge.walls);

  }

  @Test
  public void testKruskalAlg() {
    Assert.assertEquals(m.kruskalAlg(m.mazeVertex), m.mazeVertex);
    Assert.assertEquals(mSmall.kruskalAlg(mSmall.mazeVertex), mSmall.mazeVertex);
    Assert.assertEquals(mLarge.kruskalAlg(mLarge.mazeVertex), mLarge.mazeVertex);

  }

  @Test
  public void testMakeScene() {
    Assert.assertEquals(m.makeScene(), m.makeScene());
    Assert.assertEquals(mSmall.makeScene(), mSmall.makeScene());
    Assert.assertEquals(mLarge.makeScene(), mLarge.makeScene());
  }

  @Test
  public void testIsEmpty() {
    Assert.assertFalse(new ConsLo<String>("Hello", new MtLo<>()).isEmpty());
    Assert.assertTrue(new MtLo<String>().isEmpty());
    Assert.assertFalse(new ConsLo<String>("Hello",
            new ConsLo<String>("World", new MtLo<String>())).isEmpty());
  }

  @Test
  public void testLen() {
    Assert.assertEquals(new ConsLo<String>("Hello", new ConsLo<String>("World",
            new MtLo<String>())).length(), 2);
    Assert.assertEquals(new ConsLo<String>("Hello", new MtLo<String>()).length(), 1);
    Assert.assertEquals(new MtLo<String>().length(), 0);
  }

  @Test
  public void testIterator() {
    IList<String> list = new ConsLo<String>("Hello",
            new ConsLo<String>("World", new ConsLo<String>("!", new MtLo<String>())));
    Iterator<String> iter = list.iterator();
    Assert.assertTrue(iter.hasNext());
    Assert.assertEquals(iter.next(), "Hello");
    Assert.assertTrue(iter.hasNext());
    Assert.assertEquals(iter.next(), "World");
    Assert.assertTrue(iter.hasNext());
    Assert.assertEquals(iter.next(), "!");
    Assert.assertFalse(iter.hasNext());
    Assert.assertThrows(NoSuchElementException.class, iter::next);
  }

  @Test
  public void testAdd() {
    IList<String> list = new MtLo<String>();
    Assert.assertEquals(list.add("Hello"), new ConsLo<String>("Hello", new MtLo<String>()));
    Assert.assertEquals(list.add("Hello").add("World"),
            new ConsLo<String>("Hello", new ConsLo<String>("World", new MtLo<String>())));
    Assert.assertEquals(list.add("Hello").add("World").add("!"),
            new ConsLo<String>("Hello", new ConsLo<String>("World",
                    new ConsLo<String>("!", new MtLo<String>()))));
  }

  @Test
  public void testGet() {
    IList<String> list = new ConsLo<String>("Hello",
            new ConsLo<String>("World", new ConsLo<String>("!", new MtLo<String>())));
    Assert.assertEquals(list.get(0), "Hello");
    IList<String> emptyList = new MtLo<String>();
    Assert.assertNull(emptyList.get(0));
  }

  @Test
  public void testGetData() {
    IList<String> list = new ConsLo<String>("Hello",
            new ConsLo<String>("World", new ConsLo<String>("!", new MtLo<String>())));
    Assert.assertEquals(list.getData(), "Hello");
    IList<String> emptyList = new MtLo<String>();
    Assert.assertNull(emptyList.getData());
  }

  @Test
  public void testGetNext() {
    IList<String> list = new ConsLo<String>("Hello",
            new ConsLo<String>("World", new ConsLo<String>("!", new MtLo<String>())));
    IList<String> list2 = new ConsLo<String>("Hello", new MtLo<String>());
    Assert.assertEquals(list.next(), new ConsLo<String>("World",
            new ConsLo<String>("!", new MtLo<String>())));
    Assert.assertEquals(list2.next(), new MtLo<String>());
  }

  @Test
  public void testSort() {
    ArrayList<Edge> edgeList = new ArrayList<>();
    ArrayList<Edge> unsortedEdgeList = new ArrayList<>();
    ArrayList<Edge> edgeList2 = new ArrayList<>();
    ArrayList<Edge> unsortedEdgeList2 = new ArrayList<>();
    ArrayList<Edge> edgeList3 = new ArrayList<>();
    ArrayList<Edge> unsortedEdgeList3 = new ArrayList<>();

    Edge e1 = new Edge(null, null, 1);
    Edge e2 = new Edge(null, null, 3);
    Edge e3 = new Edge(null, null, 4);
    Edge e4 = new Edge(null, null, 7);
    Edge e5 = new Edge(null, null, 2);

    edgeList2.add(e1);
    edgeList2.add(e2);
    edgeList2.add(e3);

    edgeList3.add(e1);
    edgeList3.add(e2);

    edgeList.add(e1);
    edgeList.add(e5);
    edgeList.add(e2);
    edgeList.add(e3);
    edgeList.add(e4);

    unsortedEdgeList.add(e1);
    unsortedEdgeList.add(e2);
    unsortedEdgeList.add(e3);
    unsortedEdgeList.add(e4);
    unsortedEdgeList.add(e5);

    unsortedEdgeList2.add(e1);
    unsortedEdgeList2.add(e3);
    unsortedEdgeList2.add(e2);

    unsortedEdgeList3.add(e2);
    unsortedEdgeList3.add(e1);


    Assert.assertEquals(m.sort(unsortedEdgeList), edgeList);
    Assert.assertEquals(m.sort(unsortedEdgeList2), edgeList2);
    Assert.assertEquals(m.sort(unsortedEdgeList3), edgeList3);
  }

  @Test

  public void testCombine() {

    ArrayList<Edge> edgeList = new ArrayList<>();
    ArrayList<Edge> edgeList4 = new ArrayList<>();
    ArrayList<Edge> edgeList2 = new ArrayList<>();
    ArrayList<Edge> edgeList5 = new ArrayList<>();
    ArrayList<Edge> edgeList3 = new ArrayList<>();
    ArrayList<Edge> edgeList6 = new ArrayList<>();
    ArrayList<Edge> edgeList7 = new ArrayList<>();
    ArrayList<Edge> edgeList8 = new ArrayList<>();
    ArrayList<Edge> edgeList9 = new ArrayList<>();

    Edge e1 = new Edge(null, null, 1);
    Edge e2 = new Edge(null, null, 3);
    Edge e3 = new Edge(null, null, 4);
    Edge e4 = new Edge(null, null, 7);
    Edge e5 = new Edge(null, null, 2);

    edgeList.add(e1);
    edgeList5.add(e2);

    edgeList6.add(e1);
    edgeList6.add(e2);


    edgeList2.add(e1);
    edgeList2.add(e2);
    edgeList3.add(e3);

    edgeList4.add(e1);
    edgeList4.add(e2);
    edgeList4.add(e3);

    edgeList7.add(e1);
    edgeList7.add(e2);
    edgeList7.add(e3);
    edgeList7.add(e4);
    edgeList8.add(e5);

    edgeList9.add(e1);
    edgeList9.add(e5);
    edgeList9.add(e2);
    edgeList9.add(e3);
    edgeList9.add(e4);


    Assert.assertEquals(m.combine(edgeList2, edgeList3), edgeList4);
    Assert.assertEquals(m.combine(edgeList, edgeList5), edgeList6);
    Assert.assertEquals(m.combine(edgeList7, edgeList8), edgeList9);

  }

  @Test
  public void testKruskalHelpFind() {
    HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
    Maze maze2 = new Maze(10, 10);
    hashmap.put(1, 1);
    hashmap.put(2, 1);
    hashmap.put(3, 2);
    hashmap.put(4, 3);
    hashmap.put(5, 4);
    hashmap.put(6, 6);
    hashmap.put(7, 6);


    Assert.assertEquals(maze2.kruskalHelpFind(hashmap, 1), 1);
    Assert.assertEquals(maze2.kruskalHelpFind(hashmap, 2), 1);
    Assert.assertEquals(maze2.kruskalHelpFind(hashmap, 3), 1);
    Assert.assertEquals(maze2.kruskalHelpFind(hashmap, 4), 1);
    Assert.assertEquals(maze2.kruskalHelpFind(hashmap, 5), 1);
    Assert.assertEquals(maze2.kruskalHelpFind(hashmap, 6), 6);
    Assert.assertEquals(maze2.kruskalHelpFind(hashmap, 7), 6);
  }


  @Test
  public void testVertexNum() {
    Assert.assertEquals(mSmall.mazeVertex.get(0).get(0).vertexNum(), 0);
    Assert.assertEquals(mSmall.mazeVertex.get(1).get(0).vertexNum(), 1);
    Assert.assertEquals(mSmall.mazeVertex.get(0).get(1).vertexNum(), 1000);
    Assert.assertEquals(mSmall.mazeVertex.get(1).get(1).vertexNum(), 1001);
    Assert.assertEquals(mSmall.mazeVertex.get(2).get(2).vertexNum(), 2002);
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(mSmall.mazeVertex.get(0).get(0).equals(mSmall.mazeVertex.get(0).get(0)), true);
    Assert.assertEquals(mSmall.mazeVertex.get(1).get(0).equals(mSmall.mazeVertex.get(0).get(0)), false);
    Assert.assertEquals(mSmall.mazeVertex.get(0).get(1).equals(mSmall.mazeVertex.get(0).get(0)), false);
    Assert.assertEquals(mSmall.mazeVertex.get(1).get(1).equals(mSmall.mazeVertex.get(0).get(0)), false);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(mSmall.mazeVertex.get(0).get(0).hashCode(), 0);
    Assert.assertEquals(mSmall.mazeVertex.get(1).get(0).hashCode(), 1);
    Assert.assertEquals(mSmall.mazeVertex.get(0).get(1).hashCode(), 1000);
    Assert.assertEquals(mSmall.mazeVertex.get(1).get(1).hashCode(), 1001);
    Assert.assertEquals(mSmall.mazeVertex.get(2).get(2).hashCode(), 2002);
  }

  @Test
  public void testOnKeyEvent() {
    mSmall.bfsPressed = false;
    mSmall.dfsPressed = false;
    mSmall.userTurn = false;

    mSmall.onKeyEvent("m");
    Assert.assertTrue(mSmall.userTurn);
    Assert.assertFalse(mSmall.bfsPressed);
    Assert.assertFalse(mSmall.dfsPressed);
    mSmall.onKeyEvent("b");
    Assert.assertFalse(mSmall.userTurn);
    Assert.assertTrue(mSmall.bfsPressed);
    Assert.assertFalse(mSmall.dfsPressed);
    mSmall.onKeyEvent("t");
    Assert.assertTrue(mSmall.toggle);
    mSmall.onKeyReleased("t");
    Assert.assertFalse(mSmall.toggle);
    mSmall.onKeyEvent("d");
    Assert.assertFalse(mSmall.userTurn);
    Assert.assertFalse(mSmall.bfsPressed);
    Assert.assertTrue(mSmall.dfsPressed);
    mSmall.onKeyEvent("m");
    mSmall.onKeyEvent("up");
    Assert.assertTrue(mSmall.userPressedUp);
    Assert.assertFalse(mSmall.userPressedDown);
    Assert.assertFalse(mSmall.userPressedLeft);
    Assert.assertFalse(mSmall.userPressedRight);
    mSmall.onKeyEvent("down");
    Assert.assertFalse(mSmall.userPressedUp);
    Assert.assertTrue(mSmall.userPressedDown);
    Assert.assertFalse(mSmall.userPressedLeft);
    Assert.assertFalse(mSmall.userPressedRight);
    mSmall.onKeyEvent("left");
    Assert.assertFalse(mSmall.userPressedUp);
    Assert.assertFalse(mSmall.userPressedDown);
    Assert.assertTrue(mSmall.userPressedLeft);
    Assert.assertFalse(mSmall.userPressedRight);
    mSmall.onKeyEvent("right");
    Assert.assertFalse(mSmall.userPressedUp);
    Assert.assertFalse(mSmall.userPressedDown);
    Assert.assertFalse(mSmall.userPressedLeft);
    Assert.assertTrue(mSmall.userPressedRight);
    mSmall.onKeyEvent("r");
    Assert.assertFalse(mSmall.bfsPressed);
    Assert.assertFalse(mSmall.dfsPressed);
    Assert.assertFalse(mSmall.userTurn);
    Assert.assertFalse(mSmall.solvedMaze);
  }

  @Test
  public void testReset() {
    mSmall.bfsPressed = true;
    mSmall.reset();
    Assert.assertFalse(mSmall.bfsPressed);
    mSmall.dfsPressed = true;
    mSmall.reset();
    Assert.assertFalse(mSmall.dfsPressed);
    mSmall.userTurn = true;
    mSmall.reset();
    Assert.assertFalse(mSmall.userTurn);
    mSmall.solvedMaze = true;
    mSmall.reset();
    Assert.assertFalse(mSmall.solvedMaze);
    mSmall.height = 10;
    mSmall.width = 10;
    mSmall.reset();
    Assert.assertEquals(mSmall.height, 10);
    Assert.assertEquals(mSmall.width, 10);
    mSmall.userPressedUp = true;
    mSmall.reset();
    Assert.assertFalse(mSmall.userPressedUp);
    mSmall.userPressedDown = true;
    mSmall.reset();
    Assert.assertFalse(mSmall.userPressedDown);
    mSmall.userPressedLeft = true;
    mSmall.reset();
    Assert.assertFalse(mSmall.userPressedLeft);
    mSmall.userPressedRight = true;
    mSmall.reset();
    Assert.assertFalse(mSmall.userPressedRight);


  }

  @Test
  public void testGetVertex() {
    ArrayList<ArrayList<Vertex>> vertices = new ArrayList<>();
    for (int x = 0; x < mSmall.width; x++) {
      ArrayList<Vertex> v = new ArrayList<>();
      for (int y = 0; y < mSmall.height; y++) {
        v.add(new Vertex(x, y));
      }
      vertices.add(v);

      Assert.assertEquals(mSmall.getVertex(), mSmall.vertices);
    }

  }

  @Test
  public void testReconstructs() {
    HashMap<String, Edge> hashmap = new HashMap<String, Edge>();
    mSmall.rightMovesCount = 0;
    mSmall.endCurrent = mSmall.mazeVertex.get(0).get(0);
    mSmall.reconstruct(hashmap);
    Assert.assertEquals(mSmall.endCurrent, mSmall.mazeVertex.get(0).get(0));
    mSmall.rightMovesBFS = 0;
    mSmall.endCurrentBFS = mSmall.mazeVertex.get(0).get(0);
    mSmall.reconstructBFS(hashmap);
    Assert.assertEquals(mSmall.endCurrentBFS, mSmall.mazeVertex.get(0).get(0));
    mSmall.userStart = mSmall.mazeVertex.get(0).get(0);
    Assert.assertEquals(mSmall.endCurrentBFS, mSmall.mazeVertex.get(0).get(0));

  }

  @Test
  public void testOnTick() {
    mSmall.bfsPressed = true;
    mSmall.onTick();
    Assert.assertTrue(mSmall.bfsPressed);
    mSmall.dfsPressed = true;
    mSmall.onTick();
    Assert.assertTrue(mSmall.dfsPressed);
    mSmall.userTurn = true;
    mSmall.onTick();
    Assert.assertTrue(mSmall.userTurn);
    mSmall.height = 10;
    mSmall.width = 10;
    mSmall.onTick();
    Assert.assertEquals(mSmall.height, 10);
    Assert.assertEquals(mSmall.width, 10);
    mSmall.onKeyEvent("down");
    mSmall.onTick();
    Assert.assertTrue(mSmall.userPressedDown);
    mSmall.onKeyEvent("up");
    mSmall.onTick();
    Assert.assertTrue(mSmall.userPressedUp);
    mSmall.onKeyEvent("left");
    mSmall.onTick();
    Assert.assertTrue(mSmall.userPressedLeft);
    mSmall.onKeyEvent("right");
    mSmall.onTick();
    Assert.assertTrue(mSmall.userPressedRight);
  }

  @Test
  public void testManualMode() {
    mSmall.userTurn = true;
    mSmall.userStart = mSmall.mazeVertex.get(mSmall.mazeVertex.size() - 5)
            .get(mSmall.mazeVertex.get(0).size() - 5);
    mSmall.userPressedUp = true;
    mSmall.manualMode();
    mSmall.userPressedUp = true;
    mSmall.manualMode();
    Assert.assertEquals(mSmall.solvedUser, false);
    mSmall.userPressedLeft = true;
    mSmall.manualMode();
    Assert.assertEquals(mSmall.solvedUser, false);
    mSmall.userPressedRight = true;
    mSmall.manualMode();
    Assert.assertEquals(mSmall.solvedUser, false);
    mSmall.userPressedDown = true;
    mSmall.manualMode();
    Assert.assertEquals(mSmall.solvedUser, false);

  }

  @Test
  public void testDfs() {
    Maze m = new Maze(5, 5);
    Stack<Vertex> stack = new Stack<Vertex>();
    stack.add(m.mazeVertex.get(0).get(0));
    m.onTick();
    m.solvedMaze = false;
    m.onKeyEvent("d");
    m.onTick();
    m.dfs(stack);
    m.onTick();
    stack.add(m.mazeVertex.get(0).get(1));
    m.dfs(stack);
    m.onTick();
    stack.add(m.mazeVertex.get(0).get(2));
    m.dfs(stack);
    m.onTick();
    stack.add(m.mazeVertex.get(4).get(4));

    Assert.assertTrue(m.visited.contains(m.mazeVertex.get(0).get(0)));
    Assert.assertTrue(m.visited.contains(m.mazeVertex.get(0).get(1)));
    Assert.assertTrue(m.visited.contains(m.mazeVertex.get(0).get(2)));
    Assert.assertFalse(m.visited.contains(m.mazeVertex.get(4).get(4)));


  }


  @Test
  public void testBfs() {
    Maze m = new Maze(5, 5);
    Queue<Vertex> queue = new LinkedList<Vertex>();
    queue.add(m.mazeVertex.get(0).get(0));
    m.onTick();
    m.onKeyEvent("b");
    m.onTick();
    m.bfs(queue);
    m.onTick();
    queue.add(m.mazeVertex.get(0).get(1));
    m.bfs(queue);
    m.onTick();
    queue.add(m.mazeVertex.get(0).get(2));
    m.bfs(queue);
    m.onTick();
    queue.add(m.mazeVertex.get(4).get(4));

    Assert.assertTrue(m.visitedBFS.contains(m.mazeVertex.get(0).get(0)));
    Assert.assertTrue(m.visitedBFS.contains(m.mazeVertex.get(0).get(1)));
    Assert.assertTrue(m.visitedBFS.contains(m.mazeVertex.get(0).get(2)));
    Assert.assertFalse(m.visited.contains(m.mazeVertex.get(4).get(4)));


  }

  @Test
  public void testReconstructBFS() {
    Maze m = new Maze(4, 4);
    HashMap<String, Edge> hashmap = new HashMap<String, Edge>();

    m.endCurrentBFS = m.mazeVertex.get(0).get(1);
    hashmap.put("0,1", new Edge(m.mazeVertex.get(0).get(0), m.mazeVertex.get(0).get(1), 0));
    hashmap.put("0,0", new Edge(m.mazeVertex.get(0).get(0), m.mazeVertex.get(0).get(0), 0));


    m.endCurrentBFS = m.mazeVertex.get(0).get(0);
    m.reconstructBFS(hashmap);

    Assert.assertEquals(m.endCurrentBFS, m.mazeVertex.get(0).get(0));
    Assert.assertEquals(m.endCurrentBFS.equals(m.mazeVertex.get(0).get(1)), false);
    Assert.assertTrue(m.endCurrentBFS.equals(m.mazeVertex.get(0).get(0)));


  }

  @Test
  public void testReconstructDFS() {
    Maze m = new Maze(4, 4);
    HashMap<String, Edge> hashmap = new HashMap<String, Edge>();

    m.endCurrent = m.mazeVertex.get(0).get(1);
    hashmap.put("0,1", new Edge(m.mazeVertex.get(0).get(0), m.mazeVertex.get(0).get(1), 0));
    hashmap.put("0,0", new Edge(m.mazeVertex.get(0).get(0), m.mazeVertex.get(0).get(0), 0));


    m.endCurrent = m.mazeVertex.get(0).get(0);
    m.reconstruct(hashmap);

    Assert.assertEquals(m.endCurrent, m.mazeVertex.get(0).get(0));
    Assert.assertEquals(m.endCurrent.equals(m.mazeVertex.get(0).get(1)), false);
    Assert.assertEquals(m.endCurrent.equals(m.mazeVertex.get(0).get(0)), true);


  }

}
