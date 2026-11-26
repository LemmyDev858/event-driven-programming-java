# Activity 1: Self-Check Notes

1. **What is the role of the Subject interface?**
   The `Subject` interface defines the contract that any publisher must support (`registerObserver`, `removeObserver`, and `notifyObservers`). It allows observers and clients to interact with a subject through an abstraction rather than depending on a concrete implementation.

2. **What happens if you call notifyObservers() without registering any observers?**
   Nothing breaks or throws an error. The `observers` list is initialized as an empty `ArrayList<>()`, so the `for (Observer o : observers)` loop runs zero times and completes cleanly.

3. **What is the difference between registerObserver() and removeObserver()?**
   `registerObserver(Observer o)` adds an observer to the `observers` list so it will receive future notifications. `removeObserver(Observer o)` removes an observer from the `observers` list so it stops receiving notifications.

4. **Why is the observers list stored as an instance variable?**
   Each `WeatherData` instance needs to maintain its own independent list of subscribed observers across multiple method calls (`registerObserver`, `removeObserver`, `notifyObservers`, and `setMeasurements`). Storing it as an instance variable preserves the subscriptions for the lifetime of that `WeatherData` object.
