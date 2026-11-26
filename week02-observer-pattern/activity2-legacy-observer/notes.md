# Activity 2: Self-Check Notes

1. **Why can't you extend another class if you already extend Observable?**
   Java only supports single inheritance for classes (`extends`), meaning a class can have at most one direct superclass. Once a class extends `java.util.Observable`, it cannot extend any other class.

2. **What is the difference between the push model and the pull model?**
   In the **push model**, the subject sends the updated data directly as parameters in the `update(...)` call (as in Activity 1's `update(temperature, humidity, pressure)`). In the **pull model**, the subject only notifies the observer that something changed (like `notifyObservers()` in `Observable`), and the observer must call getter methods on the subject to pull the data it needs.

3. **Why did Java deprecate these classes?**
   `java.util.Observer` and `java.util.Observable` were deprecated in Java 9 because the API is inflexible and flawed: `Observable` is a class rather than an interface (forcing single inheritance), `setChanged()` is `protected` and easy to forget, notification order is unspecified, updates are untyped (`Object`), and it lacks modern concurrency and extensibility support.
