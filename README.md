# StateMachine

Source root is located at src/main/java.
Tests are located in src/test/java.
StateMachine.java is an example driver class.

   Sample Input

      Number of vertices?
      3
      Number of edges to add?
      2
      Enter 2 src and dest vertex pairs 
      0 1
      1 2
      Number of transitions?
      2
      Enter Transitions
      1
      2


  Sample Output
  
     State Transitions
     0 -> 1
     1 -> 2
     
     Printing the entire state machine. Current state is represented by asterisk(*).
     Adjacency list of vertex 0
     0: 0 -> 1(1) 

     Adjacency list of vertex 1
     1: 1 -> 2(2) 1 -> 0(1) 

    Adjacency list of vertex 2
     2: 2 -> 1(2)  *
