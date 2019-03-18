

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

The libraries are too big to study all the documentation [Java9-api], but
**every programmer should be familiar with the basics of java.lang, java.util, and java.io, and their subpackages.**
Knowledge of other libraries can be acquired on an as-needed basis.

Several libraries bear special mention.
The collections framework and the streams library (Items 45–48) should be part of every programmer’s basic toolkit,
as should parts of the concurrency utilities in java.util.concurrent.
This package contains both high-level utilities to simplify the task of multithreaded programming and low-level primitives to
allow experts to write their own higher- level concurrent abstractions.
The high-level parts of java.util.concurrent are discussed in Items 80 and 81.

To summarize, don’t reinvent the wheel.
If you need to do something that seems like it should be reasonably common, there may already be a facility in the libraries that does what you want.
If there is, use it; if you don’t know, check.
Generally speaking, library code is likely to be better than code that you’d write yourself and is likely to improve over time.
This is no reflection on your abilities as a programmer.
Economies of scale dictate that library code receives far more attention than most developers could afford to devote to the same functionality.

