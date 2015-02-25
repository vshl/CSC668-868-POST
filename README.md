# CSC668-868-POST
Project repo for SFSU CSC668/868

compile src from src/ directory:
 ```
  javac com/post/registry/ServerReg.java \
        com/post/server/ProductReader.java \
        com/post/client/CashPayment.java \
        com/post/server/PostManagerImpl.java \
        com/post/server/ProductSpecificationImpl.java
  ```

usage:
* Start RMI registry:
  1. rmiregistry -J-Djava.security.policy=com/post/registry/permission.policy &
* Register remote object:
  1.  java -Djava.rmi.server.hostname=localhost -Djava.security.policy=com/post/registry/permission.policy com/post/registry/ServerReg
* In netbeans/eclipse
  1.  set VM options:  -Djava.security.policy=com/post/presentation/permission.policy
  2.  set working directory to src/    
  2.  run MainFrame class

* to test new server-side code, you have to tear down the rmiregistry, recompile server code, restart rmiregistry and register remote object again
* to kill rmiregistry
  1.  issue command: ```ps```    [this will list user processes]
  2.  find the one that looks something like this: ```28304 ttys000    0:00.88 /usr/bin/rmiregistry -J-Djava.security.policy=com/post/registry/permission.policy```
  3.  in this case, process ID = 28304
  4.  kill process with ```kill 28304````

  __Alternatively__ you can also follow the following steps:
    1. Go to the same prompt where you had started the registry. If you haven't notice `&` make the command run in background. just type `fg`. It brings the command in foreground.
    2. Once command is foreground, you can press `ctrl+C` to kill the process.

*  If you get any ```class not found ``` exceptions, you need to recompile the source with javac [what ever class is not found]
