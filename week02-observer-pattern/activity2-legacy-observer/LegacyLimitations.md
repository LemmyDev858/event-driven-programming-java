# Limitations of java.util.Observer and java.util.Observable

## Limitation 1: Single Inheritance
Question: Why is it a problem that Observable is a CLASS, not an INTERFACE?

Answer: Because Java only supports single class inheritance, extending `Observable` uses up the subject class's one superclass slot. As a result, a class cannot extend any other domain or base class while also being an `Observable`, limiting flexibility and reuse.

## Limitation 2: Cannot Change the Notification Order
Question: In what order are observers notified? Can you control this?

Answer: Observers are notified in an unspecified order (in the legacy JDK implementation, notifications are delivered in reverse registration order, and this behavior is not guaranteed by the API contract). You cannot control or customize the notification order without rewriting or bypassing `Observable`.

## Limitation 3: setChanged() is Confusing
Question: Why must you call setChanged() before notifyObservers()?

Answer: `Observable` maintains an internal `changed` boolean flag and checks it inside `notifyObservers()`, clearing it after notifying. Unless `setChanged()` (a `protected` method) is called first, `notifyObservers()` silently does nothing. It is easy to forget `setChanged()`, causing observers to silently miss updates, and because `setChanged()` is `protected`, external classes cannot compose or wrap an `Observable` easily.

## Limitation 4: Pull Model by Default
Question: How does the observer get the data? Is this efficient?

Answer: By default (`notifyObservers()` with no arguments), no state data is pushed to observers; instead, the observer receives only a generic `Observable` reference and a `null` `Object arg`, so it must cast the `Observable` to the concrete class and call getter methods (`getTemperature()`, `getHumidity()`, etc.) to pull the data. This requires extra method calls, type casting, and tighter coupling to the concrete subject's getters, and even the `notifyObservers(Object arg)` overload is untyped (`Object`).

## Limitation 5: Deprecated Since Java 9
Question: Why did Java deprecate these classes?

Answer: Java deprecated `java.util.Observer` and `java.util.Observable` in Java 9 because the event model is inflexible and limited: `Observable` is a class rather than an interface, `setChanged()` is easy to forget and `protected`, notifications are not typed (passing `Object`), observers are notified in an unspecified order, and the API is not thread-safe for rich concurrent event workflows or extensible compared to `java.beans.PropertyChangeListener`, `java.util.concurrent.Flow`, or custom Observer interfaces.
