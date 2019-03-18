

Item 42: Prefer lambdas to anonymous classes
============================================


Historically, interfaces (or, rarely, abstract classes) with a single abstract method were used as _function types_.
Their instances, known as _function objects_, represent functions or actions.
Since JDK 1.1 was released in 1997, the primary means of creating a function object was the _anonymous class_ (Item 24).

Anonymous classes were adequate for the classic objected-oriented design patterns requiring function objects, notably the _Strategy_ pattern [Gamma95].
The Comparator interface represents an _abstract strategy_ for sorting; the anonymous class above is a _concrete strategy_ for sorting strings.
The verbosity of anonymous classes, however, made functional programming in Java an unappealing prospect.

In Java 8, the language formalized the notion that interfaces with a single abstract method are special and deserve special treatment.
These interfaces are now known as _functional interfaces_, and the language allows you to create instances of these interfaces using _lambda expressions_, or _lambdas_ for short.
Lambdas are similar in function to anonymous classes, but far more concise.

Note that the types of the lambda (Comparator<String>), of its parameters (s1 and s2, both String), and of its return value (int) are not present in the code.
The compiler deduces these types from context, using a process known as _type inference_.
In some cases, the compiler won’t be able to determine the types, and you’ll have to specify them.
The rules for type inference are complex: they take up an entire chapter in the JLS [JLS, 18].
**Omit the types of all lambda parameters unless their presence makes your program clearer.**

One caveat should be added concerning type inference.
Item 26 tells you not to use raw types, Item 29 tells you to favor generic types, and Item 30 tells you to favor generic methods.
This advice is doubly important when you’re using lambdas, because the compiler obtains most of the type information that allows it to **perform type inference from generics**.

The addition of lambdas to the language makes it practical to use function objects where it would not previously have made sense.

