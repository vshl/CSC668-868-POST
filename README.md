# CSC668-868-POST
Project repo for SFSU CSC668/868

compile src from src/ directory:
*  javac com/post/registry/ServerReg.java
*  javac com/post/server/ProductReader.java
*  javac com/post/server/PostManagerImpl.java
*  javac com/post/server/ProductSpecificationImpl.java 

usage:
* Start RMI registry:
  1. rmiregistry -J-Djava.security.policy=com/post/registry/permission.policy &
* Register remote object:
  1.  java -Djava.rmi.server.hostname=localhost -Djava.security.policy=com/post/registry/permission.policy com/post/registry/ServerReg
* In netbeans/eclipse
  1.  set VM options:  -Djava.security.policy=com/post/presentation/permission.policy
  2.  run MainFrame class
