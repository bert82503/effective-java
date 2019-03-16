

Item 59: Know and use the libraries
===================================


**By using a standard library, you take advantage of the knowledge of the experts
who wrote it and the experience of those who used it before you.**

As of Java 7, you should no longer use Random. For most uses,
**the random number generator of choice is now ThreadLocalRandom.**
It produces higher quality random numbers, and it’s very fast. On my machine, it is 3.6 times faster than Random.
For fork join pools and parallel streams, use SplittableRandom.

**Numerous features are added to the libraries in every major release, and it pays to keep abreast of these additions.**
Each time there is a major release of the Java platform, a web page is published describing its new features.
These pages are well worth reading [Java8-feat, Java9-feat].

