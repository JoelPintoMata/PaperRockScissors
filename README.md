Usage
=====

Compile
-------
```
$ mvn compile
```

Run
---
```
$ mvn exec:java -Dexec.mainClass="Main"
```

Test
----
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
