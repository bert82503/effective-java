

Item 42: Prefer lambdas to anonymous classes
============================================


Historically, **interfaces with a single abstract method** were used as _function types_.
Their instances, known as _function objects_, **represent functions or actions**.
Since **JDK 1.1** was released in 1997, the primary means of **creating a function object** was the _anonymous class_ (Item 24).

_Anonymous classes_ were adequate for the classic _objected-oriented design patterns_ requiring _function objects_, notably the _Strategy_ pattern [Gamma95].
The Comparator _interface_ represents an _abstract strategy_ for sorting; the _anonymous class_ above is a _concrete strategy_ for sorting strings.
`The verbosity of anonymous classes`, however, made functional programming in Java an `unappealing prospect`.

In **Java 8**, the language formalized the notion that **interfaces with a single abstract method** `are special and deserve special treatment`.
**These interfaces** are now known as _functional interfaces_, and the language allows you to **create instances of these interfaces** using _lambda expressions_, or _lambdas_ for short.
_Lambdas_ **are** similar in function to _anonymous classes_, but **far more concise.**

Note that `the types of the lambda, of its parameters, and of its return value are not present in the code.`
**The _compiler_ deduces these types from context**, using a process known as _type inference_.
In some cases, the compiler won’t be able to determine the types, and you’ll have to specify them.
**The rules for type inference** are `complex`: they take up an entire chapter in the JLS [JLS, 18].
**Omit the types of all lambda parameters unless their presence makes your program clearer.**

`One caveat` should be added concerning _type inference_.
Item 26 tells you not to use raw types, Item 29 tells you to **favor generic types**, and Item 30 tells you to **favor generic methods**.
**This advice is doubly important** when you’re **using _lambdas_**, because **the compiler obtains most of the type information** that allows it to **perform type inference from generics**.

the comparator can be made even more succinct if a _comparator construction method_ is used in place of a lambda (Items 14. 43):

**The addition of _lambdas_ to the language makes it practical to use _function objects_** where it would not previously have made sense.

Unlike methods and classes, **_lambdas_ lack names and documentation; if a computation isn’t self-explanatory, or exceeds a few lines, don’t put it in a lambda.**
**One line is ideal for a lambda, and three lines is a reasonable maximum.**
If you `violate this rule`, it can `cause serious harm to the readability` of your programs.

Likewise, you might think that _anonymous classes_ are obsolete in the era of lambdas.
This is closer to the truth, but there are `a few things` you can `do with anonymous classes` that you can’t do with lambdas.
Lambdas are limited to functional interfaces.
Finally, `a lambda cannot obtain a reference to itself`. In **a lambda**, the **this** keyword **refers to the enclosing instance**, which is typically what you want.
In **an anonymous class**, the **this** keyword **refers to the anonymous class instance**.

In summary, as of **Java 8, _lambdas_** are by far the best way to **represent `small` _function objects_.**
**Don’t use _anonymous classes_ for _function objects_ unless you have to create instances of types that aren’t functional interfaces.**
Also, remember that **_lambdas_** make it so easy to **represent `small` _function objects_**
that it **opens the door to functional programming techniques** that were not previously practical in Java.

