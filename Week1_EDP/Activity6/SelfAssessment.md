# Activity 6: Final Self-Assessment

## Learning Outcome 1: Define EDP Components

### 1. What is an event? Give two examples.

An event is an action or occurrence that a program can detect and respond to. Examples include clicking a button and pressing a keyboard key.

### 2. What is an event source? Give two examples.

An event source is a component that generates an event. Examples include a JButton and a keyboard.

### 3. What is an event listener? Give two examples.

An event listener is an object that waits for and receives events from an event source. Examples in Java include ActionListener and KeyListener.

### 4. What is an event handler? Give two examples.

An event handler is the code that runs in response to an event. Examples include code that updates a counter after a button click and code that clears a text field when the Clear button is clicked.

### 5. Draw a diagram showing how these four components relate to each other.

```text
Event Source
    |
    | generates
    v
  Event
    |
    | received by
    v
Event Listener
    |
    | calls / triggers
    v
Event Handler
    |
    v
Application responds
```

## Learning Outcome 2: Compare Paradigms

### 6. How does procedural programming differ from event-driven programming?

Procedural programming follows a predefined sequence of instructions. Event-driven programming waits for events, such as button clicks or key presses, and responds by executing the related handlers.

### 7. What is the main advantage of event-driven programming for GUIs?

It makes graphical applications interactive because the user can choose actions and the application responds to events instead of following only one fixed sequence.

### 8. In which scenario would you choose procedural programming over event-driven?

I would choose procedural programming for a simple task that follows a clear sequence, such as calculating the total cost of items or processing a fixed set of records.

## Learning Outcome 3: Event Loop and Queue

### 9. What is the event loop? What does it do?

The event loop continually checks the event queue, takes pending events and sends them for processing by the appropriate listener and handler.

### 10. What is the event queue? How does it work?

The event queue stores events until they can be processed. Events are placed in the queue as they occur and are taken for processing by the event loop.

### 11. Why should the event loop never be blocked?

If the event loop is blocked by a slow task, other events cannot be processed on time. The application may appear frozen and become unresponsive.

### 12. What is the EDT in Java Swing?

The Event Dispatch Thread (EDT) is the thread responsible for processing Swing events and performing most updates to Swing components. Long-running tasks should not run on it.

## Learning Outcome 4: Real-World Examples

### 13. List five real-world event-driven systems.

1. ATM machine.
2. Microwave oven.
3. Traffic light system.
4. Elevator system.
5. Smartphone touchscreen.

### 14. For one system, identify all four EDP components.

**Example: ATM machine**

- **Event source:** ATM keypad.
- **Event:** User presses a number key.
- **Listener:** ATM software input listener.
- **Handler:** The software records the entered digit and uses it during PIN verification.

### 15. Why are most modern applications event-driven?

Most modern applications need to respond to user actions, system notifications, timers and other events. Event-driven programming makes applications interactive and allows them to respond when events occur.

## Step 2: My Score

- **10–12 correct:** Good.


