# CSC668-868-POST
Project repo for SFSU CSC668/868

compile src:
*  javac com/post/server/PostManagerImpl.java
*  javac com/post/presentation/MainFrame.java

usage:
* Start RMI registry:
  1. rmiregistry -J-Djava.security.policy=com/post/registry/permission.policy &
* Register remote object:
  1.  java -Djava.rmi.server.hostname=localhost -Djava.security.policy=com/post/registry/permission.policy com/post/registry/ServerReg
* In seperate terminal, start GUI:
  1.  java -Djava.security.policy=com/post/registry/permission.policy com/post/presentation/MainFrame
