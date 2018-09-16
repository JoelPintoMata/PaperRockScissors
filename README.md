Usage
=====

Compile
-------
```bash
$ mvn compile
```

Package
-------
```bash
$ mvn package
```

Run
---
```
$ mvn exec:java -Dexec.mainClass="Main"
```
, compile, package and run
```bash
$ mvn compile && mvn package && mvn exec:java -Dexec.mainClass="Main"
```

Test
```bash
```
$ mvn test
```

Technical discussion
====================

Design patterns
---------------
### Strategy
Capture the game abstraction into Strategy interface and StrategyTemplate. Finally it buries the implementation details in derived concrete game classes like PaperRockScissorsImpl.

### Dependency injection
Injection of a external game solution into a game implementation, e.g, PaperRockScissorsSolutionImpl is injected in PaperRockScissorsImpl
