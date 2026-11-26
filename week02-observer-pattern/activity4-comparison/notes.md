# Activity 4: Self-Check Notes

1. **Which mechanism carries both the old and new value of a property?**
   `PropertyChangeListener` (via `PropertyChangeEvent.getOldValue()` and `PropertyChangeEvent.getNewValue()`).

2. **Which mechanism requires a helper class to manage the listener list?**
   `PropertyChangeListener` (via `PropertyChangeSupport`).

3. **Which two mechanisms are recommended for modern Java?**
   Custom Observer and JavaFX Bindings.

4. **Which mechanism is deprecated and should be avoided?**
   `java.util.Observer` / `java.util.Observable`.
