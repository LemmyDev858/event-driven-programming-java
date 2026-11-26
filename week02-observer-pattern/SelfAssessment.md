# Activity 5: Final Self-Assessment & Final Reflection

## Learning Outcome 1: Design and Implement the Observer Pattern

1. **Draw the UML diagram of the Observer pattern. Label Subject, Observer, ConcreteSubject, ConcreteObserver.**

```
+----------------------------+          +----------------------------+
|       <<interface>>        |          |       <<interface>>        |
|          Subject           |--------->|          Observer          |
+----------------------------+ notifies +----------------------------+
| + registerObserver(o)      |          | + update(...)              |
| + removeObserver(o)        |          +----------------------------+
| + notifyObservers()        |                        ^
+----------------------------+                        | implements
              ^                                       |
              | implements              +-------------+-------------+
              |                         |                           |
+----------------------------+  +------------------+      +------------------+
|      ConcreteSubject       |  | ConcreteObserver |      | ConcreteObserver |
|       (WeatherData)        |  | (CurrentDisplay) |      | (ForecastDisplay)|
+----------------------------+  +------------------+      +------------------+
| - observers: List<Observer>|  | + update(...)    |      | + update(...)    |
| - state                    |  +------------------+      +------------------+
+----------------------------+
| + registerObserver(o)      |
| + removeObserver(o)        |
| + notifyObservers()        |
| + setMeasurements(...)     |
+----------------------------+
```

2. **Write the Java code (from memory) for a Subject interface.**
```java
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
```

3. **Why does the Subject need a list of observers?**
   So it can support multiple subscribers dynamically at runtime—adding new observers, removing observers that are no longer interested, and iterating through all registered observers to notify them whenever its state changes.

## Learning Outcome 2: Evaluate Legacy java.util.Observer

4. **List three problems with java.util.Observable.**
   - `Observable` is a concrete class rather than an interface, which consumes Java's single inheritance slot.
   - `setChanged()` is `protected` and easy to forget, causing `notifyObservers()` to silently do nothing.
   - Notification order is unspecified, and the `update(Observable o, Object arg)` method is untyped (`Object`) and encourages pulling data via casts.

5. **Why was this API deprecated?**
   It was deprecated in Java 9 because its design is rigid, non-extensible, lacks type safety, has an awkward `setChanged()` contract, and does not meet modern event-handling or concurrency needs compared to `PropertyChangeListener`, `java.util.concurrent.Flow`, JavaFX properties/bindings, or custom interfaces.

6. **What is the "pull model" and why is it harder to use?**
   In the pull model, the subject notifies the observer without sending the updated data directly; the observer receives a reference to the subject and must cast it (if needed) and call getter methods to retrieve the values. This requires extra method calls, couples observers to specific getter APIs, and adds boilerplate.

## Learning Outcome 3: Create a Custom Event Notification System

7. **What methods must a custom Subject interface provide?**
   Methods to register/add an observer (e.g., `registerObserver` / `addObserver`), remove/unregister an observer (`removeObserver`), and notify all registered observers (`notifyObservers`).

8. **How does the Subject notify all observers?**
   By iterating over its stored collection of registered `Observer` references and calling the observer interface's update/callback method (e.g., `o.update(...)` or `o.onDataChanged(value)`) on each one.

9. **How do you prevent a memory leak when observers are no longer needed?**
   Explicitly call `removeObserver(o)` when an observer is no longer needed so the subject does not continue holding a strong reference to it (which would prevent garbage collection—the "lapsed listener" problem).

## Learning Outcome 4: Compare Different Mechanisms

10. **Name four event notification mechanisms in Java.**
    1. Custom Observer (own `Subject` / `Observer` interfaces)
    2. `java.util.Observer` / `java.util.Observable` (legacy, deprecated)
    3. `PropertyChangeListener` / `PropertyChangeSupport` (`java.beans`)
    4. JavaFX Properties and Bindings

11. **Which one is best for JavaFX?**
    JavaFX Properties and Bindings.

12. **Which one is deprecated?**
    `java.util.Observer` and `java.util.Observable`.

---

## One-Page Summary of the Observer Pattern

The Observer pattern is a behavioral design pattern that defines a one-to-many dependency between objects so that when one object (the **Subject**) changes state, all of its dependent objects (the **Observers**) are notified and updated automatically. Rather than hardcoding calls to specific display, logging, or UI classes inside the data model, the Subject depends only on an abstract `Observer` interface. This decouples the publisher of state changes from the subscribers that react to them.

In a custom Java implementation, the pattern consists of four main participants: a `Subject` interface (declaring `registerObserver`, `removeObserver`, and `notifyObservers`), an `Observer` interface (declaring `update` or a domain-specific callback), a `ConcreteSubject` (which holds the state and a `List<Observer>`), and one or more `ConcreteObserver` classes (which implement the `Observer` interface and react to updates). When the subject's state changes, it invokes `notifyObservers()`, which loops through the registered observers and delivers either the updated data directly (**push model**) or a reference allowing observers to query getters (**pull model**).

The key benefit of the Observer pattern is **loose coupling**: new observers can be added or removed at runtime without modifying the subject's code, and the subject can be tested independently of any UI or downstream consumers. To avoid memory leaks (known as the lapsed listener problem), observers should be unregistered with `removeObserver` when they are no longer needed. In modern Java, a custom Observer interface is preferred for plain Java applications, JavaFX Properties/Bindings are ideal for JavaFX UIs, `PropertyChangeListener` supports legacy JavaBeans/Swing code, and `java.util.Observer`/`Observable` should be avoided since their deprecation in Java 9.

---

## Final Reflection

The Observer pattern is a behavioral design pattern in which a subject maintains a list of dependent observers and automatically notifies them whenever its state changes, which is important because it eliminates tight coupling between data models and the components that react to them. It forms the foundation of event-driven programming: instead of components constantly polling for changes or hardcoding direct calls to one another, subjects emit events or state-change notifications that registered listeners respond to dynamically at runtime. By separating event producers from event consumers through interfaces, systems become much easier to extend, maintain, and test in isolation. For my own plain Java project, I would choose a **Custom Observer** interface because it gives full type safety, avoids the single-inheritance and `setChanged()` pitfalls of the deprecated `java.util.Observer`, and keeps the architecture clean without needing extra frameworks. If I were building a desktop UI with JavaFX, however, I would choose **JavaFX Properties and Bindings** for its built-in reactive updates and minimal boilerplate.
